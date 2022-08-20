import java.util.ArrayList;
import java.util.Scanner;

public class LinkedList {

    class Node {
        char data;
        Node previous;
        Node next;

        public Node(char data) {
            this.data = data;
        }
    }


    Node head, tail = null;

    public void addAtEnd(String sen) {

        for (int i = 0; i < sen.length(); i++) {
            Node newNode = new Node(sen.charAt(i));
            if (head == null) {
                head = tail = newNode;
                head.previous = null;
                tail.next = null;
            }
            else {
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
                tail.next = null;
            }
        }
    }

    public void display() {
        int leftCount = 0;
        int rightCount = 0;
        ArrayList leftArray = new ArrayList();
        ArrayList rightArray = new ArrayList();
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            if (current.data == ':' || current.data == ' ') {
                Node right = current.next;
                while (right != null) {
                    rightCount++;
                    rightArray.add(right.data);
                    right = right.next;
                }
                break;
            }
            leftCount++;
            leftArray.add(current.data);
            current = current.next;
        }

        System.out.println(leftCount);
        System.out.println(leftArray);
        System.out.println(rightCount);
        System.out.println(rightArray);

        int flag = 0;
        if (leftArray.size() > rightArray.size()) {
            System.out.println(" L");
        } else if (rightArray.size() > leftArray.size()) {
            System.out.println(" R");
        } else if (rightArray.size() == leftArray.size()) {
            for (int i = 1; i <= leftCount; i++) {
                if (leftArray.indexOf(i) == rightArray.indexOf(leftCount - i)) {
                    flag++;
                }
            }
            if (flag == leftCount) {
                System.out.println("M");
            } else {
                for (int i = 0; i < leftCount; i++) {
                    if (leftArray.indexOf(i) == rightArray.indexOf(i)) {
                        flag++;
                    }
                }
                if (flag == leftCount) {
                    System.out.println("S");
                } else
                    System.out.println("D");
            }


        }


    }

    public static void main(String[] args) {
        System.out.println("enter the sentence");
        Scanner sc = new Scanner(System.in);
        String sentence = sc.next();
        LinkedList dlist = new LinkedList();
        dlist.addAtEnd(sentence);
        dlist.display();


    }

}
