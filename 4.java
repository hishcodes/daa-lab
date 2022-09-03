import java.util.Scanner;
import java.util.Random;

public class QuickSort
{
    int[] a;
    int n;
    void input()
    {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        System.out.println("Enter n");
        n = sc.nextInt();
        a = new int[n];
        for(int i=0; i<n; i++)
        {
            a[i] = rm.nextInt(1000);
        }
    }
    void display()
    {
        for(int i=0; i<n; i++)
        {
            System.out.println(a[i] + " ");
        }
    }
    void sort()
    {
        quicksort(0, a.length-1);
    }
    void quicksort(int left, int right)
    {
        if(left < right)
        {
            int s = partition(left, right);
            quicksort(left, s-1);
            quicksort(s+1, right);
        }
    }
    int partition(int left, int right)
    {
        int pivot = a[left];
        int i = left;
        int j = right+1;
        do
        {
            do
            {
                ++i;
            }while(i<right && a[i]<pivot);
            do
            {
                --j;
            }while(j>left && a[j]>pivot);
            swap(i,j);
        }while(i<j);
        swap(i,j);
        swap(left, j);
        return j;
    }
    void swap(int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args)
    {
        QuickSort sorter = new QuickSort();
        sorter.input();
        sorter.display();
        sorter.sort();
        sorter.display();
    }
}