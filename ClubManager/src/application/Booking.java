package application;
import java.util.Date;

import model.BadBookingException;
import model.Facility;
import model.Member;

import java.util.*;

public class Booking {
	
	private Facility f;
	private Member m;
	private Calendar startdate;
	private Calendar enddate;
	

	public Booking(Facility f, Member m, Calendar startdate, Calendar enddate) throws BadBookingException 
	{	
		super();
		
		if (f==null || m==null || startdate==null || enddate==null)
		{
			throw new BadBookingException("Missing Booking Info");
		}
		
		if (startdate.after(enddate))
		{
			throw new BadBookingException("Invalid date input");
		}
		
		this.f = f;
		this.m = m;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	
	public Facility getF() {
		return f;
	}


	public void setF(Facility f) {
		this.f = f;
	}


	public Member getM() {
		return m;
	}


	public void setM(Member m) {
		this.m = m;
	}


	public Calendar getStartdate() {
		return startdate;
	}


	public void setStartdate(Calendar startdate) {
		this.startdate = startdate;
	}


	public Calendar getEnddate() {
		return enddate;
	}


	public void setEnddate(Calendar enddate) {
		this.enddate = enddate;
	}


	public boolean overlaps(Booking bk)
	{
		boolean overlap = false;	

		if(this.enddate.after(bk.startdate) && bk.enddate.after(this.startdate))
		{
			overlap = true;
		}
		
		return overlap;
	}
	
	public String toString()
	{
	
		return(this.f.toString() + "\n" + this.m.toString()+ "\n" + displayDate(startdate)+" - "
	+ displayDate(enddate));
	}
	
	public void show()
	{
		System.out.println(toString());	
	}
	
	private String displayDate(Calendar inputDate)
	{		
		return (inputDate.get(Calendar.DATE) + "/" + (inputDate.get(Calendar.MONTH)+1) + "/" 
	+ inputDate.get(Calendar.YEAR));
	}

}
