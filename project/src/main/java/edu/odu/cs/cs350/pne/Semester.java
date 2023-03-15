import java.util.List;

public class Semester 
{
    private List<Offerings> offeringList;
    private List<String> CRSEList;
    private String semesterCode;

    public Semester(List<Offering> offeringList, List<String> CRSEList, String semesterCode)
    {
        this.offeringList = offeringList;
        this.CRSEList = CRSEList;
        this.semesterCode = semesterCode;
    }

    public List<Offering> getOfferingList()
    {
        return offeringList
    }

    public void setOfferingList(List<Offering> offeringList)
    {
        this.offeringList = offeringList;
    }

    public List<String> getCRSEList()
    {
        return CRSEList;
    }

    public void setCRSEList(List<String> CRSEList)
    {
        this.CRSEList = CRSEList;
    }

    public String getSemesterCode()
    {
        return semesterCode;
    }

    public void SetSemesterCode(String semesterCode)
    {
        this.semesterCode = semesterCode;
    }
}
