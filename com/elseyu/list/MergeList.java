package com.elseyu.list;

/*
 * 合并两个有序的单链表
 * 数据结构书上的内容，不解释太多
 */
public class MergeList {
	public static Node mergeList(Node head1,Node head2) {
		if (head1 == null || head2 == null) {
			return head1 == null ? head2 : head1; 
		}
		//定义新的头
		Node head = null;
		Node pre = null;
		//选择较小的节点作为当前节点的头和当前节点的前一个节点
		if (head1.value <= head2.value) {
			head = head1;
			pre = head1;
			head1 = head1.next;
		} else {
			head = head2;
			pre = head2;
			head2 = head2.next;
		}
		//一个个合并
		while (head1 != null && head2 != null) {
			if (head1.value <= head2.value) {
				//前一个连接到较小的节点
				pre.next = head1;
				//移动
				pre = head1;
				head1 = head1.next;
			} else {
				pre.next = head2;
				pre = head2;
				head2 = head2.next;
			}
		}
		
		//到达最后，可能一个到达尾部，另一个未到达
		pre.next = head1 == null ? head2 : head1;
		return head;
	}
}
