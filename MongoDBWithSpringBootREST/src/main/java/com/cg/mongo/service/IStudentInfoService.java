package com.cg.mongo.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.cg.mongo.entity.StudentInfo;

public interface IStudentInfoService {

	public List<StudentInfo> getAllStudentInfo();
	public StudentInfo getStudentById(ObjectId _id);
	public void create(StudentInfo student);
	public void delete(ObjectId _id);
	public void update(StudentInfo student);
	public StudentInfo getStudentByRollNo(Integer rollno);
}
