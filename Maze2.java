// up,down,left,right
public class Maze2
{
    public static void main(String arg[])
    {
        int n=5;
        int a[][]={{0,1,0,0,0},
                    {0,1,0,1,0},
                    {0,0,0,1,0},
                    {1,1,1,1,0},
                    {1,1,1,1,0},
                };
        int sol[][]=new int[n][n];
        if(findMaze(0,0,a,sol))
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    System.out.print(sol[i][j]+" ");
                System.out.println();
            }
        }
        else
            System.out.println("NO destination found"); 
    }
    public static boolean findMaze(int i,int j,int a[][],int sol[][])
    {
        if(i==sol.length-1&&j==sol.length-1&&a[i][j]==0)
        {
            sol[i][j]=1;
            return true;
        }
        if((i>=0&&i<=sol.length-1)&&(j>=0&&j<=sol.length-1)&&a[i][j]==0&&sol[i][j]==0)
        {
            sol[i][j]=1;
            if(findMaze(i+1, j, a, sol)==true)
                return true;
            if(findMaze(i, j+1, a, sol)==true)
                return true;
            if(findMaze(i-1, j, a, sol)==true)
                return true;
            if(findMaze(i, j-1, a, sol)==true)
                return true;
            sol[i][j]=0;
            return false;
        }
        return false;
    }
}