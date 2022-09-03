import java.util.*;
class Square implements Runnable
{
    public int x;
    public Square(int num)
    {
        x = num;
    }
    public void run()
    {
        System.out.println("Square is "+ x*x);
    }
}

class Cube implements Runnable
{
    public int x;
    public Cube(int num)
    {
        x = num;
    }
    public void run()
    {
        System.out.println("Cube is "+ x*x*x);
    }
}

class GenerateNos implements Runnable
{
    public void run()
    {
        int num=0;
        Random r = new Random();
        try
        {
            for(int i=0; i<5; i++)
            {
                num = r.nextInt(100);
                System.out.println(num);
                Thread t1 = new Thread(new Square(num));
                t1.start();
                Thread t2 = new Thread(new Cube(num));
                t2.start();
                Thread.sleep(1000);
                System.out.println("--------------");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}

public class MultiThreadDemo
{
    public static void main(String[] args)
    {
        GenerateNos g = new GenerateNos();
        Thread t = new Thread(g);
        t.start();
    }
}