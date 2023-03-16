package edu.odu.cs.cs350.pne;

import java.time.LocalDate;
import java.util.ArrayList;

//import java.util.
/*
* A history containing a list of semesters and snapshot dates
*
* @author aaron 
*/
public class History {
    private ArrayList<LocalDate> snapShotDate;
    private ArrayList<Semester> semester;

    public History() {
        snapShotDate = new ArrayList<LocalDate>();
        semester = new ArrayList<Semester>();
    }

    public History(ArrayList<LocalDate> snapShotDate, ArrayList<Semester> semester) {
        this.snapShotDate = snapShotDate;
        this.semester = semester;
    }

    public void setSnapShotDate(ArrayList<LocalDate> date) {
        this.snapShotDate = date;
    }

    public ArrayList<LocalDate> getSnapShotDate() {
        return snapShotDate;
    }

    public void setSemester(ArrayList<Semester> sem) {
        this.semester = sem;
    }

    public ArrayList<Semester> getSemester() {
        return semester;
    }

}
