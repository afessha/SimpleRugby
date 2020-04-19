package sample;
import java.io.IOException;

public class Coach {
    private String SRUNumber,name, address, DOB, mobileNum, email, postcode,password,squadName;

    public Coach(){


    }
    public Coach( String name, String SRUNumber, String DOB, String address,  String mobileNum, String email, String postcode,String password, String squadName) throws IOException {
        this.name = name;
        this.SRUNumber = SRUNumber;
        this.address = address;
        this.DOB = DOB;
        this.mobileNum = mobileNum;
        this.email = email;
        this.postcode = postcode;
        this.password=password;
        this.squadName= squadName;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }
}
