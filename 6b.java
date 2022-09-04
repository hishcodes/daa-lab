import java.util.Scanner;
class Knapsack01_Greedy
{
    static int[] p, wt;
    static int n, C;
    static void solve_knapsack()
    {
        int profit=0;
        int i;
        int c = C;
        for(i=1; i<=n; i++)
        {
            if(c >= wt[i])
            {
                System.out.println("Item "+i+" is added with weights "+wt[i]+" and profit "+p[i]);
                profit = profit + p[i];
                c = c - wt[i];
            }
        }
        System.out.println("Total profit of the knapsack = "+profit);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        n = sc.nextInt();
        System.out.println("Enter weights");
        wt = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            wt[i] = sc.nextInt();
        }
        System.out.println("Enter profits");
        p = new int[n+1];
        for(int i=1; i<=n; i++)
        {
            p[i] = sc.nextInt();
        }
        System.out.println("Enter maximum capacity");
        C = sc.nextInt();
        solve_knapsack();
    }
}