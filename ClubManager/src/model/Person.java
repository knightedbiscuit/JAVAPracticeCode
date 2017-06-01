package model;

public class Person {

	protected String surname;
	protected String firstname;
	protected String secondname;

	public Person(String surname, String firstname, String secondname) {
		super();
		this.surname = surname;
		this.firstname = firstname;
		this.secondname = secondname;
	}

	public Person(String surname, String firstname) {
		this(surname, firstname, null);
	}

	public Person() {
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public void show() {
		System.out.println(toString());

	}

	public String toString() {
		if (secondname != null) {
			return (surname + " " + secondname + " " + firstname);
		} else {
			return (surname + " " + firstname);
		}

	}

}
