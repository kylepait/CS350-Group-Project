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
        this.section = new ArrayList<>();
        this.CRSE = "";
        this.SUBJ = "";
        this.enrollment = 0;
        this.maxEnrollment = 0;
        this.currentEnrollment = 0;
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
