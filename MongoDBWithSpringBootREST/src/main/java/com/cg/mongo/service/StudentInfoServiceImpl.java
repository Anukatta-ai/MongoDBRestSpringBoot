package com.cg.mongo.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mongo.entity.StudentInfo;
import com.cg.mongo.repository.IStudentInfoRepository;

@Service
public class StudentInfoServiceImpl implements IStudentInfoService {
	
	
	private IStudentInfoRepository repository;
	
	  @Autowired
	  public StudentInfoServiceImpl(IStudentInfoRepository repository) {
	        this.repository = repository;
	    }

	@Override
	public List<StudentInfo> getAllStudentInfo() {
		
		return repository.findAll();
	}

	@Override
	public StudentInfo getStudentById(ObjectId id) {
		
		return repository.findBy_id(id);
	}

	@Override
	public StudentInfo getStudentByRollNo(Integer rollno) {
		return repository.findBy_rollNo(rollno);
	}

	@Override
	public void create(StudentInfo student) {
		repository.insert(student);
	}

	@Override
	public void delete(ObjectId id) {
		repository.deleteById(id.toString());
	}

	@Override
	public void update(StudentInfo student) {
		repository.save(student);
	}

	
}
