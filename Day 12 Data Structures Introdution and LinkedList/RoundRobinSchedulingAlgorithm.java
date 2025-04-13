class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    int remainingTime;
    int completionTime;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class Process{

    ProcessNode head, tail;

    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode process = new ProcessNode(processId, burstTime, priority);

        if(head == null) {
            head = tail = process;
            process.next = head;
            return;
        }

        process.next = head;
        tail.next = process;
        tail = process;
    }

    public void removeById(int id) {
        if(head == null) {
            System.out.println("No process is assigned!");
        }

        ProcessNode temp = head, prev = tail;
        boolean found = false;
        do {
            if(temp.processId == id) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        while (temp != head);

        if(!found) {
            System.out.println("The process with id " + id + " not found!");
        }

        if(head == tail) {
            head = tail = null;
        }
        else if (temp == head) {
            head = head.next;
            tail.next = head;
        }
        else if (temp == tail) {
            tail = prev;
            prev.next = head;
        }
        else {
            prev.next = temp.next;
        }
    }

    public void roundRobin(int timeQuantum) {

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;
        int processCount = 0;

        if(head == null) {
            System.out.println("No process to Schedule!");
            return;
        }

        ProcessNode temp = head;

        do {
            processCount++;
            temp = temp.next;
        }
        while (temp != head);

        ProcessNode current = head;

        while (head != null) {
            if (current.remainingTime > timeQuantum) {
                System.out.println("Process " + current.processId + " executed for " + timeQuantum + " units.");
                current.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
            }
            else {
                currentTime += current.remainingTime;
                current.completionTime = currentTime;

                int turnAroundTime = current.completionTime;
                int waitingTime = turnAroundTime - current.burstTime;

                totalWaitingTime += waitingTime;
                totalTurnAroundTime += turnAroundTime;

                System.out.println("Process " + current.processId + " completed at time " + currentTime + ".");

                ProcessNode toRemove = current;
                current = current.next;
                removeById(toRemove.processId);

                if (head == null) {
                    break;
                }
                displayProcesses();
                continue;

            }
            current = current.next;
        }

        double avgWaitingTime = (double) totalWaitingTime / processCount;
        double avgTurnAroundTime = (double) totalTurnAroundTime / processCount;
        System.out.println("\n===== Final Results =====");
        System.out.printf("Average Waiting Time: %.2f\n", avgWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f\n", avgTurnAroundTime);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode temp = head;
        System.out.println("Process List:");
        System.out.println("------------------------------------------");
        System.out.printf("%-12s %-15s %-10s\n", "Process ID", "Remaining Time", "Priority");
        System.out.println("------------------------------------------");
        do {
            System.out.printf("%-12d %-15d %-10d\n", temp.processId, temp.remainingTime, temp.priority);
            temp = temp.next;
        } while (temp != head);
        System.out.println("------------------------------------------\n");
    }

}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {

        Process scheduler = new Process();

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 4, 1);
        scheduler.addProcess(3, 6, 3);
        scheduler.addProcess(4, 8, 2);

        scheduler.displayProcesses();

        int timeQuantum = 3;

        scheduler.roundRobin(timeQuantum);
    }
}
