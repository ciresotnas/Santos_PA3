import java.lang.Math;
import java.security.SecureRandom;
import java.util.Scanner;

public class p1 {
    private static String goodResponse(String newResponse) {
        int responseChoice;
        SecureRandom random = new SecureRandom();
        responseChoice = random.nextInt(4);
        switch (responseChoice) {
            case 0:
                newResponse = "Very Good!";
                break;
            case 1:
                newResponse = "Excellent!";
                break;
            case 2:
                newResponse = "Nice Work!";
                break;
            case 3:
                newResponse = "Keep up the good work!";
                break;
        }
        return newResponse;
    }

    private static String badResponse(String custResponse) {
        int responseChoice;
        SecureRandom random = new SecureRandom();
        responseChoice = random.nextInt(4);
        switch (responseChoice) {
            case 0:
                custResponse = "No. Please try again.";
                break;
            case 1:
                custResponse = "Wrong. Try once more.";
                break;
            case 2:
                custResponse = "Don't give up!";
                break;
            case 3:
                custResponse = "No. Keep trying.";
                break;
        }
        return custResponse;
    }

    private static double[] generateQuestion(double[] tempNums, int difficultyLv) {
        tempNums = new double[2];
        int boundary = (int)(Math.pow(10, difficultyLv));

        SecureRandom random = new SecureRandom();

        tempNums[0] = random.nextInt(boundary);
        tempNums[1] = random.nextInt(boundary);
        return tempNums;
    }

    private static String generateWord(int mathChoice) {
        SecureRandom random = new SecureRandom();
        String wordChoice = "0/";
        if(mathChoice == 5)
            mathChoice = (random.nextInt(4) + 1);
        switch(mathChoice) {
            case 1:
                wordChoice = "plus";
                break;
            case 2:
                wordChoice = "times";
                break;
            case 3:
                wordChoice = "minus";
                break;
            case 4:
                wordChoice = "divided by";
                break;
        }
        return wordChoice;
    }

    private static double solve(double x, double y, String mathC) {
        double solution = 0.0;
        switch (mathC) {
            case "plus":
                solution = (x + y);
                break;
            case "times":
                solution = (x * y);
                break;
            case "minus":
                solution = (x - y);
                break;
            case "divided by":
                solution = (x/y);
                break;
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String comResponse = "0/", arithWord;
        char restart;
        double[] quesNums;
        double userAnswer, realAnswer;
        int diffChoice, arithChoice, i, j, numCorrect = 0, numWrong = 0;
        double finalPercent;
        quesNums = new double[2];

        for(j = 0; j >= 0; j++) {
            System.out.println("Please enter difficulty level (1-4): ");
            diffChoice = scnr.nextInt();
            System.out.println("Please enter 1 for addition, 2 for multiplication, 3 for subtraction, 4 for division, or 5 for a blend: ");
            arithChoice = scnr.nextInt();

            for (i = 0; i < 10; i++) {
                quesNums = generateQuestion(quesNums, diffChoice);
                arithWord = generateWord(arithChoice);

                System.out.println("How much is " + quesNums[0] + " " + arithWord + " " + quesNums[1] + "?");// write your code he
                realAnswer = solve(quesNums[0], quesNums[1], arithWord);

                userAnswer = scnr.nextDouble();

                if (userAnswer == realAnswer) {
                    System.out.println(goodResponse(comResponse));
                    numCorrect++;
                } else {
                    System.out.println(badResponse(comResponse));
                    numWrong++;
                }
            }
            finalPercent = (((numCorrect / 10.0)) * 100);
            System.out.println("You answered " + numCorrect + " questions correct, and " + numWrong + " questions wrong.");

            if (finalPercent < 75) {
                System.out.println("Please ask your teacher for extra help.");
            } else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            System.out.println("Would you like to begin again? (Y/N): ");
            restart = scnr.next().charAt(0);
            if (restart == 'N')
                break;
        }
    }
}
