// Jack Dixon
// 9/9/2025
// Wordle Game 

import java.util.Random;
import java.util.Scanner;


public class WordleGame
{
    private String[] WORDS = {"ARRAY", "CACHE", "CLASS", "DEBUG", "EVENT", "FRAME", "GRAPH", "HEAPS", "INDEX", "LOGIC", "PANEL", "QUEUE", "STACK", "TABLE", "VALUE", "YIELD", "ZEROS"};
    private String selectedWord;
    private int remainingGuesses; 

    public static void main(String[] args)
    {
        System.out.print("Hello World");
        Scanner scan = new Scanner(System.in);



        playGame();
    }

     public void playGame();
        {
            selectedRandomWord();
            remainingGuesses = 6;

            char[] guess = new char[5];  //make the word that they guess a char so I can check it easier
            for (int i = 0; i < 5; i++) 
            {
                guess[i] = '_';
            }

            System.out.println("Hello welcome to the wordle");

            while(remainingGuesses > 0) 
            {
                displayGuess(guess);
                System.out.println("Write your next guess: ");
                String input = scan.nextLine().toUpperCase();

                if(input.length() !=5 )
                {
                    System.out.println("not 5 letters enter a 5 letter word");
                    continue;
                }
                if(input.equals(selectedWord))
                {
                    System.out.println("you guessed correctly!")
                    displayGuess(selectedWord.toCharArray());
                    break;
                }
                else
                {
                    remainingGuesses--;
                    updateGuess(guess, input);
                    System.out.println("wrong guess. remaining guesses: " + remainingGuesses)
                }
            }

            if(remainingGuesses == 0)
            {
                System.out.println("game over, the word was " + selectedWord);
            }

        }

        public void displayGuess(char[] guess) //diplays the guess 
        {
            for(char c : guess)
            {
                System.out.print(c + " ")
            }
            System.out.println();
        }
        
        public void selectRandomWord() //selects a random word from my list
        {
        Random random = new Random();
        int index = random.nextInt(WORDS.length);
        selectedWord = WORDS[index];
        }

        public void updateGuess(char[] guess, String input);
        {
            for(int i = 0; i < 5; i++)
            {
                char inputChar = input.charAt(i);
                if(inputChar == selectedWord.charAt(i))
                {
                    guess[i] = inputChar;
                    System.out.print("\u001B[32m" + guess[i] + " "); //green
                }   
                else if(selectedWord.contains(String.valueOf(inputChar))) //checks if its in the word so we need to convert char to string temperaroly
                {
                    System.out.print("\u001B[33m" + inputChar + " "); //yellow 
                }            
                else 
                {
                    System.out.print("\u001B[0m" + guess[i] + " "); //resets color for letters
                }
                System.out.println("\u001B[0m"); //resets it fully after printing for the next guess
            }
        }
}