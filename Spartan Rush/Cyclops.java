
/**
 * Write a description of class Cyclops here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cyclops 
{
    String imgname;
    double x;
    double y;
    int health = 1000;
    long tpStart = 0;
    /**
     * Constructor for objects of class Cyclops
     */
    public Cyclops()
    {
        imgname = "cyclopsLeft.png";
        x = 0.5;
        y = 1;
    }

    public void move(double playerX, double playerY)
    {

        if (playerX >= x)
        {
            imgname = "cyclopsRight.png";
        }
        if (playerX < x)
        {
            imgname = "cyclopsLeft.png";
        }
        if (teleportIsAvailable())
        {
            tpStart = System.currentTimeMillis();
            x = (Math.random());
            y = (Math.random());
        }
    }

    public void drawCyclops()
    {
            StdDraw.picture(x, y, imgname, 0.6, 0.45);
    }

    public  boolean alive()
    {
        if (health > 0)
            return true;
        else
        {
            return false;
        }
    }

    public void takeDamage(double SwordX, double SwordY, double ScaleX, 
    double ScaleY)
    {
        if (SwordX > (x - ScaleX/2) && SwordX < (x + ScaleX/2))
        {
            if (SwordY > (y - ScaleY) && SwordY < (y + ScaleY))
            {
                health -= 50;
            }
        }
    }

    public boolean teleportIsAvailable()
    {
        if (tpStart == 0)
        {
            return true;
        }
        if (tpStart + 5000 <= System.currentTimeMillis())
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public double clypX()
    {
        return x;
    }

    public double clypY()
    {
        return y;
    }
}

