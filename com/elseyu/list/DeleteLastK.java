package com.elseyu.list;

/*
 * 删除单、双链表倒数第k个节点，后面给出双链表节点的定义（单链表节点的定义在同一个包中，就不特别给出了）
 * 解答：其实方法我见过的有三种（其实都是殊途同归吧），下面我给出我最喜欢的一种
 */
public class DeleteLastK {
	/*
	 * 删除单链表倒数第k个节点
	 */
	public static Node removeLastKthNode(Node head, int k) {
		//参数的合法性
		if(head == null || k < 1) {
			return head;
		}
		
		Node cur = head;
		//cur一直跑到链表尾，同时k递减
		while(cur != null) {
			cur =cur.next;
			k--;
		}
		
		//此时判断k的值
		//大于0说明k比链表的长度还大，不存在倒数第k个，这里直接返回头部
		if (k > 0) {
			return head;
			//k等0说明倒数第k个恰好是链表头，删除链表头
		} else if (k == 0) {
			head = head.next;
		}
		
		//剩下的情况就是k小于0
		cur = head; //对cur重新赋值
		while (++k < 0) {
			cur = cur.next;
		}
		//此时cur节点就是要找到的倒数第k个节点的前一个节点
		cur.next = cur.next.next;
		return head;
	}
	
	
	/*
	 * 删除双链表倒数第k个节点:处理几乎是一样的
	 */
	public static DoubleNode removeLastKthInDouble(DoubleNode head, int k) {
		//参数的合法性
		if(head == null || k < 1) {
			return head;
		}
		
		DoubleNode cur = head;
		//cur一直跑到链表尾，同时k递减
		while(cur != null) {
			cur =cur.next;
			k--;
		}
		
		//此时判断k的值
		//大于0说明k比链表的长度还大，不存在倒数第k个，这里直接返回头部
		if (k > 0) {
			return head;
			//k等0说明倒数第k个恰好是链表头，删除链表头
		} else if (k == 0) {
			head = head.next;
			//只需要注意这里要和上一个断开
			head.last = null;
		}
		
		//剩下的情况就是k小于0
		cur = head; //对cur重新赋值
		while (++k < 0) {
			cur = cur.next;
		}
		//此时cur节点就是要找到的倒数第k个节点的前一个节点
		DoubleNode newNext = cur.next.next;
		cur.next = newNext;
		newNext.last = cur; //注意上一个节点重连
		return head;
	}
}

/*
 * 单链表
 */
class DoubleNode {
	public int value;
	public DoubleNode last;
	public DoubleNode next;
	
	public DoubleNode(int value) {
		this.value = value;
	}
	
}