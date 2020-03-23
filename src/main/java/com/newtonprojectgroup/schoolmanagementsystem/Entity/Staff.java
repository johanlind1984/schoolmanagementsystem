package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.*;

@Entity
@Table(name="staff")
@PrimaryKeyJoinColumn(name="idstaff")
public class Staff extends Person {

    @Id
    @Column(name="idstaff")
    private String staffId;

    public Staff() {
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
