package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestHistory {

    /**
     * 
     */
    @Test
    public void testNewHistory() {
        ArrayList<LocalDate> date = new ArrayList<LocalDate>();
        ArrayList<Semester> sem = new ArrayList<Semester>();
        History h = new History();

        h.setSnapShotDate(date);
        h.setSemester(sem);
        assertThat(h.getSemester(), is(sem));
        assertThat(h.getSnapShotDate(), is(date));
    }

    @Test
    public void testGetSemester() {
        ArrayList<Semester> sem = new ArrayList<Semester>();
        History h = new History();

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

        h.setSemester(s);

        h.setSnapShotDate(date);
        assertThat(h.getSnapShotDate(), is(date));
        assertThat(h.getSemester(), is(s));

        // setting the snapshot first
        History h2 = new History();

        h.setSnapShotDate(date);
        assertThat(h2.getSnapShotDate(), is(date));

    }

    /**
     * test the set snap shot date function
     */
    @Test
    public void testSetSnapShotDate() {
        ArrayList<LocalDate> date = new ArrayList<LocalDate>();
        ArrayList<Semester> sem = new ArrayList<Semester>();

        History h = new History();

        h.setSnapShotDate(date);
        assertThat(h.getSnapShotDate(), is(date));

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

        assertThat(h.getSemester(), is(sem));
        assertThat(h.getSnapShotDate(), is(date));

    }

    @Test
    public void testaddSnapShotDate() {
        LocalDate l = LocalDate.of(2023, 3, 17);
        LocalDate l2 = LocalDate.of(2021, 2, 15);
        History h = new History();

        h.addSnapShotDate(l);
        assertThat(h.getSnapShotDate().toString(), is(h.snapShotToString(h.getSnapShotDate())));

        h.addSnapShotDate(l2);
        assertThat(h.getSnapShotDate().toString(), is(h.snapShotToString(h.getSnapShotDate())));

        assertThat(h.getSnapShotDate().get(0), is(l));
        assertThat(h.getSnapShotDate().get(1), is(l2));

    }

    /**
     * 
     */
    @Test
    public void testAddSemester() {
        History h = new History();
        Semester s = new Semester();
        h.addSemester(s);
        assertThat(h.getSemester().toString(), is(h.SemesterToString(h.getSemester())));

        Semester s2 = new Semester();
        h.addSemester(s2);

        // assertThat(h.getSemester().toString(),
        // is(h.SemesterToString(h.getSemester())));
        assertThat(h.getSemester().get(0), is(s));
        assertThat(h.getSemester().get(1), is(s2));

    }

    @Test
    public void testGetSemesterByIndex() {
        History h = new History();
        Semester s = new Semester();
        Semester s2 = new Semester();

        h.addSemester(s);
        h.addSemester(s2);

        assertThat(h.getSemesterByIndex(0), is(s));
        assertThat(h.getSemesterByIndex(1), is(s2));

    }

    @Test
    public void testGetSnapShotDateByIndex() {
        History h = new History();
        LocalDate date = LocalDate.of(2023, 3, 17);
        LocalDate d2 = LocalDate.of(2020, 12, 27);

        h.addSnapShotDate(date);
        h.addSnapShotDate(d2);

        assertThat(h.getSnapShotByIndex(0), is(date));
        assertThat(h.getSnapShotByIndex(1), is(d2));

    }
}
