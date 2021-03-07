class Node {

    int data;
    Node left,right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class SortedArrayToBST {
    
    static Node root;

    SortedArrayToBST()
    {
        root = null;
    }

    Node convert(int[] arr, int l, int r)
    {
        if(l > r)
            return null;

        int mid = (l+r)/2;
        Node node = new Node(arr[mid]);

        node.left = convert(arr,l,mid-1);

        node.right = convert(arr,mid+1,r);

        return node;
    }

    void Inorder(Node node)
    {
        if(node == null)
            return;
        
        Inorder(node.left);
        System.out.print(node.data +"->");
        Inorder(node.right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
            1,2,3,4,5,6,7
        };

        int n = arr.length;
        SortedArrayToBST tree = new SortedArrayToBST();

        root = tree.convert(arr, 0, n-1);
        tree.Inorder(root);
        System.out.println();
    }
}
