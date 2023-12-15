package dao;

import java.util.List;

import model.student;

public interface studentDao {
	//create
	void add(student s);
	//read
	String querysAll();
	List<student> queryAll2();
	//update
	
	//delete
}
