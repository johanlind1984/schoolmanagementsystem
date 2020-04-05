package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
@PrimaryKeyJoinColumn(name = "idteacher")
public class Teacher extends Person {
	
	

}
