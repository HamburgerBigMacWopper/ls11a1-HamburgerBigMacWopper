package de.oszimt.fian.hase.model.base;

public abstract class Person {
    protected int id;
    protected String firstname;
    protected String lastname;
    protected String email;

    public Person(int id, String firstname, String lastname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person tempPerson) {
            return this.id == tempPerson.getId();
        }
        return false;
    }

    public String toString() {
        String returnstring = "";
        returnstring += "firstname: " + firstname;
        returnstring += "\tlastname: " + lastname;
        returnstring += "\tid: " + id;
        returnstring += "\temail: " + email;
        return returnstring;
    }
}
