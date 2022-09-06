//The progam has some errors

import java.util.Scanner;
class PrimsMST
{
    static int[][] wt, edges;
    static int n, cost;
    static void prims()
    {
        int[] u,lowcost,visited;
        int mincost, min=0, i,j,v;

        u = new int[n+1];
        lowcost = new int[n+1];
        visited = new int[n+1];
        edges = new int[n][3];
        
        visited[1] = 1;
        for(i=2; i<=n; i++)
        {
            visited[i] = 0;
            u[i] = 1;
            lowcost[i] = wt[1][i];
        }
        for(i=1; i<=n-1; i++)
        {
            min = lowcost[2];
            v = 2;
            for(j=3; j<=n; j++)
            {
                if((lowcost[j] < min) && (visited[j]==0))
                {
                    min = lowcost[j];
                    v = j;
                }
            }
            edges[i][1] = u[v];
            edges[i][2] = v;
            mincost += lowcost[v];
            visited[v] = 1;
            lowcost[v] = 99;
            for(j=2; j<=n; j++)
            {
                if(wt[v][j]<lowcost[j] && visited[j]==0)
                {
                    lowcost[j] = wt[v][j];
                    u[j] = v;
                }
            }
        }
        System.out.println("Edges of the MST are");
        for(i=1; i<=n-1; i++)
        {
            System.out.print("("+wt[i][1]+" , "+wt[i][2]+")");
        }
        System.out.println("Mincost = "+mincost);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,j;
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter weighted matrix");
        wt= new int[n+1][n+1];
        for(i=1; i<=n; i++)
        {
            for(j=1; j<=n; j++)
            {
                wt[i][j] = sc.nextInt();
            }
        }
        prims();
    }
}