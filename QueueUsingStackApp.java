/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolverine
 */
class myQueue1 {
    
    myStack s1;
    myStack s2;
    int size;
    int count = 0;
    
    myQueue1(int size) {
        this.size = size;
        this.s1 = new myStack(size);
        this.s2 = new myStack(size);
    }
    
    public void enqueue(int key) {
        if (isFull()) {
            System.out.println("Overflow");
        } else {
            s1.push(key);
            count++;
        }
    }
    
    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        count--;
        return s2.pop();
    }
    
    private boolean isFull() {
        return count == size;
    }
    
    public void display() {
        for (int i = s2.top; i >= 0; i--) {
            System.out.print(s2.arr[i] + " ");
        }
        s1.display();
    }
    
}

public class QueueUsingStackApp {
    
    public static void main(String args[]) {
        myQueue1 q = new myQueue1(10);
        q.dequeue();
        q.enqueue(0);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.enqueue(70);
        q.enqueue(80);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(0);
        q.enqueue(10);
        
        q.display();
    }
}
