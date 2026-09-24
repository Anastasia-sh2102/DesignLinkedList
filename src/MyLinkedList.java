import java.util.Arrays;

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

        private static Node nonTrivialNode(int val) {
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

    private void printValues() {
        for (int nodeNumber = 0; nodeNumber < size; nodeNumber++) {
            System.out.print(get(nodeNumber) + "->");
        }
        System.out.println();
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

    public void cook(String operation, int[] parameterGroup) {
        switch (operation) {
            case "get":
                get(parameterGroup[0]);
                break;

                case "printValues":
                    printValues();
                    break;

            case "addAtHead":
                addAtHead(parameterGroup[0]);
                break;

                case "addAtTail":
                    addAtTail(parameterGroup[0]);
                    break;

                case "addAtIndex":
                    addAtIndex(parameterGroup[0], parameterGroup[1]);
                    break;

                    case "deleteAtIndex":
                        deleteAtIndex(parameterGroup[0]);
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid operation");
        }
    }

    public static void main(String[] args) {
        MyLinkedList cooked = new MyLinkedList();
        String[] operations = new String[]{"addAtHead","addAtHead","addAtTail","addAtHead","get","deleteAtIndex","get","deleteAtIndex","addAtHead","addAtIndex","addAtIndex","addAtHead","addAtTail","addAtHead","addAtTail","addAtTail","addAtTail","addAtTail","get","get","addAtHead","addAtTail","addAtIndex","addAtHead","get","addAtHead","addAtTail","addAtTail","addAtHead","addAtHead","get","addAtHead","addAtTail","addAtHead","get","deleteAtIndex","addAtIndex","addAtTail","deleteAtIndex","addAtTail","addAtHead","addAtTail","deleteAtIndex","addAtTail","addAtHead","addAtTail","get","addAtIndex","get","get","addAtTail","addAtTail","deleteAtIndex","addAtTail","addAtIndex","addAtTail","addAtHead","addAtTail","addAtTail","addAtTail","addAtHead","addAtHead","addAtHead","get","addAtTail","addAtIndex","addAtIndex","addAtIndex","addAtIndex","deleteAtIndex","deleteAtIndex","addAtIndex","addAtIndex","addAtTail","deleteAtIndex","addAtIndex","addAtIndex","addAtIndex","get","addAtTail","addAtTail","deleteAtIndex","addAtHead","get","deleteAtIndex","addAtHead","addAtHead","addAtTail","addAtTail","addAtTail","addAtHead","addAtHead","addAtHead","addAtTail","addAtHead","addAtTail","addAtHead","get","get","addAtHead","deleteAtIndex"};
        int[][] parameterGroups = {{36},{62},{38},{71},{4},{2},{2},{0},{48},{3,79},{3,71},{61},{36},{66},{52},{92},{94},{3},{11},{8},{51},{93},{5,18},{76},{8},{44},{47},{54},{15},{74},{5},{94},{16},{90},{3},{2},{4,59},{25},{5},{7},{71},{91},{24},{70},{61},{58},{22},{18,81},{9},{2},{50},{12},{21},{63},{28,82},{58},{96},{74},{37},{70},{93},{72},{5},{36},{99},{9,93},{1,8},{29,95},{5,73},{20},{1},{2,73},{34,86},{70},{47},{33,13},{6,99},{22,11},{50},{55},{92},{35},{13},{18},{0},{78},{43},{2},{58},{96},{23},{93},{6},{90},{97},{53},{7},{43},{33},{95},{63}};
        for (int stepNum = 0; stepNum < parameterGroups.length; stepNum++) {
            cooked.printValues();
            System.out.println("step" + stepNum + ": " + operations[stepNum] + Arrays.toString(parameterGroups[stepNum]));
            cooked.cook(operations[stepNum], parameterGroups[stepNum]);
        }
        System.out.println(cooked.size);
    }
}


