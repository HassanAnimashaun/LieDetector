

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
        {
            String[] questions = getQuestions();
            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i]);
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("y")) {
                    answers[i] = 1;
                } else {
                    answers[i] = 0;
                }
            }
            System.out.println();
            System.out.println(Arrays.toString(answers));
            return answers;
        }
    }

    public static ArrayList<Integer> whereAreZeros(int[] answers) {
        ArrayList<Integer> zero = new ArrayList<Integer>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 0) {
                zero.add(i + 1);
            }
        }
        return zero;
    }

    public static ArrayList<Integer> whereAreOnes(int[] answers) {
        ArrayList<Integer> one = new ArrayList<Integer>();
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 1) {
                one.add(i + 1);
            }
        }
        return one;
    }

    public static int linearSearch(int[] answers, int key) {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == key) {
                answers[i] = 0;
                return i;
            }
        }
        System.out.println(Arrays.toString(answers));
        return -1;
    }
    
    public static void weightTwo(int[] answers, int[][] fanoPlane) {
        ArrayList<Integer> onesIndexes = whereAreOnes(answers);
        int first = onesIndexes.get(0);
        int second = onesIndexes.get(1);
        int lie = 0;
        for (int i = 0; i < fanoPlane.length; i++) {
	        int a = fanoPlane[i][0];
	        int b = fanoPlane[i][1];
	        int c = fanoPlane[i][2];
	        if (a == first && b == second) {
	            lie = c;
	        } else if (a == first && c == second) {
	            lie = b;
	        } else if (b == first && c == second) {
	            lie = a;
	        }
        }
        System.out.println("The lie is in the position of the " + lie + " in the string");
        answers[lie - 1] = 1;
        System.out.println(Arrays.toString(answers));
        
    }

    public static void weightThree(int[] answers, int[][] fanoPlane) {
        ArrayList<Integer> onesIndexes = whereAreOnes(answers);
        int first = onesIndexes.get(0);
        int second = onesIndexes.get(1);
        int third = onesIndexes.get(2);
        int lie = 0;
        for (int i = 0; i < fanoPlane.length; i++) {
            int a = fanoPlane[i][0];
            int b = fanoPlane[i][1];
            int c = fanoPlane[i][2];
            if (a == first && b == second && c == third) {
                lie = c;
            } else if (a == first && c == second && b == third) {
                lie = b;
            } else if (b == first && c == second && a == third) {
                lie = a;
            }
        }
        if (onesIndexes.contains(lie)) {
            System.out.println("No lie was told");
        } else {
            int firstZero = whereAreZeros(answers).get(0);
            int secondZero = whereAreZeros(answers).get(1);
            int thirdZero = whereAreZeros(answers).get(2);
            int fourthZero = whereAreZeros(answers).get(3);
            int lieZeros = -1;
            for (int i = 0; i < fanoPlane.length; i++) {
                int a = fanoPlane[i][0];
                int b = fanoPlane[i][1];
                int c = fanoPlane[i][2];

                if (a == firstZero && b == secondZero && c == thirdZero) {
                    lieZeros = fourthZero;
                    break;
                } else if (a == firstZero && b == thirdZero && c == secondZero) {
                    lieZeros = secondZero;
                    break;
                } else if (a == secondZero && b == thirdZero && c == firstZero) {
                    lieZeros = firstZero;
                    break;
                } else if (a == firstZero && b == secondZero && c == fourthZero) {
                    lieZeros = thirdZero;
                    break;
                } else if (a == firstZero && b == thirdZero && c == fourthZero) {
                    lieZeros = secondZero;
                    break;
                } else if (a == secondZero && b == thirdZero && c == fourthZero) {
                    lieZeros = firstZero;
                    break;
                }
            }
            System.out.println("The lie is in the position of the " + lieZeros + " in the string");
            answers[lieZeros - 1] = 1;
            System.out.println(Arrays.toString(answers));
        }
    }

    public static void weightFour(int[] answers, int[][] fanoPlane) {
        if (whereAreZeros(answers).size() == 1) {
            int firstZero = whereAreZeros(answers).get(0);
            int lie = -1;
            for (int i = 0; i < fanoPlane.length; i++) {
                int a = fanoPlane[i][0];
                int b = fanoPlane[i][1];
                int c = fanoPlane[i][2];

                if (a == firstZero) {
                    lie = a;
                    break;
                } else if (b == firstZero) {
                    lie = b;
                    break;
                } else if (c == firstZero) {
                    lie = c;
                    break;
                }
            }
            System.out.println("The lie is in the position of the " + lie + " in the string");
            answers[lie - 1] = 1;
            System.out.println(Arrays.toString(answers));
            
        } else if (whereAreZeros(answers).size() == 2) {
            int firstZero = whereAreZeros(answers).get(0);
            int secondZero = whereAreZeros(answers).get(1);
            int lie = -1;
            for (int i = 0; i < fanoPlane.length; i++) {
                int a = fanoPlane[i][0];
                int b = fanoPlane[i][1];
                int c = fanoPlane[i][2];

                if (a == firstZero && b == secondZero) {
                    lie = c;
                    break;
                } else if (a == firstZero && c == secondZero) {
                    lie = b;
                    break;
                } else if (b == firstZero && c == secondZero) {
                    lie = a;
                    break;
                }
            }
            System.out.println("The lie is in the position of the " + lie + " in the string");
            answers[lie - 1] = 0;
            System.out.println(Arrays.toString(answers));
            
        } else if (whereAreZeros(answers).size() == 3) {
            int firstZero = whereAreZeros(answers).get(0);
            int secondZero = whereAreZeros(answers).get(1);
            int thirdZero = whereAreZeros(answers).get(2);
            int lie = 0;
            for (int i = 0; i < fanoPlane.length; i++) {
                int a = fanoPlane[i][0];
                int b = fanoPlane[i][1];
                int c = fanoPlane[i][2];

                if (a == firstZero && b == secondZero && c == thirdZero) {
                    lie = fanoPlane[i][2];
                    break;
                } else if (a == firstZero && b == thirdZero && c == secondZero) {
                    lie = fanoPlane[i][1];
                    break;
                } else if (a == secondZero && b == thirdZero && c == firstZero) {
                    lie = fanoPlane[i][0];
                }
                System.out.println("The lie is in the position of the " + lie + " in the string");
                
                answers[lie - 1] = 0;
            }
        }
    }

    public static int decode(int[] answers) {
        int weight = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == 1) {
                weight++;
            }
        }
        int[][] fanoPlane = {
                { 1, 2, 3 },
                { 1, 4, 5 },
                { 1, 6, 7 },
                { 2, 4, 6 },
                { 2, 5, 7 },
                { 3, 4, 7 },
                { 3, 5, 6 }
        };
       
        if (weight == 0) {
        	System.out.println("No lie was told");
        }
        else if (weight == 1) {
           linearSearch(answers,1);
        }
         else if ( weight == 2) {
             weightTwo(answers, fanoPlane);
        } else if (weight == 3) {
            weightThree(answers, fanoPlane);
        } else if (weight >= 4) {
            weightFour(answers, fanoPlane);
        }
        int numGuessed = (answers[0] << 3) | (answers[1] << 2) | (answers[2] << 1) | answers[3];
	    System.out.println("The number thought of was " + numGuessed);
		return weight;
    }
   
    public static void main(String[] args) {
        int[] answers = new int[7];
        encode(answers);
        decode(answers);
       
    }
}
