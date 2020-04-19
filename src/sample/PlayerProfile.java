package sample;

public class PlayerProfile {
    private String playerSRUNum,squadID;
    private Integer passingStandard,passingSpin,passingPop,tacklingFront,tacklingRear,tacklingSide,tacklingScrabble,kickingDrop,kickingPunt,kickingGrubber,kickingGoal;

    //Constructor

    public PlayerProfile() {
    }

    public PlayerProfile(String playerSRUNum, String squadID, Integer passingStandard, Integer passingSpin, Integer passingPop, Integer tacklingFront, Integer tacklingRear, Integer tacklingSide, Integer tacklingScrabble, Integer kickingDrop, Integer kickingPunt, Integer kickingGrubber, Integer kickingGoal) {
        this.playerSRUNum = playerSRUNum;
        this.squadID = squadID;
        this.passingStandard = passingStandard;
        this.passingSpin = passingSpin;
        this.passingPop = passingPop;
        this.tacklingFront = tacklingFront;
        this.tacklingRear = tacklingRear;
        this.tacklingSide = tacklingSide;
        this.tacklingScrabble = tacklingScrabble;
        this.kickingDrop = kickingDrop;
        this.kickingPunt = kickingPunt;
        this.kickingGrubber = kickingGrubber;
        this.kickingGoal = kickingGoal;
    }

    //Getters and setters

    public String getPlayerSRUNum() {
        return playerSRUNum;
    }

    public void setPlayerSRUNum(String playerSRUNum) {
        this.playerSRUNum = playerSRUNum;
    }

    public String getSquadID() {
        return squadID;
    }

    public void setSquadID(String squadID) {
        this.squadID = squadID;
    }

    public Integer getPassingStandard() {
        return passingStandard;
    }

    public void setPassingStandard(Integer passingStandard) {
        this.passingStandard = passingStandard;
    }

    public Integer getPassingSpin() {
        return passingSpin;
    }

    public void setPassingSpin(Integer passingSpin) {
        this.passingSpin = passingSpin;
    }

    public Integer getPassingPop() {
        return passingPop;
    }

    public void setPassingPop(Integer passingPop) {
        this.passingPop = passingPop;
    }

    public Integer getTacklingFront() {
        return tacklingFront;
    }

    public void setTacklingFront(Integer tacklingFront) {
        this.tacklingFront = tacklingFront;
    }

    public Integer getTacklingRear() {
        return tacklingRear;
    }

    public void setTacklingRear(Integer tacklingRear) {
        this.tacklingRear = tacklingRear;
    }

    public Integer getTacklingSide() {
        return tacklingSide;
    }

    public void setTacklingSide(Integer tacklingSide) {
        this.tacklingSide = tacklingSide;
    }

    public Integer getTacklingScrabble() {
        return tacklingScrabble;
    }

    public void setTacklingScrabble(Integer tacklingScrabble) {
        this.tacklingScrabble = tacklingScrabble;
    }

    public Integer getKickingDrop() {
        return kickingDrop;
    }

    public void setKickingDrop(Integer kickingDrop) {
        this.kickingDrop = kickingDrop;
    }

    public Integer getKickingPunt() {
        return kickingPunt;
    }

    public void setKickingPunt(Integer kickingPunt) {
        this.kickingPunt = kickingPunt;
    }

    public Integer getKickingGrubber() {
        return kickingGrubber;
    }

    public void setKickingGrubber(Integer kickingGrubber) {
        this.kickingGrubber = kickingGrubber;
    }

    public Integer getKickingGoal() {
        return kickingGoal;
    }

    public void setKickingGoal(Integer kickingGoal) {
        this.kickingGoal = kickingGoal;
    }
}
