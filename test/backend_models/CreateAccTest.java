/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CreateAccTest {
    CreateAcc C;
    private final String username= Tasnim";
    private final String pass = "11709069";
    private final boolean checkacc = false;
    //private final String gender= "male";
    
    public CreateAccTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        C = new CreateAcc();
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testcheckAcc() throws IOException {
         assertEquals(C.checkAcc( username, pass),checkacc);
     }
}
