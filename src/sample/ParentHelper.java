package sample;

public class ParentHelper {

    private String SRUNumber,name, address, DOB, mobileNum, email, postcode;

    //Constructor
    public ParentHelper(){

    }

    public ParentHelper(String name,String SRUNumber,  String address, String DOB, String mobileNum, String email, String postcode) {

        this.name = name;
        this.SRUNumber = SRUNumber;
        this.address = address;
        this.DOB = DOB;
        this.mobileNum = mobileNum;
        this.email = email;
        this.postcode = postcode;
    }

    //Getters and setters

    public String getSRUNumber() {
        return SRUNumber;
    }

    public void setSRUNumber(String SRUNumber) {
        this.SRUNumber = SRUNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
