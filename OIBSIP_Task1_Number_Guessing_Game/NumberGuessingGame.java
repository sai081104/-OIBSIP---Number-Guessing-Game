import javax.swing.*;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        int score = 0;
        int rounds = 3;

        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!");

        for (int round = 1; round <= rounds; round++) {
            int randomNumber = new Random().nextInt(100) + 1;
            int attempts = 5;
            boolean isGuessed = false;

            JOptionPane.showMessageDialog(null, "Round " + round + " - Guess a number between 1 and 100. You have " + attempts + " attempts.");

            while (attempts > 0) {
                String input = JOptionPane.showInputDialog("Enter your guess:");
                
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game exited.");
                    System.exit(0);
                }

                try {
                    int guess = Integer.parseInt(input);

                    if (guess == randomNumber) {
                        JOptionPane.showMessageDialog(null, "Correct! You guessed the number.");
                        score += attempts * 10;
                        isGuessed = true;
                        break;
                    } else if (guess < randomNumber) {
                        JOptionPane.showMessageDialog(null, "The number is higher. Attempts left: " + (attempts - 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "The number is lower. Attempts left: " + (attempts - 1));
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }

                attempts--;
            }

            if (!isGuessed) {
                JOptionPane.showMessageDialog(null, "You ran out of attempts! The number was: " + randomNumber);
            }
        }

        JOptionPane.showMessageDialog(null, "Game Over! Your total score is: " + score);
    }
}
