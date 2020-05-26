/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsoccerscout;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oOo
 */
public class MatchPlayerTest {
    
    public MatchPlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getID method, of class MatchPlayer.
     */

    public void testGetIDlargerthan9() throws SQLException {
        System.out.println("getID");
        String a = "1.";
        MatchPlayer instance = new MatchPlayer();
        for(int i = 1;i<=99;i++)
        {
        String b = String.valueOf(i) + ".";
        assertEquals(instance.getID(b),11);
        }
        //This is fairly input dependant as most of the input are fixed by the AddingPlayer part,so can only check 0. and such if they work perfectly
        // TODO review the generated test code and remove the default call to fail.
    }
    public void testID1() throws SQLException{
        String a = "a.";
        MatchPlayer instance = new MatchPlayer();
        String b = a + ".";
            assertEquals(instance.getID(b),"a");
            System.out.println(instance.getID(b));
        }
    @Test
    public void testgetList() throws SQLException{
        MatchPlayer instance = new MatchPlayer();
        int exp = 14;
        instance.getList();
        assertTrue(instance.PlayerList.size()>14);
    }

    /**
     * Test of main method, of class MatchPlayer.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MatchPlayer.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
