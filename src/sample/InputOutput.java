package sample;

import java.io.*;
import java.util.ArrayList;

public class InputOutput {
    private File coachFile;
    private File playerFile;
    private File parentHelperFile;
    private File trainingRecordFile;
    private File gameRecordFile;
    private File playerProfileFile;
    private FileWriter write;
    private PrintWriter out;


    private String pathToCoachFile = "data/coachData.txt";
    private String pathToPlayerFile = "data/playerData.txt";
    private String pathToParentHelperFile = "data/parentHelperData.txt";
    private String pathToTrainingRecordFile = "data/trainingRecordData.txt";
    private String pathToGameRecordFile = "data/gameRecordData.txt";
    private String pathToPlayerProfileFile = "data/playerProfileData.txt";

    /*
     * CONSTRUCTOR - initialise all 4 files
     */

    public InputOutput() {
        this.coachFile = new File(pathToCoachFile);
        this.playerFile= new File(pathToPlayerFile);
        this.parentHelperFile= new File(pathToParentHelperFile);
        this.trainingRecordFile= new File(pathToTrainingRecordFile);
        this.gameRecordFile= new File(pathToGameRecordFile);
        this.playerProfileFile=new File(pathToPlayerProfileFile);

    }



    /*
     * Write Player Details method
     * Takes ArrayList<Player> as parameter
     * Initialise FileWriter with the Player File
     * Initlaise PrintWriter with FileWriter
     * Loop through Player ArrayList and (if != null)
     * Write all Player attributes to Player File
     * Flush PrintWriter when complete
     */
    public void writePlayerDetails(ArrayList<Player> playerList) {
        try {
            write = new FileWriter(playerFile);
            out = new PrintWriter(write);

            for (Player i : playerList) {
                if (playerList != null) //noinspection Duplicates
                {
                    out.write(i.getName()+ ",");
                    out.write(i.getSRUNumber()+ ",");
                    out.write(i.getDOB() + ",");
                    out.write(i.getAddress()+ ",");
                    out.write(i.getEmail()+ ",");
                    out.write(i.getPostcode() + ",");
                    out.write(i.getMobileNum()+ ",");
                    out.write(i.getEmergencyContact() + ",");
                    out.write(i.getEmergencyContTel() + ",");
                    out.write(i.getDoctor() + ",");
                    out.write(i.getDoctorTel()+ ",");
                    out.write(i.getHealthIssue() + ",");
                    out.write(i.getPlayingPos() + ",");
                    out.write(i.getAge()+ ",");
                    out.write(i.getSquadID()+"\n");



                }
            }
            out.flush();
        } catch (IOException e) {
            Validator.displayAlert("Alert", "Invalid path");
        }
    }

    /*
     * Read Player Data method
     * Takes ArrayList<Player> as parameter
     * Initialise FileReader with Player File
     * Initialise Scanner with FileReader
     * Create new Player Object
     * Read through Player File and Scan each line
     * Set Player attributes to these inputs
     * Add Player to Player ArrayList
     */
    public void readPlayerData(ArrayList<Player> playerList) throws IOException {

        BufferedReader in =Validator.checkFile(pathToPlayerFile); //check if the file exists
        String str;
        while ((str = in.readLine()) != null) {
            playerList.add(populatePlayerDetails(str));
        }
        in.close();
    }

    private static Player populatePlayerDetails(String str)throws IOException  {
        String[] data;
        if (str == null) {
            return null;
        } else {
            //the content, str.split(",") returns an array[] of strings separated by a comma
            data = str.split(",");
            if (data.length<15){
                System.out.println("Empty ");
                return null;
            }else {
                return new Player(data[0], data[1], data[2], data[3], data[4], data[5], data[6],data[7],data[8],data[9],data[10],
                        data[11], data[12],Integer.parseInt(data[13]),data[14]);

            }

        }
    }



