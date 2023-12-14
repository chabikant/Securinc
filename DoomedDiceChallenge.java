public class DoomedDiceChallenge {
    public static void main(String[] args) {
        int[] Die_A = {1, 2, 3, 4, 5, 6};
        int[] Die_B = {1, 2, 3, 4, 5, 6};
        undoom_dice(Die_A, Die_B);
    }

    public static void undoom_dice(int[] Die_A, int[] Die_B) {
        // Part A
        int totalCombinations = 6 * 6;
        System.out.println("Total combinations: " + totalCombinations);

        int[][] distribution = new int[6][6];
        double[] probabilities = new double[13]; // Possible sums range from 2 to 12

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                distribution[i][j] = Die_A[i] + Die_B[j];
                probabilities[distribution[i][j]] += 1.0 / totalCombinations;
            }
        }

        System.out.println("Distribution of all possible combinations:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(distribution[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Probability of all possible sums:");
        for (int i = 2; i <= 12; i++) {
            System.out.println("P(Sum = " + i + ") = " + probabilities[i]);
        }

        // Part B
        int[] New_Die_A = new int[6];
        int[] New_Die_B = new int[6];

        for (int i = 0; i < 6; i++) {
            if (Die_A[i] > 4) {
                New_Die_A[i] = 4;
                New_Die_B[i] = Die_B[i] + (Die_A[i] - 4);
            } else {
                New_Die_A[i] = Die_A[i];
                New_Die_B[i] = Die_B[i];
            }
        }

        // Check if the probabilities remain the same
        int[][] newDistribution = new int[6][6];
        double[] newProbabilities = new double[13];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                newDistribution[i][j] = New_Die_A[i] + New_Die_B[j];
                newProbabilities[newDistribution[i][j]] += 1.0 / totalCombinations;
            }
        }

        // Print the old and new probabilities for comparison
        System.out.println("The old and new probabilities for comparison");
        for (int i = 2; i <= 12; i++) {
            System.out.println("P(Sum = " + i + "): " + probabilities[i] + " -> " + newProbabilities[i]);
        }

        // Print the new dice
        System.out.print("New_Die_A = [");
        for (int i = 0; i < 6; i++) {
            System.out.print(New_Die_A[i] + (i < 5 ? ", " : ""));
        }
        System.out.println("]");

        System.out.print("New_Die_B = [");
        for (int i = 0; i < 6; i++) {
            System.out.print(New_Die_B[i] + (i < 5 ? ", " : ""));
        }
        System.out.println("]");
    }
}
