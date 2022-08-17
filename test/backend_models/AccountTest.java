/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class AccountTest {
    Account A;
    private final String username= tasnim";
    
    
    
    
    //@BeforeClass
    //public static void setUpClass() {
    //}
    
    //@AfterClass
    //public static void tearDownClass() {
    //}
    
    @Before
    public void setUp() throws Exception {
    
        A = new Account(username); 
        
    }
    
    //@After
    //public void tearDown() {
    //}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void testgetUsername() {
     assertEquals(A.getUsername(),username);
     
     
     }
     
     
     //@Test
     //public void testgetGender(){
     //assertEquals(A.getGender(),gender);
     //}
}
