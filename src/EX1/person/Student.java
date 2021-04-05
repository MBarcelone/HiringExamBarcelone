package EX1.person;

import EX1.school.Subject;

import java.util.List;

public class Student extends Person {

    private List<Subject> subjectList;

    public Student(Integer personId, String personName, String personLastName, List<Subject> subjectList) {
        super(personId, personName, personLastName);
        this.subjectList = subjectList;
    }

    public List<Subject> getSubjectList() {
        return this.subjectList;
    }

    public void doJobTask() {
        //Here we can add implementation of a student studying
    }

}
