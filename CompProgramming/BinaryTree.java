// Java program to check if two Nodes in 
// a binary tree are cousins 
// using level-order traversals 
import java.util.*;  
  
// User defined node class 
class Node 
{ 
    int data; 
    Node left, right; 
  
    // Constructor to create a new tree node  
    Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
} 

class Pair {
    Node n1,n2;
    Pair(Node n1,Node n2) {
      this.n1 = n1;
      this.n2 = n2;
    }

    Node getKey()
    {
        return n1;
    }

    Node getValue()
    {
        return n2;
    }
}
  
  
class BinaryTree 
{ 
    Node root; 
  
    // Returns true if a and b are cousins,  
    // otherwise false.  
    boolean isCousin(Node node, Node a, Node b) 
    { 
        if(node == null) 
            return false; 
          
        // To store parent of node a. 
        Node parA = null; 
  
        // To store parent of node b. 
        Node parB = null; 
  
        // queue to perform level order  
        // traversal. Each element of  
        // queue is a pair of node and  
        // its parent. 
        Queue<Pair> q = new LinkedList<> (); 
  
        // Dummy node to act like parent  
        // of root node.  
        Node tmp = new Node(-1); 
  
        // To store front element of queue.  
        Pair ele; 
  
        // Push root to queue. 
        q.add(new Pair(node, tmp)); 
  
        int levelSize; 
  
        while(!q.isEmpty()) 
        { 
  
            // find number of elements in  
            // current level.  
            levelSize = q.size(); 
            while(levelSize != 0) 
            {
                ele = q.remove();
                System.out.println(ele.getKey().data + "ele");
 
  
                // check if current node is node a  
                // or node b or not.  
                if(ele.getKey().data == a.data) 
                {
                    parA = ele.getValue();
                    System.out.println(parA.data + "data");
                } 
  
                if(ele.getKey().data == b.data)
                { 
                    parB = ele.getValue();
                    System.out.println(parB.data + "data");
                } 
  
                // push children of current node  
                // to queue.  
                if(ele.getKey().left != null) 
                    q.add(new Pair(ele.getKey().left, ele.getKey())); 
  
                if(ele.getKey().right != null) 
                    q.add(new Pair(ele.getKey().right, ele.getKey())); 
  
                levelSize--;
            
                // If both nodes are found in  
                // current level then no need  
                // to traverse current level further.  
                if(parA != null && parB != null) 
                {
                    System.out.println("found");
                    break;
                } 
            } 
  
            // Check if both nodes are siblings  
            // or not. 
            if(parA != null && parB != null) 
                return parA != parB; 
  
            // If one node is found in current level  
            // and another is not found, then  
            // both nodes are not cousins.  
            if ((parA!=null && parB==null) || (parB!=null && parA==null)) 
                return false; 
        } 
  
        return false; 
    } 
  
    // Driver code 
    public static void main(String args[]) 
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.right = new Node(15); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
  
        Node Node1, Node2; 
        Node1 = tree.root.left; 
        Node2 = tree.root; 
        if (tree.isCousin(tree.root, Node1, Node2)) 
            System.out.println("Yes"); 
        else
            System.out.println("No" + Node1.data + " " + Node2.data); 
    } 
} 