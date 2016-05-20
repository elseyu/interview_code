package com.elseyu.list;

import java.util.Stack;

/*
 * 两个单链表相加生成相加链表
 * 问题描述：有点像大整数加法，假如给定一个链表1->2->3->null,那么它代表数值123，
 * 另一个链表2->3->null,它代表23，相加为146，返回1->4->6-null
 */
public class AddList {
	/*
	 * 解法1：
	 * 利用两个栈，分别将两个链表的数值全部压入，然后同步弹出进行相加。
	 * 需要注意的是处理进位和弹出的时候要同时连起来
	 */
	public static Node addList1(Node head1, Node head2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Node cur1 = head1;
		Node cur2 = head2;
		//压栈操作
		while (cur1 != null) {
			stack1.push(cur1.value);
			cur1 = cur1.next;
		}
		
		while (cur2 != null) {
			stack2.push(cur2.value);
			cur2 = cur2.next;
		}
		
		Node node = null; //弹出时重新生成的节点
		Node pre = null; //保存上一个节点
		int n = 0; //保存相加后的数
		int n1 = 0; //保存stack1中弹出的数值
		int n2 = 0; //保存stack2中弹出的数值
		int ca = 0; //保存进位
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			n1 = stack1.isEmpty() ? 0 : stack1.pop();
			n2 = stack2.isEmpty() ? 0 : stack2.pop(); //这里的判断重要
			n = n1 + n2 + ca;
			pre = node; 
			node = new Node(n % 10);
			node.next = pre; //连起来
			ca = n / 10;
		}
		
		//最后还要判断是否有进位
		if (ca == 1) {
			pre = node;
			node = new Node(ca);
			node.next = pre;
		}
		
		return node;
	}
	/*
	 * 解法2：
	 * 不用栈结构，直接将两个链表反转
	 * 最后再反转回来。反转操作这里再次给出，当作练手~~~
	 */
	public static Node addList2(Node head1, Node head2) {
		head1 = reverse(head1);
		head2 = reverse(head2);
		
		Node c1 = head1; //保存head1
		Node c2 = head2; //保存head2
		Node node = null; //弹出时重新生成的节点
		Node pre = null; //保存上一个节点
		int n = 0; //保存相加后的数
		int n1 = 0; //保存stack1中弹出的数值
		int n2 = 0; //保存stack2中弹出的数值
		int ca = 0; //保存进位
		
		while (c1 != null || c2 != null) {
			n1 = c1 == null ? 0 : c1.value;
			n2 = c2 == null ? 0 : c2.value;
			n = n1 + n2 + ca;
			pre = node;
			node = new Node(n % 10);
			node.next = pre;
			ca = n /10; //和上面操作是一样的
		}
		
		//最后还要判断是否有进位
		if (ca == 1) {
			pre = node;
			node = new Node(ca);
			node.next = pre;
		}
		//还原原来的链表
		head1 = reverse(head1);
		head2 = reverse(head2);
		return node;
	}
	
	/*
	 * 反转方法
	 */
	public static Node reverse(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
