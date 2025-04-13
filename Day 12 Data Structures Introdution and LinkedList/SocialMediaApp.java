import java.util.ArrayList;

class UserNode{
    String userId;
    String name;
    int age;
    ArrayList<String> friends;
    UserNode next;

    public UserNode (String userId, String name, int age){
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    UserNode head;

    public void addUser(String userId, String name, int age){
        UserNode user = new UserNode(userId, name, age);
        user.next = head;
        head = user;
    }

    public UserNode findUserById(String userId) {
        UserNode temp = head;
        while (temp != null){
            if(temp.userId.equals(userId)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void addFriend(String userId1, String userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 != null && user2 != null && !user1.friends.contains(userId2)){
           user1.friends.add(userId2);
           user2.friends.add(userId1);
        }
    }

    public void removeFriend(String userId1, String userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if (user1 != null && user2 != null) {
            user1.friends.remove(userId2);
            user2.friends.remove(userId1);
        }
    }

    public void displayFriends(String userId){
        UserNode user = findUserById(userId);
        if(user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println("The friends of " + user.name + " are:");
        for (String id : user.friends){
            UserNode friend = findUserById(id);
            if(friend != null) {
                System.out.println(" -" + friend.name + " (" + friend.userId + ")");
            }
        }
    }

    public void mutualFriends(String userId1, String userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);
        if(user1 == null || user2 == null){
            System.out.println("User not found!");
            return;
        }

        System.out.println("Mutual friends of " + user1.name + " and " + user2.name + ":");
        for (String id : user1.friends){
            if(user2.friends.contains(id)){
                UserNode mutual = findUserById(id);
                if(mutual != null) {
                    System.out.println(" -" + mutual.name + "(" + mutual.userId + ")");
                }
            }
        }
    }

    public void searchUser(String keyword) {
        UserNode temp = head;
        boolean found = false;
        while (temp != null) {
            if(temp.name.equalsIgnoreCase(keyword) || temp.userId.equalsIgnoreCase(keyword)) {
                System.out.println("User found: " + temp.name + " (" + temp.userId + "), Age: " + temp.age);
                found = true;
                break;
            }
            temp = temp.next;
        }
        if(!found) {
            System.out.println("User not found!");
        }
    }

    public void countFriends() {
        UserNode temp = head;
        System.out.println("Friends Count: ");
        while (temp != null) {
            System.out.println(temp.name + " (" + temp.userId + ")" + " has " + temp.friends.size() + " friends.");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        UserNode temp = head;
        System.out.println("All Users:");
        while (temp.next != null) {
            System.out.println("- " + temp.name + " (" + temp.userId + "), Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser("U1", "Alice", 25);
        sm.addUser("U2", "Bob", 30);
        sm.addUser("U3", "Charlie", 22);
        sm.addUser("U4", "David", 27);

        sm.addFriend("U1", "U2");
        sm.addFriend("U1", "U3");
        sm.addFriend("U2", "U3");
        sm.addFriend("U4", "U1");

        sm.displayAllUsers();

        System.out.println("\nFriend List:");
        sm.displayFriends("U1");

        System.out.println("\nMutual Friends:");
        sm.mutualFriends("U1", "U2");

        System.out.println("\nSearch:");
        sm.searchUser("Charlie");

        System.out.println("\nFriend Count:");
        sm.countFriends();

        System.out.println("\nRemoving friend U1 <-> U2");
        sm.removeFriend("U1", "U2");

        sm.displayFriends("U1");
        sm.displayFriends("U2");
    }
}
