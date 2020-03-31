package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="staff")
@PrimaryKeyJoinColumn(name="idstaff")
public class Staff extends Person {

    public Staff() {
    }

}
