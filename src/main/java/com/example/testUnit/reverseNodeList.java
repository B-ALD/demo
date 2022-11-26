package com.example.testUnit;




import java.io.Serializable;

/**
 * 翻转链表
 * @author lyl04
 */
public class reverseNodeList {
    static class ListNode {
        Object val;
        ListNode next;

        public ListNode(Object val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
        }
    }

    public static void main(String[] args) {
       ListNode node5 = new ListNode(1,null);
       ListNode node4 = new ListNode(2,node5);
       ListNode node3 = new ListNode(3,node4);
       ListNode node2 = new ListNode(4,node3);
       ListNode node1 = new ListNode(5,node2);
       reverse(node1);
        System.out.println(node1);
    }

    public static ListNode reverse(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public void test(){
        
    }

}
