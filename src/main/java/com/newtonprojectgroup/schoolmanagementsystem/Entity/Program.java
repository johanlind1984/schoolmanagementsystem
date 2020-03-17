package com.newtonprojectgroup.schoolmanagementsystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="program")
public class Program {

    @Id
    @Column(name="idprogram")
    private int programId;

    @Column(name="program_name")
    private String programName;

    // @ManyToMany
    // private List<Course> courseList;


    public Program() {
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
