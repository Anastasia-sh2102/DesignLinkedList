public class DesignLinkedList {
    static class MyLinkedList {
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
            if (0 <= index && index < size) {
                curNode = curNode.next;
                return curNode.val;
            }
            return -1;
        }

        private Node getNode(int index) {
            if (size == 0 || index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("invalid index");
            }

            Node curNode = head;
            for (int i = 0; i <= index; i++) {
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
            getNode(size - 1).next = newTail;
            size++;
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
}
