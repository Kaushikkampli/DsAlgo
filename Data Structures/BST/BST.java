class Node
{
    int val;
    Node left,right;

    Node(int key){
        val = key;
        left = right = null;
    }
}

public class BST {
    static Node root;

    BST()
    {
        root = null;
    }

    Node search(Node node,int key)
    {
        if(node.val == key)
            return node;

        if(key < node.val)
            return search(node.left, key);
        else
            return search(node.right, key);
    }

    Node insert(Node node,int key)
    {
        if(node == null)
        {
            node = new Node(key);
            return node;
        }

        if(key < node.val)
            node.left = insert(node.left, key);
        else
            node.right = insert(node.right, key);

        return node;
    }

    void Inorder(Node node)
    {
        if(node == null)
            return;
        
        Inorder(node.left);
        System.out.print(node.val+"->");
        Inorder(node.right);
    }

    int Insuc(Node node)
    {
        while(node.left != null)
            node = node.left;

        return node.val;
        
    }

    Node delete(Node node,int key)
    {
        if(node == null)
        {
            return node;
        }

        if(key < node.val)
            node.left = delete(node.left, key);
        else if(key > node.val)
            node.right = delete(node.right, key);
            
        else
        {
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;
            else
            {
                node.val = Insuc(node.right);

                node.right = delete(node.right, node.val);
            }
            
        }
        return node;
    }

    public static void main(String[] args) {
        BST tree = new BST();

        root = tree.insert(root,50);
        root = tree.insert(root,30);
        root = tree.insert(root,20);
        root = tree.insert(root,40);
        root = tree.insert(root,70);
        root = tree.insert(root,60);
        root = tree.insert(root,80);

        tree.Inorder(root);
    
        try
        {
            if(tree.search(root, 90).val == 90)
            System.out.println("\nelement 90 found");
        }
        catch(Exception ex)
        {
            System.out.println("\nelement 90 not found");
        }

        tree.delete(root, 50);
        System.out.println("After deletion");
        tree.Inorder(root);
 
    }
}
