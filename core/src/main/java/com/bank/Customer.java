package main.java.com.bank;

public class Customer {
    private final String name;
    private final String passportId;

    public Customer(String name, String passportId) {
        this.name = name;
        this.passportId = passportId;
    }

    public String getName() {
        return name; 
    }
    
    public String getPassportId() { 
        return passportId; 
    }
}
