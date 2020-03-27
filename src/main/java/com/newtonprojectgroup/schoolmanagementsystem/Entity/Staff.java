package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="staff")
@PrimaryKeyJoinColumn(name="idstaff")
public class Staff extends Person {

//    Här kan du inte ha en "idstaffkolumnen efyersom den används som primaryKeyJoinColumn"
//    @Column(name="idstaff")
//    private String staffId;

    public Staff() {
    }

}
