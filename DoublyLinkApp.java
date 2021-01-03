/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wolverine
 */
//hello
class Link2 {

    int key;
    Link2 prev = null;
    Link2 next = null;

    Link2(int key) {
        this.key = key;
    }
}

class LinkList1 {

    Link2 first = null;
    Link2 last = null;
    int count = 0;

    public void insert(int key) {
        Link2 newLink = new Link2(key);
        if (first == null) {
            first = newLink;
            last = newLink;

        } else {
            last.next = newLink;
            newLink.prev = last;
            last = newLink;
        }
        count++;
    }

    public void insertFirst(int key) {
        Link2 newLink = new Link2(key);
        if (first == null) {
            first = newLink;
            last = newLink;
        } else {
            first.prev = newLink;
            newLink.next = first;
            first = newLink;
        }
        count++;
    }

    public void insertAfter(int key, int insertAfter) {
        Link2 newLink = new Link2(key);
        if (first == null) {
            System.out.println("No Elements Exist in List");
            return;
        }
        if (first.key == key) {
            this.insertFirst(key);
        } else if (last.key == key) {
            this.insert(key);
        } else {
            Link2 temp = first.next;
            while (temp.next != null && key != temp.key) {
                temp = temp.next;
            }

            if (key == temp.key) {
                newLink.prev = temp;
                newLink.next = temp.next;
                temp.next.prev = newLink;
                temp.next = newLink;
            } else {
                System.out.println("Nubmer not found");
            }
        }
        count++;
    }

    public void insertAtIndex(int index, int key) {
        Link2 newLink = new Link2(key);
        if (first == null) {
            System.out.println("No Elements Exist in List");
            return;
        }
        if (index == 0) {
            this.insertFirst(key);
        } else if (index == count) {
            this.insert(key);
        } else {
            Link2 temp = getLinkAtIndex(index);
            if (temp != null) {
                newLink.prev = temp.prev;
                newLink.next = temp;
                temp.prev.next = newLink;
                temp.prev = newLink;
            } else {
                System.out.println("Index not Found/Invalid Index");
                return;
            }
        }
        count++;
    }

    public Link2 getLinkAtIndex(int index) {
        if (first == null) {
            return null;
        }
        Link2 temp = first;
        int i = 0;
        while (temp != null) {
            if (i++ == index) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public int deleteFirst() {
        if (first == null) {
            return -1;
        }
        int key = first.key;
        first = first.next;
        first.prev = null;
        return key;
    }

    public int deleteLast() {
        if (last == null) {
            return -1;
        }
        int key = last.key;
        last = last.prev;
        last.next = null;
        return key;
    }

    public boolean delete(int key) {
        if (first == null) {
            return false;
        }
        if (first.key == key) {
            first = first.next;
            first.prev = null;
            return true;
        }
        if (last.key == key) {
            last = last.prev;
            last.next = null;
            return true;
        }
        Link2 temp = first.next;
        while (temp.next != null && key != temp.key) {
            temp = temp.next;
        }
        if (key == temp.key) {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            return true;
        }
        return false;
    }

    public void displayForward() {
        Link2 temp = first;
        System.out.println("Display Forward: ");
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Link2 temp = last;
        System.out.println("Display Backward: ");
        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

public class DoublyLinkApp {

    public static void main(String args[]) {
        LinkList1 ll = new LinkList1();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);

        ll.displayForward();

//        ll.insertAtIndex(4, 4);
//        ll.displayForward();
//        ll.displayBackward();
//
//        System.out.println("After Insert First: ");
//        ll.insertFirst(4);
//        ll.displayForward();
//        ll.displayBackward();
//
        System.out.println("After Insert 2: ");
        ll.insertAfter(5, 2);
        ll.displayForward();
//        ll.displayBackward();

//        System.out.println("After Insert 10: ");
//        ll.insertAfter(6,2);
//        ll.displayForward();
//        ll.displayBackward();

        System.out.println("After Delete 2: ");
        ll.delete(2);
        ll.displayForward();

    }
}
