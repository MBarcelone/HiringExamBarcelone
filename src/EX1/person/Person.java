package EX1.person;

import java.util.Date;

public abstract class Person implements JobTask {

    protected Integer personId;
    protected String personName;
    protected String personLastName;
    private Date personBirthDate;

    public Person(Integer personId, String personName, String personLastName) {
        this.personId = personId;
        this.personName = personName;
        this.personLastName = personLastName;
    }

    public Integer getPersonId() {
        return this.personId;
    }

    public String getPersonName() {
        return this.personName;
    }

    public String getPersonLastName() {
        return this.personLastName;
    }

    public Date getPersonBirthDate() {
        return this.personBirthDate;
    }
}
