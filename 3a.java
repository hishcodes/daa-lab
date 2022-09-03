import java.util.Scanner;
class ExceptionDemo
{
    public static void main(String[] args)
    {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        try
        {
            System.out.println("Enter a");
            a = sc.nextInt();
            System.out.println("Enter b");
            b = sc.nextInt();
            c = a/b;
            System.out.println("c is "+ c);
        }
        catch(ArithmeticException ex)
        {
            System.out.println(ex);
        }
    }
}