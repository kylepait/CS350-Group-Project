package edu.odu.cs.cs350.pne;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class History {
    private ArrayList<LocalDate> snapShotDate;
    private ArrayList<Semester> semester;

    private LocalDate startDate;
    private LocalDate endDate;

    public History() {
        this.snapShotDate = new ArrayList<LocalDate>();
        this.semester = new ArrayList<Semester>();
    }

    public History(ArrayList<LocalDate> snapShotDate, ArrayList<Semester> semester,
            LocalDate startDate, LocalDate endDate) {
        this.snapShotDate = snapShotDate;
        this.semester = semester;
        this.startDate = startDate;
        this.endDate = endDate;
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

    /**
     * @param date
     *             date is the LocalDate to be added to the arrayList
     */
    public void addSnapShotDate(LocalDate date) {
        this.snapShotDate.add(date);
    }

    /**
     * @param sem
     *            sem is the semester to be added to the arraylist
     */
    public void addSemester(Semester sem) {
        this.semester.add(sem);
    }

    /**
     * @param snapshot
     * @return string of snapshot
     *         converts a snapshot array list into one string
     *         mostly for unit testing
     */
    public String snapShotToString(ArrayList<LocalDate> snapshot) {
        StringBuffer buf = new StringBuffer();
        buf.append("[");
        Integer j = snapshot.size();
        for (Integer i = 0; i < j; i++) {
            buf.append(snapshot.get(i).toString());
            if (i != j - 1)
                buf.append(", ");
        }
        buf.append("]");
        return buf.toString();
    }

    /**
     * @param sem
     * @return string of snapshot
     *         converts a semester array list into one string
     *         mostly for unit testing
     */
    public String SemesterToString(ArrayList<Semester> sem) {
        StringBuffer buf = new StringBuffer();
        buf.append("[");
        Integer j = sem.size();
        for (Integer i = 0; i < j; i++) {
            buf.append(sem.get(i).toString());
            if (i != j - 1)
                buf.append(", ");
        }
        buf.append("]");
        return buf.toString();
    }

    /**
     * @param index
     * @return the snapShotDate at Index index in ArrayList snapShotDate
     */
    public LocalDate getSnapShotByIndex(Integer index) {
        return this.getSnapShotDate().get(index);
    }

    /**
     * @param index
     * @return the Semester at Index index in ArrayList semester
     */
    public Semester getSemesterByIndex(Integer index) {
        return this.getSemester().get(index);
    }

    /**
     * @return start date of a provided semester
     */
    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate StartDate) {
        this.startDate = StartDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate EndDate) {
        this.endDate = EndDate;
    }
}
