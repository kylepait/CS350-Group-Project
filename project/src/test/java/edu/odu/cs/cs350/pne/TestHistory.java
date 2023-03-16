package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestHistory {

    @Test
    public void testconstructor() {
        History h = new History();
        assertThat(h.getSemester(), is(null));
        assertThat(h.getSnapShotDate(), is(null));
    }

    /**
     * 
     */
    @Test
    public void testNewHistory() {
        ArrayList<LocalDate> date = new ArrayList<LocalDate>();
        ArrayList<Semester> sem = new ArrayList<Semester>();
        History h = new History();
        /// assertThat(h.getSnapShotDate(), is(null));
        // assertThat(h.getSemester(), is(null));
        h.setSnapShotDate(date);
        h.setSemester(sem);
        assertThat(h.getSemester(), is(sem));
        assertThat(h.getSnapShotDate(), is(date));
    }

    @Test
    public void testGetSemester() {
        ArrayList<Semester> sem = new ArrayList<Semester>();
        History h = new History();
        // assertThat(h.getSemester(), is(null));
        h.setSemester(sem);
        assertThat(h.getSemester(), is(sem));
    }

    /**
     * test the set semester function
     */
    @Test
    public void testSetSemester() {
        ArrayList<Semester> s = new ArrayList<Semester>();
        ArrayList<Semester> S2 = new ArrayList<Semester>();

        History h = new History();

        h.setSemester(s);
        assertThat(h.getSemester(), is(s));

        h.setSemester(S2);
        assertThat(h.getSemester(), is(S2));
    }

    /**
     * test the get snap shot date function under various orders
     * of instruction
     */
    @Test
    public void testGetSnapShotDate() {
        ArrayList<LocalDate> date = new ArrayList<LocalDate>();
        ArrayList<Semester> s = new ArrayList<Semester>();

        // setting the semester first
        History h = new History();
        // assertThat(h.getSnapShotDate(), is(null));

        h.setSemester(s);
        // assertThat(h.getSnapShotDate(), is(null));

        h.setSnapShotDate(date);
        assertThat(h.getSnapShotDate(), is(date));
        assertThat(h.getSemester(), is(s));

        // setting the snapshot first
        History h2 = new History();
        // assertThat(h2.getSnapShotDate(), is(null));
        // assertThat(h2.getSemester(), is(null));

        h.setSnapShotDate(date);
        assertThat(h2.getSnapShotDate(), is(date));
        assertThat(h2.getSemester(), is(null));
    }

    /**
     * test the set snap shot date function
     */
    @Test
    public void testSetSnapShotDate() {
        ArrayList<LocalDate> date = new ArrayList<LocalDate>();
        ArrayList<Semester> sem = new ArrayList<Semester>();

        History h = new History();

        // assertThat(h.getSnapShotDate(), is(null));

        h.setSnapShotDate(date);
        assertThat(h.getSnapShotDate(), is(date));
        // assertThat(h.getSemester(), is(null));

        h.setSemester(sem);
        assertThat(h.getSnapShotDate(), is(date));
        assertThat(h.getSemester(), is(sem));

        ArrayList<LocalDate> d2 = new ArrayList<LocalDate>();

        h.setSnapShotDate(d2);
        assertThat(h.getSnapShotDate(), is(d2));
        assertThat(h.getSemester(), is(sem));
    }

    /**
     * test the creation of a History when passed
     * with parameters
     */
    @Test
    public void testHistoryParamed() {
        // yes, i know Paramed is not a word. it is 1 AM and
        // i forget the name when constructed with parameters

        ArrayList<LocalDate> date = new ArrayList<LocalDate>();
        ArrayList<Semester> sem = new ArrayList<Semester>();

        History h = new History(date, sem);
        History h2 = new History();

        assertThat(h.getSemester(), is(sem));
        assertThat(h.getSnapShotDate(), is(date));

        assertNull(h2.getSemester());
        assertNull(h2.getSnapShotDate());

        assertNotEquals(h.getSemester(), h2.getSemester());
        assertNotEquals(h.getSnapShotDate(), h2.getSnapShotDate());

    }
}
