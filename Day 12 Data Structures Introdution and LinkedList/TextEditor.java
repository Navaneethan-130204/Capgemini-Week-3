class TextNode{

    String text;
    TextNode next, prev;

    public TextNode(String text) {
        this.text = text;
        this.next = this.prev = null;
    }
}

class Text{

    TextNode head, current;
    int size = 0;
    final int limit = 0;

    public void addText(String text){

        TextNode words = new TextNode(text);
        if(head == null) {
            head = current = words;
            size = 1;
            return;
        }

        current.next = null;
        current.next = words;
        words.prev = current;
        current = words;
        size++;

        if(size > limit) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo(){
        if(current == null || current.prev == null){
            System.out.println("Nothing to Undo!");
            return;
        }
        current = current.prev;
    }

    public void redo(){
        if(current == null || current.next == null) {
            System.out.println("Nothing to Redo!");
            return;
        }
        current = current.next;
    }

    public void show (){
        if(current == null) {
            System.out.println("Text is empty!");
        }
        else {
            System.out.println("Current text: " + current.text);
        }
    }
}

public class TextEditor {

    public static void main(String[] args) {
        Text editor = new Text();

        editor.addText("Hello");
        editor.addText("Hello, World");
        editor.addText("Hello, Java!");

        editor.show();

        editor.undo();
        editor.show();

        editor.undo();
        editor.show();

        editor.redo();
        editor.show();

        editor.addText("Hello again!");
        editor.show();

        editor.redo();
        editor.undo();
        editor.show();
    }
}