    /*
     * Write Coach Details method
     * Takes ArrayList<Coach> as parameter
     * Initialise FileWriter with the Coach File
     * Initlaise PrintWriter with FileWriter
     * Loop through Coach ArrayList and (if != null)
     * Write all Animal attributes to coach File
     * Flush PrintWriter when complete
     */
    public void writeCoachDetails(ArrayList<Coach> coachList) {
        try {
            write = new FileWriter(coachFile);
            out = new PrintWriter(write);

            for (Coach i : coachList) {
                if (coachList != null) //noinspection Duplicates
                {
                    out.write(i.getName()+ ",");
                    out.write(i.getSRUNumber()+ ",");
                    out.write(i.getDOB() + ",");
                    out.write(i.getAddress()+ ",");
                    out.write(i.getMobileNum()+ ",");
                    out.write(i.getEmail()+ ",");
                    out.write(i.getPostcode() + ",");
                    out.write(i.getPassword() + ",");
                    out.write(i.getSquadName() + "\n");
                }
            }
            out.flush();
        } catch (IOException e) {
            Validator.displayAlert("Alert", "Invalid path");
        }
    }

    /*
     * Read coach Data method
     * Takes ArrayList<Coach> as parameter
     * Initialise FileReader with Coach File
     * Initialise Scanner with FileReader
     * Create new Coach Object
     * Read through Coach File and Scan each line
     * Set coach attributes to these inputs
     * Add coach to coach ArrayList
     */
    public void readCoachData(ArrayList<Coach> coachList) throws IOException {

        BufferedReader in =Validator.checkFile(pathToCoachFile); //check if the file exists
        String str;
        while ((str = in.readLine()) != null) {
            coachList.add(populateCoachDetails(str));
        }
        in.close();
    }

    private static Coach populateCoachDetails(String str) throws IOException {
        String[] data;
        if (str == null) {
            return null;
        } else {
            //the content, str.split(",") returns an array[] of strings separated by a comma
            data = str.split(",");
            if (data.length<9){
                System.out.println("Empty ");
                return null;
            }else {
                return new Coach(data[0], data[1], data[2], data[3], data[4], data[5], data[6],data[7],data[8]);

            }

        }
    }

    /*
     * Write ParentHelper Details method
     * Takes ArrayList<ParentHelper> as parameter
     * Initialise FileWriter with the parentHelper File
     * Initalise PrintWriter with FileWriter
     * Loop through ParentHelper ArrayList and (if != null)
     * Write all ParentHelper attributes to ParentHelper File
     * Flush PrintWriter when complete
     */
    public void writeParentHelperDetails(ArrayList<ParentHelper> parentHelperList) {
        try {
            write = new FileWriter(parentHelperFile);
            out = new PrintWriter(write);

            for (ParentHelper i : parentHelperList) {
                if (parentHelperList != null) //noinspection Duplicates
                {
                    out.write(i.getName()+ ",");
                    out.write(i.getSRUNumber()+ ",");
                    out.write(i.getDOB() + ",");
                    out.write(i.getAddress()+ ",");
                    out.write(i.getMobileNum()+ ",");
                    out.write(i.getEmail()+ ",");
                    out.write(i.getPostcode() + "\n");
                }
            }
            out.flush();
        } catch (IOException e) {
            Validator.displayAlert("Alert", "Invalid path");
        }
    }

    /*
     * Read ParentHelper Data method
     * Takes ArrayList<ParentHelper> as parameter
     * Initialise FileReader with Coach File
     * Initialise Scanner with FileReader
     * Create new ParentHelper Object
     * Read through Coach File and Scan each line
     * Set parentHelper attributes to these inputs
     * Add ParentHelper to ParentHelper ArrayList
     */
    public void readParentHelperData(ArrayList<ParentHelper> parentHelperList) throws IOException {

        BufferedReader in =Validator.checkFile(pathToParentHelperFile); //check if the file exists
        String str;
        while ((str = in.readLine()) != null) {
            parentHelperList.add(populateParentHelperDetails(str));
        }
        in.close();
    }

