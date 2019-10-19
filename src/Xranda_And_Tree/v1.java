package Xranda_And_Tree;

import java.util.*;
import java.lang.*;
import java.io.*;

public class v1 {

    private static Node root = null;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodeCount = in.nextInt();
        for (int i = 0; i < nodeCount; i++) {
            int node1 = in.nextInt(), node2 = in.nextInt(), weight = in.nextInt();
            
        }

    }

    static class Node {
        HashMap<Integer, Node> nodes;
        int name, weight;

        Node(int name, int weight) {
            this.name = name;
        }

        int getName() {
            return name;
        }

        int getWeight() {
            return weight;
        }

        void addNode(int name, Node node) {
            nodes.put(name, node);
        }

        HashMap<Integer, Node> getNodes() {
            return nodes;
        }
    }
}
