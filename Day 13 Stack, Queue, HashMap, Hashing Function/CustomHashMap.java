class Node {
     int key;
     int value;
     Node next;

     public Node(int key, int value) {
         this.key = key;
         this.value = value;
         this.next = null;
     }
}

class CustomHashMap {

    private Node[] map;
    int capacity;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        map = new Node[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(map[index] == null) {
            map[index] = newNode;
        }
        else {
            Node current = map[index];
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            newNode.next = map[index];
            map[index] = newNode;
        }
    }

    public int get(int key) {
        int index = hash(key);
        Node current = map[index];

        while (current != null) {
            if(current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {

        int index = hash(key);
        Node current = map[index];
        Node previous = null;

        while (current != null) {
            if(current.key == key) {
                if(previous == null) {
                    map[index] = current.next;
                }
                else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap(10);

        map.put(1, 100);
        map.put(2, 200);
        map.put(11, 300);

        System.out.println("Value for key 1: " + map.get(1));
        System.out.println("Value for key 2: " + map.get(2));
        System.out.println("Value for key 11: " + map.get(11));

        map.put(1, 150);
        System.out.println("Updated value for key 1: " + map.get(1));

        map.remove(2);
        System.out.println("Value for key 2 after removal: " + map.get(2));
    }
}
