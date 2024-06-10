// import java.util.*;
public class AllPossiblePath
{
    static int flag = 0;
    public static void main(String arg[])
    {
        // Scanner sc=new Scanner(System.in);
        int n=5;
        int a[][]={ {0,1,0,0,0},
                    {0,1,0,1,0},
                    {0,0,0,1,0},
                    {1,0,1,1,0},
                    {1,0,0,0,0},
                };
        int sol[][]=new int[n][n];
        findMaze(0,0,a,sol);
        if(flag==0)
        {
           System.out.println("no path found");
           return;
        }
    }
    public static boolean findMaze(int i,int j,int a[][],int sol[][])
    {
        if(i==sol.length-1&&j==sol.length-1&&a[i][j]==0)
        {
            sol[i][j]=1;
            flag++;
            System.out.println(flag+"->");
            System.out.println("--------------------");
            for(int x=0;x<sol.length;x++)
            {
                for(int y=0;y<sol.length;y++)
                System.out.print(sol[x][y]);
                System.out.println();
            }
            return false;
        }
        if((i>=0&&i<=sol.length-1)&&(j>=0&&j<=sol.length-1)&&a[i][j]==0&&sol[i][j]==0)
        {
            sol[i][j]=1;
            if(findMaze(i+1,j,a,sol))   return true;
            if(findMaze(i,j+1,a,sol))   return true;
            if(findMaze(i-1,j,a,sol))   return true;
            if(findMaze(i,j-1,a,sol))   return true;
            sol[i][j]=0;
            return false;
        }
        return false;
    }
}