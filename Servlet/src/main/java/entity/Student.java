package entity;

public class Student {
    private int id;
    private String name;
    private String email;
    private String regd;
    private int password;

    public Student(int id, String name, String email, String regd,int password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.regd = regd;
        this.password=password;
    }

    public Student() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegd() {
        return regd;
    }

    public void setRegd(String regd) {
        this.regd = regd;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", regd=" + regd +
                ", password=" + password +
                '}';
    }
}
