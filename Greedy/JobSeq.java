import java.util.*;

class JobSeq
{
    Job[] jobs;
    Disjoint slots;

    JobSeq(int n)
    {
        jobs = new Job[n];

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the jobs");
        for(int i = 0;i < n; i++)
        {
            String[] input = scan.nextLine().split(" ");
            
            char id = input[0].charAt(0);
            int d = Integer.parseInt(input[1]);
            int p = Integer.parseInt(input[2]);

            jobs[i] = new Job(id, d, p);
        }

        slots = new Disjoint(maxdeadline(jobs));
        scan.close();
    }

    class Disjoint
    {
        int[] parent;

        Disjoint(int t)
        {
            parent = new int[t + 1];

            for(int i = 0;i <= t; i++)
                parent[i] = i;
        }

        int find(int u)
        {
            if(parent[u] == u)
                return u;
            
            return parent[u] = find(parent[u]);
        }

        void merge(int u, int v)
        {
            parent[v] = u;
        }
    }

    class Job 
    {
        
        char id;
        int deadline,profit;

        Job(char id,int d,int p)
        {
            this.id = id;
            deadline = d;
            profit = p;
        }
    }

    int maxdeadline(Job[] jobs)
    {
        int max = -1;
        for(Job job : jobs)
        {
            if(job.deadline > max)
                max = job.deadline;
        }

        return max;
    }

    ArrayList<Character> findseq()
    {
        ArrayList<Character> seq = new ArrayList<>();

        Arrays.sort(jobs, new Comparator<Job>(){
           public int compare(Job a,Job b)
           {
               return a.profit > b.profit ? -1 : 1;
           } 
        });

        for(Job job : jobs)
        {
            int slot = slots.find(job.deadline);

            if(slot > 0)
            {
                int child = slot;
                int parent = slots.find(slot - 1);

                slots.merge(parent,child);
                seq.add(job.id);
            }
            
        }

        return seq;
    }

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of jobs");
        int n = scan.nextInt();

        scan.nextLine();

        JobSeq obj = new JobSeq(n);
        
        ArrayList<Character> seq = obj.findseq();

        System.out.print(seq);
        scan.close();
    }
}
