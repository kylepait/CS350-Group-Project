package edu.odu.cs.cs350.pne;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

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
        Offering offering = new Offering(section, "350", "CS", 5, 20, 15);
        offering.setSection(section);
        offering.setCRSE("350");
        offering.setSUBJ("CS");
        offering.setEnrollment(5);
        offering.setMaxEnrollment(20);
        offering.setCurrentEnrollment(15);

        assertEquals(section, offering.getSection());
        assertEquals("350", offering.getCRSE());
        assertEquals("CS", offering.getSUBJ());
        assertEquals(5, offering.getEnrollment());
        assertEquals(20, offering.getMaxEnrollment());
        assertEquals(15, offering.getCurrentEnrollment());
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

    @Test
    public void testSetMaxEnrollment() {
        Offering offering = new Offering();
        offering.setMaxEnrollment(30);

        assertEquals(30, offering.getMaxEnrollment());
    }

    @Test
    public void testGetMaxEnrollment() {
        Offering offering = new Offering();
        offering.maxEnrollment = 40;

        assertEquals(40, offering.getMaxEnrollment());
    }

    @Test
    public void testSetCurrentEnrollment() {
        Offering offering = new Offering();
        offering.setCurrentEnrollment(32);

        assertEquals(32, offering.getCurrentEnrollment());
    }

    @Test
    public void testGetCurrentEnrollment() {
        Offering offering = new Offering();
        offering.currentEnrollment = 45;

        assertEquals(45, offering.getCurrentEnrollment());
    }
}
