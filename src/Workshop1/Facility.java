package Workshop1;

public class Facility
{
	private String name;
	private String description;

	public Facility(String name, String description)
	{
		super();
		this.name = name;
		this.description = description;
	}

	public Facility(String name)
	{
		super();
		this.name = name;
		this.description = null;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public void show()
	{
		System.out.println(toString());
	}
	
	public String toString()
	{
		String result = description == null ? name : name + ": " + description;
		return result;
	}
}
