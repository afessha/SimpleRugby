package sample;

public class TrainingRecord {

    private String coachOrganizing,date,location,time,skilliesAndActivitiesUnderT,playerPresent,injuries;

    //Constructor
    public TrainingRecord(){

    }

    public TrainingRecord(String coachOrganizing, String date, String location, String time, String skilliesAndActivitiesUnderT, String playerPresent, String injuries) {
        this.coachOrganizing = coachOrganizing;
        this.date = date;
        this.location = location;
        this.time = time;
        this.skilliesAndActivitiesUnderT = skilliesAndActivitiesUnderT;
        this.playerPresent = playerPresent;
        this.injuries = injuries;
    }

    //Getters and setters

    public String getCoachOrganizing() {
        return coachOrganizing;
    }

    public void setCoachOrganizing(String coachOrganizing) {
        this.coachOrganizing = coachOrganizing;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSkilliesAndActivitiesUnderT() {
        return skilliesAndActivitiesUnderT;
    }

    public void setSkilliesAndActivitiesUnderT(String skilliesAndActivitiesUnderT) {
        this.skilliesAndActivitiesUnderT = skilliesAndActivitiesUnderT;
    }

    public String getPlayerPresent() {
        return playerPresent;
    }

    public void setPlayerPresent(String playerPresent) {
        this.playerPresent = playerPresent;
    }

    public String getInjuries() {
        return injuries;
    }

    public void setInjuries(String injuries) {
        this.injuries = injuries;
    }
}
