package application;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import model.BadBookingException;
import model.Facility;
import model.Member;

public class BookingRegister {
	
	private Facility f;
	private Member m;
	private ArrayList <Booking> bookingsList;
	private HashMap <Facility,ArrayList<Booking>> bookingsMap;
	
	public BookingRegister() {
		super();
		this.bookingsMap = new HashMap<Facility, ArrayList<Booking>> ();
	}
	
	public void addBooking(Facility f, Member m, Calendar startdate, Calendar enddate) throws BadBookingException
	{
		Booking b = new Booking(f,m,startdate,enddate);		

		if (!bookingsMap.containsKey(f))
		{
			bookingsList = new ArrayList<Booking>();
			bookingsList.add(b);
			bookingsMap.put(f, bookingsList);		
		}
		else
		{
			bookingsList = bookingsMap.get(f);
			for (Iterator <Booking> i = bookingsList.iterator(); i.hasNext();)
			{
				Booking n = i.next();
				if(n.overlaps(b)) throw new BadBookingException("Booking overlaps");
			}
			bookingsList.add(b);
		}
	}
	
	public ArrayList<Booking> getBookings(Facility f, Calendar sDate, Calendar eDate)
	{
		ArrayList<Booking> requestedBookings = new ArrayList<Booking>();
		bookingsList = bookingsMap.get(f);
		
		for (Iterator <Booking> i = bookingsList.iterator(); i.hasNext();)
		{
			Booking n = i.next();
			if(n.getStartdate().after(sDate) && n.getEnddate().before(eDate))
			{
				requestedBookings.add(n);
			}
		}
		
		return requestedBookings;	
	}
	
	
	public void removeBooking(Booking b) throws Exception
	{
		int index = -1;
		f = b.getF();	
		bookingsList = bookingsMap.get(f);
		
		index = bookingsList.indexOf(b);
		if (index==-1) throw new Exception("No booking found.");
		else
		{
			bookingsList.remove(index);
		}			
	}
}
