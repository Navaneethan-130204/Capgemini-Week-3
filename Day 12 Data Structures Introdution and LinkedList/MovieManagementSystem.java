import jdk.jshell.execution.JdiDefaultExecutionControl;

class MovieNode {

    String movieTitle;
    String director;
    int year;
    double rating;
    MovieNode next, prev;

    public MovieNode(String movieTitle, String director, int year, double rating) {
        this.movieTitle = movieTitle;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

class Movie {

    MovieNode head;

    public void addBeg(String movieTitle, String director, int year, double rating) {

        MovieNode movie = new MovieNode(movieTitle, director, year, rating);
        if(head == null) {
            head = movie;
            return;
        }

        if(head.next == null){
            movie.next = head;
            head.prev = movie;
        }
        head = movie;
    }

    public void addEnd(String movieTitle, String director, int year, double rating) {

        MovieNode movie = new MovieNode(movieTitle, director, year, rating);
        if(head == null) {
            head = movie;
            return;
        }

        MovieNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = movie;
        movie.prev = temp;
    }

    public void addPos(String movieTitle, String director, int year, double rating, int pos){

        MovieNode movie = new MovieNode(movieTitle, director, year, rating);
        if(head == null) {
            head = movie;
            return;
        }

        if(pos == 1) {
            addBeg(movieTitle, director, year, rating);
            return;
        }

        MovieNode temp = head;
        for(int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        if(head.next == null) {
            addEnd(movieTitle, director, year, rating);
        }
        else {
            movie.next = temp.next;
            movie.prev = temp;
            temp.next.prev = movie;
            temp.next = movie;
        }
    }

    public void removeByTile(String movieTitle) {
        if(head == null) {
            System.out.println("Record is empty!");
            return;
        }

        if(head.next == null && head.movieTitle.equalsIgnoreCase(movieTitle)) {
            System.out.println("Record Not found!");
            return;
        }

        MovieNode temp = head;
        while (temp != null) {
            if(temp.movieTitle.equalsIgnoreCase(movieTitle)) {
                if(temp.next == null){
                    temp.prev.next = temp.next;
                }
                if(temp.prev == null) {
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByDirector(String director) {
        if(head == null) {
            System.out.println("Record is empty!");
            return;
        }

        if(head.next == null && !head.director.equalsIgnoreCase(director)) {
            System.out.println("Record Not found!");
            return;
        }

        MovieNode temp = head;
        System.out.println("========================================================");
        System.out.printf("%-15s %-20s %-7s %-5s\n", "Movie Title", "Director", "Year", "Rating");
        System.out.println("========================================================");
        while (temp != null) {
            if(temp.director.equalsIgnoreCase(director)) {
                display(temp);
            }
            temp = temp.next;
        }
        System.out.println("========================================================");
    }

    public void searchByRating(double rating) {
        if(head == null) {
            System.out.println("Record is empty!");
            return;
        }

        if(head.next == null && !(head.rating == rating)) {
            System.out.println("Record Not found!");
            return;
        }

        MovieNode temp = head;
        System.out.println("========================================================");
        System.out.printf("%-15s %-20s %-7s %-5s\n", "Movie Title", "Director", "Year", "Rating");
        System.out.println("========================================================");
        while (temp.next != null) {
            if(temp.rating == rating) {
                display(temp);
            }
            temp = temp.next;
        }
        System.out.println("========================================================");
    }

    public void updateMovieRating(String movieTitle, double newRating) {
        if(head == null) {
            System.out.println("Record is empty!");
            return;
        }

        if(head.next == null && !head.movieTitle.equalsIgnoreCase(movieTitle) ) {
            System.out.println("Record Not found!");
            return;
        }

        MovieNode temp = head;
        while (temp.next != null) {
            if(temp.movieTitle.equalsIgnoreCase(movieTitle)) {
                temp.rating = newRating;
            }
            temp = temp.next;
        }

    }

    public void display (MovieNode movie){
        System.out.printf("%-15s %-20s %-7d %-5.2f\n", movie.movieTitle, movie.director, movie.year, movie.rating );
    }

    public void displayAllForward() {
        if (head == null) {
            System.out.println("No Movie Records found!.");
            return;
        }

        MovieNode temp = head;

        System.out.println("========================================================");
        System.out.printf("%-15s %-20s %-7s %-5s\n", "Movie Title", "Director", "Year", "Rating");
        System.out.println("========================================================");
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
        System.out.println("========================================================");
    }

    public void displayAllBackward() {
        if (head == null) {
            System.out.println("No Movie Records found!.");
            return;
        }

        MovieNode temp = head;

        System.out.println("========================================================");
        System.out.printf("%-15s %-20s %-7s %-5s\n", "Movie Title", "Director", "Year", "Rating");
        System.out.println("========================================================");
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null){
            display(temp);
            temp = temp.prev;
        }
        System.out.println("========================================================");
    }
}

public class MovieManagementSystem {

    public static void main(String[] args) {

        Movie movie = new Movie();

        movie.addBeg("Inception", "Christopher Nolan", 2010, 8.8);
        movie.addEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movie.addEnd("The Prestige", "Christopher Nolan", 2006, 8.5);
        movie.addPos("Dunkirk", "Christopher Nolan", 2017, 7.9, 2);

        System.out.println("Displaying all movies forward:");
        movie.displayAllForward();

        System.out.println("\nDisplaying all movies backward:");
        movie.displayAllBackward();

        System.out.println("\nSearching for movies by 'Christopher Nolan':");
        movie.searchByDirector("Christopher Nolan");

        System.out.println("\nSearching for movies with rating 8.6:");
        movie.searchByRating(8.6);

        System.out.println("\nUpdating rating of 'Interstellar' to 9.0");
        movie.updateMovieRating("Interstellar", 9.0);
        movie.displayAllForward();

        System.out.println("\nRemoving 'Dunkirk'");
        movie.removeByTile("Dunkirk");
        movie.displayAllForward();
    }
}