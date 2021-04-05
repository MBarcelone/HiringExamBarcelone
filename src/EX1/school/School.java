package EX1.school;

import EX1.person.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class School {

    private List<Student> students;
    private List<Employee> employees;
    private Principal principal;
    private Janitor janitor;

    public School(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public Map<Character, List<Student>> getStudentsGroupedByLastNameInitial() {
        return this.students.stream()
                .collect(Collectors.groupingBy(student -> student.getPersonLastName().charAt(0)));
    }

    public List<Student> getStudentsBySubjectId(Integer subjectId) {
        return this.students.stream()
                .filter(student -> student.getSubjectList()
                        .stream()
                        .anyMatch(subject -> subject.getSubjectId().equals(subjectId)))
                .collect(Collectors.toList());
    }

    public void printStudentsGroupedByLastNameInitial(Map<Character, List<Student>> orderedList) {
        orderedList.forEach((key, value) -> System.out.println("Group " + key + ": " +
                value.stream()
                        .map(student -> student.getPersonName() + " " + student.getPersonLastName())
                        .collect(Collectors.joining(", "))
        ));
    }

    public void printStudentsBySubjectId(List<Student> studentsBySubjectId) {
        studentsBySubjectId.forEach(student ->
                System.out.println(student.getPersonName() + " " + student.getPersonLastName())
        );
    }

}
