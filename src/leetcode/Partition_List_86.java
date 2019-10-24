package leetcode;

import java.util.List;

public class Partition_List_86 {
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode partition, before, cur;
        // partition 指针指向小于 x 的值
        // cur 指针指向不小于 x 的值
        // before 指针是 cur 的前置节点
        // cur 向前遍历，直到遇到比 x 小的值，然后将 cur 节点置于 partition 节后面
        // 更新三个节点
        partition = before = cur = head;
        cur = cur.next;
        while (cur != null) {
            if (cur.val >= x) {
                cur = cur.next;
                before = before.next;
                continue;
            }
            // iterator current node
            ListNode temp = cur;
            cur = cur.next;
            before.next = cur;

            // iterator partition node
            temp.next = partition.next;
            partition.next = temp;
            partition = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(1);
        //ListNode node2 = new ListNode(0);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(2);
        node.next = node1;
        // node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        partition(node, 2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

