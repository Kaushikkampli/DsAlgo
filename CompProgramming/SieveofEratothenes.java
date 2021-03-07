package CompProgramming;

class SieveofEratosthenes
{
    static int[] prime;
    static boolean[] bool;

    SieveofEratosthenes(int n)
    {
        prime = new int[n];
        bool = new boolean[n];

        bool[0] = bool[1] = false;

        for(int i = 2;i < n; i++)
        {
            prime[i] = i;
            bool[i] = true;
        } 
    }

    void genPrimes()
    {
        for(int i = 2;i <= (int)Math.sqrt(prime.length-1); i++)
        {
            if(bool[i])
            {
                for(int j = i*i; j < prime.length; j += i)
                    bool[j] = false;
            }
        }
    }

    public static void main(String[] args) {

        SieveofEratosthenes s = new SieveofEratosthenes(121);
        s.genPrimes();
        
        for(int i = 0;i < prime.length; i++)
        {
            if(bool[i])
                System.out.println(prime[i]);
        }
    }
}