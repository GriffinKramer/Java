public class PowerUp
{
    private double x;
    private double y;
    private boolean hasPowerUp = false;
    
    public PowerUp()
    {
        x = Math.random();
        y = Math.random();
    }

    public void drawPowerUp()
    {
        StdDraw.picture(x, y, "PowerUp.png", 0.15, 0.1);
    }
    
    public void grab(double playerX,double playerY)
    {
        if (playerX > (x - 0.05) && playerX < (x + 0.05))
        {
            if (playerY > (y - 0.05) && playerY < (y + 0.05))
            {
                hasPowerUp = true;
            }
        }
    }
    
    public double effect1()
    {
        if (hasPowerUp == true)
        {
            return 0.5;
        }
        else 
        {
            return 0.1;
        }
    }

    public boolean grabber()
    {
        return hasPowerUp;
    }
}
