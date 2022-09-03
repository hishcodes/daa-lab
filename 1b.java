import java.util.Scanner;
class Stack
{
    int[] item;
    int top;
    Stack(int size)
    {
        top = -1;
        item = new int[size];
    }
    void push(int data)
    {
        if(top == item.length-1)
        {
            System.out.println("Overflow!");
        }
        else
        {
            item[++top] = data;
        }
    }
    int pop()
    {
        if(top < 0)
        {
            System.out.println("Underflow!");
        }
        else
        {
            System.out.println("Popped element is "+ item[top]);
            return item[top--];
        }
        return 0;
    }
    void display()
    {
        int i;
        if(top < 0)
        {
            System.out.println("Underflow!");
        }
        else
        {
            for(i=0; i<=top; i++)
            {
                System.out.print(item[i] + " ");
            }
            System.out.println("<--top");
        }
    }
}
class StackDemo
{
    public static void main(String[] args)
    {
        Stack stk = new Stack(3);
        int num, choice;
        boolean rerun = true;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("MENU");
            choice = sc.nextInt();
            switch (choice)
            {
                case 1 :    System.out.println("Enter num");
                            num = sc.nextInt();
                            stk.push(num);
                            break;
                case 2 :    stk.pop();
                            break;
                case 3 :    stk.display();
                            break;
                case 4 :    rerun = false;
                            break;
                default :   System.out.println("Invalid option");
            }
        }while(rerun == true);
    }
}