package sample;

public class Player {
    private String name, SRUNumber,DOB,address,email,postcode,mobileNum,emergencyContact,emergencyContTel, doctor,doctorTel,healthIssue,playingPos,squadID;
    private Integer age;


    //Constructors
    public Player(){


    }

    public Player(String name, String SRUNumber, String DOB, String address, String email, String postcode, String mobileNum, String emergencyContact, String emergencyContTel, String doctor, String doctorTel, String healthIssue, String playingPos, Integer age,String squadID) {
        this.name = name;
        this.SRUNumber = SRUNumber;
        this.DOB = DOB;
        this.address = address;
        this.email = email;
        this.postcode = postcode;
        this.mobileNum = mobileNum;
        this.emergencyContact = emergencyContact;
        this.emergencyContTel = emergencyContTel;
        this.doctor = doctor;
        this.doctorTel = doctorTel;
        this.healthIssue = healthIssue;
        this.playingPos = playingPos;
        this.age = age;
        this.squadID= squadID;
    }

    //Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSRUNumber() {
        return SRUNumber;
    }

    public void setSRUNumber(String SRUNumber) {
        this.SRUNumber = SRUNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContTel() {
        return emergencyContTel;
    }

    public void setEmergencyContTel(String emergencyContTel) {
        this.emergencyContTel = emergencyContTel;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDoctorTel() {
        return doctorTel;
    }

    public void setDoctorTel(String doctorTel) {
        this.doctorTel = doctorTel;
    }

    public String getHealthIssue() {
        return healthIssue;
    }

    public void setHealthIssue(String healthIssue) {
        this.healthIssue = healthIssue;
    }

    public String getPlayingPos() {
        return playingPos;
    }

    public void setPlayingPos(String playingPos) {
        this.playingPos = playingPos;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSquadID() {
        return squadID;
    }

    public void setSquadID(String squadID) {
        this.squadID = squadID;
    }
}
