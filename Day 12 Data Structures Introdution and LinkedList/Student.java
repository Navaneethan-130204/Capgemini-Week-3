class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentLinkedList {

    StudentNode head;

    public void addFirst(int rollNumber, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        if(head == null) {
            head = newStudent;
            return;
        }
        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addPos(int rollNumber, String name, int age, String grade, int pos) {
        StudentNode newStudent = new StudentNode(rollNumber, name, age, grade);
        StudentNode temp = head;
        for(int i = 0; temp != null && i < pos-1; i++){
            temp = temp.next;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteFirst(){
        if(head == null) {
            System.out.println("No students in the list!");
        }
        else{
            StudentNode temp = head;
            head = head.next;
            temp.next = null;
        }
    }

    public void deleteEnd(){
        StudentNode temp = head;
        if(head == null) {
            System.out.println("No Students in the list!");
        }

        if (head.next == null) {
            head = null;
        }

        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deletePos(int pos){
        StudentNode temp = head;
        for(int i = 0; temp != null & i < pos-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void searchStudent(int rollNumber) {
        StudentNode temp = head;
        while (temp.next != null) {
            if(temp.rollNumber == rollNumber){
                displayStudent(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student RollNumber Not Found!");
    }

    public void updateGrade(String grade, int rollNumber) {
        StudentNode temp = head;
        while(temp != null) {
            if(temp.rollNumber == rollNumber){
                temp.grade = grade;
                displayStudent(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student RollNumber Not Found!");
    }

    public void displayStudent(StudentNode student){
        System.out.printf("%-12s %-10s %-10d %-10s\n", student.rollNumber, student.name, student.age, student.grade);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No Student records found.");
            return;
        }

        StudentNode temp = head;

        System.out.println("============================================");
        System.out.printf("%-12s %-10s %-10s %-10s\n", "RollNumber", "Name", "Age", "Grade");
        System.out.println("============================================");
        while (temp != null) {
            displayStudent(temp);
            temp = temp.next;
        }
        System.out.println("============================================");
    }
}

public class Student {
    public static void main(String[] args) {
        StudentLinkedList student = new StudentLinkedList();
        student.addEnd(102, "Mary", 14, "Grade B");
        student.addFirst(101, "Alex", 15, "Grade A");
        student.addEnd(104, "Jane", 16, "Grade B");
        student.addPos(103, "Alex", 15, "Grade A", 2);
        student.addEnd(105, "George", 15, "Grade C");
        System.out.println("Student Records Addition: ");
        student.displayAll();
        System.out.println();

        System.out.println("Search student with Roll Number : 103");
        student.searchStudent(103);
        System.out.println();

        System.out.println("Updating Student Grade.");
        student.updateGrade("Grade A", 105);
        System.out.println();
        student.displayAll();
        System.out.println();

        System.out.println("Student Records Deletion:");
        student.deletePos(4);
        student.deleteEnd();
        student.deleteFirst();
        student.displayAll();
    }
}
