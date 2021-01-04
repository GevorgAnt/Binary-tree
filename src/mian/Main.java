package mian;

import binaryTree.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();

        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(3);
        tree.add(15);
        tree.add(18);
        tree.add(1);
        tree.add(4);


        System.out.println(tree.maxValue(tree.root).value);
        System.out.println(tree.minValue(tree.root).value);
        tree.traverseLevelOrder();
        System.out.println();
        System.out.println(tree.containsNode(10));

        tree.delete(10);
        tree.traverseLevelOrder();

    }
}
