/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsoccerscout;

import javax.swing.JPanel;
import javax.swing.JTextField;
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
public class MatchReportTest {
    
    public MatchReportTest() {
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
     * Test of checkInt method, of class MatchReport.
     */
    @Test
    public void testCheckInt() {
        System.out.println("checkInt");
        JTextField A = null;
        MatchReport instance = new MatchReport();
        boolean expResult = false;
        boolean result = instance.checkInt(A);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCom method, of class MatchReport.
     */
    @Test
    public void testCheckCom() {
        System.out.println("checkCom");
        JTextField com = null;
        JTextField total = null;
        MatchReport instance = new MatchReport();
        boolean expResult = false;
        boolean result = instance.checkCom(com, total);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCard method, of class MatchReport.
     */
    @Test
    public void testCheckCard() {
        System.out.println("checkCard");
        MatchReport instance = new MatchReport();
        boolean expResult = false;
        boolean result = instance.checkCard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayer method, of class MatchReport.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        String A = "";
        MatchReport instance = new MatchReport();
        instance.getPlayer(A);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListPlayer method, of class MatchReport.
     */
    @Test
    public void testListPlayer() {
        System.out.println("ListPlayer");
        MatchReport instance = new MatchReport();
        instance.ListPlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addList method, of class MatchReport.
     */
    @Test
    public void testAddList() {
        System.out.println("addList");
        MatchReport instance = new MatchReport();
        boolean expResult = false;
        boolean result = instance.addList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getList method, of class MatchReport.
     */
    @Test
    public void testGetList() {
        System.out.println("getList");
        MatchReport instance = new MatchReport();
        instance.getList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPanelEnabled method, of class MatchReport.
     */
    @Test
    public void testSetPanelEnabled() {
        System.out.println("setPanelEnabled");
        JPanel panel = null;
        MatchReport instance = new MatchReport();
        instance.setPanelEnabled(panel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStat method, of class MatchReport.
     */
    @Test
    public void testUpdateStat() {
        System.out.println("updateStat");
        MatchReport instance = new MatchReport();
        instance.updateStat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printst method, of class MatchReport.
     */
    @Test
    public void testPrintst() {
        System.out.println("printst");
        MatchReport instance = new MatchReport();
        instance.printst();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updatePlayer method, of class MatchReport.
     */
    @Test
    public void testUpdatePlayer() {
        System.out.println("updatePlayer");
        MatchReport instance = new MatchReport();
        instance.updatePlayer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MatchReport.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MatchReport.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
