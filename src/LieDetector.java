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
        } else if (weight == 2) {
            System.out.println("The lie is the third point on the line");
        } else if (weight == 3) {
            System.out.println("The lie is the point not on the line");
        } else if (weight >= 4) {
            System.out.println("The lie is the point not on the line");
        }

        int toDecimal = 0;
        for (int j = 0; j < 4; j++) {
            toDecimal += answers[j] * Math.pow(2, 3 - j);
        }
        System.out.println(toDecimal);
    }

    public static void main(String[] args) {
        int[] answers = new int[7];
        encode(answers);
        decode(answers);
    }
}