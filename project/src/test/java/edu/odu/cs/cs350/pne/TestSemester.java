
package edu.odu.cs.cs350.pne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.List;
import java.util.ArrayList;




public class TestSemester 
{
    @Test
    public void testGetOfferingList()
    {
        List<Offering> offeringList = new ArrayList<>();
        offeringList.add(new Offering(new ArrayList<>(), "CS101", "COMPSCI", 0, 0, 0));

        Semester semester = new Semester(offeringList, new ArrayList<>(), "SP21");

        assertEquals(offeringList, semester.getOfferingList());
    }

    @Test
    public void testSetOfferingList()
    {
        List<Offering> offeringList1 = new ArrayList<>();
        offeringList1.add(new Offering(new ArrayList<>(), "CS101", "COMPSCI", 0, 0, 0));

        Semester semester = new Semester(offeringList1, new ArrayList<>(), "SP21");

        List<Offering> offeringList2 = new ArrayList<>();
        offeringList2.add(new Offering(new ArrayList<>(), "CS102", "COMPSCI", 0, 0, 0));

        semester.setOfferingList(offeringList2);

        assertEquals(offeringList2, semester.getOfferingList());
    }

    @Test
    public void testGetCRSEList()
    {
        List<String> CRSEList = new ArrayList<>();
        CRSEList.add("CS101");

        Semester semester = new Semester(new ArrayList<>(), CRSEList, "SP21");

        assertEquals(CRSEList, semester.getCRSEList());
    }

    @Test
    public void testSetCRSEList()
    {
        List<String> CRSEList1 = new ArrayList<>();
        CRSEList1.add("CS101");

        Semester semester = new Semester(new ArrayList<>(), CRSEList1, "SP21");

        List<String> CRSEList2 = new ArrayList<>();
        CRSEList2.add("CS102");

        semester.setCRSEList(CRSEList2);

        assertEquals(CRSEList2, semester.getCRSEList());
    }

    @Test
    public void testGetSemesterCode()
    {
        String semesterCode = "SP21";

        Semester semester = new Semester(new ArrayList<>(), new ArrayList<>(), semesterCode);

        assertEquals(semesterCode, semester.getSemesterCode());
    }

    @Test
    public void testSetSemesterCode()
    {
        String semesterCode1 = "SP21";

        Semester semester = new Semester(new ArrayList<>(), new ArrayList<>(), semesterCode1);

        String semesterCode2 = "FA21";

        semester.SetSemesterCode(semesterCode2);

        assertEquals(semesterCode2, semester.getSemesterCode());
    }
}
