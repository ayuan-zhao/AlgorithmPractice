package practice;

public class LinkedListD {
//    static class,在class 里面
//    static方法一般没有 内部方法和class的关系那么紧密， static方法一般不是必须方法

    Node head;

    public LinkedListD insert(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node p = this.head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
        }
        return this;
    }

    public LinkedListD insertFirst(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
        return this;
    }

    public static LinkedListD reverse(LinkedListD listD) {
        if (listD.head == null) {
            return listD;
        }
        Node dummy = new Node(-1);
        Node p = listD.head;
        Node q = p.next;
        dummy.next = listD.head;
        while (q != null) {
            p.next = q.next;
            q.next = dummy.next;
            dummy.next = q;
            q = p.next;
        }
        listD.head = dummy.next;
        return listD;
    }

    public static void main(String[] args) {
        LinkedListD listD = new LinkedListD();
        printList(listD);
        listD.insert(3);
        printList(listD);
        listD.insert(4);
        printList(listD);
        listD.insert(5);
        printList(listD);
        listD.insert(6);
        printList(listD);
        listD.insertFirst(2);
        listD.insertFirst(1);
        printList(listD);

        LinkedListD reversed = reverse(listD);
        printList(reversed);
    }

    public static void printList(LinkedListD listD) {
        Node p = listD.head;
        while (p != null) {
            System.out.print(p.value + " -> ");
            p = p.next;
        }
        System.out.println("null");
    }

    public static class Node {
        int value;
        Node next;
        public Node(int val) {
            this.value = val;
        }
    }
}



