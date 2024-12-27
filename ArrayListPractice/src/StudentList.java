import java.util.ArrayList;
import java.util.Arrays;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Alice", "123 Ash St"));
        students.add(new Student(102, "Bob", "456 Birch St"));
        students.add(new Student(103, "Charlie", "789 Cedar St"));
        students.add(new Student(104, "Debbie", "1011 Dogwood St"));
        students.add(new Student(105, "Edward", "1213 Elm St"));
        students.add(new Student(106, "Francine", "1415 Fir St"));
        students.add(new Student(107, "Gerald", "1617 Giant Sequoia St"));
        students.add(new Student(108, "Helen", "1819 Holly St"));
        students.add(new Student(109, "Isaac", "2021 Incense St"));
        students.add(new Student(110, "Jaqueline", "2223 Juniper St"));

        // Convert ArrayList to array for merge sort
        Student[] studentArray = students.toArray(new Student[students.size()]);

        // Sort the array using the custom comparator
        MergeSort.mergeSort(studentArray, 0, studentArray.length - 1, new StudentIdComparator());

        // Print sorted by ID (optional)
        System.out.println("Sorted by Student ID:");
        printStudents(studentArray);

        // Create a copy of the array for sorting by name
        Student[] studentArrayByName = Arrays.copyOf(studentArray, studentArray.length);

        // Sort the copy by Student Name
        MergeSort.mergeSort(studentArrayByName, 0, studentArrayByName.length - 1, new StudentNameComparator());

        // Print sorted by Name
        System.out.println("Sorted by Student Name:");
        printStudents(studentArrayByName);
    }

    private static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Address: " + student.getAddress());
            System.out.println();
        }
    }
}