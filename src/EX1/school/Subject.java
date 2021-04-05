package EX1.school;


import EX1.person.Employee;

import java.util.Objects;

public class Subject {

    private Integer subjectId;
    private String subjectName;

    public Subject(Integer subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public Integer getSubjectId() {
        return this.subjectId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

}
