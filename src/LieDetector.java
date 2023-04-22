 //import scanner and array
import java.util.Scanner;
import java.util.Arrays;
class LieDetector {
    public static void main(String[] args) {
        //create scanner
        Scanner input=new Scanner(System.in);

        //instructions
        System.out.println("write down on a piece of paper a whole number between 0 and 15 (inclusive) and hide it");
        System.out.println();
        System.out.println("answer the following questions with either y(yes) or n(no)");

        //ask questions, yes = 1, no = 0 and storing into a single array of binary length 7
        int answers[] = new int[7];

        //1st question
        System.out.println("Is the number 8 or greater?");
        String answer=input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[0]=1;
        }

        else {
            answers[0]=0;
        }

        //2nd question
        System.out.println("Is it in the set {4,5,6,7,12,13,14,15}?");
        answer=input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[1]=1;
        }

        else {
            answers[1]=0;
        }

        //3rd question
        System.out.println("Is it in the set {2,3,6,7,10,11,14,15}?");
        answer=input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[2]=1;
        }

        else {
            answers[2]=0;
        }

        //4th question hh
        System.out.println("Is it odd?");
        answer=input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[3]=1;
        }

        else {
            answers[3]=0;
        }

        //5th question
        System.out.println("Is it in the set  {1,2,4,7,9,10,12,15}?");
        answer=input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[4]=1;
        }

        else {
            answers[4]=0;
        }

        //6th question
        System.out.println("Is it in the set {1,2,5,6,8,11,12,15}?");
        answer=input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[5]=1;
        }

        else {
            answers[5]=0;
        }

        //7th question
        System.out.println("Is it in the set {1,3,4,6,8,10,13,15}?");
        answer=input.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            answers[6]=1;
        }

        else {
            answers[6]=0;
        }
//encode method
        System.out.println(Arrays.toString(answers));
//decode method 
        int weight=0;
        int index = 1;
        int newIndex = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 1) {
                weight++;
            }
            //If the weight is 0, no lie was told.
            if (weight == 0) {
                System.out.println("No lie was told");
            }
            //If the weight is 1, the lie is in the posion of the 1 in the string
            else if (weight == 1) {
                System.out.println("The lie is in the position of the 1 in the string");
                answers[weight] = newIndex;
            }
            //. If the weight is 2, then the posions of the two 1s lie on a unique line; the third point on the line is the lie.
            else if (weight == 2) {
                System.out.println("The lie is the third point on the line");
            }
            //If the weight is 3, look at the three posions of the three 1s. If they form a line, then no lie was told. If not, then the complementary set of posions of the four 0s contains exactly one line; the point not on this line gives the lie.
            else if (weight == 3) {
                System.out.println("The lie is the point not on the line");
            }
            // If the weight is 4 or more, then apply the same rules as above to the posions of the zeros.
            else if (weight >= 4) {
                System.out.println("The lie is the point not on the line");
            }
        }
       int toDecimal = 0;
       for(int i = 0; i < 4; i++){
        toDecimal += answers[i] * Math.pow(2, 3-i);
       }
       System.out.println(toDecimal);
      }
}


