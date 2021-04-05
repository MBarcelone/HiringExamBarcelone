package EX1;

import EX1.person.Student;
import EX1.school.Subject;
import EX1.school.School;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Create school data
        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Geography");
        Subject subject3 = new Subject(3, "History");
        Subject subject4 = new Subject(4, "Language");

        List<Subject> studentsSubjects1 = new ArrayList<>(Arrays.asList(subject1, subject2));
        List<Subject> studentsSubjects2 = new ArrayList<>(Arrays.asList(subject1, subject2, subject4));
        List<Subject> studentsSubjects3 = new ArrayList<>(Arrays.asList(subject1, subject3, subject4));

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Martin", "Barcelone", studentsSubjects1));
        students.add(new Student(2, "Jorge", "Pezzuti", studentsSubjects2));
        students.add(new Student(3, "Bautista", "Paez", studentsSubjects3));
        students.add(new Student(3, "Bautista", "Paez", studentsSubjects3));

	    School school = new School(students);

	    //Exercise B
        System.out.println("\n----Exercise B----\n");
	    school.printStudentsGroupedByLastNameInitial(school.getStudentsGroupedByLastNameInitial());

        //Exercise C
        System.out.println("\n----Exercise C----\n\n" + subject1.getSubjectName() + " students:");
        school.printStudentsBySubjectId(school.getStudentsBySubjectId(1));

    }
}
