/** 
 * Test the FRQ 
 * 
 * @author K. Voldstad 
 * @version 2020 
 */
public class LockTester{    
    public static void main(String[] args)    
    {   CombinationLock lock = new CombinationLock("frog");
        System.out.println("Expected ++o+   Actual " + lock.getClue("oooo"));
        System.out.println("Expected f***   Actual " + lock.getClue("flip"));
        System.out.println("Expected f++*   Actual " + lock.getClue("form"));
        System.out.println("Expected fr*g   Actual " + lock.getClue("frag"));
        System.out.println("Expected frog   Actual " + lock.getClue("frog"));
    }
}