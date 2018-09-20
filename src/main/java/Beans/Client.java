package Beans;

public class Client {

    private Integer id;
    private String fullName;

    public Client(Integer id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

}
