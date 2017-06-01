package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")

public class Member {

	@Id
	private int MemberID;
	private String Surname;
	private String FirstName;
	private String SecondName;

	public Member(int memberID, String surname, String firstName, String secondName) {
		super();
		MemberID = memberID;
		Surname = surname;
		FirstName = firstName;
		SecondName = secondName;
	}

	public Member() {
	}

	public int getMemberID() {
		return MemberID;
	}

	public void setMemberID(int memberID) {
		MemberID = memberID;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getSecondName() {
		return SecondName;
	}

	public void setSecondName(String secondName) {
		SecondName = secondName;
	}

}
