package com.cg.mongo.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cg.mongo.entity.StudentInfo;

public interface IStudentInfoRepository extends MongoRepository<StudentInfo, String> {

	StudentInfo findBy_id(ObjectId _id);
	public List<StudentInfo> findAll();
	
	@Query("{ 'rollno' : ?0 }")
	StudentInfo findBy_rollNo(Integer rollno);
}

