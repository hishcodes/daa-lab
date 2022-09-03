import java.util.Scanner;
class Main
{
    String name, phone;
    public void read()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        name = sc.nextLine();
        System.out.println("Enter phone");
        phone = sc.nextLine();
    }
    public void display()
    {
        System.out.println(name + phone);
    }
    public static void main(String[] args)
    {
        Teaching tch1 = new Teaching();
        tch1.read();
        tch1.display();

        Technical tec1 = new Technical();
        tec1.read();
        tec1.display();

        Contract cnt1 = new Contract();
        cnt1.read();
        cnt1.display();
    }
}
class Teaching extends Staff
{
    String domain;
    void read()
    {
        super.read();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter domain");
        domain = sc.nextLine();
    }
    void display()
    {
        super.display();
        System.out.println(domain);
    }
}

class Technical extends Staff
{
    String skills;
    void read()
    {
        super.read();
        System.out.println("Enter skills");
        Scanner sc = new Scanner(System.in);
        skills = sc.nextLine();
    }
    void display()
    {
        super.display();
        System.out.println(skills);
    }
}

class Contract extends Staff
{
    int period;
    Scanner sc = new Scanner(System.in);
    void read()
    {
        super.read();
        System.out.println("Enter period");
        period = sc.nextInt();
    }
    void display()
    {
        super.display();
        System.out.println(period);
    }
}