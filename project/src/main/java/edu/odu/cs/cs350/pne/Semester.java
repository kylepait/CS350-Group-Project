package edu.odu.cs.cs350.pne;

import java.util.List;
import java.util.ArrayList;

public class Semester {
    private List<Offering> offeringList;
    private List<String> CRSEList;
    private String semesterCode;

    public Semester(List<Offering> offeringList, List<String> CRSEList, String semesterCode) {
        this.offeringList = offeringList;
        this.CRSEList = CRSEList;
        this.semesterCode = semesterCode;
    }

    public Semester() {
        this.offeringList = new ArrayList<>();
        this.CRSEList = new ArrayList<>();
        this.semesterCode = "";
    }

    public List<Offering> getOfferingList() {
        return offeringList;
    }

    public void setOfferingList(List<Offering> offeringList) {
        this.offeringList = offeringList;
    }

    public List<String> getCRSEList() {
        return CRSEList;
    }

    public void setCRSEList(List<String> CRSEList) {
        this.CRSEList = CRSEList;
    }

    public String getSemesterCode() {
        return semesterCode;
    }

    public void SetSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
    }

    public void addOffering(Offering offering) {
        this.offeringList.add(offering);
    }

    public void addCRSE(String CRSE) {
        this.CRSEList.add(CRSE);
    }

    public Offering accessOffering(Integer i) {
        return this.offeringList.get(i);
    }

    // This is a tets

}
