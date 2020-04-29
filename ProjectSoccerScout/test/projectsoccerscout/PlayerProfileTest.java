package projectsoccerscout;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Breakk
 */
public class PlayerProfileTest {
    
    public PlayerProfileTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of age method, of class PlayerProfile.
     */
    @Test
    public void testAge() {
        System.out.println("age");
        String d = "";
        PlayerProfile instance = null;
        int expResult = 0;
        int result = instance.age(d);
        assertEquals(expResult, result);
    }

    /**
     * Test of main method, of class PlayerProfile.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PlayerProfile.main(args);
    }
    
}
