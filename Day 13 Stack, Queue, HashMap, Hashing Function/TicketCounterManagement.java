import java.util.LinkedList;
import java.util.Queue;
public class TicketCounterManagement {
    public static void main(String[] args) {
        Queue<String> ticketQueue = new LinkedList<>();
        ticketQueue.add("Customer 1");
        ticketQueue.add("Customer 2");
        ticketQueue.add("Customer 3");
        ticketQueue.add("Customer 4");

        System.out.println("Initial Queue: " + ticketQueue);

        while (!ticketQueue.isEmpty()) {
            System.out.println(ticketQueue.peek() + " is being served.");
            ticketQueue.remove();
            System.out.println("Queue after serving: " + ticketQueue);
            System.out.println();
        }
        System.out.println("All customers have been served!");
    }
}
