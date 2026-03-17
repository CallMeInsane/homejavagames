/*
*  This is probably not as well-rounded as it could be, maybe if I used an arraylist it'd be better.
*  Words are taken from https://cs.stanford.edu/~knuth/sgb-words.txt
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordGameJava{


    public static void main(String args[]) throws IOException{ 
        //File and input code
        Scanner kbr = new Scanner(System.in);

        //Stole this off of stack
        BufferedReader reader = new BufferedReader(new FileReader("sgb-words.txt"));
        int lines = 0;
        while (reader.readLine() != null) lines++;

        reader.close();
        reader = new BufferedReader(new FileReader("sgb-words.txt"));
        String[] words = new String[lines];

        for (int i = 0; i < lines; i++) {
            String current = reader.readLine();

            words[i] = current;
        }

//*************************************************************************************************************************************
//Game
//*************************************************************************************************************************************

        //Grab random word
        String word = words[(int)(Math.random()*(lines-1)+1)];
        String answer = "";
        System.out.println("The word was " + word);

        for (int i = 1; i<=6; i++){
            if (answer.equals(word)) 
                break;

            while (answer.length() != 5){ //Correct input length
                System.out.printf("Input a FIVE letter word (Attempt %d) ", i);
                answer = kbr.next();
            }

            while (!answer.equals(word)){
                System.out.println(checkAnswer(word, answer));

                System.out.printf("Input a FIVE letter word (Attempt %d)", i);
                answer = kbr.next();
                break;
            }

        }

        //End message
        System.out.println("The word was " + word);
    }

    //Returns a formatted correction
    static String checkAnswer(String word, String guess){
        String ans = "";

        for (int i = 0; i<5; i++){
            if (guess.length()==5){
                char current = guess.toUpperCase().charAt(i);

                if (current == word.toUpperCase().charAt(i))
                 ans += "G";

                else if (word.toUpperCase().contains(current+""))
                 ans += "Y";

                else 
                 ans += "R";
            }
        }

        return ans;
    }


}