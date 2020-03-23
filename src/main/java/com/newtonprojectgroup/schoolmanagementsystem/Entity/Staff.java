package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name = "staff")
@PrimaryKeyJoinColumn(name = "idstaff")
public class Staff extends Person {

    @Id
    @Column(name = "staffid")
    private int staffID;

    public Staff() {
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }
}
