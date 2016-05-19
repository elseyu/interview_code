package com.elseyu.list;

import java.util.Stack;

/*
 * 判断一个链表是否为回文结构
 * 进阶：如果链表长度是N，则时间复杂度请达到O(N),空间复杂度为O(1)
 * 思路：
 * 1.先说一个简单的思路，就是利用一个栈，把链表全部put进去，弹出来的时候依次和原来的链表比较。
 * 直到最后一个相等则为回文结构
 * 很明显，这里可以优化一下：不需要把全部节点put进去，只需要put后半部分即可
 * 2.进阶解法：不利用任何特殊数据结构，直接将链表后半部分翻转，然后指向中间节点，一个头指针一个中间指针，不断
 * 移动比较即可。（最后应该恢复原来的结构）
 * 显然，这里的时间复杂度为O(N),空间复杂度为O(1);
 */
public class PalindromeList {
	//解法1：优化后的解法，只存链表后半部分入栈
	public static boolean isPalindrome(Node head) {
		//参数合法性
		if (head == null || head.next == null) {
			return true;
		}
		//找到右半部分！！
		Node right = head.next; //注意这里是head.next，因为是找后半部分
		Node cur = head;
		//比较经典的走法了（类似问题：找到链表中间节点）
		while (cur.next.next != null && right.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		
		Stack<Node> stack = new Stack<>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		//主要是为了不改变链表的头：如果直接用head来迭代，会丢失链表头
		cur = head;
		while (stack.isEmpty()) {
			if (cur.value != stack.pop().value) {
				return false;
			}
		}
		
		return true;
	}
	
	//下面是进阶解法
	
	public static boolean isPalindromePro(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		//找到中间节点
		Node n1 = head;
		Node n2 = head; //因为这两个变量会不断迭代，很难取一个固定的名字
		while (n1.next != null && n2.next.next != null) {
			n1 = n1.next; //中间节点
			n2 = n2.next.next; //尾节点
		}
		
		//开始反转
		n2 = n1.next; //因为n1是中间节点，所以n1.next是右边开始第一个节点
		n1.next = null;
		Node n3 = null; //用来保存下一个节点
		while (n2 != null) {
			n3 = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = n3; //不断移动
		}
		/*						  ┢>null
		 * 反转完的结果类似   1->2->3->4<-5<-6<-7
		 */
		
		n3 = n1; //因为反转后n1是后半部分的头.这里用n3暂时保存起来
		n2 = head;
		boolean res = true; //结果
		//开始判断
		while (n2 != null && n1 != null) {
			if (n1 != n2) {
				res = false;
				break;
			}
			
			n1 = n1.next;
			n2 = n2.next;
		}
		
		//还原
		n1 = null;
		n2 = null;
		while (n3 != null) {
			n1 = n3.next;
			n3.next = n2;
			n2 = n3;
			n3 = n1;
		}
		
		return res;
		
	}
	
}
