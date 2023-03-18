package edu.odu.cs.cs350.pne;

import java.time.LocalDate;
import java.util.ArrayList;

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

    public void addSnapShotDate(LocalDate date) {
        snapShotDate.add(date);
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
        }
        buf.append("]");
        return buf.toString();
    }

}
