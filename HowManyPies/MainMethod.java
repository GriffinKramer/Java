import java.util.Scanner;
public class MainMethod
{
    public static void main (String args[])
    {
        Scanner in = new Scanner(System.in);
        String ingredient = in.nextLine();
        ingredient += ",";
        String[] theIngredients = getIngredienst(ingredient);

        Pies thePies = new Pies(Integer.parseInt(theIngredients[0]) ,
                Integer.parseInt(theIngredients[1]),Integer.parseInt(theIngredients[2]),
                Integer.parseInt(theIngredients[3]),Integer.parseInt(theIngredients[4]));
        int num_pies = 0; 
        int num_a = 0;
        int num_p = 0;
        int max_pies = 0;
        int fNumApple = 0;
        int fNumPumpk = 0;
        for (int i = 0; i <= 1000; i++)
        {

            for (int j = 0; j < i; j++)
            {
                thePies.createPumpkin();
            }

            for (int j = 0; j < 10000 - i; j++)
            {
                thePies.createApple();
            }

            num_pies = thePies.apps() + thePies.pump();
            if (num_pies >= max_pies)
            {
                max_pies = num_pies;
                fNumApple = thePies.apps();
                fNumPumpk = thePies.pump();
            }
            
            thePies.backToNormal();
        }
        System.out.println("You can make " + fNumPumpk + " pumpkin pies and " 
        + fNumApple + " apple pies");
    }

    public static String[] getIngredienst(String ingredient)
    {
        String [] theIngs = new String[5];
        String theI = "";
        int j = 0;
        for (int i = 0; i < ingredient.length(); i++)
        {
            if (!(ingredient.substring(i, i+1).equals(",")))
            {
                theI += ingredient.substring(i, i+1);
            }
            else
            {
                theIngs[j] = theI;
                j++;
                theI = "";
            }
        }
        theI = "";
        return theIngs;
    }

}

