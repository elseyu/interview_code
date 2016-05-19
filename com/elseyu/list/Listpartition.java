package com.elseyu.list;

/*
 * 将单向链表按某值划分为左边小、中间相等、右边大的形式
 * 要求：划分后原顺序不变（应该说是稳定的），时间复杂度O(N),空间复杂度O(1)
 * 思路：根据原链表划分为三个链表，一个是小于的链表，一个是相等的链表，另一个是大于的链表
 */
public class Listpartition {
	//开始
	public static Node listPartition(Node head, int pivot) {
		if (head == null || head.next == null) {
			return head;
		}
		//定义small、equal、big的头围节点
		Node smallHead = null;
		Node smallTail = null;
		Node equalHead = null;
		Node equalTail = null;
		Node bigHead = null;
		Node bigTail = null;
		
		Node next = null; //保存next的节点
		while (head != null) {
			next = head.next;
			head.next = null; //当前节点和后面断开
			if (head.value < pivot) {
				if (smallHead == null) { //头为空即当前节点时第一个，头尾都指向第一个节点，下面同理
					smallHead = head;
					smallTail = head;
				} else { //非空则用尾节点把后面的连起来
					smallTail.next = head;
					smallTail = head;
				}
			} else if (head.value == pivot) {
				if (equalHead == null) {
					equalHead = head;
					equalTail = head;
				} else {
					equalTail.next = head;
					equalTail = head;
				}
			} else {
				if (bigHead == null) {
					bigHead = head;
					bigTail = head;
				} else {
					bigTail.next = head;
					bigTail = head;
				}
			}
			head = next;
		}
		
		//上面已经分割完毕，下面要开始连接
		//要注意null的问题，小于部分和中间部分相连
		if (smallTail != null) {
			smallTail.next = equalHead;
			//这一句非常重要！！因为有可能出现中间部分为空的情况，如果为空，中间部分的尾部就是小于部分
			equalTail = equalTail == null ? smallTail : equalTail;
		}
		
		//中间部分和尾部相连
		if (equalTail != null) {
			equalTail.next = bigHead;
		}
		
		//返回头
		return smallHead != null ? smallHead : equalHead != null ? equalHead : bigHead;
	}
}
