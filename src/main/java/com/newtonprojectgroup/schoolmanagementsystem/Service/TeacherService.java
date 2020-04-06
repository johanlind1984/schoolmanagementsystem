package com.newtonprojectgroup.schoolmanagementsystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Teacher;
import com.newtonprojectgroup.schoolmanagementsystem.Repository.iRepositoryTeacher;

@Service
public class TeacherService {

	@Autowired
	private iRepositoryTeacher repoTeacher;
	
	/*public List<Teacher> listAll() {
		return repoTeacher.findAll();
	}*/
	
	public Teacher get(String idteacher) {
		return repoTeacher.findById(idteacher).get();
	}
	
	public void save(Teacher teacher) {
		repoTeacher.save(teacher);
	}
	
	
}
