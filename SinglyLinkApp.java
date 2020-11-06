/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolverine
 */
class Link1 {

    int key;
    Link1 next = null;

    Link1(int key, Link1 next) {
        this.key = key;
        this.next = next;
    }
}

class LinkedList {

    Link1 first;

    LinkedList() {
        first = null;
    }

    public void insert(int key) {
        Link1 newLink = new Link1(key, null);
        if (first == null) {
            first = newLink;
        } else {
            Link1 temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newLink;
        }
    }

    public void insertFirst(int key) {
        Link1 newLink = new Link1(key, first);
        first = newLink;
    }

    public void insertAfter(int key, int insertAfter) {
        Link1 newLink = new Link1(key, null);
        if (size() == 0) {
            System.out.println("List is Empty");
            return;
        }
        Link1 temp = first;
        while (temp != null && temp.key != insertAfter) {
            temp = temp.next;
        }
        if (temp != null) {
            newLink.next = temp.next;
            temp.next = newLink;
        } else {
            System.out.println("Number not found");
        }
    }

    public void insertAtIndex(int key, int index) {
        if (index >= size()) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0) {
            this.insertFirst(key);
            return;
        }
        Link1 temp = first.next;
        Link1 prev = first;
        for (int i = 1; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }

        Link1 newLink = new Link1(key, temp);
        prev.next = newLink;
    }

    public void deleteFirst() {
        if (first != null) {
            first = first.next;
        }
    }

    public void deleteLast() {
        Link1 temp = first;
        if (temp == null || temp.next == null) {
            first = null;
            return;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void delete(int key) {
        Link1 temp = first;
        if (size() == 0) {
            System.out.println("List is Empty");
            return;
        }
        if (first.key == key) {
            first = first.next;
            return;
        }
        Link1 prev = temp;
        while (temp != null && temp.key != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) {
            prev.next = temp.next;
        } else {
            prev.next = null;
        }
    }

    public void deleteAtIndex(int index) {
        if (index >= size()) {
            System.out.println("Invalid Index");
            return;
        }
        if (index == 0) {
            this.deleteFirst();
            return;
        }

        Link1 temp = first.next;
        Link1 prev = first;

        for (int i = 1; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }

    public void display() {
        Link1 temp = first;

        if (size() == 0) {
            System.out.println("List is Empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverse() {
        Link1 prev = null;
        Link1 current = first;
        Link1 next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        first = prev;
    }

    public void reverseGroup(int k) {
        if (k > size()) {
            System.out.println("K is greater than size of linked list");
            return;
        }
        Link1 prev = null;
        Link1 current = first;
        Link1 next;
        int i = 0;
        while (current != null && i<k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        first.next = current;
        first = prev;
    }

    public void reverseRecur() {
        first = this.reverse(first);
    }

    public Link1 reverse(Link1 current) {
        if (current == null || current.next == null) {
            return current;
        }
        Link1 a = this.reverse(current.next);
        current.next.next = current;

        current.next = null;
        return a;
    }

    public int size() {
        Link1 temp = first;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void countingOff(int count) {
        Link1 temp = first;
        Link1 prev = first;
        int size = this.size();
        System.out.println("Counting off: ");
        for (int j = size; j > 0; j -= count) {
            for (int i = 0; i < count; i++) {
                prev = temp;
                if (temp.next == null) {
                    temp = first;
                } else {
                    temp = temp.next;
                }
            }
            System.out.print(temp.key + " ");
            if (temp == first) {
                first = first.next;
            }
            prev.next = temp.next;
        }
    }

    public void clear() {
        first = null;
    }
}

public class SinglyLinkApp {

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insert(6);

        
//        ll.reverseGroup(3);
        ll.display();
//
//        System.out.println("After Insert First");
//        ll.insertFirst(4);
//        ll.display();
//
//        System.out.println("After Insert After 2");
//        ll.insertAfter(5, 2);
//        ll.display();
//
//        System.out.println("After Insert At 0");
//        ll.insertAtIndex(6, 0);
//        ll.display();
//
//        System.out.println("After Insert At 6");
//        ll.insertAtIndex(7, 6);
//        ll.display();
//        System.out.println("Reverse: ");
//        ll.reverse();
//        ll.display();
//
//        System.out.println("ReverseRecur: ");
//        ll.reverseRecur();
//        ll.display();

//        ll.insertAfter(5, 10);
//        ll.display();
//
//        System.out.println("Delete First");
//        ll.deleteFirst();
//        ll.display();
//
//        System.out.println("Delete Last");
//        ll.deleteLast();
//        ll.display();
//
//        System.out.println("Delete 3");
//        ll.delete(3);
//        ll.display();
//
//        System.out.println("Delete At 1");
//        ll.deleteAtIndex(1);
//        ll.display();
//
//        System.out.println("Clearing Linked List");
//        ll.clear();
//        ll.display();
//        ll.countingOff(2);
    }
}
