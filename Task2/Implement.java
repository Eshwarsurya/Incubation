package Final.Task2;
import java.util.Arrays;
import java.util.Scanner;

public class Implement {
String s;
public Implement(String str)
{
	s=str;
	
}

public boolean isEmpty()		//isEmpty
{

	if(s==""&&s=="null")
		return true;
	else
		return false;
}


public String toLowerCase()					//toLowercase
{
	char[] ch=toCharArray();
	String string="";
	for(int i=0;i<s.length();i++)
	{
		 if(ch[i]>='A'&&ch[i]<='Z')
		{
			string+=((char)((int)ch[i]+32));
		} 
		 else 
		{
			string+=ch[i];
		}
	}

	return string;					
}


private char[] toLowerCase1(String str1)					//toLowercase for internal conversion
{
	char[] ch=toCharArray();
	char[] result=new char[str1.length()];
	for(int i=0;i<str1.length();i++)
	{
		if(ch[i]>='A'&&ch[i]<='Z')
		{
			result[i]=((char)((int)ch[i]+32));
		}
		else
		{
			result[i]=ch[i];
		}
	}

	return result;					
}


public String toUpperCase()						//toUpperCase
{
	char[] ch=toCharArray();
	String string="";
	for(int i=0;i<s.length();i++)
	{
		if(ch[i]>='a'&&ch[i]<='z')
		{
			string+=((char)((int)ch[i]-32));
		}
		else
		{
			string+=ch[i];
		}
	}
	return string;
}


public String concat(String str2)		//concat
{
	String result="";
	result=s+str2;
	return result;
}


public char[] toCharArray()					//toCharArray
{
	char[] result=new char[s.length()];
	for(int i=0;i<s.length();i++)
	{
		result[i]=s.charAt(i);
	}
	return result;
}


private char[] toCharArray1(String str3)			//for internal conversion
{
	char[] result=new char[str3.length()];
	for(int i=0;i<str3.length();i++)
	{
		result[i]=str3.charAt(i);
	}
	return result;
}


public String trim()							//trim
{
	char[] ch=toCharArray();
	int start=0,end=0;
	String string="";
	for(int i=0;i<s.length();i++)
	{
		if(ch[i]!=' ')
		{
			start=i;
			break;
		}
	}
	for(int i=s.length()-1;i>=0;i--)
	{
		if(ch[i]!=' ')
		{
			end=i;
			break;
		}
	}
	for(int i=start;i<=end;i++)
	{
		string+=ch[i];
	}
	return string;
}


public boolean startsWith(String str3)				//StartsWith
{
	boolean flag=false;
	char[] ch1=toCharArray();
	char[] ch2=toCharArray1(str3);
	for(int i=0;i<str3.length();i++)
	{
		if(ch1[i]==ch2[i])
		{
			flag= true;
			
		}
		else if(ch2[i]=='\0')
			break;
	}
	return flag;
}


public boolean endsWith(String str3)				//endsWith
{
	boolean flag=false;
	char[] ch1=toCharArray();
	char[] ch2=toCharArray1(str3);
	for (int l = 0, h = str3.length() - 1; l < h; l++, h--)
    {
        char temp = ch2[l];
        ch2[l] = ch2[h];
        ch2[h] = temp;
    }
	for (int l = 0, h = s.length() - 1; l < h; l++, h--)
    {
        char temp = ch1[l];
        ch1[l] = ch1[h];
        ch1[h] = temp;
    }
	for(int i=0;i<str3.length();i++)
	{
		if(ch1[i]==ch2[i])
		{
			flag= true;
			
		}
		else if(ch1[i]!=ch2[i])
		{
			flag=false;
			break;
		}
			
	}
	return flag;
}


public int codePointAt(int i)				//codePointAt
{
	char[] ch=toCharArray();
	return (int)ch[i];
}


public int codePointBefore(int i)			//codePointBefore
{
	char[] ch=toCharArray();
	if(i!=0)
	 return (int)ch[i-1];
	else 
		return 0;
}


public int codePointCount(int start,int end)			//codePointCount
{
	if(start<0||end>s.length()||start>end)
		return 0;
	else
	return end-start;
}


public int compareTo(String str1) 				//compareTo
{
	char[] ch1=toCharArray();
	char[] ch2=toCharArray1(str1);
	int len1=ch1.length;
	int len2=ch2.length;
	int length=(len1>len2)?len2:len1;
	int i=0,result=0;
	if(len1!=len2)
	{
		return len1-len2;
	}
	else
	{
		while(i<length)
		{
			char c1=ch1[i];
			char c2=ch2[i];
			if(c1!=c2)
				result=c1-c2;	
			i++;
		}
		return result;
	}
}


public int compareToIgnoreCase(String str4)					//compareToIgnoreCase
{
	char[] ch1=toLowerCase1(s);
	char[] ch2=toLowerCase1(str4);
	int len1=ch1.length;
	int len2=ch2.length;
	int length=(len1>len2)?len2:len1;
	int i=0,result=0;
	if(len1!=len2)
		return len1-len2;
	else 
	{
	while(i<length)
	{
		char c1=ch1[i];
		char c2=ch2[i];
		if(c1!=c2)
			result= c1-c2;
		i++;
	}
	return result;
	}
}

public boolean contains(String str5)				//contains
{
	char[] ch1=toCharArray();
	char[] ch2=toCharArray1(str5);
	boolean result=false;
	int count=0;
	for(int i=0;i<ch1.length;i++)
	{
		for(int j=0;j<ch2.length;j++)
		{
			if(i<ch1.length&&ch1[i]==ch2[j])
			{
				count++;
				result=true;
				i++;
				continue;
				
			}
			else
			{
				result=false;
				break;
			}
			
		} 
		if(count==ch2.length)
			{
				i=ch1.length;
			}
		
	}
	return result;
}



public int hashCode()							//hashCode
{
	char[] ch=toCharArray();
	int len=ch.length;
	int result=0;
	for(int i=0;i<len;i++)
	{
		result+=(int)ch[i]*Math.pow(31,(len-(i+1)));
	}
	return result;
}

public String copyValueOf(String str,int start,int value)			//copyValueOf
{
	char ch1[]=toCharArray1(str);
	String string="";
	if(start>=0&&value<str.length())
	{
		for(int i=start;i<=value;i++)
		{
			string+=ch1[i];	
		}
	}
	else
	{
		return "0";
	}
	return string;
}


public boolean equals(String str5)					//equals
{
	char ch1[]=toCharArray();
	char ch2[]=toCharArray1(str5);
	boolean result=false;
	if(ch1.length!=ch2.length)
	{
		result=false;
	}
	else
	{
	for(int i=0;i<str5.length();i++)
	{
		if(ch1[i]==ch2[i])
		{
			result=true;
		}
		else
		{
			result=false;
			break;
		}
	}
	}
	return result;
}


public boolean equalsIgnoreCase(String str5)					//equalsIgnoreCase
{
	char ch1[]=toLowerCase1(s);
	char ch2[]=toLowerCase1(str5);
	boolean result=false;
	if(ch1.length!=ch2.length)
	{
		result=false;
	}
	else
	{
		for(int i=0;i<str5.length();i++)
		{
		if(ch1[i]==ch2[i])
		{
			result=true;
		}
		else
		{
			result=false;
			break;
		}
	}
	}
	return result;
}


public char charAt(int index)				//charAt
{
	char[] ch=s.toCharArray();
	if(index<s.length())
		return ch[index];
	else
		return '0';
}


public int length()							//length
{
	char ch[]=s.toCharArray();
	return ch.length;
}


public String valueOf(Object obj)				//valueOf
{
	return obj+"";
}

public String subString(int index)				//subString(index)
{
	char ch[]=s.toCharArray();
	String string="";
	if(index>0&&index<s.length())
	{
	for(int i=index;i<s.length();i++)
	{
		string+=ch[i];
	}
	}
	else
	{
		string="";
	}
	return string;
}


public String subString(int start,int end)				//subString(start,end)
{
	char ch[]=s.toCharArray();
	String string="";
	if(start>0&&end<s.length())
	{
		for(int i=start;i<end;i++)
		{
			string+=ch[i];
		}
	}
	else
	{
		string="";
	}
	return string;
}


public String replace(char oldChar,char newChar)			//replace
{
	char ch[]=s.toCharArray();
	String string="";
	for(int i=0;i<s.length();i++)
	{
		if(ch[i]!=oldChar)
		{
			string+=ch[i];
		}
		else
		{
			ch[i]=newChar;
			string+=ch[i];
		}
	}
	return string;
}


}

