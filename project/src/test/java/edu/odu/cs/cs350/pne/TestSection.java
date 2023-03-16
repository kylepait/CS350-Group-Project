
package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class TestSection {
    
        //test1
        @Test
        public void testEmptyConstructor(){
            Section section = new Section();
        }

        @Test
        public void testNonEmptyConstructor(){
            Section section = new Section(22222, 2, 2, 3, "Kyle", "maybe");
            assertEquals(22222, section.crn);
            assertEquals(2, section.seatsRemaining);
            assertEquals(2, section.crossListCap);
            assertEquals(3, section.enrollments);
            
            assertEquals("Kyle", section.instructor);
            assertEquals("maybe", section.link);
        }
}
