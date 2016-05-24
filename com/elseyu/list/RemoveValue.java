package com.elseyu.list;

/*
 * 在单链表中删除指定值的节点:给定头节点head，和指定值value，删除链表中值为value的点
 * 要求：时间复杂度O(N),空间复杂度O(1)
 * 思路：
 * 1.首先找到第一个节点值不为value的点，记作newHead
 * 2.然后设定两个节点：pre，cur，cur代表当前节点，pre代表当前节点前一个节点
 * 3.当cur的值为value时，删除，cur和pre向后步进
 * 4.不等时，直接向后移动
 * 5.返回newHead
 */
public class RemoveValue {
	public static Node removeValue(Node head, int val) {
		if (head == null) {
			return head;
		}
		while (head != null) {
			if (head.value == val) {
				break;
			}
			head = head.next;
		}
		//此时head为newHead
		Node pre = head;
		Node cur = head;
		while(cur != null) {
			if (cur.value == val) {
				pre.next  =cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
		
	}
}
