public class SumTree {
    //https://www.geeksforgeeks.org/problems/sum-tree/1
    class Node{
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    int sum(Node root){
        
        //if root is empty
        if(root == null) return 0;
        
        int l = sum(root.left);
        int r = sum(root.right);
        
        return root.data+l+r;
    }
    boolean isSumTree(Node root) {
        // Your code here
        //if the root is empty or with no childrem
        if(root == null || (root.left==null && root.right==null)) return true;
        
        int l = sum(root.left);
        int r = sum(root.right);
        
        if(l+r == root.data){
            //checking for every node to be equal with the sum of their children
            if(isSumTree(root.left) && isSumTree(root.right)){
                return true;
            }
        }
        
        return false;
    }
}
