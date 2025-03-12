import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String filepath="words.txt";
        ArrayList<String>words=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(filepath))){
                String line;
                while((line=reader.readLine())!=null){
                    words.add(line.trim());
                }
        }
        catch(FileNotFoundException e){
            System.out.println("OOPS!! the file is not found");
        }
        catch(IOException e){
            System.out.println("OOP!! The file is nor found");
        }
        Scanner scanner=new Scanner(System.in);
        Random random=new Random();
        String word=words.get(random.nextInt(words.size()));
        int wrongGuess=0;
        ArrayList<Character>wordState=new ArrayList<>();
        for(int i=0;i<word.length();i++){
            wordState.add('_');
        }
        System.out.println();
        while(wrongGuess<6){
            System.out.println(gethangmanart(wrongGuess));
            System.out.println("**************");
            System.out.println("WELCOME TO THE JAVA HANGMAN GAME PROGRAM");
            System.out.println("**************");
            System.out.println();
            System.out.print("Word: ");
            for(char c:wordState){
                System.out.print(c+" ");
            }
            System.out.println();
            System.out.println("Guess the letter of the word: ");
            char guess=scanner.next().toLowerCase().charAt(0);
            if(word.indexOf(guess)>=0){
                System.out.println(gethangmanart(wrongGuess));
                System.out.println("CORRECT");
                for(int i=0;i<word.length();i++){
                    if(word.charAt(i)==guess){
                        wordState.set(i,guess);
                    }
                }
                if(!wordState.contains('_')){
                    System.out.println("You Won the game");
                    System.out.println("The original word is "+word);
                    break;
                }
            }
            else{
                wrongGuess++;
                System.out.println("INCORRECT");
            }
            if(wrongGuess>=6){
                System.out.println(gethangmanart(wrongGuess));
                System.out.println("The original word: "+word);
                System.out.println("Thank you for playing the game");
                System.out.println("Have a nice day");
                System.out.println("ByeByeBye");
            }
        }
        scanner.close();

    }
    static String gethangmanart(int wrongGuess){
        return switch(wrongGuess){
            case 0->" ";
            case 1-> """
                      o
                    """;
            case 2-> """
                      o
                      |
                    """;
            case 3-> """
                      o
                     /|
                    """;
            case 4-> """
                      o
                     /|\\
                    """;
            case 5-> """
                      o
                     /|\\
                     /
                    """;
            case 6-> """
                       o
                      /|\\
                      / \\
                    """;
            default->"";
        };
    }
}