package gold;

import java.util.Scanner;

public class Monster {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		System.out.println("Dimensions of the dungeon(Row x Column):");
		Scanner sc= new Scanner(System.in);
		int row=sc.nextInt();
		int column=sc.nextInt();
		int[][] matrix=new int[row][column];
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[i].length;j++)
			{
				matrix[i][j]=1;
			}
		} 
		System.out.println("Position of Adventurer: ");
		int ar=sc.nextInt();
		int ac=sc.nextInt();
		int[] start = {ar-1,ac-1};
		System.out.println("Position of Gold: ");
		int gr=sc.nextInt();
		int gc=sc.nextInt(); 
		int[] end = {gr-1,gc-1};
		System.out.println("Position of Monster: ");
		int mr=sc.nextInt();
		int mc=sc.nextInt(); 
		int[] mon = {mr-1,mc-1};
		int adventurerCount=MinimumDistance.shortestPath(matrix, start, end);
		int monsterCount=MinimumDistance.shortestPath(matrix, mon, end);
		if(adventurerCount>monsterCount)
		{
			System.out.println("No possible solution");
		}
		else
		{
			System.out.println("Minimum number of steps:"+adventurerCount);
		}
		

	}

}
