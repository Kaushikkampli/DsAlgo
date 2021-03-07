package CountingInversion;

import java.io.*;
import java.util.*;

class countinginv 
{
    static int arr[] = new int[100000];
    static long count = 0;

    public static void split(int[] arr,int l,int r)
    {
        if(l < r)
        {
            int mid = (l+r)/2;

            split(arr,l,mid);
            split(arr,mid+1,r);
            count_splitinv(arr,l,mid,r);
        }
    }

    public static void count_splitinv(int[] arr,int l,int mid,int r)
    {
        int n1 = (mid - l) + 1;
        int n2 = (r - (mid + 1)) + 1;

        int b[] = new int[n1];
        int c[] = new int[n2];

        int i = 0;
        while(i != n1)
        {
            b[i] = arr[l + i];
            i++;
        }

        i = 0;
        while(i != n2)
        {
            c[i] = arr[mid + i + 1];
            i++;
        }

        i = 0;
        int j = 0;
        int k = l;

        while(i != n1 && j != n2)
        {
            if(b[i] < c[j])
            {
                arr[k] = b[i];
                i++;  
            }
            else
            {
                count += (n1 - i);
                arr[k] = c[j];
                j++;
            }
            k++;
        }
    }

    public static void main(String[] args) throws Exception
    {
        File file = new File("/home/kaushik/Courses/Stanford/MergeSort/input.txt");
        Scanner scan = new Scanner(file);

        int  i = 0,n;
        while(scan.hasNextLine())
        {
            arr[i] = scan.nextInt();
            i++;
        }
        n = i;

        split(arr,0,n-1);

        System.out.println(count);
        scan.close();
    }
}