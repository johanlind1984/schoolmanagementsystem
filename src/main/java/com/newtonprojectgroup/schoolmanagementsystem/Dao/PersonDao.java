package com.newtonprojectgroup.schoolmanagementsystem.Dao;

import com.newtonprojectgroup.schoolmanagementsystem.Entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Repository
@Qualifier("fakeData")
public class PersonDao {

    private static Map<String, Person> persons;

    static {
        persons = new HashMap<String, Person>(){
            {
                put("Stefan", new Person());
            }
        };
    }

    public Collection<Person> getAllStudents() {
        return this.persons.values();
    }

    public Person getStudentById(int id) {
        return this.persons.get(id);
    }

    public void removeStudentById(int id) {
        this.persons.remove(id);
    }

    public void updateStudent(Person person) {
        Person s = persons.get(person.getStudentId());
        s.setFirstName(person.getFirstName());
        persons.put(person.getStudentId(), person);
    }

    public void insertStudentToDb(Person person) {
        this.persons.put(person.getStudentId(), person);
    }
}
