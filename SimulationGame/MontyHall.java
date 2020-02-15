import java.util.Scanner;
import java.util.Arrays;
public class MontyHall
{
    public static void main (String args[])
    {
        int noChangeCorrect = 0;
        int ChangeCorrect = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of tests");
        int numTests = input.nextInt();
        for (int i = 0; i < numTests; i++)
        {
            int correctDoor = (int)(Math.random() * 3 + 1);
            int doorGuess = (int)(Math.random() * 3 + 1);
            noChangeCorrect += compareInts(correctDoor, doorGuess);
        }
        for (int i = 0; i < numTests; i++)
        {
            int correctDoor2 = (int)(Math.random() * 3 + 1);
            int doorGuess2 = (int)(Math.random() * 3 + 1);
            ChangeCorrect += ChangeDoor(correctDoor2, doorGuess2);
        }
        System.out.println("There were " + noChangeCorrect + " wins out of "
            + numTests + " tests(no switch)");
        System.out.println("There were " + ChangeCorrect + " wins out of "
            + numTests + " tests(switch)");
    }

    public static int compareInts(int CorrectDoor, int doorGuess)
    {
        if (CorrectDoor == doorGuess)
        {
            return 1;
        }
        else 
        {
            return 0;
        }
    }

    public static int ChangeDoor(int correctDoor, int doorGuess)
    {
        if (correctDoor == doorGuess)
        {
            return 0;
        }
        else 
        {
            return 1;
        }
    }
}

