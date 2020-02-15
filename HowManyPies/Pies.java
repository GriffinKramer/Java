public class Pies
{
    private int pumpkin;
    private int apples;
    private int eggs;
    private int milk;
    private int sugar;
    private int Fpumpkin;
    private int Fapples;
    private int Feggs;
    private int Fmilk;
    private int Fsugar;
    private int pPies = 0;
    private int aPies = 0;
    public Pies(int a, int b, int c, int d, int e)
    {
        pumpkin = a;
        apples = b;
        eggs = c;
        milk = d;
        sugar = e;
        Fpumpkin = pumpkin;
        Fapples = apples;
        Feggs = eggs;
        Fmilk = milk;
        Fsugar = sugar;
    }

    /*recepies
    Pumpkin Pie:
    1 pumpkin, 3 eggs, 4 milk, 3 sugar
    Apple Pie:
    1 apple  , 4 eggs, 3 milk, 2 sugar
     */
    public void createPumpkin()
    {
        if (canPumkin())
        {
            pumpkin--;
            eggs = eggs - 3;
            milk = milk - 4;
            sugar = sugar - 3;
            pPies++;
        }
    }

    public void createApple()
    {
        if (canApple())
        {
            apples--;
            eggs = eggs - 4;
            milk = milk - 3;
            sugar = sugar - 2;
            aPies++;
        }
    }

    public boolean canPumkin()
    {
        if (pumpkin >= 1 && eggs >= 3 && milk >= 4 && sugar >= 3)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    public boolean canApple()
    {
        if (apples >= 1 && eggs >= 4 && milk >= 3 && sugar >= 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int pump()
    {
        return pPies;
    }

    public int apps()
    {
        return aPies;
    }

    public void backToNormal()
    {
        pumpkin = Fpumpkin;
        apples = Fapples;
        eggs = Feggs;
        milk = Fmilk;
        sugar = Fsugar;
        pPies = 0;
        aPies = 0;
    }
}
