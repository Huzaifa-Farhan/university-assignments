import java.util.Random;

public class Random {
    public static void main(String[] args){
        Random randomdie = new Random();
        int die1 = randomdie.nextInt(6) + 1;
        int die2 = randomdie.nextInt(6) + 1;
        int totalRoll = die1 + die2;
        System.out.println("First Die Roll is: " + die1);
        System.out.println("Second Die Roll is: " + die2);
        System.out.println("Total roll amount: " + totalRoll);
    }
}