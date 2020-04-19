package sample;

public class Squad {

    private String idNumber,name, description;

    //Constructor

    public Squad() {
    }

    public Squad(String idNumber, String name, String description) {
        this.idNumber = idNumber;
        this.name = name;
        this.description = description;
    }


    //Getters and setters
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