    private static ParentHelper populateParentHelperDetails(String str) throws IOException {
        String[] data;
        if (str == null) {
            return null;
        } else {
            //the content, str.split(",") returns an array[] of strings separated by a comma
            data = str.split(",");
            if (data.length<7){
                System.out.println("Empty ");
                return null;
            }else {
                return new ParentHelper(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);

            }

        }
    }


    /*
     * Write TrainingRecord Details method
     * Takes ArrayList<TrainingRecord> as parameter
     * Initialise FileWriter with the TrainingRecord File
     * Initlaise PrintWriter with FileWriter
     * Loop through TrainingRecord ArrayList and (if != null)
     * Write all TrainingRecord attributes to TrainingRecord File
     * Flush PrintWriter when complete
     */
    public void writeTrainingRecordDetails(ArrayList<TrainingRecord> trainingRecordList) {
        try {
            write = new FileWriter(trainingRecordFile);
            out = new PrintWriter(write);

            for (TrainingRecord i : trainingRecordList) {
                if (trainingRecordList != null) {
                    out.write(i.getCoachOrganizing()+ ";");
                    out.write(i.getDate()+ ";");
                    out.write(i.getLocation() + ";");
                    out.write(i.getTime()+ ";");
                    out.write(i.getSkilliesAndActivitiesUnderT()+ ";");
                    out.write(i.getPlayerPresent() + ";");
                    out.write(i.getInjuries()+ "\n");


                }
            }
            out.flush();
        } catch (IOException e) {
            Validator.displayAlert("Alert", "Invalid path");
        }
    }

    /*
     * Read trainingRecord Data method
     * Takes ArrayList<TrainingRecord> as parameter
     * Initialise FileReader with TrainingRecord File
     * Initialise Scanner with FileReader
     * Create new TrainingRecord Object
     * Read through TrainingRecord File and Scan each line
     * Set TrainingRecord attributes to these inputs
     * Add TrainingRecord to TrainingRecord ArrayList
     */
    public void readTrainingRecordData(ArrayList<TrainingRecord> trainingRecordList) throws IOException {

        BufferedReader in =Validator.checkFile(pathToTrainingRecordFile); //check if the file exists
        String str;
        while ((str = in.readLine()) != null) {
            trainingRecordList.add(populateTrainingRecordDetails(str));
        }
        in.close();
    }

    private static TrainingRecord populateTrainingRecordDetails(String str)throws IOException  {
        String[] data;
        if (str == null) {
            return null;
        } else {
            //the content, str.split(",") returns an array[] of strings separated by a semi colon
            data = str.split(";");
            if (data.length<7){
                System.out.println("Empty ");
                return null;
            }else {
                return new TrainingRecord(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);

            }

        }
    }

    /*
     * Write GameRecord Details method
     * Takes ArrayList<GameRecord> as parameter
     * Initialise FileWriter with the GameRecord File
     * Initlaise PrintWriter with FileWriter
     * Loop through GameRecord ArrayList and (if != null)
     * Write all GameRecord attributes to GameRecord File
     * Flush PrintWriter when complete
     */
    public void writeGameRecordDetails(ArrayList<GameRecord> gameRecordList) {
        try {
            write = new FileWriter(gameRecordFile);
            out = new PrintWriter(write);

            for (GameRecord i : gameRecordList) {
                if (gameRecordList != null) {
                    out.write(i.getOppositionName()+ ";");
                    out.write(i.getDate()+ ";");
                    out.write(i.getLocation() + ";");
                    out.write(i.getKoTime()+ ";");
                    out.write(i.getResult()+ ";");
                    out.write(i.getScore() + ";");
                    out.write(i.getFirstHalfScoreComments()+ ";");
                    out.write(i.getSecondHalfScoreComments()+ "\n");



                }
            }
            out.flush();
        } catch (IOException e) {
            Validator.displayAlert("Alert", "Invalid path");
        }
    }

