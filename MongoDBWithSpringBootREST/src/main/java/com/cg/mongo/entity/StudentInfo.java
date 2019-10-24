package com.cg.mongo.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentInfo")
public class StudentInfo{

	@Id
	private ObjectId _id;

	private Integer rollno;
	private String name;

	public StudentInfo() {

	}

	public StudentInfo(ObjectId _id, Integer rollno, String name) {
		super();
		this._id = _id;
		this.rollno = rollno;
		this.name = name;
	}

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public Integer getRollno() {
		return rollno;
	}

	public void setRollno(Integer rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
