class TaskNode{
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class Task {
    TaskNode head, tail, current;

    public void addBeg(int taskId, String taskName, int priority, String dueDate) {
        TaskNode task = new TaskNode(taskId, taskName, priority, dueDate);
        if(head == null) {
            head = tail = task;
            task.next = head;
            return;
        }

        tail.next = task;
        task.next = head;
        head = task;
    }

    public void addEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode task = new TaskNode(taskId, taskName, priority, dueDate);
        if(head == null) {
            head = tail = task;
            task.next = head;
            return;
        }

        tail.next = task;
        task.next = head;
        tail = task;
    }

    public void addPos(int taskId, String taskName, int priority, String dueDate, int pos) {
        TaskNode task = new TaskNode(taskId, taskName, priority, dueDate);
        if(head == null) {
            head = tail = task;
            return;
        }

        if(pos == 1) {
            addBeg(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode temp = head;
        for(int i = 0; i < pos-1; i++) {
            temp = temp.next;
        }
        task.next = temp.next;
        temp.next = task;
    }

    public void removeById(int id) {
        if(head == null) {
            System.out.println("No task is assigned");
            return;
        }

        TaskNode temp = head, prev = tail;
        boolean found = false;
        do {
            if(temp.taskId == id){
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        while (temp != head);

        if(!found) {
            System.out.println("Task with Id " + id + " not found.");
            return;
        }

        if(head == tail) {
            head = tail = null;
        }
        else if (temp == head) {
            head = head.next;
            tail.next = head;
        }
        else if(temp == tail) {
            tail = prev;
            tail.next = head;
        }
        else {
            prev.next = temp.next;
        }
    }

    public void searchByPriority(int priority) {
        if(head == null) {
            System.out.println("No task is assigned");
            return;
        }

        System.out.println("==============================================");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Task Id", "Task Name", "Priority", "Due Date");
        System.out.println("==============================================");
        TaskNode temp = head;
        do {
            if(temp.priority == priority) {
                display(temp);
            }
            temp = temp.next;
        }
        while (temp != head);
        System.out.println("==============================================");
    }

    public void viewCurrent(){
        if(head == null) {
            System.out.println("No task found!");
            return;
        }

        if(current == null) {
            current = head;
        }
        System.out.println("Current Task:");
        System.out.println("==============================================");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Task Id", "Task Name", "Priority", "Due Date");
        System.out.println("==============================================");
        display(current);
        System.out.println("==============================================");
        System.out.println();
        current = current.next;
    }

    public void display (TaskNode task){
        System.out.printf("%-10d %-10s %-10d %-10s\n", task.taskId, task.taskName, task.priority, task.dueDate);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No Task Records found!.");
            return;
        }

        TaskNode temp = head;

        System.out.println("==============================================");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Task Id", "Task Name", "Priority", "Due Date");
        System.out.println("==============================================");
        do {
            display(temp);
            temp = temp.next;
        }
        while (temp != head);
        System.out.println("==============================================");
        System.out.println();
    }
}

public class TaskScheduler {

    public static void main(String[] args) {
        Task taskList = new Task();

        taskList.addBeg(1, "Design", 2, "2025-04-15");
        taskList.addEnd(2, "Code", 1, "2025-04-20");
        taskList.addEnd(4, "Test", 3, "2025-04-25");
        taskList.addPos(3, "Deploy", 2, "2025-04-30", 2);

        taskList.displayAll();

        System.out.println("\nTasks with priority 2:");
        taskList.searchByPriority(2);

        System.out.println("\nViewing current task and moving to next:");
        taskList.viewCurrent();
        taskList.viewCurrent();
        taskList.viewCurrent();
        taskList.viewCurrent();

        System.out.println("\nRemoving Task with ID 2...");
        taskList.removeById(2);
        taskList.displayAll();

        System.out.println("\nViewing current task and moving to next after removal:");
        taskList.viewCurrent();
        taskList.viewCurrent();
        taskList.viewCurrent();
        taskList.viewCurrent();
    }
}