package Day1;

public class Ex1 {
	public static void primitivetest (int i)
	{
		System.out.println("Before: \t" + i);
		i = 5;
		System.out.println("After: \t\t" + i);
	}
 public static void main (String[] args)
 {
//	 int i = 3;
//	 primitivetest(i);
//	 System.out.println("Outside: \t" + i);
	 long l = 1114;
	 byte b = (byte) l;
	 System.out.println(b);
 }
}
