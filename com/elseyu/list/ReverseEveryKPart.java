package com.elseyu.list;

import java.util.Stack;

/*
 * 将单链表每k个节点之间逆序:给定一个但单链表的头节点，请设计一个函数，实现这个单链表
 * 在每k个节点之间逆序，如果最后不足k个节点，则不用调整
 * 
 * 思路：利用栈结构
 * 1.遍历链表，如果栈的大小小于k，则不断将节点压入栈中
 * 2.当栈的大小第一次达到k时，从栈中弹出这些节点，并且重新连接
 * 此时需要记录新的头节点（要返回的头），原来的头要和后面的连接
 * 3.当栈大小每次达到k时，都弹出调整
 */
public class ReverseEveryKPart {
	public static Node reverseKNode(Node head, int k) {
		//如果k小于2，调整是没有必要的；头为空链表只有一个节点，也没有调整的必要
		if (k < 2 || head == null || head.next == null) {
			return head;
		}
		
		Stack<Node> stack = new Stack<>();
		Node newHead = head; //待返回的新的头（只有在第一次达到k时赋值）
		Node cur = head; //不断迭代的当前节点
		Node pre = null; //代表前一个
		Node next = null; //代表后一个
		
		while (cur != null) {
			next = cur.next;
			stack.push(cur);
			if (stack.size() == k) {
				//弹出重新连接的方法，此方法返回
				pre = resign(stack,pre,next);
				//这一句很关键了,就是判断是否是第一次到达k
				newHead = newHead == head ? pre : newHead;
			}
			cur = next;
		}
		return newHead;
	}

	//对栈元素重新连接，传入时left、right是连接上一次和下一次的节点
	private static Node resign(Stack<Node> stack, Node left, Node right) {
		Node cur = stack.pop();
		//left就是上一次调整的尾部
		if (left != null) {
			left.next = cur;
		}
		Node  next = null;
		while (!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}
}
