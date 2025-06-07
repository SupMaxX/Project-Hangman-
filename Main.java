import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        System.out.println("Welcome to Hangman!");
        File dictionary = new File("java/fisiere/usa.txt");

        Scanner textScanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();
        while(textScanner.hasNextLine()) { 
            words.add(textScanner.nextLine());
        }

        String hidden_text = words.get((int)(Math.random()*words.size()));
        char[] textArray = hidden_text.toCharArray();


        char[] myAnswers = new char[textArray.length];
        for(int i = 0; i < textArray.length; i++){
            myAnswers[i] = '?';
        }

        int lives = 6;

        boolean finished = false;

        while(finished == false){
            System.out.println("*****************************************");

            System.out.print("Guess a letter: ");
            String letter = input.next();
            while(letter.length() != 1 || Character.isDigit(letter.charAt(0))){ 
                System.out.println("Error Input - Try Again"); 
                letter = input.next(); 
            }

            boolean found = false;
            for(int i = 0; i < textArray.length; i++){ 
                if(letter.charAt(0) == textArray[i]){
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }

            if(!found){ 
                lives--;
                System.out.println("Wrong Letter");
            }

            boolean done = true;
            for(int i = 0; i < myAnswers.length; i++){ 
                if(myAnswers[i] == '?'){
                    System.out.print(" _");
                    done=false;
                }
                else {
                    System.out.print(" " + myAnswers[i]);
                }
            }

            System.out.println("\n" + "Lives Left: " + lives); 
            drawHangman(lives);
            drawHangman(lives);

            if(done){
                System.out.println("Congrats You Found the Word"); 
                finished = true;
                //write the result to a txt file
                FileWriter writer = new FileWriter("java/fisiere/results.txt");
                writer.write(hidden_text + " - " + "won");
                writer.close();
            }

            if(lives <= 0){
                System.out.println("You are dead! Study Your English");
                finished = true; 

                FileWriter writer = new FileWriter("java/fisiere/results.txt"); 
                writer.write(hidden_text + " - " + "lost");
                writer.close();
            }
        }
    }
    
    public static void drawHangman(int l) {
        if(l == 6) {
         System.out.println("|----------");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 5) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 4) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|    |");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 3) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 2) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else if(l == 1) {
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|   /");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
        else{
         System.out.println("|----------");
         System.out.println("|    O");
         System.out.println("|   -|-");
         System.out.println("|   /|");
         System.out.println("|");
         System.out.println("|");
         System.out.println("|");
        }
       }
     
}