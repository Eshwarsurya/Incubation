package Final.Task2;
import java.util.Scanner;

public class Main{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str=sc.nextLine();
		Implement obj=new Implement(null);							//"alAKU@%"
		System.out.println(obj.isEmpty());
//		System.out.println(obj.toLowerCase());
//		System.out.println(obj.toUpperCase());
//		System.out.println("Enter string to concat:");
//		String str2=sc.nextLine();
//		System.out.println(obj.concat(str2));
//		System.out.println(obj.toCharArray());
//		System.out.println(obj.trim());
//		System.out.println("Enter the another string");
//		String str3=sc.nextLine();
//		System.out.println(obj.startsWith("ac"));
		System.out.println("Enter the another string");
//		String str4=sc.nextLine();
//		System.out.println(obj.endsWith(str4));
//		System.out.println(obj.codePointAt(1));
//		System.out.println(obj.codePointBefore(1));
//		System.out.println(obj.codePointCount(0,5));
//		System.out.println(obj.compareTo(str4));
//		System.out.println(obj.compareToIgnoreCase(str4));
//		System.out.println(obj.contains(str4));
//		System.out.println(obj.hashCode());
//		System.out.println(obj.copyValueOf(str,1,3));
		String str5=sc.nextLine();
		System.out.println(obj.equals(str5));
		System.out.println(obj.equalsIgnoreCase(str5));
//		System.out.println(obj.charAt(2));
//		System.out.println(obj.length());
//		System.out.println(obj.valueOf(true));
//		System.out.println(obj.subString(4));
//		System.out.println(obj.subString(1,3));
//		System.out.println(obj.replace('u', 'r'));
	}

}
