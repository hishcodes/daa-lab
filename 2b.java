import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    private String name;
    private String dob;

    void read()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        name = sc.nextLine();
        System.out.println("Enter dob");
        dob = sc.nextLine();
        String dobPattern = "\\d{2}/\\d{2}/\\d{4}";
        while(!(dob.matches(dobPattern)))
        {
            System.out.println("Enter correct dob");
            dob = sc.nextLine;
        }
    }
    void display()
    {
        int i;
        System.out.println("Customer name "+ name);
        StringTokenizer st = new StringTokenizer(dob, ",");
        for(i=0; i<3; i++)
        {
            System.out.print(","+ st.nextToken());
        }
    }
    public static void main(String[] args)
    {
        Main c1 = new Main();
        c1.read();
        c1.display();
    }
}