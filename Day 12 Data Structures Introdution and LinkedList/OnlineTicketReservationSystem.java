class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime){
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class Ticket {

    TicketNode head, tail, current;

    public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode ticket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);

        if(head == null) {
            head = tail = ticket;
            ticket.next = head;
            return;
        }

        ticket.next = head;
        tail.next = ticket;
        tail = ticket;
    }

    public void removeId(int id) {
        if(head == null) {
            System.out.println("Id not found!");
        }

        TicketNode temp = head, prev = tail;
        boolean found = false;
        do {
            if(temp.ticketId == id) {
                found = true;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        while (temp != head);

        if(!found) {
            System.out.println("The ticket with id " + id + " not found!");
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

    public void currentTicket() {
        if(head == null) {
            System.out.println("No Tickets found!");
        }

        if(current == null) {
            current = head;
        }

        System.out.println("==============================================================================");
        System.out.printf("%-10s %-15s %-15s %-15s %-10s\n", "Ticket Id", "Customer Name", "Movie Name", "Seat Number", "Booking Time");
        System.out.println("==============================================================================");
        display(current);
        System.out.println("==============================================================================");
        System.out.println();
        current = current.next;
    }

    public void searchByCustomerOrMovieName(String keyword) {
        if(head == null) {
            System.out.println("No Tickets found!");
        }

        System.out.println("==============================================================================");
        System.out.printf("%-10s %-15s %-15s %-15s %-10s\n", "Ticket Id", "Customer Name", "Movie Name", "Seat Number", "Booking Time");
        System.out.println("==============================================================================");
        TicketNode temp = head;
        do {
            if(temp.customerName.equalsIgnoreCase(keyword) || temp.movieName.equalsIgnoreCase(keyword)) {
                display(temp);
            }
            temp = temp.next;
        }
        while (temp != head);
        System.out.println("==============================================================================");
        System.out.println();
    }

    public void totalTicketBooked (){
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        }
        while (temp != head);

        if(count == 0) {
            System.out.println("No Tickets Booked!");
        }
        else {
            System.out.println(count + " ticket(s) has been booked!");
        }
    }

    public void display (TicketNode ticket){
        System.out.printf("%-10d %-15s %-15s %-15d %-10s\n", ticket.ticketId, ticket.customerName, ticket.movieName, ticket.seatNumber, ticket.bookingTime);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tickets found!.");
            return;
        }

        TicketNode temp = head;

        System.out.println("==============================================================================");
        System.out.printf("%-10s %-15s %-15s %-15s %-10s\n", "Ticket Id", "Customer Name", "Movie Name", "Seat Number", "Booking Time");
        System.out.println("==============================================================================");
        do {
            display(temp);
            temp = temp.next;
        }
        while (temp != head);
        System.out.println("==============================================================================");
        System.out.println();
    }
}

public class OnlineTicketReservationSystem {
    public static void main(String[] args) {
        Ticket ticketList = new Ticket();

        ticketList.addTicket(101, "Alice", "Avengers", 12, "2025-04-15 18:00");
        ticketList.addTicket(102, "Bob", "Avengers", 13, "2025-04-15 18:00");
        ticketList.addTicket(103, "Charlie", "Inception", 5, "2025-04-16 20:30");
        ticketList.addTicket(104, "David", "Interstellar", 8, "2025-04-17 21:00");

        System.out.println("All Booked Tickets:");
        ticketList.displayAll();

        System.out.println("Viewing tickets one by one:");
        ticketList.currentTicket();
        ticketList.currentTicket();
        ticketList.currentTicket();
        ticketList.currentTicket();
        ticketList.currentTicket();

        System.out.println("Searching by customer/movie name 'Avengers':");
        ticketList.searchByCustomerOrMovieName("Avengers");

        System.out.println("Searching by customer/movie name 'Charlie':");
        ticketList.searchByCustomerOrMovieName("Charlie");

        ticketList.totalTicketBooked();

        System.out.println("Removing ticket with ID 102...");
        ticketList.removeId(102);
        ticketList.displayAll();

        ticketList.totalTicketBooked();

        System.out.println("Removing ticket with ID 999...");
        ticketList.removeId(999);
    }
}