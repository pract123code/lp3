//using dp

class KnapsackDP {
    public static void main(String[] args) {

        int[] w = {10, 20, 30};
        int[] p = {60, 100, 120};
        int W = 50, n = w.length;

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {

                if (w[i - 1] <= j)
                    dp[i][j] = Math.max(
                        p[i - 1] + dp[i - 1][j - w[i - 1]],
                        dp[i - 1][j]
                    );
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println("Maximum Profit = " + dp[n][W]);
    }
}
//using bb

import java.util.*;

class KnapsackBB {

    static int[] w = {10, 20, 30};
    static int[] p = {60, 100, 120};
    static int W = 50, n = 3;

    static class Node {
        int level, weight, profit;
        double bound;

        Node(int l, int w, int p) {
            level = l;
            weight = w;
            profit = p;
            bound = calculateBound(this);
        }
    }

    static double calculateBound(Node u) {
        if (u.weight >= W) return 0;

        double b = u.profit;
        int wt = u.weight, i = u.level + 1;

        while (i < n && wt + w[i] <= W) {
            wt += w[i];
            b += p[i];
            i++;
        }

        if (i < n)
            b += (W - wt) * (double) p[i] / w[i];

        return b;
    }

    public static void main(String[] args) {

        PriorityQueue<Node> q = new PriorityQueue<>(
            (a, b) -> Double.compare(b.bound, a.bound)
        );

        q.add(new Node(-1, 0, 0));
        int maxProfit = 0;

        while (!q.isEmpty()) {
            Node u = q.poll();

            if (u.bound <= maxProfit || u.level == n - 1)
                continue;

            int i = u.level + 1;

            Node v = new Node(i, u.weight + w[i],
                              u.profit + p[i]);

            if (v.weight <= W) {
                maxProfit = Math.max(maxProfit, v.profit);
                if (v.bound > maxProfit)
                    q.add(v);
            }

            Node x = new Node(i, u.weight, u.profit);

            if (x.bound > maxProfit)
                q.add(x);
        }

        System.out.println("Maximum Profit = " + maxProfit);
    }
}
