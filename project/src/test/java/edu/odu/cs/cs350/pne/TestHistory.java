package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestHistory {

    @test
    public void testconstructor() {
        History h = new History();
        assertThat(h.semester, is(null));
        assertThat(h.snapShotDate, is(null));
    }

    @test
    public void testNewHistory() {
        LocalDate date = LocalDateTime.now().toLocalDate();
        Semester sem = new Semester(null, null, null);
        History h = new History(date, sem);
        assertThat(h.semester, is(null));
        assertThat(h.snapShotDate, is(LocalDateTime.now().toLocalDate()));
    }

    @test
    public void testGetSemester() {
        Semester sem = new Semester();
        LocalDate date = LocalDateTime.of(2018, 6, 22, 3, 15);
        History h = new History(sem, date);
        assertThat(h.getSemester(), is(sem));
    }
}
