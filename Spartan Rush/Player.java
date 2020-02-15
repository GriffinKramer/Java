/**
 * This contains the player for my code and all of it's methods
 *
 * @author (Griffin Kramer)
 * @version (Version 2.3)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private String playerVar;
    private String[] playerVarArray = {"spartanRightDown.png","spartanRightUp.png","spartanLeftDown.png", "spartanLeftUp.png"};
    private int health = 100;
    private boolean isRight = true;
    int ctrR = 0;
    int ctrL = 0;
    long dashStartTime = 0;
    /**
    constructor
    */
    public Player()
    {
        x = 0.1;
        y = 0.1;
        playerVar = playerVarArray[0];
        StdDraw.picture(x, y, playerVar, 0.3, 0.2);
    }
    /**
    Move function that moves the player
    */
    public void move()
    {
        if (StdDraw.isKeyPressed(68))
        {
            isRight = true;
            x += 0.0075;
            switchImage();
        }
        if (StdDraw.isKeyPressed(65))
        {
            isRight = false;
            x -= 0.0075; 
            switchImage();
        }
        if (StdDraw.isKeyPressed(87))
        {
            y += 0.0075;
        }
        if (StdDraw.isKeyPressed(83))
        {
            y -= 0.0075;
        }
    }
    /**
     Corrects player position so he stays on the screen
    */
    public void inBounds()
    {
        if (x <= 0)
        {
            x = 0.001;
        }
        if (x >= 1)
        {
            x = 0.999;
        }
        if (y <= 0)
        {
            y = 0.001;
        }
        if (y >= 1)
        {
            y = 0.999;
        }
    }
    /**
     Draws the player
    */
    public void drawPlayer()
    {
        StdDraw.picture(x, y, playerVar, 0.3, 0.2);
    }
    /**
     * returns x 
    @return returns x coordinate for the player
    */
    public double x_cord()
    {
        return x;
    }
    /**
     * returns y
    @return returns y coordinate for the player
    */
    public double y_cord()
    {
        return y;
    }
    /**
     * returns image to draw player
    @return returns the image that is used to draw the player
    */
    public String ppVar()
    {
        return playerVar;
    }
    /**
     * returns if player can throw the sword
    @return returns if the player can throw his sword
    */
    public boolean throwSword()
    {
        if (StdDraw.isKeyPressed(81))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
    lowers health when touched by another object
    @param Whisp's X cordinate
    @param Whisp's Y cordinate
    */
    public void takeDamage(double WhispX, double WhispY)
    {
        if (x < (WhispX + 0.05) && x > (WhispX - 0.05))
        {
            if (y < (WhispY + 0.1) && y > (WhispY - 0.1))
            {
                health -= 100;
            }
        }
    }
    /**
    lowers health when touched by another object - modified for the cyclops class
    @param Cyplops's X cordinate
    @param Cyplops's Y cordinate
    */
    public void takeDamageCyplops(double cX, double cY)
    {
       if (x < (cX + 0.09) && x > (cX - 0.09))
        {
            if (y < (cY + 0.5) && y > (cY + 0.2))
            {
                health -= 100;
            }
        } 
    }
    /**
     * returns if alive
    @return returns if player is alive
    */
    public boolean isAlive()
    {
        if (health > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
    Switches the player image
    */
    public void switchImage()
    {
        
        if (isRight == true)
        {
            if (playerVar.equals(playerVarArray[0]))
            {
                ctrR++;
                if (ctrR >= 10)
                {
                    playerVar =  playerVarArray[1];
                }
            }
            else if (playerVar.equals(playerVarArray[1]))
            {
                ctrR--;
                if (ctrR <= 0)
                {
                    playerVar = playerVarArray[0];
                }
            }
            else
            {
                playerVar = playerVarArray[0];
            }
        }
        else
        {
            if (playerVar.equals(playerVarArray[3]))
            {
                ctrL++;
                if (ctrL >= 10)
                {
                    playerVar = playerVarArray[2];
                }
            }
            else if (playerVar.equals(playerVarArray[2]))
            {
                ctrL--;
                if (ctrL <= 0)
                {
                    playerVar = playerVarArray[3];
                }
            }
            else
            {
                playerVar = playerVarArray[2];
            }
        }
        
    }
    /**
    sets up dash for player
    */
    public void dash()
    {
        if (StdDraw.isKeyPressed(69))
        {
            if (dashIsAvailable())
            {
                if (playerVar.equals("spartanLeftUp.png") || 
                playerVar.equals("spartanLeftDown.png"))
                {
                    for (int i = 0; i < 15; i++)
                    {
                        x -= 0.015;
                        StdDraw.picture(x, y, playerVar, 0.3, 0.2);
                    }
                    dashStartTime = System.currentTimeMillis();
                }
                else
                {
                    for (int i = 0; i < 15; i++)
                    {
                        x += 0.015;
                        StdDraw.picture(x, y, playerVar, 0.3, 0.2);
                    }
                    dashStartTime = System.currentTimeMillis();
                }
            }
        }
    }
    /**
     * checks if dash is available
    @return returns if player is able to dash
    */
    public boolean dashIsAvailable()
    {
        if (dashStartTime == 0)
        {
            return true;
        }
        else if (dashStartTime + 1000 <= System.currentTimeMillis())
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

}
