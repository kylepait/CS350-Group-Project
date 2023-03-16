package edu.odu.cs.cs350.pne;

import java.util.List;
import java.util.ArrayList;

public class Offering {
    List<Section> section;
    String CRSE;
    String SUBJ;
    int enrollment;
    int maxEnrollment;
    int currentEnrollment;

    public Offering() {
        this.section = new ArrayList<>();
        this.CRSE = "";
        this.SUBJ = "";
        this.enrollment = 0;
        this.maxEnrollment = 0;
        this.currentEnrollment = 0;
    }

    public Offering(List<Section> section, String CRSE, String SUBJ) {
        this.section = new ArrayList<Section>();
        this.CRSE = CRSE;
        this.SUBJ = SUBJ;
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
}
