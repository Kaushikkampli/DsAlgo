package QuickSort;

import java.util.*;
import java.io.*;

public class QuickSort
{
    static int n,comp = 0;

    public static void swap(int[] arr,int i,int j)
    {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void findPiv(int[] arr,int l,int r)
    {
        int N = (r-l) + 1;
        int m = arr[l];
        int n = arr[r];
    
        int mid,piv;
        if(N%2 == 0)
            mid = (N/2) - 1;
        else
            mid = (N/2);

        if(m > arr[mid])
        {
            if(arr[mid] > n)
                piv = mid;
            else if(m < n)
                piv = l;
            else
                piv = r;
        }
        else
        {
            if(arr[mid] < n)
                piv = mid;
            else if(n > m)
                piv = r;
            else
                piv = l;
        }

        
        swap(arr,piv,l);
    }

    public static void randPiv(int[] arr,int l,int r)
    {
        Random random = new Random();
        int piv = random.nextInt((r - l) + 1) + l;
        swap(arr,piv,l);
    }

    public static void qsort(int[] arr,int l,int r)
    {
        if(l < r)
        {
            int  p = partition(arr,l,r);
            qsort(arr,l,p-1);
            qsort(arr,p+1,r);
        }
    }

    public static int partition(int[] arr,int l,int r)
    {
        int i = l+1;
        randPiv(arr,l,r);

        int piv = arr[l];
        comp += (r - l);

        for(int j = l+1; j <= r; j++)
        {
            if(arr[j] < piv)
            {
                if(i != j)
                    swap(arr,j,i);
                i++;
            }
        }

        swap(arr,l,i-1);

        return i-1;
    }

    public static void main(String[] args) throws Exception
    {
        int[] arr = new int[10000];;

        File file = new File("/home/kaushik/Courses/Stanford/QuickSort/QuickSort.txt");
        Scanner scan = new Scanner(file);        

        int i = 0;
        while(scan.hasNextLine())
        {
            arr[i++] = scan.nextInt();
        }
        n = i;

        scan.close();

        System.out.println("Before Sorting");
        for(i = 0; i < n; i++)
        {
            System.out.printf(+arr[i]+"\t");
        }

        qsort(arr,0,n-1);
        System.out.println();

        System.out.println("After Sorting");
        for(i = 0; i < n; i++)
        {
            System.out.printf(+arr[i]+"\t");
        }

        System.out.println();
        System.out.println("Comparisons = " +comp);
    }
}