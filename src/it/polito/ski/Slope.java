package it.polito.ski;

public class Slope {
    
    private String name;
    private String difficulty;
    private String startingLiftName;

    public Slope(String name, String difficulty, String startingLiftName) {
        this.name = name;
        this.difficulty = difficulty;
        this.startingLiftName = startingLiftName;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getStartingLiftName() {
        return startingLiftName;
    }
    public void setStartingLiftName(String startingLiftName) {
        this.startingLiftName = startingLiftName;
    }

    


}
