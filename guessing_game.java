import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.PrintStream;
import java.util.Random;

// typewriter text animation
public class guessing_game extends PrintStream {
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


/*remove if you want to start the text animation
    public class guessing_game{ */

//starting code
    public static void main(String[] args) throws InterruptedException{

//delay speed setting - return if you will start the animation

        int delayMillis = 50; // delay speed
        System.setOut(new guessing_game(System.out, delayMillis));
//unpacking scanner import
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the game Player!");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("This game was called \'7-Lives\'");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("This game is all about guessing a word where you only given 7 attempts to try");
        System.out.println("");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("You have to choose what word-category you want to play");
        TimeUnit.SECONDS.sleep((long) 1.5);
//starts of the loop (while)       
        outerloop: while(true){
            System.out.println("");
            System.out.println("Options: SHS Subject, Hobbies, Animals, Fruits");
            TimeUnit.SECONDS.sleep((long) 1.5);
            System.out.print("Answer: ");
            String option = input.nextLine().toLowerCase();
            System.out.println("");
            
//shs subject word-category            
            if (option.equals("shs subject")) {
                System.out.println("You chose " + option + " word-category");
                System.out.println("LOAAADDIIINGG....");
                String[] words = {"21st Century Literature", "Computer Programming", "Oral Communication", "Physical Education", "Media and Information Literacy", "Philosophy", "General Mathematics"};
//picking random inputs from the array     
                Random random = new Random();

                String wordToGuess = words[random.nextInt(words.length)];
                char[] guessedWord = new char[wordToGuess.length()];
//for loop
                for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = wordToGuess.charAt(i) == ' ' ? ' ' : '_';
                }
//attempts
                int attempts = 7;

                Scanner scanner = new Scanner(System.in);
//initialization if the word is fully guessed
                boolean wholeWordGuessed = false;
//while loop if still having lives
                while (attempts > 0 && !wholeWordGuessed) {
                    System.out.println("");
                    System.out.println("Word to guess: " + String.valueOf(guessedWord));
                    System.out.println("Attempts left: " + attempts);
                
                    System.out.print("Guess a letter or the whole word: ");
                    String guess = scanner.nextLine().toLowerCase();
// if the whole word is guessed                
                    if (guess.equals(wordToGuess.toLowerCase())) {
                        wholeWordGuessed = true;
                        System.out.println("");
                        System.out.println("Congratulations! You guessed the whole word.");
                        break outerloop;
                    }
                
                    char letterGuess = guess.charAt(0);
                    boolean correctGuess = false;
//for loop                
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
// guesing the word by letter                
                    if (correctLetters == wordToGuess.length()) {
                        System.out.println("");
                        System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                        break outerloop;
                    }
                
                    if (!correctGuess) {
                        attempts--;
                    }
                }
                if (attempts == 0) {
                    System.out.println("");
                    System.out.println("You ran out of attempts. The word was: " + wordToGuess);
                    TimeUnit.SECONDS.sleep((long) 1.5);
                    System.out.println("");
                    System.out.println("Better Luck again next time!");
                    break outerloop;
                }

                scanner.close();
            }             
//hobbies            
            if (option.equals("hobbies")) {
                System.out.println("You chose " + option + " word-category");
                String[] words = {"Reading", "Singing", "Dancing", "Games", "Cooking", "Instruments", "Sleeping"};
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
                        System.out.println("");
                        System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                        break outerloop;
                    }
                
                    if (!correctGuess) {
                        attempts--;
                    }
                }
                if (attempts == 0) {
                    System.out.println("");
                    System.out.println("You ran out of attempts. The word was: " + wordToGuess);
                    TimeUnit.SECONDS.sleep((long) 1.5);
                    System.out.println("");
                    System.out.println("Better Luck again next time!");
                    break outerloop;
                }

                scanner.close();
//animals                     
            } if (option.equals("animals")) {
                System.out.println("You chose " + option + " word-category");
                String[] words = {"dogs", "cats", "birds", "turtle", "butterfly", "frogs", "cappybara"};
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
                        System.out.println("");
                        System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                        break outerloop;
                    }
                
                    if (!correctGuess) {
                        attempts--;
                    }
                }
                if (attempts == 0) {
                    System.out.println("");
                    System.out.println("You ran out of attempts. The word was: " + wordToGuess);
                    TimeUnit.SECONDS.sleep((long) 1.5);
                    System.out.println("");
                    System.out.println("Better Luck again next time!");
                    break outerloop;
                }

                scanner.close();
            
// fruits            
            } if (option.equals("fruits")) {
                System.out.println("You chose " + option + " word-category");
                String[] words = {"apples", "mangoes", "orange", "strawberry", "pineapple", "banana", "watermelon"};
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
                        System.out.println("");
                        System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                        break outerloop;
                    }
                
                    if (!correctGuess) {
                        attempts--;
                    }
                }
                if (attempts == 0) {
                    System.out.println("");
                    System.out.println("You ran out of attempts. The word was: " + wordToGuess);
                    TimeUnit.SECONDS.sleep((long) 1.5);
                    System.out.println("");
                    System.out.println("Better Luck again next time!");
                    break outerloop;
                }

                scanner.close();
            
            
            } 
            
             else{
                System.out.println("Error. Please input correct keys");
                continue;
            }

        } 
            
        System.out.println("Thank you for playing the game!");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("");
        System.out.println("Credits to: Rhenz Daryl Naranjo");
        TimeUnit.SECONDS.sleep((long) 1.5);
        System.out.println("From MAWD102");

        input.close(); 
    }
}
