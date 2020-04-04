package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@PrimaryKeyJoinColumn(name="idadmin")
public class Admin extends Person {

    public Admin() {
    }
}
