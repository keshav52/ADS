
class Link {

    int key;
    Link next;

    public Link(int key, Link next) {
        this.key = key;
        this.next = next;
    }
}

class LinkList {

    Link front;
    Link rear;
    int count = 0;

    public LinkList() {
        front = null;
        rear = null;
    }

    public void enqueue(int key) {
        Link newLink = new Link(key, null);

        if (front == null) {
            front = newLink;
            rear = newLink;
        } else {
            rear.next = newLink;
            rear = newLink;
        }
        count++;
    }

    public int dequeue() {
        if (front == null) {
            return -1;
        } else {
            int key = front.key;
            front = front.next;
            return key;
        }
    }

    public void display() {
        Link temp = front;

        while (temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
    }
    
    public myQueue toArray()
    {
        Link temp = front;
        myQueue q = new myQueue(count);
        while (temp != null) {
            q.enqueue(temp.key);
            temp = temp.next;
        }
        
        return q;
    }
}

class myQueue {

    int[] arr;
    int size;
    int count = 0;
    int front, rear;

    myQueue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    public void enqueue(int key) {
        if (isFull()) {
            System.out.println("Overflow2");
        } else {
            arr[rear] = key;
            rear = (rear + 1) % size;
            count++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            return -1;
        } else {
            int key = arr[front];
            front = (front + 1) % size;
            count--;
            return key;
        }
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void display() {
        for (int i = 0, j = front; i < count; i++, j = (j + 1) % size) {
            System.out.print(arr[j] + " ");
        }
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        int key = this.dequeue();

        this.reverse();

        this.enqueue(key);
    }

    public LinkList toLinkList() {
        LinkList temp = new LinkList();
        for (int i = 0, j = front; i < count; i++, j = (j + 1) % size)
            temp.enqueue(arr[j]);
        
        return temp;
    }
}

public class QueueApp {

    public static void main(String args[]) {
        myQueue q = new myQueue(10);
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
        q.enqueue(20);

        q.display();

        System.out.println();
        q.reverse();
        q.display();
        
        LinkList LinkedQueue = q.toLinkList();
        
        System.out.println();
        LinkedQueue.display();
        
        q = LinkedQueue.toArray();
        
        System.out.println();
        q.display();
        
    }
}
