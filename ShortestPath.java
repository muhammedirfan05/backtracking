// import java.util.*;
public class ShortestPath
{
    static int flag = 0;
    static int shortest[][];
    static int shortestDistance = Integer.MAX_VALUE;
    public static void main(String arg[])
    {
        
        int n=5;
        int a[][]={{0,1,0,0,0},
                    {0,1,0,1,0},
                    {0,0,0,1,0},
                    {1,0,1,1,0},
                    {1,0,0,0,0},
                };
        int sol[][]=new int[n][n];
        shortest=new int[n][n];
        findMaze(0,0,a,sol,1);
        if(flag==0)
        {
           System.out.println("no path found");
           return;
        }
        System.out.println("Mininum Path->"+shortestDistance);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(shortest[i][j]+" ");
            System.out.println();
        }
    }
    public static boolean findMaze(int i,int j,int a[][],int sol[][],int count)
    {
        if(i==sol.length-1&&j==sol.length-1&&a[i][j]==0)
        {
            sol[i][j]=1;
            flag=1;
            if(count<shortestDistance)
            {
                shortestDistance=count;
                for(int x=0;x<sol.length;x++)
                {
                    for(int y=0;y<sol.length;y++)
                        shortest[x][y]=sol[x][y];
                }
            }
            return false;
        }
        if((i>=0&&i<=sol.length-1)&&(j>=0&&j<=sol.length-1)&&a[i][j]==0&&sol[i][j]==0)
        {
            sol[i][j]=1;
            if(findMaze(i+1,j,a,sol,count+1))   return true;
            if(findMaze(i,j+1,a,sol,count+1))   return true;
            if(findMaze(i-1,j,a,sol,count+1))   return true;
            if(findMaze(i,j-1,a,sol,count+1))   return true;
            sol[i][j]=0;
            return false;
        }
        return false;
    }
}