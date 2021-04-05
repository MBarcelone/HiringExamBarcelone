package EX1.person;

public class Employee extends Person {

    public Employee(Integer personId, String personName, String personLastName) {
        super(personId, personName, personLastName);
    }

    public void doJobTask() {
        //Here we can add implementation of a employee (eg. administrative) do his stuff
    }
}
