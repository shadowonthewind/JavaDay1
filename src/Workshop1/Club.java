package Workshop1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Club
{
	private ArrayList<Member> members = new ArrayList<Member>();
	private HashMap<String, Facility> facilities = new HashMap<String, Facility>();
	private BookingRegister br = new BookingRegister();

	// Member Methods
	public Member addMember(String surname, String firstName, String secondName)
	{
		Member m = new Member(surname, firstName, secondName, lowestEmptyNumber());
		members.add(m);
		return m;
	}

	private int lowestEmptyNumber()
	{
		boolean unfound = true;
		int n = 1;
		while (unfound)
		{
			unfound = false;
			for (Member m : members)
			{
				if (m.getMemberNumber() == n)
				{
					unfound = true;
					n++;
					break;
				}
			}
		}
		return n;
	}

	public void showMembers()
	{
		for (Member m : members)
		{
			if (m != null)
				m.show();
		}
	}

	public void removeMember(int i)
	{
		for (Member member : members)
		{
			if (member.getMemberNumber() == i)
			{
				members.remove(member);
				return;
			}
		}
	}

	// Facility Methods
	public void addFacility(String name, String description)
	{
		Facility f = new Facility(name, description);
		facilities.put(name, f);
	}

	public Facility getFacility(String name)
	{
		return facilities.get(name);
	}

	public ArrayList<Facility> getFacilities()
	{
		ArrayList<Facility> result = new ArrayList<Facility>();
		Set<String> keys = facilities.keySet();
		for (String key : keys)
		{
			result.add(facilities.get(key));
		}
		return result;
	}

	public void showFacilities()
	{
		for (Facility f : getFacilities())
		{
			f.show();
		}
	}

	public void removeFacility(String name)
	{
		if (facilities.containsKey(name))
		{
			facilities.remove(name);
			System.out.println("Removed " + name);
		} else
		{
			System.out.println("No such facility found: " + name);
		}
	}

	public void show()
	{
		showFacilities();
		showMembers();
	}

	public void addBooking(int memNo, String facName, Date startDate, Date endDate)
	{
		try
		{
			Member m1 = null;
			Facility f1 = facilities.get(facName);
			for (Member m : members)
			{
				if (m.getMemberNumber() == memNo)
				{
					m1 = m;
					break;
				}
			}
			br.addBooking(m1, f1, startDate, endDate);
		} catch (BadBookingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
