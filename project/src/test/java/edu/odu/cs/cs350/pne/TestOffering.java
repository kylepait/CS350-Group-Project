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

        assertThat(null, equalTo(offering.getSection()));
        assertThat("", equalTo(offering.getCRSE()));
        assertThat("", equalTo(offering.getSUBJ()));
    }

    @Test
    public void testDestructor() {
        Offering offering = new Offering("350", "CS");
        Section section = new Section(34185, 10, 50, 40, "Polawar", "R2");
        offering.setSection(section);
        offering.setCRSE("350");
        offering.setSUBJ("CS");

        assertEquals(section, offering.getSection());
        assertEquals("350", offering.getCRSE());
        assertEquals("CS", offering.getSUBJ());
    }
}
