package application;

import java.util.*;

import model.BadBookingException;
import model.Member;
import data.*;

import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClubApplication {

	public static Calendar ConvertDate(String s) throws ParseException {
		Date input = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			input = sdf.parse(s);
		} catch (ParseException e) {
			throw e;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(input);
		return cal;
	}

	public static void main(String[] args) throws ParseException, DAOException {
		// TODO Auto-generated method stub

		// Person p = new Person("li", "bingzhao", null);
		// Person q = new Person ("laura", "tan");

		// System.out.println(q);
		// System.out.println(q.show());

		// Facility f1 = new Facility("Badminton Court");
		// Facility f2 = new Facility ("Football Field", "Five a side");

		// System.out.println(f1.show());
		// System.out.println(f2.show());

		// System.out.println(p.toString());
		// System.out.println(f1.toString());

		// Member m1 = new Member("li", "bingzhao", 123456);
		// System.out.println(m1.show());

		Club myClub = new Club();

		Member m2 = myClub.addMember("PAGE", "LARRY");
		Member m3 = myClub.addMember("GATES", "BILL");
		Member m4 = myClub.addMember("JOSH", "ROBINSON", "CRUISE");

		// myClub.removeMembers(2);
		// myClub.showMembers();

		myClub.addFacility("Futsal Court", "Five-a-side");
		myClub.addFacility("Tennis Court", "clay court");
		myClub.addFacility("Basketball court", "Indoor with airconditioning");
		// myClub.show();

		// ArrayList<Booking> bookingList = new ArrayList<Booking>();
		// BookingRegister br = new BookingRegister();
		try {
			myClub.addBooking(m2.getMemberNumber(), "Futsal Court", ConvertDate("04/06/2017"),
					ConvertDate("05/06/2017"));
			myClub.addBooking(m3.getMemberNumber(), "Futsal Court", ConvertDate("06/06/2017"),
					ConvertDate("12/06/2017"));
			myClub.showBookings("Futsal Court", ConvertDate("01/01/2017"), ConvertDate("30/12/2017"));
		} catch (BadBookingException e) {
			System.out.println(e.getMessage());
		}

		myClub.showMembers();



		MemberDAO mDAO = new MemberDAOImpl();
		ArrayList<Member> mList = new ArrayList<Member>();
		mList = mDAO.listAllMember();
		System.out.println("\nShowing Database results");
		if(mList==null) throw new DAOException("Table is empty");
		else
		{
			for(Iterator<Member> i = mList.iterator(); i.hasNext();)
			{
				Member m = i.next();
				m.show();
			}
		}

		

		/*
		 * Start of old booking code try { Booking bk1 = new
		 * Booking(myClub.getFacility("Futsal Court"), m2, date1, date2);
		 * bk1.show(); } catch (BadBookingException e) {
		 * System.out.println(e.getMessage()); };
		 * 
		 * Calendar date3 = Calendar.getInstance(); Calendar date4 =
		 * Calendar.getInstance(); date3.set(2017, 4, 3); date4.set(2017, 4,
		 * 10);
		 * 
		 * try{ Booking bk2 = new Booking(myClub.getFacility("Futsal Court"),
		 * m2, date3, date4); bk2.show(); } catch (BadBookingException e) {
		 * System.out.println(e.getMessage()); };
		 * 
		 * Calendar date5 = Calendar.getInstance(); Calendar date6 =
		 * Calendar.getInstance();
		 * 
		 * try{ Booking bk3 = new Booking
		 * (myClub.getFacility("Basketball court"), m2, date5,date6);
		 * bk3.show(); } catch (BadBookingException e) {
		 * System.out.println(e.getMessage()); } end of old booking code
		 */

		// if(bk1.overlaps(bk2))
		// {
		// System.out.println("Dates overlap");
		// }
		// else
		// {
		// System.out.println("Dates do not overlap");
		// }

		// System.out.println(m2.show());
		// System.out.println(m3.show());
		// System.out.println(m4.show());

	}

}
