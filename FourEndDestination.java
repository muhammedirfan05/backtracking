import java.util.*;
public class FourEndDestination
{
    static int shortest[][],flag=0;
    static int sh=Integer.MAX_VALUE;
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt(),e=sc.nextInt();
        int a[][]=new int[n][n];
        int sol[][]=new int[n][n];
        shortest=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                a[i][j]=sc.nextInt();
        }
        findPath(s,e,a,sol,1);
        if(flag==0)
        {
            System.out.println("no path");
            sc.close();
            return;
        }
        else
        {
            System.out.println("Minimum Steps: "+sh);
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    System.out.print(shortest[i][j]+" ");
                System.out.println();
                    // shortest[i][j]=a[i][j];
            }
        }
        sc.close();
    }
    public static boolean findPath(int i,int j,int a[][],int sol[][],int c)
    {
        if(((i==0&&j==0)||(i==a.length-1&&j==a.length-1)||(i==0&&j==a.length-1)||(i==a.length-1&&j==0))&&a[i][j]==0)
        {
            sol[i][j]=1;
            if(sh>c)
            {
                flag=1;
                sh=c;
                for(int x=0;x<a.length;x++)
                {
                    for(int y=0;y<a.length;y++)
                        shortest[x][y]=sol[x][y];
                }
            }
            return false;
        }
        if((i>=0&&i<=sol.length-1)&&(j>=0&&j<=sol.length-1)&&a[i][j]==0&&sol[i][j]==0)
        {
            sol[i][j]=1;
            if(findPath(i+1,j,a,sol,c+1))   return true;
            if(findPath(i,j+1,a,sol,c+1))   return true;
            if(findPath(i-1,j,a,sol,c+1))   return true;
            if(findPath(i,j-1,a,sol,c+1))   return true;
            sol[i][j]=0;
            return false;
        }
        return false;
    }
}