package Workshop1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClubManager
{

	public static void main(String[] args)
	{
		int i = 5;
		String j = new Integer(i).toString();
		Person p1 = new Person("Alice", "a");
		Person p2 = new Person("Bob", "b", "c");
		p1.show();
		p2.show();
		Facility f1 = new Facility("swimming pool", "cold water");
		Facility f2 = new Facility("tennis court");
		f1.show();
		f2.show();
		Club c = new Club();
		Member m1 = c.addMember("Alice", "a", null);
		Member m2 = c.addMember("Bob", "b", "Barnes");
		Member m3 = c.addMember("Carl", "c", "Cake");
		// m1.show();
		// m2.show();
		// m3.show();
		// System.out.println(c.lowestEmptyNumber());
		c.showMembers();
		c.removeMember(2);
		c.showMembers();
		// System.out.println(c.lowestEmptyNumber());

		c.addFacility("sports hall 1", "Buggered if i know");
		c.addFacility("sports hall 2", "Buggered if i know this one too");
		c.showFacilities();
		c.removeFacility("sports hall 2");

		c.show();
		try
		{
			Booking b1 = new Booking(m3, f2, new Date(2016, 11, 3), new Date(2016, 11, 4));
			Booking b2 = new Booking(m2, f1, new Date(2016, 11, 2), new Date(2016, 11, 6));
			Booking b3 = new Booking(m1, f2, new Date(2016, 11, 2), new Date(2016, 11, 6));
		} catch (BadBookingException e)
		{
			System.out.println(e.getMessage());
		}
		// System.out.println(b1.overlaps(b2));
		// System.out.println(b1.overlaps(b3));
		// b1.show();
		// b2.show();

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		BookingRegister br = new BookingRegister();
		try
		{
			Date b1s = df.parse("1-11-2016");
			Date b1e = df.parse("2-11-2016");
			Date b2s = df.parse("3-11-2016");
			Date b2e = df.parse("4-11-2016");
			Date b3s = df.parse("5-11-2016");
			Date b3e = df.parse("6-11-2016");

			br.addBooking(m1, f1, b1s, b1e);
			br.addBooking(m2, f1, b2s, b2e);
			br.addBooking(m3, f1, b3s, b3e);
			
			System.out.println(br.getBookings(f1, b2s, b3e));
		} catch (ParseException e)
		{
			System.out.println(e.getMessage());
		} catch (BadBookingException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
