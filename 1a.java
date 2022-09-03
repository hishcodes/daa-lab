import java.util.Scanner;
class Student
{
    String usn, name, branch, phone;
    public void read()
    {
        Scanner sc = new Scanner(System.in);
        usn = sc.nextLine();
        name = sc.nextLine();
        branch = sc.nextLine();
        phone = sc.nextLine();
    }
    public void display()
    {
        System.out.println(usn + name + branch + phone);
    }
}
class StudentDemo 
{
    public static void main(String[] args)
    {
        int i;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n");
        int n = sc.nextInt();
        Student[] st = new Student[n];
        for(i=0; i<st.length; i++)
        {
            st[i] = new Student();
        }
        for(i=0; i<n; i++)
        {
            st[i].read();
        }
        for(i=0; i<n; i++)
        {
            st[i].display();
        }
    }
}