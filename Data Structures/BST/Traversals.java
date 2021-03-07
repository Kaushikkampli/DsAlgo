class Node
{
    int key;
    Node left,right;

    public Node(int key)
    {
        this.key = key;
        left = right = null;
    }
}

public class Traversals
{
    Node root;

    Traversals()
    {
        root = null;
    }

    void Preorder(Node node)
    {
        if(node == null)
            return;

        System.out.print(node.key +"->");
        Preorder(node.left);
        Preorder(node.right);
    }

    void Inorder(Node node)
    {
        if(node == null)
            return;

        Inorder(node.left);
        System.out.print(node.key +"->");
        Inorder(node.right);
    }

    void Postorder(Node node)
    {
        if(node == null)
            return;

        Postorder(node.left);
        Postorder(node.right);
        System.out.print(node.key +"->");
    }

    void printInorder()
    {
        System.out.println("Inorder");
        Inorder(root);
    }

    void printPreorder()
    {
        System.out.println("Preorder");
        Preorder(root);
    }

    void printPostorder()
    {
        System.out.println("Postorder");
        Postorder(root);
    }

    public static void main(String[] args) {

        Traversals tree = new Traversals();

        tree.root = new Node(1);
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 

        tree.printInorder();
        System.out.println();

        tree.printPreorder();
        System.out.println();

        tree.printPostorder();
        System.out.println();
    }
}