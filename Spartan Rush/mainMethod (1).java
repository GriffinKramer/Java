import java.awt.Color;
import java.util.ArrayList;
/**
 * This contains the main method for my code as well as a few helper methods
 * it is what runs the code
 * @author (Griffin Kramer)
 * @version (Version 2.3)
 */
public class mainMethod
{
    /**
     main method to use the game
    */
    public static void main (String args[])
    {
        boolean game = true;
        StdDraw.setCanvasSize(600,600);

        //StdDraw.picture(100, 0.5, "Map.png", 0.96, 0.72);
        StdDraw.show();
        int numWhisps = 7;
        Player Player = new Player();
        Sword Sword = new Sword(Player.throwSword());
        ArrayList <Whisp> whispList = makeWhisps(numWhisps);
        PowerUp jUp = new PowerUp();
        int  generatePowerUp = -1;
        boolean drawPowerUp = false;
        int kills = 0;
        Cyclops cyp = new Cyclops();

        while (game)
        {
            StdDraw.enableDoubleBuffering();

            //StdDraw.picture(0.5, 0.5, "Map.png", 1.5, 1.1);

            Player.move();
            Player.inBounds();
            Player.dash();
            Player.drawPlayer();

            Sword.placeSword(Player.x_cord(), Player.y_cord(), Player.ppVar());
            Sword.move();
            Sword.drawSword();

            StdDraw.text(0.95, 0.95, Integer.toString(kills));
            for (int i = 0; i < whispList.size(); i++)
            {
                if (whispList.get(i).alive())
                {
                    whispList.get(i).move(Player.x_cord(), Player.y_cord());
                    whispList.get(i).drawWhisp();
                    whispList.get(i).takeDamage(Sword.SwordX(), Sword.SwordY(), 
                        Sword.ScalerX(), Sword.ScalerY());
                    Sword.hit(whispList.get(i).WhispX(),
                        whispList.get(i).WhispY());
                    Player.takeDamage(whispList.get(i).WhispX(),
                        whispList.get(i).WhispY());
                }
                else
                {
                    whispList.remove(i);
                    kills++;
                }
            }
            if (kills < numWhisps)
            {
                if (whispList.size() == 0)
                {
                    whispList = makeWhisps(numWhisps);
                }
            }
            else if (kills == numWhisps)
            {
                if (cyp.alive())
                {
                    cyp.move(Player.x_cord(), Player.y_cord());
                    cyp.drawCyclops();
                    cyp.takeDamage(Sword.SwordX(), Sword.SwordY(),Sword.ScalerX(), Sword.ScalerY());
                    Sword.hit(cyp.clypX(),cyp.clypX());
                    Player.takeDamageCyplops(cyp.clypX(),cyp.clypX());
                }
                else 
                {
                    kills++;
                }
            }
            else{
                if (whispList.size() == 0)
                {
                    whispList = makeWhisps(numWhisps);
                }
            }
            

            if  (Player.isAlive() == false)
            {
                game = false;
            }

            generatePowerUp =(int) ((Math.random()) * 1000);
            if (generatePowerUp == 99)
            {
                drawPowerUp = true;
            }
            if (drawPowerUp)
            {
                if (jUp.grabber() == false)
                {
                    jUp.drawPowerUp();
                }
                jUp.grab(Player.x_cord(), Player.y_cord());
                Sword.ChangeScaleX(jUp.effect1());
            }

            StdDraw.show(17);
            StdDraw.clear();
            StdDraw.disableDoubleBuffering();

        }
    }
    /**
    Returns an array list of Whisp objects.
    Precondition: This is only called when the length of the existing list is 0.
    Postcondition: Returns list w/ desired number of whisps.
    @param numOfWhisps - the desired number of whisps
    @return whispList - a new arraylist filled with whisp objects
    */
    public static ArrayList<Whisp> makeWhisps(int numOfWhisps)
    {
        ArrayList<Whisp> whispList = new ArrayList<Whisp>();
        for (int i = 0; i < numOfWhisps; i++)  
        {
            Whisp whisp = new Whisp((generateRandom()), generateRandom());
            whispList.add(whisp);

        }
        return whispList;
    }
    /**
    Returns a random value.
    
    
    @return number - a random number -1 to 0 or 1 to 2
    */
    public static double generateRandom()
    {
        double num;
        int num2 = (int) ((Math.random()) * 2);
        if (num2 == 1)
        {
            num = (Math.random() - 1);
        }
        else
        {
            num = (Math.random() + 1);
        }
        return num;
    }

}