    /*
     * Read GameRecord Data method
     * Takes ArrayList<GameRecord> as parameter
     * Initialise FileReader with GameRecord File
     * Initialise Scanner with FileReader
     * Create new GameRecord Object
     * Read through GameRecord File and Scan each line
     * Set GameRecord attributes to these inputs
     * Add GameRecord to GameRecord ArrayList
     */
    public void readGameRecordData(ArrayList<GameRecord> gameRecordList) throws IOException {

        BufferedReader in =Validator.checkFile(pathToGameRecordFile); //check if the file exists
        String str;
        while ((str = in.readLine()) != null) {
            gameRecordList.add(populateGameRecordDetails(str));
        }
        in.close();
    }

    private static GameRecord populateGameRecordDetails(String str)  {
        String[] data;
        if (str == null) {
            return null;
        } else {
            //the content, str.split(",") returns an array[] of strings separated by a semi colon
            data = str.split(";");
            if (data.length<8){
                System.out.println("Empty ");
                return null;
            }else {
                return new GameRecord(data[0], data[1], data[2], data[3], data[4], data[5], data[6],data[7]);

            }

        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //PLAYER PROFILE

    /*
     * Write PlayerProfile Details method
     * Takes ArrayList<PlayerProfile> as parameter
     * Initialise FileWriter with the PlayerProfile File
     * Initlaise PrintWriter with FileWriter
     * Loop through PlayerProfile ArrayList and (if != null)
     * Write all PlayerProfile attributes to PlayerProfile File
     * Flush PrintWriter when complete
     */
    public void writePlayerProfileDetails(ArrayList<PlayerProfile> playerProfileList) {
        try {
            write = new FileWriter(playerProfileFile);
            out = new PrintWriter(write);

            for (PlayerProfile i : playerProfileList) {
                if (playerProfileList != null) //noinspection Duplicates
                {
                    out.write(i.getPlayerSRUNum()+ ",");
                    out.write(i.getSquadID()+ ",");
                    out.write(i.getPassingStandard() + ",");
                    out.write(i.getPassingSpin()+ ",");
                    out.write(i.getPassingPop()+ ",");
                    out.write(i.getTacklingFront() + ",");
                    out.write(i.getTacklingRear()+ ",");
                    out.write(i.getTacklingSide() + ",");
                    out.write(i.getTacklingScrabble() + ",");
                    out.write(i.getKickingDrop() + ",");
                    out.write(i.getKickingPunt()+ ",");
                    out.write(i.getKickingGrubber() + ",");
                    out.write(i.getKickingGoal() + "\n");



                }
            }
            out.flush();
        } catch (IOException e) {
            Validator.displayAlert("Alert", "Invalid path");
        }
    }

    /*
     * Read PlayerProfile Data method
     * Takes ArrayList<PlayerProfile> as parameter
     * Initialise FileReader with PlayerProfile File
     * Initialise Scanner with FileReader
     * Create new PlayerProfile Object
     * Read through PlayerProfile File and Scan each line
     * Set PlayerProfile attributes to these inputs
     * Add PlayerProfile to PlayerProfile ArrayList
     */
    public void readPlayerProfileData(ArrayList<PlayerProfile> playerProfileList) throws IOException {

        BufferedReader in =Validator.checkFile(pathToPlayerProfileFile); //check if the file exists
        String str;
        while ((str = in.readLine()) != null) {
            playerProfileList.add(populatePlayerProfileDetails(str));
        }
        in.close();
    }

    private static PlayerProfile populatePlayerProfileDetails(String str)throws IOException  {
        String[] data;
        if (str == null) {
            return null;
        } else {
            //the content, str.split(",") returns an array[] of strings separated by a comma
            data = str.split(",");
            if (data.length<13){
                System.out.println("Empty +++++++++++");
                return null;
            }else {
                return new PlayerProfile(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7]),Integer.parseInt(data[8]),Integer.parseInt(data[9]),
                        Integer.parseInt(data[10]),Integer.parseInt(data[11]),Integer.parseInt(data[12]));

            }

        }
    }


}
