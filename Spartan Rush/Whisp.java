public class Whisp
{
    private int health = 100;
    private double x;
    private double y;
    private int whispVar = 0;
    private String[] whispVarArray = {"whispRightUp.png", "whispRightDown.png", "whispLeftUp.png", "whispLeftDown.png"};
    private boolean alive = true;
    private int ctrR = ((int)(Math.random() + 1))*30;
    private int ctrL = ((int)(Math.random() + 1))*30;;
    private boolean isRight = true;
    
    public Whisp()
    {
        x = 1.1;
        y = 1.1;
    }
    
    public Whisp(double xx, double yy)
    {
        x = xx;
        y = yy;
    }

    public void move(double playerX, double playerY)
    {
        if (playerX >= x)
        {
            isRight = true;
            x += 0.0025;
            switchImage();
        }
        if (playerX < x)
        {
            isRight = false;
            x -= 0.0025;
            switchImage();
        }
        if (playerY > y)
            y += 0.0025;
        if (playerY < y)
            y -= 0.0025;
    }

    public void switchImage()
    {
        
        if (isRight == true)
        {
            if (whispVar == (1))
            {
                ctrR++;
                if (ctrR >= 30)
                {
                    whispVar = 0;
                }
            }
            else if (whispVar == 0)
            {
                ctrR--;
                if (ctrR <= 0)
                {
                    whispVar = 1;
                }
            }
            else
            {
                whispVar = 1;
            }
        }
        else
        {
            if (whispVar == 3)
            {
                ctrL++;
                if (ctrL >= 30)
                {
                    whispVar = 2;
                }
            }
            else if (whispVar == 2)
            {
                ctrL--;
                if (ctrL <= 0)
                {
                    whispVar = 3;
                }
            }
            else
            {
                whispVar = 3;
            }
        }
        
    }
    
    public void drawWhisp()
    {
        if (x <= 1 && x >= 0 && y <= 1 && y >= 0)
            StdDraw.picture(x, y, whispVarArray[whispVar], 0.3, 0.2);
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
    
    public double WhispX()
    {
        return x;
    }
    
    public double WhispY()
    {
        return y;
    }
}
