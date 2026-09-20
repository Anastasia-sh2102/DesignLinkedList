public class DesignLinkedList {
    class MyLinkedList {
        int size;
        Node head;

        class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
                this.next = null;
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
            Node newTail = new Node(val);
            if (size == 0) {
                addAtHead(val);
            } else {
                getNode(size - 1).next = newTail;
                size++;
            }
        }

        public void addAtIndex(int index, int val) {

            if (index < 0 || index > size) {
                return;
            }
            if (index == size) {
                addAtTail(val);
            }

            if (index < size) {
                Node newMiddle = new Node(val);
                getNode(index - 1).next = newMiddle;
                newMiddle.next = getNode(index + 1);
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if (size == 0 || index < 0 || index >= size) {
                return;
            }
            if (size == 1) {
                head = new Node(123456);
                size --;
            } else {
                getNode(index - 1).next = getNode(index + 1);
                size--;
            }
        }
    }

    public static void main(String[] args) {
        DesignLinkedList iWantABreak = new DesignLinkedList();
        MyLinkedList linkedList = new iWantABreak.MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(0);
        linkedList.addAtTail(2);
        System.out.println(linkedList.get(0));
    }
}
