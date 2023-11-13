import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

/*public class guessing_game extends PrintStream {
    //method of typewrter animation
    private int delayMillis;
    public guessing_game(PrintStream original, int delayMillis) {
        super(original);
        this.delayMillis = delayMillis;
    }

    @Override
    public void println(String x) {
        for (char c : x.toCharArray()) {
            super.print(c);
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.println();
    }
*/

//remove if you want to start the animation
    public class hello{ 
//starting code
    public static void main(String[] args) throws InterruptedException{

/*delay speed setting - return if you will start the animation

        int delayMillis = 50; // delay speed
        System.setOut(new guessing_game(System.out, delayMillis));
*/

        Scanner input = new Scanner(System.in);

/*place codes here & introduction
        System.out.println("Welcome to the game Player!");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("This game was called \'7-Lives\'");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("This game is all about guessing a word where you only given 7 attempts to try");
        System.out.println("");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("You can choose what word-category you want to play");
        TimeUnit.SECONDS.sleep((long) 1.5);
*/
        
        outerloop: while(true){
            System.out.println("Option: SHS Subject, hobbies, Animals, Place");
            TimeUnit.SECONDS.sleep((long) 1.5);
            System.out.print("Answer: ");
            String option = input.nextLine().toLowerCase();
            System.out.println("");
            
//shs subject            
            if (option.equals("shs subject")) {
                System.out.println("You chose " + option + " word-category");
                String[] words = {"21st Century Literature", "Computer Programming", "Oral Communication", "Physical Education", "Media and Information Literacy", "Philosophy", "General Mathematics"};
                Random random = new Random();
                String wordToGuess = words[random.nextInt(words.length)];

                char[] guessedWord = new char[wordToGuess.length()];

                for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = wordToGuess.charAt(i) == ' ' ? ' ' : '_';
                }

                int attempts = 7;
                Scanner scanner = new Scanner(System.in);
                boolean wholeWordGuessed = false;

                while (attempts > 0 && !wholeWordGuessed) {
                    System.out.println("");
                    System.out.println("Word to guess: " + String.valueOf(guessedWord));
                    System.out.println("Attempts left: " + attempts);
                
                    System.out.print("Guess a letter or the whole word: ");
                    String guess = scanner.nextLine().toLowerCase();
                
                    if (guess.equals(wordToGuess.toLowerCase())) {
                        wholeWordGuessed = true;
                        System.out.println("");
                        System.out.println("Congratulations! You guessed the whole word.");
                        break outerloop;
                    }
                
                    char letterGuess = guess.charAt(0);
                    boolean correctGuess = false;
                
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (Character.toLowerCase(wordToGuess.charAt(i)) == letterGuess) {
                            guessedWord[i] = letterGuess;
                            correctGuess = true;
                        }
                    }
                
                    int correctLetters = 0;
                    for (char c : guessedWord) {
                        if (c != '_') {
                            correctLetters++;
                        }
                    }
                
                    if (correctLetters == wordToGuess.length()) {
                        System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                        break;
                    }
                
                    if (!correctGuess) {
                        attempts--;
                    }
                }
                

                if (attempts == 0) {
                    System.out.println("You ran out of attempts. The word was: " + wordToGuess);
                    System.out.println("Better Luck again next time!");
                    break;
                }

                scanner.close();
            }
        }
        System.out.println("tnx");  
            
/*  credits- remove if start the animation
        System.out.println("Thank you for playing!");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("Credits to: Rhenz Daryl Naranjo");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("From MAWD102");

        input.close(); */
    }
}
