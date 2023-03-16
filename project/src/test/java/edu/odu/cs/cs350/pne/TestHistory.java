package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestHistory {

    @test
    public void testconstructor() {
        History h = new History();
        assertThat(h.getSemester(), is(null));
        assertThat(h.getSnapShotDate(), is(null));
    }

    /**
     * 
     */
    @test
    public void testNewHistory() {
        ArrayList<LocalDate> date = new ArrayList<LocalDate>;
        Semester sem = new Semester(null, null, null);
        History h = new History();
        assertThat(h.getSnapShotDate(),is(null));
        assertThat(h.getSemester(),is(null));
        h.setSnapShotDate(date);
        h.set
        assertThat(h.getSemester(), is(null));
        assertThat(h.getSnapShotDate(), is(date));
    }

    @test
    public void testGetSemester() {
        Semester sem = new Semester();
        LocalDate date = LocalDateTime.of(2018, 6, 22, 3, 15);
        History h = new History(sem, date);
        assertThat(h.getSemester(), is(sem));
    }
}
