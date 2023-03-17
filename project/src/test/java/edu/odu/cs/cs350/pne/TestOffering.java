package edu.odu.cs.cs350.pne;

import java.util.List;
import java.util.ArrayList;

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

        assertEquals(null, offering.getSection());
        assertEquals("", offering.getCRSE());
        assertEquals("", offering.getSUBJ());
    }

    @Test
    public void testDestructor() {
        List<Section> section = new ArrayList<Section>();
        Offering offering = new Offering(section, "350", "CS");
        offering.setSection(section);
        offering.setCRSE("350");
        offering.setSUBJ("CS");

        assertEquals(section, offering.getSection());
        assertEquals("350", offering.getCRSE());
        assertEquals("CS", offering.getSUBJ());
    }

    @Test
    public void testSetSection() {
        List<Section> section = new ArrayList<Section>();
        Offering offering = new Offering();
        offering.setSection(section);

        assertEquals(section, offering.getSection());
    }

    @Test
    public void testGetSection() {
        List<Section> section = new ArrayList<Section>();
        Offering offering = new Offering();
        offering.section = section;

        assertEquals(section, offering.getSection());
    }

    @Test
    public void testSetCRSE() {
        Offering offering = new Offering();
        offering.setCRSE("350");

        assertEquals("350", offering.getCRSE());
    }

    @Test
    public void testGetCRSE() {
        Offering offering = new Offering();
        offering.CRSE = "361";

        assertEquals("361", offering.getCRSE());
    }

    @Test
    public void testSetSUBJ() {
        Offering offering = new Offering();
        offering.setSUBJ("CS");

        assertEquals("CS", offering.getSUBJ());
    }

    @Test
    public void testGetSUBJ() {
        Offering offering = new Offering();
        offering.SUBJ = "MTH";

        assertEquals("MTH", offering.getSUBJ());
    }

    @Test
    public void testSetEnrollment() {
        Offering offering = new Offering();
        offering.setEnrollment(5);

        assertEquals(5, offering.getEnrollment());
    }

    @Test
    public void testGetEnrollment() {
        Offering offering = new Offering();
        offering.enrollment = 10;

        assertEquals(10, offering.getEnrollment());
    }
}
