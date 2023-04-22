
//import scanner and array
import java.util.Scanner;
import java.util.Arrays;

class LieDetector {
    public static void main(String[] args) {
        // create scanner
        Scanner input = new Scanner(System.in);

        // instructions
        System.out.println("write down on a piece of paper a whole number between 0 and 15 (inclusive) and hide it");
        System.out.println();
        System.out.println("answer the following questions with either y(yes) or n(no)");

        // ask questions, yes = 1, no = 0 and storing into a single array of binary
        // length 7
        int answers[] = new int[7];

        // 1st question
        System.out.println("Is the number 8 or greater?");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[0] = 1;
        }

        else {
            answers[0] = 0;
        }

        // 2nd question
        System.out.println("Is it in the set {4,5,6,7,12,13,14,15}?");
        answer = input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[1] = 1;
        }

        else {
            answers[1] = 0;
        }

        // 3rd question
        System.out.println("Is it in the set {2,3,6,7,10,11,14,15}?");
        answer = input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[2] = 1;
        }

        else {
            answers[2] = 0;
        }

        // 4th question hh
        System.out.println("Is it odd?");
        answer = input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[3] = 1;
        }

        else {
            answers[3] = 0;
        }

        // 5th question
        System.out.println("Is it in the set  {1,2,4,7,9,10,12,15}?");
        answer = input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[4] = 1;
        }

        else {
            answers[4] = 0;
        }

        // 6th question
        System.out.println("Is it in the set {1,2,5,6,8,11,12,15}?");
        answer = input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[5] = 1;
        }

        else {
            answers[5] = 0;
        }

        // 7th question
        System.out.println("Is it in the set {1,3,4,6,8,10,13,15}?");
        answer = input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[6] = 1;
        }

        else {
            answers[6] = 0;
        }
        // encode method
        System.out.println(Arrays.toString(answers));
        
        // decode method
        int weight = 0; // initialize weight to zero
        int[] liePositions = new int[answers.length]; // an array to store the positions of lies

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 1) {
                weight++;
                liePositions[weight - 1] = i + 1; // store the position of the lie
            }
            // If the weight is 0, no lie was told.
            if (weight == 0) {
                System.out.println("No lie was told");
            }
            // If the weight is 1, the lie is in the position of the 1 in the string
            else if (weight == 1) {
                System.out.println("The lie is in position " + liePositions[0]);
            }
            // If the weight is 2, then the positions of the two 1s lie on a unique line;
            // the third point on the line is the lie.
            else if (weight == 2) {
                int diff = liePositions[1] - liePositions[0];
                int nextPos = liePositions[1] + diff;
                System.out.println("The lie is in position " + nextPos);
            }
            // If the weight is 3, look at the three positions of the three 1s. If they form
            // a line, then no lie was told.
            // If not, then the complementary set of positions of the four 0s contains
            // exactly one line; the point not on this line gives the lie.
            else if (weight == 3) {
                int pos1 = liePositions[0];
                int pos2 = liePositions[1];
                int pos3 = liePositions[2];
                if ((pos1 - pos2) * (pos2 - pos3) == 1) {
                    System.out.println("No lie was told");
                } else {
                    int[] zeros = new int[answers.length - weight];
                    int zeroCount = 0;
                    for (int j = 0; j < answers.length; j++) {
                        if (answers[j] == 0) {
                            zeros[zeroCount] = j + 1;
                            zeroCount++;
                        }
                    }
                    int a = pos1 - pos2;
                    int b = pos1 - pos3;
                    int c = pos2 - pos3;
                    int d = -a * pos1 - b * pos2 - c * pos3;
                    for (int j = 0; j < zeros.length; j++) {
                        int z = zeros[j];
                        if (a * z + b * (z + c) + d == 0) {
                            System.out.println("The lie is in position " + z);
                            break;
                        }
                    }
                }
            }
            // If the weight is 4 or more, then apply the same rules as above to the
            // positions of the zeros.
            else if (weight >= 4) {
                int[] zeros = new int[answers.length - weight];
                int zeroCount = 0;
                for (int j = 0; j < answers.length; j++) {
                    if (answers[j] == 0) {
                        zeros[zeroCount] = j + 1;
                        zeroCount++;
                    }
                }
                int[] lieZeros = new int[weight];
                int lieZeroCount = 0;
                for (int j = 0; j < zeros.length; j++) {
                    int z = zeros[j];
                    boolean isLieZero = false;
                    for (int k = 0; k < weight; k++) {
                        if (Math.abs(z - liePositions[k]) == 1) {
                            isLieZero = true;
                            break;
                        }
                    }
                    if (isLieZero) {
                        lieZeros[lieZeroCount] = z;
                        lieZeroCount++;
                    }
                }
                if (lieZeroCount == 0) {
                    System.out.println("No lie was told");
                } else {
                    int[] diffs = new int[lieZeroCount - 1];
                    for (int j = 0; j < diffs.length; j++) {
                        diffs[j] = lieZeros[j + 1] - lieZeros[j];
                    }
                    boolean isLine = true;
                    for (int j = 1; j < diffs.length; j++) {
                        if (diffs[j] != diffs[0]) {
                            isLine = false;
                            break;
                        }
                    }
                    if (isLine) {
                        System.out.println("No lie was told");
                    } else {
                        int a = diffs[0];
                        int b = -1;
                        int c = lieZeros[0] - a;
                        int d = -a * lieZeros[0] - b * 1 - c;
                        for (int j = 0; j < zeros.length; j++) {
                            int z = zeros[j];
                            if (a * z + b * 1 + c + d == 0) {
                                System.out.println("The lie is in position " + z);
                                break;
                            }
                        }
                    }
                }
            }
        }
        int toDecimal = 0;
        for (int i = 0; i < 4; i++) {
            toDecimal += answers[i] * Math.pow(2, 3 - i);
        }
        System.out.println(toDecimal);
    }
}
