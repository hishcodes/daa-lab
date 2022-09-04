import java.util.Scanner;
class DijkstraSP
{
    static int[][] wt;
    static int[] prev,visit,dist;
    static int s,n;
    static void dijkstra()
    {
        int i,j,step,u;
        prev = new int[n+1];
        visit = new int[n+1];
        dist = new int[n+1];
        for(i=1; i<=n; i++)
        {
            prev[i] = 0;
            dist[i] = 0;
            visit[i] = 0;
        }
        for(i=1; i<=n; i++)
        {
            dist[i] = wt[s][i];
            if(dist[i] == 99)
            {
                prev[i] = 0;
            }
            else
            {
                prev[i] = s;
            }
            visit[i] = 0;
        }
        visit[s] = 1;
        dist[s] = 0;
        for(step=2; step<=n; step++)
        {
            u = minvertex();
            visit[u] = 1;
            for(j=1; j<=n; j++)
            {
                if(((dist[u]+wt[u][j])<dist[j]) && visit[j]==0)
                {
                    dist[j] = dist[u] + wt[u][j];
                    prev[j] = u;
                }
            }
        }
        printpath();
    }
    static int minvertex()
    {
        int u=0, i;
        int min = 99;
        for(i=1; i<=n; i++)
        {
            if((dist[i] < min) && (visit[i] == 0))
            {
                min = dist[i];
                u = i;
            }
        }
        return u;
    }
    static void printpath()
    {
        int i,t;
        for(i=1; i<=n; i++)
        {
            if((visit[i] == 1) && (i!=s))
            {
                System.out.println("From "+s+" to "+i+" dist= "+dist[i]+" path: ");
                t = prev[i];
                System.out.println(i);
                while(t != s)
                {
                    System.out.println("<--"+t);
                    t = prev[t];
                }
            }
            System.out.println("<--"+s);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,j;
        System.out.println("Enter n");
        n = sc.nextInt();
        System.out.println("Enter weighted matrix");
        wt = new int[n+1][n+1];
        for(i=1; i<=n; i++)
        {
            for(j=1; j<=n; j++)
            {
                wt[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter source vertex");
        s = sc.nextInt();
        dijkstra();
    }
}