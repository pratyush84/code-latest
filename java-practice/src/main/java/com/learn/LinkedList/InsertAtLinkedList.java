package com.learn.LinkedList;

public class InsertAtLinkedList {
    public static void main(String[] args) {
        ListNode l5 = new ListNode(1);
        l5.next = null;
        ListNode l4 = new ListNode(2);
        l4.next = l5;
        ListNode l3 = new ListNode(3);
        l3.next = l4;
        ListNode l2 = new ListNode(2);
        l2.next = l3;
        ListNode l1 = new ListNode(1);
        l1.next = l2;

        ListNode m3 = new ListNode(4);
        m3.next = null;
        ListNode m2 = new ListNode(6);
        m2.next = m3;
        ListNode m1 = new ListNode(5);
        m1.next = m2;

        DoublyLinkedListNode d3 = new DoublyLinkedListNode(4);
        DoublyLinkedListNode d4 = new DoublyLinkedListNode(10);
        d4.next = null;
        d4.prev = d3;

        DoublyLinkedListNode d2 = new DoublyLinkedListNode(3);
        DoublyLinkedListNode d1 = new DoublyLinkedListNode(1);


//        printLinkedList(insertNodeAtPosition(l1,4,0));
//        printLinkedList(addTwoNumbers(l1,m1));
        System.out.println(isPalindrome(l1));

    }


    static boolean isEqual2(ListNode head1, ListNode head2){
        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while(curr1 != null && curr2 != null){
            if(curr1.data != curr2.data){
                return false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return (curr1 == null && curr2 == null);
    }
    static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        ListNode p1 = secondHead;
        ListNode curr = p1;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return isEqual(prev,head);

    }
    static ListNode insertNodeAtPosition(ListNode head, int data, int position) {
        int index = 0;

        ListNode prev = head;
        ListNode insert = new ListNode(data);
        insert.next = null;
        ListNode curr = head;
        boolean isInserted = false;
        if(position != 0) {
            while (curr != null) {
                if (index == position) {
                    prev.next = insert;
                    insert.next = curr;
                    isInserted = true;
                    break;
                }
                ListNode next = curr.next;
                prev = curr;
                curr = next;
                index++;
            }
        } else{
            insert.next = curr;
            head = insert;
            isInserted = true;
        }

        if(index == position && !isInserted){
            prev.next = insert;
            insert.next = null;
        }
        return head;
    }

    static boolean isEqual(ListNode head1, ListNode head2){
        while(head1 != null && head2 != null){
            if(head1.data != head2.data){
                return false;
            }
            head1=head1.next;
            head2=head2.next;
        }

        return true;
    }
    static ListNode reverseLinkedList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

        }

//        head = prev;
        return prev;
    }

    static void printLinkedList(ListNode head){
        while(head != null){
            ListNode next = head.next;
            System.out.println(head.data);
            head = next;
        }
    }
    static void printDoublyLinkedList(DoublyLinkedListNode head){
        while (head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        DoublyLinkedListNode curr = head;
        DoublyLinkedListNode insert = new DoublyLinkedListNode(data);

        while (curr != null){
            DoublyLinkedListNode next = curr.next;
            DoublyLinkedListNode prev = curr.prev;

            if(curr.prev == null && data < curr.data){
                insert.next = curr;
                curr.prev = insert;
                head = insert;
                return head;
            }
            if(curr.next == null && data > curr.data){
                curr.next=insert;
                insert.prev = curr;
                insert.next = null;
                return head;
            }
            if(data >= curr.data && data <= next.data){
                curr.next = insert;
                insert.next = next;
                insert.prev = curr;
                next.prev = insert;
                return head;
            }

            curr = next;
        }




        return head;
    }

    static ListNode addTwoNumbers(ListNode head1, ListNode head2){
        int sum = convertListToNum(head1) + convertListToNum(head2);
        ListNode result = null;
        ListNode head = null;

        while(sum != 0){
            int val = sum % 10;
            ListNode node = new ListNode(val);
            if(result != null){
                result.next = node;
                result = result.next;
            } else{
                result = head = node;
            }
            sum = sum/10;
        }
        return head;
    }

    static int convertListToNum(ListNode head){
        int sum = 0;
        int index = 0;
        while(head != null){
            sum += head.data * Math.pow(10,index);
            index++;
            head = head.next;
        }
        return sum;
    }

}
