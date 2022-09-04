import java.util.Scanner;
import java.util.Arrays;
class Hamiltonian
{
    int[][] graph;
    int[] path;
    int n, pathCount;
    Main(int[][] g)
    {
        graph = g;
        n = g.length;
        path = new int[n];
        Arrays.fill(path, -1);
    }
    void findHamiltonian()
    {
        try
        {
            path[0] = 0;
            pathCount = 1;
            solve(0);
            System.out.println("No solution");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            display();
        }
    }
    void solve(int vertex) throws Exception
    {
        if(graph[vertex][0]==1 && pathCount==n)
        {
            throw new Exception("Solution found");
        }
        if(pathCount==n)
        {
            return;
        }
        for(int v=0; v<n; v++)
        {
            if(graph[vertex][v] == 1)
            {
                path[pathCount++] = v;
                graph[vertex][v] = 0;
                graph[v][vertex] = 0;
                if(!(isPresent(v)))
                {
                    solve(v);
                }
                graph[vertex][v] = 1;
                graph[v][vertex] = 1;
                path[--pathCount] = -1;
            }
        }
    }
    boolean isPresent(int v)
    {
        for(int i=0; i<pathCount-1; i++)
        {
            if(path[i] == v)
            {
                return true;
            }
        }
        return false;
    }
    void display()
    {
        for(int i=0; i<=n; i++)
        {
            System.out.print(path[i%n]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        System.out.println("Enter matrix");
        int[][] g = new int[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                g[i][j] = sc.nextInt();
            }
        }
        Hamiltonian hc = new Hamiltonian(g);
        hc.findHamiltonian();
    }
}