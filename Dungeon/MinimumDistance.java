package gold;

public class MinimumDistance 
{
	static int shortestPath(int[][] matrix, int[] start, int[] end) 
	{
		int m= matrix.length;
		int n = matrix[0].length;
		boolean[][] visited =new boolean[m][n];
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j<n; j++) 
			{
				if (matrix[i][j] == 0)
				{
					visited[i][j] = true;
				}
				else 
				{
					visited[i][j] = false;
				}
			}
		} 
		int count = visitUtil(matrix, start, end, visited, Integer.MAX_VALUE,0); 
		return count;
	}
	
	static int visitUtil(int[][] matrix, int[] start, int[] end, boolean[][] visited, int shortest, int dist) 
	{ 
		int sx= start[0],sy=start[1];
		int dx = end[0], dy=end[1];
		if(matrix[sx][sy] == 0 || matrix[dx][dy] == 0|| !isValid(matrix, sx, sy, visited)) 
		{
			return Integer.MAX_VALUE;
		}
		if(sx==dx && sy == dy) 
		{
			return Math.min(dist,shortest);
		}
	
		visited[sx][sy]=true; 
		if(isValid (matrix, sx-1, sy, visited))
		{
			shortest=visitUtil(matrix, new int[]{sx-1,sy}, end,visited, shortest, dist+1);
		}
		if (isValid(matrix, sx+1, sy, visited))
		{
			shortest=visitUtil(matrix, new int[]{sx+1, sy}, end, visited, shortest, dist+1);
		}
		if (isValid(matrix, sx, sy-1, visited)) 
		{
			shortest=visitUtil(matrix, new int[]{sx,sy-1}, end, visited, shortest, dist+1);
		}
		if (isValid(matrix, sx, sy+1, visited))
		{
			shortest=visitUtil(matrix, new int[]{sx, sy+1}, end, visited, shortest, dist+1);
		}
		visited[sx][sy] = false; 
		return shortest;
	}

	static boolean isValid(int[][] matrix, int x, int y, boolean[][] visited)
	{
		if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]==1 && !visited[x][y]) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
