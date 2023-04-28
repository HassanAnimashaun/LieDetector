import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
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
            if (answer.equalsIgnoreCase("y")) {
                answers[i] = 1;
            } else {
                answers[i] = 0;
            }
            answers[i] = answers[i];
        }
        System.out.println();
        System.out.println(Arrays.toString(answers));
        return answers;
    }

    public static ArrayList<Integer> whereAreZeros(int[] answers) {
        ArrayList<Integer> zero = new ArrayList<Integer>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                zero.add(i + 1);
            }
        }
        System.out.println("zero" + zero);
        return zero;
    }

    public static ArrayList<Integer> whereAreOnes(int[] answers) {
        ArrayList<Integer> one = new ArrayList<Integer>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 1) {
                one.add(i + 1);
                
            }
        }
        System.out.println("one:" + one + "\n");
        return one;
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
        whereAreZeros(answers);
        whereAreOnes(answers);

         //use fanoplane to find the lie position(create final)
          int[][] fanoPlane = {
            {1, 2, 3},
            {1, 4, 5},
            {1, 6, 7},
            {2, 4, 6},
            {2, 5, 7},
            {3, 4, 7},
            {3, 5, 6}
        };
       
        if (weight == 0) {
            System.out.println("No lie was told");
        }

        else if (weight == 1) {
            System.out.println("The lie is in the position of the 1 in the string");
            linearSearch(answers, 1);
            
        } 

        else if (weight == 2) {
            System.out.println("The lie is the third point on the line");
        } 

        else if (weight == 3) {
            System.out.println("The lie is the point not on the line");
        } 

        else if (weight >= 4) {
            System.out.println("The lie is the point not on the line");
            
        }

        int numGuessed = 0;
        for (int j = 0; j < 4; j++) {
            numGuessed += answers[j] * Math.pow(2, 3 - j);
        }
        System.out.println("The number thought of was " + numGuessed);
    }

    public static void main(String[] args) {
       
        
        
        int[] answers = new int[7];
        encode(answers);
        decode(answers);
    }
}