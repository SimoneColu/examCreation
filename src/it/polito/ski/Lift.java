package it.polito.ski;

public class Lift implements Comparable<Lift> {
    private String name;
    private LiftType type;
    
    
    
    public Lift(String name, LiftType type) {
        this.name = name;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LiftType getType() {
        return type;
    }
    public void setType(LiftType type) {
        this.type = type;
    }
    @Override
    public int compareTo(Lift other) {
        int r = this.name.compareTo(other.getName());
        return r;
    }

    

}
