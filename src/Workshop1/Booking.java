package Workshop1;

import java.util.Date;

public class Booking
{
	private Member member;
	private Facility facility;
	private Date startDate;
	private Date endDate;

	public Booking(Member member, Facility facility, Date startDate, Date endDate) throws BadBookingException
	{
		super();
		String error = null;
		if (member == null)
		{
			error = "Invalid member";
		} else if (facility == null)
		{
			error = "Invalid facility";
		} else if (startDate == null || endDate == null)
		{
			error = "Invalid date";
		} else if (startDate.after(endDate) || endDate.before(startDate))
		{
			error = "wrong date sequence";
		}
		if (error != null)
		{
			throw new BadBookingException(error);
		}
		this.member = member;
		this.facility = facility;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Member getMember()
	{
		return member;
	}

	public Facility getFacility()
	{
		return facility;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public boolean overlaps(Booking that)
	{
		return (!(that.getStartDate().compareTo(this.endDate) > 0 || that.getEndDate().compareTo(this.startDate) < 0)
				&& this.facility.getName().equals(that.getFacility().getName()));
	}

	public String toString()
	{
		return "Member: " + member.toString() + "\nFacility: " + facility.toString() + "\nDate: " + startDate.toString()
				+ " to " + endDate.toString();
	}

	public void show()
	{
		System.out.println(toString());
	}
}
