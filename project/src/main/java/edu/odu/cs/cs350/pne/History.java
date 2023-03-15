package edu.odu.cs.cs350.pne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.List;

/*
* A history containing a list of semesters and snapshot dates
*
* @author aaron 
*/
public class History {
    private List<LocalDate> snapShotDate;
    private List<Semester> semester;

    // constructor
    public History() {
        snapShotDate = new List<LocalDate>();
        semester = new List<Semester>();
    }

    /*
     * Create a new History
     * 
     * @param snapShotDate: the date to be created for
     * 
     * @param semester: the semester to be created for
     */
    public History(List<LocalDate> snapShotDate, List<Semester> semester) {
        this.snapShotDate = snapShotDate;
        this.semester = semester;
    }

}
