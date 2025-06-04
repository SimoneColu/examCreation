package it.polito.ski;

public class LiftType {
    private String code;
    private String category;
    private int capacity;
    
    
    

    public LiftType(String code, String category, int capacity) {
        this.code = code;
        this.category = category;
        this.capacity = capacity;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
