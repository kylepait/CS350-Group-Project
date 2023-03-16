
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
            assertEquals(0, section.crn);
            assertEquals(0, section.seatsRemaining);
            assertEquals(0, section.crossListCap);
            assertEquals(0, section.enrollments);
            
            assertEquals("", section.instructor);
            assertEquals("", section.link);

        }

        //test2
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

        //test3
        @Test
        public void testGetCRN(){
            Section section = new Section();
            section.crn = 202020;

            assertEquals(202020, section.getCRN());
        }

        //test4
        @Test
        public void testSetCRN(){
            Section section = new Section();

            section.setCRN(123456);
            assertEquals(123456, section.getCRN());
        }
}
