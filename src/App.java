import java.util.List;
import java.util.Scanner;

import com.ramesh.dao.repoImplementation.fileimplementation.StudentCrudFileOperation;
import com.ramesh.models.Student;


public class App {
    public static void main(String[] args) {
        StudentCrudFileOperation fileOps = new StudentCrudFileOperation("Students.csv");
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        while (true) {
            System.out.println("<<<<< Students Managemen System >>>>>>");
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    fileOps.save(new Student(id, name, email));
                    break;

                case 2:
                   List<Student> students= fileOps.getall();
                   System.out.println("<<<<< All Students >>>>>>");
                   for(Student st : students){
                    System.out.println(st);

                   }
                
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Email: ");
                    String newEmail = scanner.nextLine();

                    fileOps.update(updateId, new Student(updateId,newName,newEmail));
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    fileOps.delete(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
                }
            System.out.println(Student.count);
        }
    }
}
