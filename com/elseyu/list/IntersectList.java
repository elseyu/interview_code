package com.elseyu.list;

/*
 * 两个单链表相交的一系列问题：
 * 在这里，单链表可能有环，也可能无环。给定两个单链表的的头head1、head2，
 * 这两个链表可能相交，也可能不相交。请设计一个函数，如果两个链表相交，则返
 * 回相交的第一个节点；若不相交则返回null
 * 要求：时间复杂度：O(n+m),空间复杂度O(1)
 * 
 * 思路：本题可以拆分为3个子问题
 * 1.判断链表是否有环，如果有环，返回入环第一个节点；如果无环，返回null
 * 2.判断两个无环链表是否相交，相交则返还相交第一个节点，不相交返回null
 * 3.判断两个有环链表是否相交，相交则返还相交第一个节点，不相交返回null
 * ps：一个链表有环，一个无环是不可能相交的
 * 
 */
public class IntersectList {
	//判断链表是否有环
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		//设置一个快的指针，一个慢的指针
		Node slow = head.next;
		Node fast = head.next.next;
		//一直走下去，如果有环，两个指针必定相遇；如果无环，fast则等于null
		while (fast != null) {
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		//无环，返回null
		if (fast == null) {
			return null;
		}
		
		//fast指针从头开始走，有环的话他们必定相遇，而且相遇的节点就是环的入口
		fast = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return fast;
	}
	
	//判断两个无环链表是否相交
	public static Node getInNoLoop(Node head1,Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 =head1;
		Node cur2 = head2;
		int n = 0; //计数器，用来计算链表1和链表2的长度之差
		//链表1走到最后一个节点,同时计数器加1
		while (cur1.next != null) {
			cur1 = cur1.next;
			n++;
		}
		//链表2走到最后一个节点，计数器减一
		while (cur2.next != null) {
			cur2 = cur2.next;
			n--;
		}
		//如果最后一个节点不相等
		if (cur1 != cur2) {
			return null;
		}
		//如果n>0，说明链表1比链表2长；反之，他们相等或者链表2更长。这里用cur1表示更长的链表
		cur1 = n > 0 ?  head1 : head2;
		//这里用cur2表示短的链表
		cur2 = cur1 == head1 ? head2 : head2;
		n = Math.abs(n); //求绝对值
		//长得链表先走n步
		while (n != 0) {
			cur1 = cur1.next;
			n--;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		
		return cur1;
	}
	
	//判断判断两个有环链表是否相交，相交则返还相交第一个节点，不相交返回null
	//传入的参数应该包含入环的第一个节点
	public static Node getInLoop(Node head1, Node loop1, Node head2, Node loop2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 =head1;
		Node cur2 = head2;
		int n = 0; //计数器，用来计算链表1和链表2的长度之差
		
		//相等说明两个链表先相交再入环，此时处理和上面判断无环链表相交差不多
		if (loop1 == loop2) {
			//链表1走到入环第一个节点,同时计数器加1
			while (cur1.next != loop1) {
				cur1 = cur1.next;
				n++;
			}
			//链表2走到入环第一个节点，计数器减一
			while (cur2.next != loop2) {
				cur2 = cur2.next;
				n--;
			}
			//如果最后一个节点不相等
			if (cur1 != cur2) {
				return null;
			}
			//如果n>0，说明链表1比链表2长；反之，他们相等或者链表2更长。这里用cur1表示更长的链表
			cur1 = n > 0 ?  head1 : head2;
			//这里用cur2表示短的链表
			cur2 = cur1 == head1 ? head2 : head2;
			n = Math.abs(n); //求绝对值
			//长得链表先走n步
			while (n != 0) {
				cur1 = cur1.next;
				n--;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			
			return cur1;
			//否则，让loop1一直走，他肯定可以回到loop1，如果走的过程中能遇到loop2，则它们相交
			//如果没有遇到则不相交
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
	
	//这里就是所有过程
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			return getInNoLoop(head2, head2);
		} else if (loop1 != null && loop2 != null) {
			return getInLoop(head1, loop1, head2, loop2);
		} else {
			return null;
		}
	}
}
