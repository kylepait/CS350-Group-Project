package edu.odu.cs.cs350.pne;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//import java.beans.Transient;

public class TestOffering {
    @Test
    public void testConstructor() {
        Offering offering = new Offering();

        assertNotNull(offering.getSection());
        assertTrue(offering.getSection().isEmpty());
        assertEquals("", offering.getCRSE());
        assertEquals("", offering.getSUBJ());
        assertEquals(0, offering.getEnrollment());
        assertEquals(0, offering.getMaxEnrollment());
        assertEquals(0, offering.getCurrentEnrollment());
    }

    @Test
    public void testDestructor() {
        List<Section> section = new ArrayList<>();
        section.add(new Section(34615, 4, 50, 46, "Kennedy", "R1"));
        section.add(new Section(38216, 6, 32, 26, "Polawar", "R2"));
        Offering offering = new Offering(section, "350", "CS", 5, 20, 15);
        
        assertEquals(section, offering.getSection());
        assertEquals("350", offering.getCRSE());
        assertEquals("CS", offering.getSUBJ());
        assertEquals(5, offering.getEnrollment());
        assertEquals(20, offering.getMaxEnrollment());
        assertEquals(15, offering.getCurrentEnrollment());
    }

    @Test
    public void testGetSetSection() {
        List<Section> section = new ArrayList<Section>();
        Offering offering = new Offering();
        offering.setSection(section);

        assertEquals(section, offering.getSection());
    }

    @Test
    public void testGetSetCRSE() {
        Offering offering = new Offering();
        offering.setCRSE("350");

        assertEquals("350", offering.getCRSE());

        Offering offering1 = new Offering();
        offering1.setCRSE("361");

        assertEquals("361", offering1.getCRSE());
    }

    @Test
    public void testGetSetSUBJ() {
        Offering offering = new Offering();
        offering.setSUBJ("CS");

        assertEquals("CS", offering.getSUBJ());

        Offering offering1 = new Offering();
        offering1.setSUBJ("MTH");

        assertEquals("MTH", offering1.getSUBJ());
    }

    @Test
    public void testGetSetEnrollment() {
        Offering offering = new Offering();
        offering.setEnrollment(5);

        assertEquals(5, offering.getEnrollment());

        Offering offering1 = new Offering();
        offering1.setEnrollment(10);

        assertEquals(10, offering1.getEnrollment());
    }

    @Test
    public void testGetSetMaxEnrollment() {
        Offering offering = new Offering();
        offering.setMaxEnrollment(30);

        assertEquals(30, offering.getMaxEnrollment());

        Offering offering1 = new Offering();
        offering1.setMaxEnrollment(60);

        assertEquals(60, offering1.getMaxEnrollment());
    }

    @Test
    public void testGetSetCurrentEnrollment() {
        Offering offering = new Offering();
        offering.setCurrentEnrollment(32);

        assertEquals(32, offering.getCurrentEnrollment());

        Offering offering1 = new Offering();
        offering1.setCurrentEnrollment(51);

        assertEquals(51, offering1.getCurrentEnrollment());
    }
}
