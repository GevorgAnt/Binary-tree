package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
   public Node root;

   //add function
    public void add(int val) {
        root=addRec(root,val);
    }


    public Node addRec(Node root,int a) {
        if (root == null) {
            root = new Node(a);
        } else {

                if (a<root.value) {
                    root.leftNode=addRec(root.leftNode,a);
                } else {
                    root.rightNode=addRec(root.rightNode,a);
            }
        }
        return root;
    }
    //delete function
    public void delete(int val)
    {
        root=deleteRecursive(root,val);
    }
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            //has no child return null
            if (current.leftNode == null && current.rightNode == null) {
                return null;
            }
            //has one child
            if (current.rightNode == null) {
                return current.leftNode;
            }

            if (current.leftNode == null) {
                return current.rightNode;
            }
            //has two children
            Node smallestValueNode = minValue(current.rightNode);
            current.value = smallestValueNode.value;
            current.rightNode = deleteRecursive(current.rightNode, smallestValueNode.value);
            return current;


        }
        if (value < current.value) {
            current.leftNode = deleteRecursive(current.leftNode, value);
            return current;
        }
        current.rightNode = deleteRecursive(current.rightNode, value);
        return current;
    }


    //check if function contain value
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.leftNode, value)
                : containsNodeRecursive(current.rightNode, value);
    }

    //Breadth-First Search
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(node.value+" ");

            if (node.leftNode != null) {
                nodes.add(node.leftNode);
            }

            if (node.rightNode != null) {
                nodes.add(node.rightNode);
            }
        }
    }

    //find max value
    public Node maxValue(Node root)
    {

        
        if(root.rightNode!=null) {

          root=  maxValue(root.rightNode);
        }
       return root;


    }

    //fund minimum value
    public Node minValue(Node root)
    {


        if(root.leftNode!=null) {

            root=  minValue(root.leftNode);
        }
        return root;


    }

}

