package model;

public class Member extends Person implements Comparable<Member> {
	private int memberNumber;

	public Member(String surname, String firstname, String secondname, int memberNumber) {
		super(surname, firstname, secondname);
		this.memberNumber = memberNumber;
	}

	public Member(String surname, String firstname, int memberNumber) {
		super(surname, firstname);
		this.memberNumber = memberNumber;
	}

	public Member() {
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String toString() {
		return (super.toString() + ", Membership Number: " + String.valueOf(memberNumber));
	}

	@Override
	public int compareTo(Member m) {
		// TODO Auto-generated method stub
		return (this.getSurname().compareTo(m.getSurname()));
	}

}
