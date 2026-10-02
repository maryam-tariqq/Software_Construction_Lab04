/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
    	// Case 1: Self-written code → always allowed
        assertTrue("Expected true: self-written code",
                RulesOf6005.mayUseCodeInAssignment(true, false, false, false, true));
        
        // Case 2: Own coursework → allowed
        assertTrue("Expected true: own coursework",
                RulesOf6005.mayUseCodeInAssignment(false, false, true, false, true));
        
        // Case 3: External cited code when implementation not required → allowed
        assertTrue("Expected true: cited external code (not required)",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, false));
        
        // Case 4: External code without citation → not allowed
        assertFalse("Expected false: external code without citation",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, false, false));
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }
    /**
    * Code from a public source that is cited and not required
    * by the assignment may be used.
    */
    
    // TEST CASE 1
    @Test
    public void testPublicCitedCodeAllowed() {
    assertTrue("Expected true: cited public code that is not required",
    RulesOf6005.mayUseCodeInAssignment(false, true, false, true, false));
    }
    /**
    * Another student's 6.005 course work may never be used,
    * even if you cite it.
    */
    
    @Test
    //TEST CASE 2
    public void testCourseWorkFromOthersNotAllowed() {
    assertFalse("Expected false: someone else's 6.005 course work",
    RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }
    /**
    * Public cited code is not allowed when the assignment asks you
    * to implement that code yourself.
    */
    
    @Test
    // TEST CASE 3
    public void testImplementationRequiredNotAllowed() {
    assertFalse("Expected false: assignment requires your own implementation",
    RulesOf6005.mayUseCodeInAssignment(false, true, false, true, true));
    }
    
    
}
