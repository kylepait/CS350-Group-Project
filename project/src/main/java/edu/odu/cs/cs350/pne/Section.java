package edu.odu.cs.cs350.pne;

public class Section {

    int crn;
    int seatsRemaining;
    int crossListCap;
    int enrollments;
    String instructor;
    String link;

    public Section(){
        crn = 0;
        seatsRemaining = 0;
        crossListCap = 0;
        enrollments = 0;
        instructor = "";
        link = "";
    }

    public Section(int crnAdd, int seatsRemainingAdd, int crossListCapAdd, int enrollmentAdd, String instructorAdd, String linkAdd){
        this.crn = crnAdd;
        this.seatsRemaining = seatsRemainingAdd;
        this.crossListCap = crossListCapAdd;
        this.enrollments = enrollmentAdd;
        this.instructor = instructorAdd;
        this.link = linkAdd;

    }
    
    public int getCRN(){
        return this.crn;
    }

    public void setCRN(int crnSet){
        this.crn = crnSet;
    }

    public int getSeatsRemaining(){
        return this.seatsRemaining;
    }

    public void setSeatsRemaining(int seatsRemainingSet){
        this.seatsRemaining = seatsRemainingSet;
    }

    public int getCrossListCap(){
        return this.crossListCap;
    }

    public void setCrossListCap(int crossListCapSet){
        this.crossListCap = crossListCapSet;
    }

    public int getEnrollments(){
        return this.enrollments;
    }

    public void setEnrollments(int enrollmentsSet){
        this.enrollments = enrollmentsSet;
    }

    public String getInstructor(){
        return this.instructor;
    }

    public void setInstructor(String instructorSet){
        this.instructor = instructorSet;
    }

    public String getLink(){
        return this.link;
    }
}
