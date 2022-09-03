import java.util.Scanner;
public class Knapsack01_DP
{
    static int[] wt,p;
    static int n,C;
    static void knapsack01_DP()
    {
        int i,w;
        int[][] k = new int[n+1][C+1];
        for(i=0; i<=n; i++)
        {
            for(w=0; w<=C; w++)
            {
                if(i==0 || w==0)
                {
                    k[i][w] = 0;
                }
                else if(wt[i] <= w)
                {
                    k[i][w] = max(p[i]+k[i-1][w-wt[i]] , k[i-1][w]);
                }
                else
                {
                    k[i][w] = k[i-1][w];
                }
            }
        }
        System.out.println("Selected items are:");
        int c = C;
        int m = n;
        while(m>0)
        {
            if(k[m][c] != k[m-1][c])
            {
                System.out.println("Item= "+m+" Weight= "+wt[m]+" Profit= "+p[m]);
                c = c - wt[m];
            }
            m--;
        }
        System.out.println("Total profit = "+ k[n][C]);
    }
    static int max(int a, int b)
    {
        if(a>b)
        {
            return a;
        }
        else
        {
            return b;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        n = sc.nextInt();
        System.out.println("Enter profits");
        p = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            p[i] = sc.nextInt();
        }
        System.out.println("Enter weights");
        wt = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter max capacity");
        C = sc.nextInt();
        knapsack01_DP();
    }
}