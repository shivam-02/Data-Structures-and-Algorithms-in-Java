public class LL {

    Node head, head2;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if (temp == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void insertAtPosition(int data, int pos) {
        Node temp = head;
        Node newNode = new Node(data);
        if (temp == null) {
            head = newNode;
        } else if (pos <= 1) {
            newNode.next = head;
            head = newNode;
        } else {
            int i = 1;
            Node prev = null;
            while (temp != null && i < pos) {
                prev = temp;
                temp = temp.next;
                i++;
            }
            prev.next = newNode;
            newNode.next = temp;
        }
    }

    public void append(int data) {
        Node temp = head;
        Node newNode = new Node(data);
        if (temp == null) {
            head = newNode;
        } else {
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
        System.out.print("\n");
    }

    public void delete(int key) {
        Node temp = head;
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node prev = null;
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    public void deleteAtPosition(int pos) {
        Node temp = head;
        if (pos <= 1) {
            head = head.next;
            return;
        }
        Node prev = null;
        int i = 1;
        while (temp != null && i < pos) {
            prev = temp;
            temp = temp.next;
            i++;
        }
        if (temp == null) return;
        prev.next = temp.next;
    }

    public void nNodeFromEnd(int n) {
        Node ref = head;
        Node main = head;
        if (n <= 0) {
            System.out.println("Give greater than 0 value");
            return;
        }
        int count = 0;
        if (head != null) {
            while (count < n) {
                if (ref == null) {
                    System.out.println(" n is greater than no. of nodes");
                    return;
                }
                ref = ref.next;
                count++;
            }
            while (ref != null) {
                main = main.next;
                ref = ref.next;
            }
            System.out.println(n + " th node from last is " + main.data);
        }
    }

    public void middleNode() {
        Node slow = head;
        Node fast = head;
        if (head != null) {
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            System.out.println("Middle node is " + slow.data);
        }
    }

    public void reverseUtil(Node curr, Node prev) {
        if (curr == null) return;
        if (curr.next == null) {
            head = curr;
        }
        Node next1 = curr.next;
        curr.next = prev;
        reverseUtil(next1, curr);
    }

    public void reverse() {
        if (head == null || head.next == null) return;
        Node prev = null;
        Node next;
        Node curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public boolean detectAndRemoveLoop() {
        Node fast = head;
        Node slow = head;
        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                countNodesInLoop(slow);
                removeLoop(slow);
                return true;
            }
        }
        return false;
    }

    public void removeLoop(Node loop) {
        Node slow = head;
        Node fast = loop;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    public void countNodesInLoop(Node loop) {
        int k = 1;
        Node slow = loop;
        Node fast = loop;
        while (slow.next != fast) {
            slow = slow.next;
            k++;
        }
        System.out.println("There are " + k + " nodes in the loop");
    }


    public void swapNode(int x, int y) {
        if (x == y || head == null) return;
        Node temp = head;
        Node prev = null;
        Node prevX = null;
        Node currX = null;
        Node prevY = null;
        Node currY = null;
        while (temp != null) {
            if (temp.data == x) {
                prevX = prev;
                currX = temp;
            }
            if (temp.data == y) {
                prevY = prev;
                currY = temp;
            }
            prev = temp;
            temp = temp.next;
        }

        if (currX == null || currY == null) return;
        if (prevX == null) {
            head = currY;
        } else {
            prevX.next = currY;
        }
        if (prevY == null) {
            head = currX;
        } else {
            prevY.next = currX;
        }

        Node next = currX.next;
        currX.next = currY.next;
        currY.next = next;
    }


    public void pairWiseSwap() {
        if (head == null || head.next == null) return;
        Node prev = head;
        Node curr = head.next;
        head = curr;
        while (true) {
            Node next = curr.next;
            curr.next = prev;
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }
            prev.next = next.next;

            prev = next;
            curr = prev.next;
        }
    }

    public Node pairWiseSwapRecursive(Node curr) {
        if (curr == null || curr.next == null) return curr;
        Node next2 = curr.next.next;
        curr.next.next = curr;
        Node newHead = curr.next;
        curr.next = pairWiseSwapRecursive(next2);
        return newHead;
    }

    public void segregateEvenOdd() {
        Node curr = head;
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
            curr = curr.next;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        head = evenStart;
    }


    public Node addTwoLists(Node a, Node b) {
        int sum = 0;
        int carry = 0;
        Node res = null;
        Node prev = null;
        while (a != null || b != null) {

            sum = (a != null ? a.data : 0) + (b != null ? b.data : 0) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;

            Node n = new Node(sum);
            if (res == null) {
                res = n;
            } else {
                prev.next = n;
            }
            prev = n;

            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;

        }
        if (carry != 0)
            res.next = new Node(carry);
        return res;
    }

    public static void main(String gg[]) {
        //LL l = new LL();

        LL list = new LL();

        // creating first list
        list.head = new Node(7);
        list.head.next = new Node(5);
        list.head.next.next = new Node(9);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList();

        LL list2 = new LL();

        // creating seconnd list
        list2.head = new Node(8);
        list2.head.next = new Node(4);
        System.out.print("Second List is ");
        list2.printList();

        LL res = new LL();
        // add the two lists and see the result
        res.head = list.addTwoLists(list.head, list2.head);
        System.out.print("Resultant List is ");
        res.printList();


        /*l.head = new Node(50);
        l.head.next = new Node(20);
        l.head.next.next = new Node(15);
        l.head.next.next.next = new Node(4);
        l.head.next.next.next.next = new Node(10);

        // Creating a loop for testing
        l.head.next.next.next.next.next = l.head.next.next;
        l.detectAndRemoveLoop();
        System.out.println("Linked List after removing loop : ");
        l.printList();*/
       /* l.append(5);
        l.append(3);
        l.push(2);
        l.push(7);
        l.insertAtPosition(11, 0);
        l.insertAtPosition(1, 6);
        l.insertAtPosition(10, 8);
        l.insertAtPosition(22, 3);
        l.append(55);
        l.append(1);
        l.printList();
        l.segregateEvenOdd();
        l.printList();*/
       /* l.head=l.pairWiseSwapRecursive(l.head);
        l.printList();*/
        /*l.swapNode(5,55);
        l.printList();
        l.swapNode(11,10);
        l.printList();
        l.swapNode(5,1);
        l.printList();*/
       /* l.reverseUtil(l.head,null);
        l.printList();*/
        /*l.middleNode();
        l.nNodeFromEnd(1);
        l.nNodeFromEnd(2);
        l.nNodeFromEnd(0);
        l.nNodeFromEnd(9);
        l.nNodeFromEnd(11);
        l.printList();
        l.delete(65);
        l.printList();
        l.delete(11);
        l.delete(10);
        l.printList();
        l.deleteAtPosition(0);
        l.printList();
        l.deleteAtPosition(1);
        l.printList();
        l.deleteAtPosition(2);
        l.printList();
        l.deleteAtPosition(10);
        l.printList();
        l.deleteAtPosition(4);
        l.printList();*/
    }
}
