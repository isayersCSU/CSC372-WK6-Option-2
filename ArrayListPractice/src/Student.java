public class Student {
    private int studentId;
    private String name;
    private String address;

    // Constructor
    public Student(int studentId, String name, String address) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    // Setter for studentId
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }
}