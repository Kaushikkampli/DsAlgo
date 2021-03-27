import java.util.*;

public class WIS {
    
    static class Job
    {
        int start;
        int finish;
        int profit;
    }

    int nonconflict(Job[] arr, int n)
    {
        for(int i = n-1; i >= 0; i--)
            if(arr[i].finish <= arr[n-1].start)
                return i;
        
        return -1;
    }

    void maxprofit(Job[] arr, int n)
    {
        Arrays.sort(arr, new Comparator<Job>()
        {
            public int compare(Job a, Job b)
            {
                return (a.finish < b.finish) ? -1 : 1;
            }
        });

        int[] dp = new int[n];
        dp[0] = arr[0].profit;

        for(int i = 1;i < n; i++)
        {
            int included = arr[i].profit;
            int job = nonconflict(arr,i+1);
            if(job != -1)
                included += dp[job];

            int excluded = dp[i-1];

            dp[i] = Math.max(included,excluded);
        }

        System.out.println("Max Profit\t" + dp[n-1]);
    }

    public static void main(String[] args) {
        
        WIS obj = new WIS();
        //{{1,2,50}, {3,5,20} , {6,19,100} , {2,100,200} };

        System.out.println("Enter the no of jobs");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Job[] arr = new Job[n];
        scan.nextLine();

        for(int i = 0;i < n; i++)
        {
            System.out.println("Enter the parameters");
            String[] line = scan.nextLine().split(" ");
            arr[i] = new Job();

            arr[i].start = Integer.parseInt(line[0]);
            arr[i].finish = Integer.parseInt(line[1]);
            arr[i].profit = Integer.parseInt(line[2]);
        }

        obj.maxprofit(arr, n);

        scan.close();
    }
}
