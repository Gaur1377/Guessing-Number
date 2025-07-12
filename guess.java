import java.util.*;
// Guessing Game
class Task{
    //Define Rule
    void Game(){
        Scanner reader = new Scanner(System.in);
        String Play = "yes";
        while(Play.equals("yes")){
            Random rand = new Random();
            int randNum = rand.nextInt(100);
            int Guess = -1;
            int tries = 0;
            int i=1;
            while(i<=10){
                System.out.println("Guess Number between 1 to 100");
                Guess = reader.nextInt();
                tries++;
                // Game Logic with Conditionals
                if(Guess<100&& Guess>-1){
                    if (Guess>randNum){
                        System.out.println("Your Guess Number is to High , try Again");
                        int a = 10-i;
                        if(i==10) {
                            // player lost
                            System.out.println("All Your Chances is Lefted ");
                            System.out.println("Game Over");
                            break;
                        }
                        System.out.println("Your chances Left is "+a);
                        i++;
                        continue;
                    } else if (Guess==randNum) {
                        System.out.println("Awesome! You guessed the number!");
                        System.out.println("It only took you " + tries + " guesses.");
                        break;
                    }
                    else {
                        System.out.println("Your Guess Number is to Low , try Again");
                        int a = 10-i;
                        if(i==10) {
                            // player lost
                            System.out.println("All Your Chances is Lefted ");
                            System.out.println("Game Over");
                            break;
                        }
                        System.out.println("Your chances Left is "+a);
                        i++;
                        continue;
                    }
                }
                else {
                    // player lost 
                    System.out.println("it is your Guess Number is invalid,try Again ");
                    break;
                }
            }
            if (i==10){
                break;
            }
            else {
                System.out.print("Would you like to play again? (yes or no): ");
                Play = reader.next().toLowerCase();

            }
        }
        reader.close();
    }
}
public class guess {
    public static void main(String[] args) {
        Task Guess = new Task();
        Guess.Game();
    }
}
