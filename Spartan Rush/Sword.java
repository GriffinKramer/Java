public class Sword
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private double scaleX;
    private double scaleY;
    private boolean swordT;
    private String direction = "spartanRightDown.png";
    private String image = "javelinRight.png";
    public Sword( boolean swordy)
    {
        x = 2.0;
        y = 2.0;
        swordT = swordy;
        scaleX = 0.1;
        scaleY = 0.1;
    }

    public void placeSword(double x2, double y2, String Dir)
    {
        if (StdDraw.isKeyPressed(81))
        {
            if (x > 1 || x < 0)
            {
                x = x2;
                y = y2;
                direction = Dir;
            }
        }
    }

    public int determineDir()
    {
        if (direction.equals("spartanRightDown.png") ||
        direction.equals("spartanRightUp.png"))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public void move()
    {
        if (determineDir() == 1)
        {
            x += 0.025;
            image = "javelinRight.png";
        }
        else
        {
            x -= 0.025;
            image = "javelinLeft.png";
        }
    }

    public void hit(double WhispX,double WhispY )
    {
        if (x > (WhispX - scaleX/2) && x < (WhispX + scaleX/2))
        {
            if (y > (WhispY - scaleY) && y < (WhispY + scaleY))
            {
                x = 100;
                y = -1;
            }
        }
    }
    
    public void hitCyclops(double cX, double cY)
    {
        if (x > (cX - scaleX/2) && x < (cX + scaleX/2))
        {
            if (y > (cY - scaleY) && y < (cY + scaleY))
            {
                x = 100;
                y = -1;
            }
        }
    }

    public void drawSword()
    {
        StdDraw.picture(x, y, image, scaleX, scaleY);
    }

    public double SwordX()
    {
        return x;
    }

    public double SwordY()
    {
        return y;
    }

    public double ScalerX()
    {
        return scaleX;
    }

    public double ScalerY()
    {
        return scaleY;
    }
    
    public void ChangeScaleX(double xToChange)
    {
        scaleX = xToChange;
    }
}
