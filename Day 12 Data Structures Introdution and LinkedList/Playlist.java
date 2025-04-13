
class SongNode{
    String songName;
    String artist;
    double duration;
    SongNode next;

    public SongNode(String songName, String artist, double duration){
        this.songName = songName;
        this.artist = artist;
        this.duration = duration;
        this.next = null;
    }
}

class Song{

    SongNode head;

    public void addStart(String songName, String artist, double duration) {
        SongNode newSong = new SongNode(songName, artist, duration);
        newSong.next = head;
        head = newSong;
    }

    public void addEnd(String songName, String artist, double duration) {
        SongNode newSong = new SongNode(songName, artist, duration);
        SongNode temp = head;
        if(head == null) {
            head = newSong;
            return;
        }

        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = newSong;
    }

    public void addPos(String songName, String artist, double duration, int pos) {
        SongNode newSong = new SongNode(songName, artist, duration);
        SongNode temp = head;
        for(int i = 0; temp != null && i < pos-1; i++){
            temp = temp.next;
        }
        newSong.next = temp.next;
        temp.next = newSong;
    }

    public void deleteFirst() {
        SongNode temp = head;
        head = head.next;
        temp.next = null;
    }

    public void deleteEnd() {
        SongNode temp = head;

        if(head == null) {
            System.out.println("PlayList is empty!");
        }

        if(head.next == null){
            head.next = null;
        }

        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deletePos(int pos) {
        SongNode temp = head;
        for(int i = 0; temp != null & i < pos-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void display(SongNode song) {
        System.out.printf("%-15s %-15s %-10.2f\n", song.songName, song.artist, song.duration);
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No Songs Found!.");
            return;
        }
        SongNode temp = head;
        System.out.println("=================================================");
        System.out.printf("%-15s %-15s %-10s\n", "Song Name", "Artist", "Duration");
        System.out.println("=================================================");
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
        System.out.println("=================================================");
    }
}

public class Playlist {
    public static void main(String[] args) {
        Song song = new Song();
        song.addEnd("Faded", "Alan Walker", 5.2);
        song.addStart("Be Free", "Vidya Vox", 3.58);
        song.addPos("Wolves", "Selena Gomez", 4.32, 1);
        song.displayAll();
    }
}
