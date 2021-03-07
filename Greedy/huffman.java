import java.util.*;

class huffman
{
    class huffNode
    {
        char c;
        int freq;

        huffNode left;
        huffNode right;
    }

    class sortby implements Comparator<huffNode>
    {
        public int compare(huffNode x,huffNode y)
        {
            return x.freq - y.freq;
        }
    }

    huffNode create(char[] letters,int[] freqs)
    {
        PriorityQueue<huffNode> pq = new PriorityQueue<>(letters.length,new sortby());

        for(int i = 0;i < letters.length; i++)
        {
            huffNode node = new huffNode();
            
            node.c = letters[i];
            node.freq = freqs[i];
            node.left = null;
            node.right = null;

            pq.add(node);
        }

        while(pq.size() > 1)
        {
            huffNode first = pq.poll();
            huffNode sec = pq.poll();

            huffNode sum = new huffNode();
            sum.freq  = first.freq + sec.freq;
            sum.c = '-';

            sum.left = first;
            sum.right = sec;

            pq.add(sum);
        }

        return pq.poll();
    }

    void printCode(huffNode root,String s)
    {
        if(root.c != '-')
        {
            System.out.println(root.c +"\t"+ s);
            return;
        }

        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        
        huffman huff = new huffman();

        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freqs = { 5, 9, 12, 13, 16, 45 };

        huffNode root = huff.create(letters,freqs);
        huff.printCode(root,"");
    }
}