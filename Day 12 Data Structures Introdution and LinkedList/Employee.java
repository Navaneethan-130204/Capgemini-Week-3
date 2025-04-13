class EmployeeNode {
    int id;
    String name;
    String department;
    double salary;
    EmployeeNode next;

    public EmployeeNode(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.next = null;
    }
}

class EmployeeLinkedList{

    EmployeeNode head;

    public void addFirst(int id, String name, String department, double salary) {
        EmployeeNode newEmp = new EmployeeNode(id, name, department, salary);
        newEmp.next = head;
        head = newEmp;
    }

    public void addEnd(int id, String name, String department, double salary) {
        EmployeeNode newEmp = new EmployeeNode(id, name, department, salary);
        EmployeeNode temp = head;

        if(head == null) {
            head = newEmp;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newEmp;
    }

    public void addPos(int id, String name, String department, double salary, int pos) {
        EmployeeNode newEmp = new EmployeeNode(id, name, department, salary);
        EmployeeNode temp = head;

        for(int i = 0; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        newEmp.next = temp.next;
        temp.next = newEmp;
    }

    public void deleteFirst() {
        EmployeeNode temp = head;
        head = head.next;
        temp.next = null;
    }

    public void deleteEnd() {
        if(head == null) {
            System.out.println("No Employee found!");
        }

        if(head.next == null) {
            head.next = null;
        }

        EmployeeNode temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;

    }

    public void deletePos(int pos) {
        EmployeeNode temp = head;
        for(int i = 0; temp != null && i < pos-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void findEmployeeId(int id) {
        EmployeeNode temp = head;
        while (temp != null){
            if(temp.id == id){
                display(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Employee ID Not Found!");
    }

    public void findEmployeeName(String name) {
        EmployeeNode temp = head;
        while (temp != null){
            if(temp.name.equalsIgnoreCase(name)){
                display(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Employee Name Not Found!");
    }

    public void display (EmployeeNode emp){
        System.out.printf("%-10d %-10s %-12s %-10.2f\n", emp.id, emp.name, emp.department, emp.salary);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No employee records.");
            return;
        }

        EmployeeNode temp = head;

        System.out.println("========================================================");
        System.out.printf("%-10s %-10s %-12s %-10s\n", "Id", "Name", "Department", "Salary");
        System.out.println("========================================================");
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
        System.out.println("========================================================");
    }
}

public class Employee {
    public static void main(String[] args) {
        EmployeeLinkedList employee = new EmployeeLinkedList();

        System.out.println("Employee Addition:");
        employee.addFirst(102, "Alex", "HR", 25000);
        employee.addEnd(104, "Peter", "IT", 35000);
        employee.addFirst(101, "Patrick", "Testing", 20000);
        employee.addPos(103, "Park", "Designer", 37500, 2);
        employee.addEnd(105,"Harry", "Team lead", 40000);
        employee.displayAll();

        System.out.println("Employee Deletion:");
        employee.deleteFirst();
        employee.deleteEnd();
        employee.deletePos(2);
        employee.displayAll();

        System.out.println("Search by Id: (103)");
        employee.findEmployeeId(103);
        System.out.println("========================================================");
        System.out.println("Search by Name: (Harry)");
        employee.findEmployeeName("Harry");
    }
}