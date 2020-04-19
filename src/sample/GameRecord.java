package sample;



public class GameRecord {

    private String oppositionName,date,location,KoTime,result,score,firstHalfScoreComments,secondHalfScoreComments;


    //Constructor
    public GameRecord() {
    }

    public GameRecord(String oppositionName, String date, String location, String koTime, String result, String score, String firstHalfScoreComments, String secondHalfScoreComments) {
        this.oppositionName = oppositionName;
        this.date = date;
        this.location = location;
        KoTime = koTime;
        this.result = result;
        this.score = score;
        this.firstHalfScoreComments = firstHalfScoreComments;
        this.secondHalfScoreComments = secondHalfScoreComments;
    }

    //Getters and setters

    public String getOppositionName() {
        return oppositionName;
    }

    public void setOppositionName(String oppositionName) {
        this.oppositionName = oppositionName;
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

    public String getKoTime() {
        return KoTime;
    }

    public void setKoTime(String koTime) {
        KoTime = koTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getFirstHalfScoreComments() {
        return firstHalfScoreComments;
    }

    public void setFirstHalfScoreComments(String firstHalfScoreComments) {
        this.firstHalfScoreComments = firstHalfScoreComments;
    }

    public String getSecondHalfScoreComments() {
        return secondHalfScoreComments;
    }

    public void setSecondHalfScoreComments(String secondHalfScoreComments) {
        this.secondHalfScoreComments = secondHalfScoreComments;
    }
}
