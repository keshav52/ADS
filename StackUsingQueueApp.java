/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolverine
 */
class myStack1 {

    myQueue q1, q2;
    int size;
    int count = 0;

    myStack1(int size) {
        q1 = new myQueue(size);
        q2 = new myQueue(size);
        this.size = size;
    }

    public void push(int key) {
        if (isFull()) {
            System.out.println("Overflow1");
        } else {
            q1.enqueue(key);
            count++;
        }
    }

    public int pop() {
        if (q1.isEmpty()) {
            return -1;
        }
        while (q1.count != 1) {
            q2.enqueue(q1.dequeue());
        }
        int key = q1.dequeue();
        count--;

        myQueue temp = q1;
        q1 = q2;
        q2 = temp;
        return key;
    }

    public void display() {
        q1.display();
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }
}

public class StackUsingQueueApp {

    public static void main(String args[]) {
        myStack1 s = new myStack1(10);
        s.push(0);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);
//        s.pop();
        s.display();
        System.out.println("DELETED: " + s.pop());
        System.out.println("DELETED: " + s.pop());
        
        s.display();

    }
}
