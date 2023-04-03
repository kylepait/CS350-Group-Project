
package edu.odu.cs.cs350.pne;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//import java.beans.Transient;

//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.*;



public class TestSection {
    
        //test1
        @Test
        public void testEmptyConstructor(){
            Section section = new Section();
            assertEquals(0, section.getCRN());
            assertEquals(0, section.getSeatsRemaining());
            assertEquals(0, section.getCrossListCap());
            assertEquals(0, section.getEnrollments());
            
            assertEquals("", section.getInstructor());
            assertEquals("", section.getLink());

        }

        //test2
        @Test
        public void testNonEmptyConstructor(){
            Section section = new Section(22222, 2, 2, 3, "XB", "Kyle", "maybe");
            assertEquals(22222, section.getCRN());
            assertEquals(2, section.getSeatsRemaining());
            assertEquals(2, section.getCrossListCap());
            assertEquals(3, section.getEnrollments());
            
            assertEquals("Kyle", section.getInstructor());
            assertEquals("maybe", section.getLink());
        }

        //test3
        @Test
        public void testGetCRN(){
            Section section = new Section();
            section.setCRN(202020);

            assertEquals(202020, section.getCRN());
        }

        //test4
        @Test
        public void testSetCRN(){
            Section section = new Section();

            section.setCRN(123456);
            assertEquals(123456, section.getCRN());
        }

        //test5
        @Test
        public void testGetSeatsRemaining(){
            Section section = new Section();
            section.setSeatsRemaining(12);

            assertEquals(12, section.getSeatsRemaining());
        }

        //test6
        @Test
        public void testSetSeatsRemaining(){
            Section section = new Section();
            section.setSeatsRemaining(15);

            assertEquals(15, section.getSeatsRemaining());
        }

        //test7
        @Test
        public void testGetCrossListCap(){
            Section section = new Section();
            section.setCrossListCap(5);

            assertEquals(5, section.getCrossListCap());
        }

        //test8
        @Test
        public void testSetCrossListCap(){
            Section section = new Section();
            section.setCrossListCap(18);

            assertEquals(18, section.getCrossListCap());
        }

        

        //test9
        @Test
        public void testGetEnrollments(){
            Section section = new Section();
            section.setEnrollments(10);

            assertEquals(10, section.getEnrollments());
        }

        //test10
        @Test
        public void testSetEnrollments(){
            Section section = new Section();
            section.setEnrollments(20);

            assertEquals(20, section.getEnrollments());
        }

        //test11
        @Test
        public void testGetInstructor(){
            Section section = new Section();
            section.setInstructor("Betty");

            assertEquals("Betty", section.getInstructor());
        }

        //test12
        @Test
        public void testSetInstructor(){
            Section section = new Section();
            section.setInstructor("Ricky");

            assertEquals("Ricky", section.getInstructor());
        }

        //test13
        @Test
        public void testGetLink(){
            Section section = new Section();
            section.setLink("a");

            assertEquals("a", section.getLink());
        }

        //test14
        @Test
        public void testSetLink(){
            Section section = new Section();
            section.setLink("b");

            assertEquals("b", section.getLink());
        }

        @Test
        public void testGetCrossListGroup(){
            Section section = new Section();
            section.setCrossListGroup("BA");
            
            assertEquals("BA", section.getCrossListGroup());
        }

        @Test
        public void testSetCrossLinkGroup(){
            Section section = new Section();
            section.setCrossListGroup("AB");

            assertEquals("AB", section.getCrossListGroup());
        }

        @Test
        public void easyPass(){
            assertEquals(1,1);
        }
}
