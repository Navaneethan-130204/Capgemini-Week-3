import java.util.Stack;

public class Queue {

    Stack<Integer> enqueueStack = new Stack<>();
    Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int value){
        enqueueStack.push(value);
        System.out.println(value + " is enqueued");
    }

    public void dequeue() {
        shiftStack();
        if(dequeueStack.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(dequeueStack.pop() + " is dequeued");
    }

    public void front() {
        shiftStack();
        if(dequeueStack.isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front: " + dequeueStack.peek());
    }

    public void shiftStack() {
        if(dequeueStack.isEmpty()){
            while (!enqueueStack.isEmpty()){
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.front();
        queue.dequeue();
        queue.front();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
