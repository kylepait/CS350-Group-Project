package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestOffering {
    @Test
    public void testConstructor() {
        Offering offering = new Offering();
        offering.setSection(null);
        offering.setCRSE("");
        offering.setSUBJ("");

        //assertEquals(null, offering.getSection());
        assertEquals("", offering.getCRSE());
        assertEquals("", offering.getSUBJ());
    }

    @Test
    public void testDestructor() {
        Section section = new Section(34185, 10, 50, 40, "Polawar", "R2");
        Offering offering = new Offering(section, "350", "CS");
        offering.setSection(section);
        offering.setCRSE("350");
        offering.setSUBJ("CS");

        //assertEquals(section, offering.getSection());
        assertEquals("350", offering.getCRSE());
        assertEquals("CS", offering.getSUBJ());
    }

    /*@Test
    public void testSetSection() {
        Section section = new Section(34187, 3, 34, 64, "Teach", "linked");
        Offering offering = new Offering();
        offering.setSection(section);

        assertEquals(section, offering.getSection());
    }

    @Test
    public void testGetSection() {
        //Section section = new Section();
        Offering offering = new Offering();
        offering.section = new Section();
    }*/

    @Test
    public void testSetCRSE() {
        Offering offering = new Offering();
        offering.CRSE = "350";

        assertEquals("350", offering.getCRSE());
    }

    @Test
    public void testGetCRSE() {
        Offering offering = new Offering();
        offering.setCRSE("361");

        assertEquals("361", offering.getCRSE());
    }

    @Test
    public void testSetSUBJ() {
        Offering offering = new Offering();
        offering.SUBJ = "CS";

        assertEquals("CS", offering.getSUBJ());
    }

    @Test
    public void testGetSUBJ() {
        Offering offering = new Offering();
        offering.setSUBJ("MTH");

        assertEquals("MTH", offering.getSUBJ());
    }
}
