
import java.util.*;

class Huffman {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char c, int f) {
            ch = c;
            freq = f;
        }
    }

    static void print(Node root, String code) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        print(root.left, code + "0");
        print(root.right, code + "1");
    }

    public static void main(String[] args) {

        char[] ch = {'A', 'B', 'C', 'D'};
        int[] f = {5, 9, 12, 13};

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> a.freq - b.freq);

        for (int i = 0; i < ch.length; i++)
            pq.add(new Node(ch[i], f[i]));

        while (pq.size() > 1) {
            Node x = pq.poll();
            Node y = pq.poll();

            Node z = new Node('-', x.freq + y.freq);
            z.left = x;
            z.right = y;
            pq.add(z);
        }

        print(pq.poll(), "");
    }
}
