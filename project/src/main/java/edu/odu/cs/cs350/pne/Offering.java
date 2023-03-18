package edu.odu.cs.cs350.pne;

import java.util.List;
import java.util.ArrayList;

public class Offering {
    private List<Section> section;
    private String CRSE;
    private String SUBJ;
    private int enrollment;
    private int maxEnrollment;
    private int currentEnrollment;

    public Offering() {
        this.section = new ArrayList<Section>();
        this.CRSE = "";
        this.SUBJ = "";
        this.enrollment = 0;
        this.maxEnrollment = 0;
        this.currentEnrollment = 0;
    }

    public Offering(List<Section> section, String CRSE, String SUBJ, int enrollment, int maxEnrollment, int currentEnrollment) {
        this.section = section;
        this.CRSE = CRSE;
        this.SUBJ = SUBJ;
        this.enrollment = enrollment;
        this.maxEnrollment = maxEnrollment;
        this.currentEnrollment = currentEnrollment;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    public List<Section> getSection() {
        return section;
    }

    public void setCRSE(String CRSE) {
        this.CRSE = CRSE;
    }

    public String getCRSE() {
        return CRSE;
    }

    public void setSUBJ(String SUBJ) {
        this.SUBJ = SUBJ;
    }

    public String getSUBJ() {
        return SUBJ;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setCurrentEnrollment(int currentEnrollment) {
        this.currentEnrollment = currentEnrollment;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public void addSection(Section section2) {
        this.section.add(section2);
    }

    public Section accessSection(Integer i) {
        return this.section.get(i);
    }
}
