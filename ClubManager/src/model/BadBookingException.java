package model;
import java.lang.Exception;

public class BadBookingException extends Exception {
	

	public BadBookingException ()
	{};
	
	public BadBookingException (String s)
	{
		super(s);
	}
	
}
