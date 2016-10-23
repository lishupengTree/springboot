package com.demo.dao;

import java.util.List;

import com.demo.entity.StudentEntity;

public interface  StudentMapper {
	public StudentEntity getStudent(String studentID);

	public StudentEntity getStudentAndClass(String studentID);

	public List<StudentEntity> getStudentAll();

	public void insertStudent(StudentEntity entity);

	public void deleteStudent(StudentEntity entity);

	public void updateStudent(StudentEntity entity);
}
