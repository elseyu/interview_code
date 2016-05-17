package com.elseyu.list;

/*
 * 反转单、双向链表：
 * 老经典题目了，不解释，上代码
 */
public class ReVerseList {
	
	/*
	 * 反转单链表
	 */
	public static Node reverseSingleList(Node head) {
		Node pre = null;
		Node next = null;
		while(head != null) { //在这里我们把head当作当前节点，并不断移动head
			next = head.next; //先把下一个节点保存
			head.next = pre; //对当前节点进行反转：就是把他的next只想上一个节点（pre）
			pre = head; //上一个节点向后移动
			head = next; //当前节点向后移动
		}
		
		return pre; //因为pre是跟着head一起移动的，当后面没有节点时，pre到了链表尾，翻转后就是head，直接返回
	}
	
	/*
	 * 反转双链表：操作和单链表几乎是一样的
	 */
	public static DoubleNode reverseDoubleList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next; //只需要注意last重连
			pre = head;
			head = next;
		}
		
		return pre;
	}
}
