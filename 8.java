import java.util.Scanner;
class Kruskal
{
    static int[][] wt;
    static int n,mincost, v1=0, v2=0;
    static void kruskal()
    {
        int i,edgewt;
        int[] root = new int[n+1];
        for(i=1; i<=n; i++)
        {
            root[i] = i;
        }
        i = 0;
        while(i != n-1)
        {
            find();
            edgewt = wt[v1][v2];
            wt[v1][v2] = wt[v2][v1] = 0;
            if(root[v1] != root[v2])
            {
                System.out.println(v1+" , "+v2);
                union(root, v1, v2);
                mincost += edgewt;
                i++;
            }
        }
        System.out.println("Mincost = "+mincost);
    }
    static void find()
    {
        int edgewt=99, i, j;
        for(i=1; i<=n; i++)
        {
            for(j=1; j<=n; j++)
            {
                if(wt[i][j]>0 && wt[i][j]<edgewt)
                {
                    edgewt = wt[i][j];
                    v1 = i;
                    v2 = j;
                }
            }
        }
    }
    static void union(int root[], int v1, int v2)
    {
        int temp, i;
        temp = root[v2];
        for(i=1; i<=n; i++)
        {
            if(root[i] == temp)
            {
                root[i] = root[v1];
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        n = sc.nextInt();
        wt = new int[n+1][n+1];
        System.out.println("Enter weighted matrix");
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                wt[i][j] = sc.nextInt();
            }
        }
        kruskal();
    }
}