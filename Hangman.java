import java.util.Scanner;

public class Hangman
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // sets the answer as a random uppercase word
        String answer = Words.getWord();
        answer = answer.toUpperCase();

        // gives the user 6 tries and zero points off
        int lives = 6;
        int hangman = 0;

        // creates a variable to hold the letters that were already guessed
        String guesses = "";

        // creates a boolean array the same length as the random word
        boolean[] revealed = new boolean[answer.length()];
        
        // prints the amount of letters in the word &
        // sets all values in the boolean to false so the game can start
        for (int i=0; i<answer.length(); i++)
        {
            revealed[i] = false;
            System.out.print("_ ");
        }


        // runs the game until the user wins or loses
        while (!hasWon(revealed, answer) && lives > 0)
        {
            // asks the user for a letter and makes it uppercase
            System.out.println();
            System.out.println();
            System.out.print("Guess a letter: ");
            String guess = input.nextLine();
            guess = guess.toUpperCase();

            System.out.println();
            
            // checks if the user has already guessed the letter
            // if so, it tells the user to try again and prompts the user again
            // if not, it continues with the game
            if (guess.length() == 1)
            {       
                if (guesses.contains(guess))
                {
                    System.out.println();
                    System.out.println("You have already guessed " + guess + ". Try again.");
                }
                else
                {
                    // sets the users guess to the variable letter
                    char letter = guess.charAt(0);

                    // if the letter is in the word, the corresponding element in the array
                    // will become true
                    for (int i=0; i<answer.length(); i++)
                    {
                        if (answer.charAt(i) == letter)
                        {
                            revealed[i] = true;
                        }
                    }

                    // if the letter is not in the word, a life is taken away
                    // and the variable hangman increases by 1
                    if (!answer.contains(guess))
                    {
                        lives--;
                        hangman++;
                    }
                
                    // the random print lines are just to skip lines
                    // so the console isnt crowded with words
                    System.out.println();
                    
                    // this will build the hangman each time the user guesses to keep
                    // track of their progress. and it will build it more and more as
                    // the variable hangman increases until it gets to 6
                    buildHangman(hangman);
                    System.out.println();
                    System.out.println();

                    // this checks to see which values of the boolean array are true
                    // and it prints the letter corresponding with the true element
                    // if the element is still false, it prints a dash
                    for (int i=0; i<answer.length(); i++)
                    {
                        if (revealed[i] == true)
                        {
                            System.out.print(answer.charAt(i) + " ");
                        }
                        else
                        {
                            System.out.print("- ");
                        }
                    }
                
                    
                    // this keeps track of the guesses after each one
                    // so the user can't guess the same letter twice
                    guesses = guesses + (guess + " ");
                
                
                    System.out.println();
                    System.out.println();
                    

                    // previous build hangman place

                    System.out.println();

                    // this tells the user how many lives they have remaining and what letters 
                    // have already guessed
                    System.out.println("You have " + lives + " lives left.");
                    System.out.println("Letters guessed: " + guesses);
                }
            }
            else
            {
                System.out.println("Too many or too few characters entered...please try again");
            }
        }

        // if the user wins, it prints "YOU WIN! :)"
        // and the correct word
        // if they lose it prints the losing message
        // and the correct word
        if (hasWon(revealed, answer))
        {
            System.out.println();
            System.out.println();
            System.out.println("YOU WIN! :)");
            System.out.print("The word is " + answer + "!");
        }
        else if (lives == 0)
        {
            System.out.println();
            System.out.println();
            System.out.println("YOU LOST! :(");
            System.out.print("The word was " + answer + "!");
        }
    }

    //this method determines whether the user has won yet
    private static boolean hasWon(boolean[] answer, String word)
    {
        //sets the amount of letters correct to 0
        int correct = 0;

        // adds 1 to the correct variable for each true value
        // in the boolean array
        for (int i=0; i<word.length(); i++)
        {
            if (answer[i] == true)
            {
                correct++;
            }
        }

        // if the amount of correct letters corresponds with the
        // word length, the user wins. if not, they haven't won yet
        if (correct == word.length())
        {
            return true;
        }
        return false;

    }
    
    // this method builds hangman according to the value 
    // of hangman. in the main program, it increases as
    // lives decrease.
    private static void buildHangman(int hangman)
    {
        if (hangman == 1)
        {
            System.out.println("____|____");
        }
        else if (hangman == 2)
        {
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        }
        else if (hangman == 3)
        {
            System.out.println("    ________");
            System.out.println("    |      |");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        }
        else if (hangman == 4)
        {
            System.out.println("    ________");
            System.out.println("    |      |");
            System.out.println("    |      O");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        }
        else if (hangman == 5)
        {
            System.out.println("    ________");
            System.out.println("    |      |");
            System.out.println("    |      O");
            System.out.println("    |     (|)");
            System.out.println("    |    ");
            System.out.println("    |    ");
            System.out.println("____|____");
        }
        else if (hangman == 6)
        {
            System.out.println("    ________");
            System.out.println("    |      |");
            System.out.println("    |      O");
            System.out.println("    |     (|)");
            System.out.println("    |      ll");
            System.out.println("    |    ");
            System.out.println("____|____");
        }
    }
}

