public class MyLinkedList {
    int size;
    Node head;

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        public static Node nonTrivialNode(int val) {
            Node node = new Node(val);
            node.next = new Node(123456);
            return node;
        }
    }

    public MyLinkedList() {
        size = 0;
        head = new Node(123456);
    }

    public int get(int index) {
        Node curNode = head;
        if (index >= size) {
            return -1;
        }
        for (int i = 1; i <= index; i++) {
            curNode = curNode.next;
        }
        return curNode.val;
    }

    private Node getNode(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }

        Node curNode = head;
        for (int i = 1; i <= index; i++) {
            curNode = curNode.next;
        }
        return curNode;

    }

    public void addAtHead(int val) {
        Node newHead = new Node(val);
        newHead.next = head;
        head = newHead;
        size++;
    }

    public void addAtTail(int val) {
        Node newTail = Node.nonTrivialNode(val);
        // add dummy node whenever tail has changed
        if (size == 0) {
            addAtHead(val);
        } else {
            getNode(size - 1).next = newTail;
            size++;
        }
    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else {
            Node newMiddle = Node.nonTrivialNode(val);
            newMiddle.next = getNode(index);
            getNode(index - 1).next = newMiddle;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return;
        }
        // index == 0
        if (size == 1) {
            head = new Node(123456);
            size--;
        } else if (index == 0) {
            head = getNode(1);
            size--;
        } else if (index == size) {
            getNode(size - 1).next = new Node(123456);
            size--;
        } else {
            getNode(index - 1).next = getNode(index + 1);
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList holidays = new MyLinkedList();
        holidays.addAtHead(1);
        holidays.deleteAtIndex(0);
        holidays.addAtTail(2);
        holidays.get(0);

        System.out.println(holidays.get(0));
    }
}


