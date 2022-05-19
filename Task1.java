package Final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
	public static void expression(String str)
	{
		int fstExp=0,nxtExp=0,coef=0;
		char[] ch=str.toCharArray();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		List<Map<Character,Integer>> list1=new ArrayList<Map<Character,Integer>>();
		List<Map<Character,Integer>> list2=new ArrayList<Map<Character,Integer>>();
		List<Map<Character, Integer>> resultList =new ArrayList<Map<Character, Integer>>();
		for(int i=0;i<str.length();i++)
		{
			if(ch[i]==')')
			{
			
				fstExp=i;
				nxtExp=i+2;
				break;
			}
		}
		for(int i=0;i<fstExp+1;i++)										//First Term
		{
			if(ch[i]=='+'||ch[i]=='-'||ch[i]==')')
			{
				list1.add(map);
				map=new HashMap<Character,Integer>();
				continue;
				
			}
			else
			{
				if((Character.isDigit(ch[i]))&&ch[i-1]!='^')				//coefficient
				{
					if(ch[i-1]=='('||ch[i-1]=='+'||ch[i-1]=='-')
					{
						if(ch[i-1]=='-')
							map.put('c', ((ch[i]-'0')*-1));
						else
						map.put('c', ch[i]-'0');
					}
					else
					{
						if(ch[i-1]=='-')
							map.put('c', -1);
						else	
							map.put('c', 1);
					}
				}
				
				if((ch[i]>='a'&&ch[i]<='z'))								//Variable
				{
					if(ch[i-1]=='('||ch[i-1]=='+'||ch[i-1]=='-')
					{
						if(ch[i-1]=='-')
							map.put('c', -1);
						else	
							map.put('c', 1);
					}
					if(ch[i+1]=='^')
					{
						map.put(ch[i], ch[i+2]-'0');
					}
					else
						map.put(ch[i],1);
				}
			}
		}
//		System.out.println(list1);
		for(int i=nxtExp;i<str.length();i++)								//Second term
		{
			if(ch[i]=='+'||ch[i]=='-'||ch[i]==')')
			{
				list2.add(map);
//				System.out.println(list1);
				map=new HashMap<Character,Integer>();
				continue;
				
			}
			else
			{
				if((Character.isDigit(ch[i]))&&ch[i-1]!='^')				//coefficient
				{
					if(ch[i-1]=='('||ch[i-1]=='+'||ch[i-1]=='-')
					{
						if(ch[i-1]=='-')
							map.put('c', ((ch[i]-'0')*-1));
						else
						map.put('c', ch[i]-'0');
					}
					else
					{
						if(ch[i-1]=='-')
							map.put('c', -1);
						else
							map.put('c', 1);
					}
				}
				
				
				if((ch[i]>='a'&&ch[i]<='z'))								//Variable
				{
					if(ch[i-1]=='('||ch[i-1]=='+'||ch[i-1]=='-')
					{
						if(ch[i-1]=='-')
							map.put('c', -1);
						else	
							map.put('c', 1);
					}
					if(ch[i+1]=='^')
					{
						map.put(ch[i], ch[i+2]-'0');
					}
					else
						map.put(ch[i],1);
				}
				
			}
		}
//		System.out.println(list2);											//Compare
			for (int i = 0; i< list1.size() ; i++)
			{
	         for (int j = 0; j < list2.size(); j++)
	         {
	        	  Map<Character, Integer> newMap = new HashMap<>();
	        	  for (Map.Entry<Character,Integer> mp: list1.get(i).entrySet()) 
	        	  {
	              	newMap.put(mp.getKey(), mp.getValue());
	        	  }
	              	 for (Map.Entry<Character,Integer> mp: list2.get(j).entrySet()) 
	              	 {

		                    if(mp.getKey()=='c')
		                    {
		                    	newMap.put(mp.getKey(),( newMap.get(mp.getKey())*(mp.getValue())));
		                        continue;
		                        
		                    }
		                    if(newMap.containsKey(mp.getKey()))
		                    {
		                    	newMap.put(mp.getKey(), newMap.get(mp.getKey()) + mp.getValue());
		                        continue;
		                    }
		                    newMap.put(mp.getKey(), mp.getValue());
	              	 }  
	              	 resultList.add(newMap);
	              	
			}
			}
//	        System.out.println("List is"+resultList);
			 for (Map<Character, Integer>mp: resultList) {

		            for (Map.Entry<Character,Integer> m: mp.entrySet()) {
		                if(m.getKey()=='c'){
		                	System.out.print(m.getValue()<0 ? m.getValue() : "+"+m.getValue());
		                    continue;
		                }
		                System.out.print(m.getKey() + "^"+ m.getValue());
		            }

		        }
		
		
	}
		public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the expression");					// (2x^2y+3xy^2z-xz^3)*(5xyz+3y^2z-2z)
			String str=sc.nextLine();
			expression(str);

		}

}
