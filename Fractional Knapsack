
import java.util.*;

class Knapsack {
    public static void main(String[] args) {

        int[] weight = {10, 20, 30};
        int[] profit = {60, 100, 120};
        int capacity = 50;

        double total = 0;

        double[] ratio = new double[weight.length];

        for (int i = 0; i < weight.length; i++)
            ratio[i] = (double) profit[i] / weight[i];

        for (int i = 0; i < weight.length; i++) {
            for (int j = i + 1; j < weight.length; j++) {

                if (ratio[i] < ratio[j]) {
                    double r = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = r;

                    int t = weight[i];
                    weight[i] = weight[j];
                    weight[j] = t;

                    t = profit[i];
                    profit[i] = profit[j];
                    profit[j] = t;
                }
            }
        }

        for (int i = 0; i < weight.length; i++) {
            if (capacity >= weight[i]) {
                total += profit[i];
                capacity -= weight[i];
            } else {
                total += ratio[i] * capacity;
                break;
            }
        }

        System.out.println("Maximum Profit = " + total);
    }
}
