package edu.odu.cs.cs350.pne;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
        section.add(new Section(34615, 4, 50, 46, "C1", "Kennedy", "R1"));
        section.add(new Section(38216, 6, 32, 26, "C1", "Polawar", "R2"));
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
        section.add(new Section(25143, 2, 40, 38, "C1", "Kennedy", "R2"));
        Offering offering = new Offering();
        offering.setSection(section);

        assertEquals(section, offering.getSection());

        section.add(new Section(31974, 9, 50, 41, "C1", "Polawar", "R1"));
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

    @Test
    public void testAddSection() {
        Offering offering = new Offering();
        Section section = new Section(25143, 2, 40, 38, "C1", "Kennedy", "R2");
        offering.addSection(section);

        assertTrue(offering.getSection().contains(section));

        Section section1 = new Section(23465, 8, 50, 42, "C1", "Polawar", "R1");
        offering.addSection(section1);

        assertTrue(offering.getSection().contains(section1));
    }

    @Test
    public void testAccessSection() {
        Offering offering = new Offering();
        Section section = new Section(34119, 1, 30, 29, "C1", "Kennedy", "R2");
        Section section1 = new Section(23465, 8, 50, 42, "C1", "Polawar", "R1");
        offering.addSection(section);
        offering.addSection(section1);

        assertThat(offering.accessSection(0), is(section));
        assertThat(offering.accessSection(1), is(section1));
    }
}
