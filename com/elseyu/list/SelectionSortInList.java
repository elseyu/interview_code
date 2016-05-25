package com.elseyu.list;

/*
 * 单链表的选择排序
 * 没什么好说的的
 */
public class SelectionSortInList {
	public static Node selectionSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node newHead = null;
		//已经排序序的连表的尾部
		Node sortedTail = null;
		//往后遍历的当前节点
		Node cur = head;
		//前一个节点
//		Node pre = null;
		//保存最小节点
		Node min = null;
		//最小节点的前一个节点
		Node minPre = null;
		while (cur.next != null) {
//			minPre = pre;
			min = cur;
			if (min.value > cur.next.value) {
				min = cur.next;
				minPre = cur;
			}
//			pre = pre.next;
			cur = cur.next;
			//证明到达最后（拿到了最小值）
			if (cur.next == null) {
				minPre.next = min.next;
				if (sortedTail == null) {
					newHead = min;
				} else {
					sortedTail.next = min;
				}
				sortedTail = min;
				cur = head;
			}
		}
		sortedTail.next = cur;
		return newHead;
	}
}
