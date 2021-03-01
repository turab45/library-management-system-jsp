package dao;

import java.util.List;

import models.Student;

public interface StudentDao {
	public Integer addStudent(Student student);
	public Integer updateStudent(Student student);
	public Integer deleteStudent(Integer id);
	public Integer getIdByName(Integer id);
	public Student getStudentById(Integer id);
	public List<Student> getAllStudent();

}
