package Workshop1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class BookingRegister
{
	private HashMap<Facility, ArrayList<Booking>> register = new HashMap<Facility, ArrayList<Booking>>();

	public void addBooking(Member member, Facility facility, Date startDate, Date endDate) throws BadBookingException
	{
		if(!register.containsKey(facility))
		{
			register.put(facility, new ArrayList<Booking>());
		}
		
		try
		{
			Booking b = new Booking(member, facility, startDate, endDate);
			for (Booking booking : register.get(facility))
			{
				if (booking.overlaps(b))
				{
					System.out.println(booking);
					throw new BadBookingException("Overlap!");
				}
			}
			register.get(facility).add(b);
		} catch (BadBookingException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Booking> getBookings(Facility facility, Date startDate, Date endDate)
	{
		ArrayList<Booking> result = new ArrayList<Booking>();
		try
		{
			Booking vbooking = new Booking(new Member("","","",0), facility, startDate, endDate);
			for (Booking b : register.get(facility))
			{
				if (b.overlaps(vbooking))
				{
					result.add(b);
				}
			}
		} catch (BadBookingException e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return result;
	}
}
