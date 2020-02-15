import java.util.ArrayList;
/**
 * Utility Class containg isPalindrome and nextPalindromeDays Methods  
 *
 * @author (Griffin)
 * @version (2/5/2020)
 */
public class PalCheck
{
    /**
     * a method that checks if the word is a palindrome
     *
     * @param  word is the word the method tests
     * @return returns true if the word is a palindrome
     */
    public static boolean isPalindrome(String word)
    {
        String modifiedWord = word + " ";
        String backWord = "";
        for (int i = word.length(); i > 0; i--)
        {
            backWord+=modifiedWord.substring(i - 1, i);
        }   
        if (word.equals(backWord))
        {
            return true;
        }
        return false;
    }

}
