package Monokeros;

import java.util.*;
import java.lang.*;
import java.io.*;

public class v1 {

    private static Node root = null;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int nodeCount = in.nextInt();
        int[] depth = new int[nodeCount];

        for (int i = 0; i < nodeCount; i++) {
            if (root == null) {
                root = new Node(in.nextInt());
                depth[i] = 1;
            } else {
                depth[i] = insertNode(root, in.nextInt()) + 1;
            }
        }

        for (int val : depth) {
            System.out.print(val + " ");
        }
    }

    static int insertNode(Node parent, int value) {
        if (value <= parent.getValue()) {
            if (parent.getLeft() != null) {
                return insertNode(parent.getLeft(), value) + 1;
            } else {
                parent.insertLeft(new Node(value));
                return 1;
            }
        } else {
            if (parent.getRight() != null) {
                return insertNode(parent.getRight(), value) + 1;
            } else {
                parent.insertRight(new Node(value));
                return 1;
            }
        }
    }

    static class Node {
        Node left, right;
        int value;

        Node(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        void insertLeft(Node node) {
            left = node;
        }

        Node getLeft() {
            return left;
        }

        void insertRight(Node node) {
            right = node;
        }

        Node getRight() {
            return right;
        }
    }
}
