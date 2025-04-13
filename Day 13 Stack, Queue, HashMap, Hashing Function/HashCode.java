import java.util.Objects;

class Employee{
    int id;
    String name;

    public Employee (int id, String name) {
        this.id = id;
         this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Employee emp = (Employee) obj;
        return id == emp.id && Objects.equals(name,emp.name);
    }

}

public class HashCode {
    public static void main(String[] args) {

        Employee e1 = new Employee(1, "Alice");
        Employee e2 = new Employee(1, "Alice");
        Employee e3 = new Employee(2, "Bob");

        // Testing equals()
        System.out.println("e1 equals e2: " + e1.equals(e2)); // true
        System.out.println("e1 equals e3: " + e1.equals(e3)); // false
        System.out.println("e1 equals null: " + e1.equals(null)); // false
        System.out.println("e1 equals e1: " + e1.equals(e1)); // true

        // Printing hash codes
        System.out.println("HashCode of e1: " + e1.hashCode());
        System.out.println("HashCode of e2: " + e2.hashCode());
        System.out.println("HashCode of e3: " + e3.hashCode());
    }
}
