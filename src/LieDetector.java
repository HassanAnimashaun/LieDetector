import java.util.Scanner;
import java.util.Arrays;



class LieDetector {
    public static String[] getQuestions() {
        String[] questions = { "Is the number 8 or greater?",
                "Is it in the set {4,5,6,7,12,13,14,15}?",
                "Is it in the set {2,3,6,7,10,11,14,15}?",
                "Is it odd?",
                "Is it in the set {1,2,4,7,9,10,12,15}?",
                "Is it in the set {1,2,5,6,8,11,12,15}?",
                "Is it in the set {1,3,4,6,8,10,13,15}?"
        };
        return questions;
    }

    public static int[] encode(int[] answers) {
        Scanner input = new Scanner(System.in);
        String[] questions = getQuestions();
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String answer = input.nextLine();
            // if yes then 1 else 0 in to answer array
            if (answer.equalsIgnoreCase("y")) {
                answers[i] = 1;
            } else {
                answers[i] = 0;
            }
            answers[i] = answers[i];
        }
        System.out.println(Arrays.toString(answers));
        return answers;
    }

    public static int linearSearch(int[] answers, int key) {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == key) {
                answers[i] = 0;
            }
        }
        System.out.println("new array" + Arrays.toString(answers));
        return -1;
    }

    public static void decode(int[] answers) {
        int weight = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 1) {
                weight++;
            }
        }
        if (weight == 0) {
            System.out.println("No lie was told");
        } else if (weight == 1) {
            System.out.println("The lie is in the position of the 1 in the string");
            int lie = linearSearch(answers, 1);
        } else if (weight == 2) {
            System.out.println("The lie is the third point on the line");
            int lie = linearSearch(answers, 1);
        } else if (weight == 3) {
            System.out.println("The lie is the point not on the line");
            int lie = linearSearch(answers, 1);
        } else if (weight >= 4) {
            System.out.println("The lie is the point not on the line");
            int lie = linearSearch(answers, 1);
        }

        int toDecimal = 0;
        for (int j = 0; j < 4; j++) {
            toDecimal += answers[j] * Math.pow(2, 3 - j);
        }
        System.out.println(toDecimal);
    }

    public static void main(String[] args) {
        //2d array of fano plane
        int[][] fanoPlane = {
                {1, 2, 3, 4},
                {1, 5, 6, 7},
                {1, 8, 9, 10},
                {1, 11, 12, 13},
                {2, 5, 8, 11},
                {2, 6, 9, 12},
                {2, 7, 10, 13},
                {3, 5, 9, 13},
                {3, 6, 10, 11},
                {3, 7, 8, 12},
                {4, 5, 10, 12},
                {4, 6, 8, 13},
                {4, 7, 9, 11}
        };
        int[] answers = new int[7];
        encode(answers);
        decode(answers);
    }
}