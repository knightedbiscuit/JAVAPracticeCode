package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import model.BadBookingException;
import model.Facility;
import model.Member;


public class Club {
	
	private int currentNum;
	// 	Array Method
	//	private Member[] memberList2 = new Member[10];
	private ArrayList<Member> memberList;
	private HashMap<String, Facility> facilitymap;
	private BookingRegister br;
	private ArrayList <Booking> reqBookingList;
	
	public Club()
	{
		this.currentNum = 0;
		this.memberList = new ArrayList<Member>();
		this.facilitymap = new HashMap<String, Facility>();
		this.br = new BookingRegister();
	}
	
	public void addBooking(int memberNum, String FacName, Calendar sDate, Calendar eDate) throws BadBookingException
	{
		br.addBooking(facilitymap.get(FacName),memberList.get(memberNum),  sDate, eDate);
	}
	
	public void getBookings(String FacName, Calendar sDate, Calendar eDate)
	{
		reqBookingList = br.getBookings(facilitymap.get(FacName), sDate, eDate);
	}
	
	public void showBookings(String FacName, Calendar sDate, Calendar eDate)
	{
		this.getBookings(FacName, sDate, eDate);
		for(Iterator<Booking> i = reqBookingList.iterator(); i.hasNext();)
		{
			Booking b = i.next();
			b.show();	
		}
	}
	
	public void addFacility(String facName, String description)
	{
		Facility f = new Facility(facName, description);
		facilitymap.put(f.getName(), f);
	}
	
	public Facility getFacility(String name)
	{
		return facilitymap.get(name);
	}
	
	public void removeFacility(String name)
	{
		try{
			facilitymap.remove(name);
		} catch(Exception e)
		{
			System.out.println("No such facility.");
		}		
	}
	
	public HashMap<String, Facility> getFacilities()
	{
		return facilitymap;
	}

	public void showFacilities()
	{
		Set<String> facilityKey = facilitymap.keySet();
		
		for (Iterator<String> i = facilityKey.iterator(); i.hasNext();)
		{
			String facName = i.next();
			Facility f = facilitymap.get(facName);
			f.show();			
		}	
	}
	
	public void show()
	{
		this.showFacilities();
		this.showMembers();
	}
	
	public ArrayList<Member> getMemberList() {
		Collections.sort(memberList);
		return memberList;
	}

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}
	
	public Member addMember(String surname, String firstname, String secondname)
	{	
		currentNum++;
		Member m = new Member(surname, firstname, secondname, currentNum);
		memberList.add(m);
		return m;
		
// 		Arrary Method
//		currentNum++;
//		Member m = new Member(surname, firstname, secondname, currentNum);	
//		memberList2[currentNum-1] = m;
//		return m;
	}
	
	public Member addMember(String surname, String firstname)
	{
		currentNum++;
		Member m = new Member(surname, firstname, currentNum);	
		memberList.add(m);
		return m;
		
		// Add member using array
//		currentNum++;
//		Member m = new Member(surname, firstname, currentNum);	
//		memberList2[currentNum-1] = m;
//		return m;
	}
	
	public void showMembers()
	{
		this.getMemberList();
		for (Iterator<Member> i = memberList.iterator(); i.hasNext();)
		{
			Member m = i.next();
			m.show();
		}	
		
		// For loop for array
//		for (int i =0; i<memberList2.length; i++)
//		{
//			if(memberList2[i] != null)
//			{
//				System.out.println(memberList2[i].toString());
//			}
//			else
//			{
//				continue;
//			}
//
//		}
	}

	public void removeMembers(int number)
	{
		int currentIndex = -1;
		
		for (Iterator<Member> i = memberList.iterator(); i.hasNext();)
		{
			Member m = i.next();
			if (m.getMemberNumber() == number)
			{
				currentIndex = memberList.lastIndexOf(m);
				memberList.remove(currentIndex);
				break;
			}
			
		}
		
		
		//Remove member using array
//		for (int i = 0; i<memberList2.length; i++)
//		{
//			if (i == number-1)
//			{
//				memberList2[i] = null;
//			}
//		}
	}
}
