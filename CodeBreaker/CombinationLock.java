public class CombinationLock
{
    private String code; 
    public CombinationLock(String code)
    {
        this.code = code;
    }

    public String getClue(String guess)
    {
        String[] codeA = new String [4];
        String[] guessA = new String [4];
        String giveClue = "";
        code += " ";
        guess += " ";

        for (int i = 0; i < 4; i++)  
        {
            codeA[i] = code.substring(i, i+1);
            guessA[i] = guess.substring(i, i+1);
            if (codeA[i].equals(guessA[i]))
            {
                giveClue += guessA[i];
            }
            else if (code.indexOf(guessA[i]) >= 0)
            {
                giveClue += "+";
            }
            else
            {
                giveClue += "*";
            }
        }
        return giveClue;
    }
}
