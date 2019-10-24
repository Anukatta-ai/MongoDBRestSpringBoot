package com.cg.mongo.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mongo.entity.StudentInfo;
import com.cg.mongo.exception.NoDataFound;
import com.cg.mongo.exception.ResponseMsg;
import com.cg.mongo.service.IStudentInfoService;

@RestController
public class StudentInfoController {

	@Autowired
	private IStudentInfoService service;

	@GetMapping("/all")
	public List<StudentInfo> getAllStudentInfo() {
		List<StudentInfo> list = service.getAllStudentInfo();
		if (list.isEmpty()) {
			throw new NoDataFound("We are out of order please visit us later");
		}
		return service.getAllStudentInfo();
	}

	@RequestMapping(value = "/searchbyid/{id}", method = RequestMethod.GET)
	public StudentInfo getStudentById(@PathVariable("id") ObjectId id) {
		StudentInfo student = service.getStudentById(id);
		if(student==null) {
			throw new NoDataFound("ID not found");
		}
		return student;
	}

	@RequestMapping(value = "/searchbyrollno/{rollno}", method = RequestMethod.GET)
	public StudentInfo getStudentById(@PathVariable("rollno") Integer rollno) {
		StudentInfo student = service.getStudentByRollNo(rollno);
		if(student==null) {
			throw new NoDataFound("Student Not Found");
		}
		return service.getStudentByRollNo(rollno);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addStudent(@RequestBody StudentInfo student) {
		service.create(student);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") ObjectId id) {
		StudentInfo student = service.getStudentById(id);
		if(student==null) {
			throw new NoDataFound("ID not found");
		}
		service.delete(id);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateStudent(@PathVariable("id") ObjectId id, @RequestBody StudentInfo student) {
		StudentInfo student1 = service.getStudentById(id);
		if(student1==null) {
			throw new NoDataFound("ID not found");
		}
		student.set_id(id);
		service.update(student);
	}

}
