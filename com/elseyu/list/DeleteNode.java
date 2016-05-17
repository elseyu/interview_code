package com.elseyu.list;

/*
 * 删除链表的中间节点或者a/b处的节点：
 * 还是很简单，直接上代码
 */
public class DeleteNode {
	//删除链表的中间节点
	public static Node removeMidNode(Node head) {
		//参数合法性
		if (head == null || head.next == null) {
			return head;
		}
		
		//处理只有两个节点的情况,直接返回头节点
		if (head.next.next == null) {
			return head.next;
		}
		
		Node pre = head;
		Node cur = head.next.next;
		//定义两个节点，一个每次走一步，另一个每次走两部，一直到链表尾
		while (pre.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		//此时pre节点就是中间节点
		pre.next = pre.next.next;
		return head;
	}
	
	public static Node removeByRatio(Node head, int a, int b) {
		//参数合法性
		if (a < 1 || b < a) {
			return head;
		}
		//链表的长度
		int length = 0;
		Node cur = head;
		while (cur.next != null) {
			cur = cur.next;
			length++;
		}
		//删除节点的位置
		int n = (int)Math.ceil((double)(a*length)/(double)b);
		if (n == 1) {
			return head.next;
		}
		
		if (n > 1) {
			cur = head;
			while (--n > 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		
		return head;
	}
}
