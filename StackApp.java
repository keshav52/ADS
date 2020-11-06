/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolverine
 */
class Link3 {

    int key;
    Link3 next;

    Link3(int key, Link3 next) {
        this.key = key;
        this.next = next;
    }

    Link3(int key) {
        this.key = key;
    }
}

class LinkedStack {

    Link3 top = null;

    public void push(int key) {
        Link3 newLink = new Link3(key, top);
        top = newLink;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        int key = top.key;
        top = top.next;
        return key;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        Link3 temp = top;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void display() {
        display(top);
    }

    private void display(Link3 temp) {
        if (temp == null) {
            return;
        }
        display(temp.next);
        System.out.print(temp.key + " ");
    }

    public myStack toArray() {
        myStack stack = new myStack(size());
        stack = pushToArray(stack, top);
        return stack;
    }

    private myStack pushToArray(myStack stack, Link3 temp) {
        if (temp == null) {
            return stack;
        }
        pushToArray(stack, temp.next);
        stack.push(temp.key);
        return stack;
    }
}

class myStack {

    int[] arr;
    int top = -1;
    int size;

    myStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int key) {
        if (isFull()) {
            System.out.println("Overflow");
        } else {
            arr[++top] = key;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[top--];
        }
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public void display() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        int key = this.pop();

        this.reverse();

        this.insertLast(key);
    }

    private void insertLast(int key) {
        if (this.isEmpty()) {
            this.push(key);
            return;
        }

        int topE = this.pop();

        this.insertLast(key);

        this.push(topE);
    }

    public LinkedStack toLinkedList() {
        LinkedStack ll = new LinkedStack();
        for (int i = 0; i <= top; i++) {
            ll.push(arr[i]);
        }
        return ll;
    }
}

public class StackApp {

    public static void main(String args[]) {
        myStack s = new myStack(10);
        s.push(0);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.push(60);

        s.display();

        System.out.println("");
        s.reverse();
        s.display();
        
        LinkedStack ll = s.toLinkedList();
        ll.push(100);
        ll.pop();
        ll.pop();
       
        System.out.println("");
        ll.display();
        
        s = ll.toArray();
        s.reverse();
        System.out.println("");
        s.display();
        
    }

}
