package Workshop1;

public class Person
{
	protected String surName;
	protected String firstName;
	protected String secondName;

	public Person(String surName, String firstName, String secondName)
	{
		super();
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = secondName;
	}

	public Person(String surName, String firstName)
	{
		super();
		this.surName = surName;
		this.firstName = firstName;
		this.secondName = null;
	}

	public String getSurName()
	{
		return surName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getSecondName()
	{
		return secondName;
	}

	public void show()
	{
		System.out.println(toString());
	}
	public String toString()
	{
		return secondName == null ? surName + " " + firstName : surName + " " + firstName + " " + secondName;
	}
}
