package com.elseyu.list;
/*
 * 反转部分链表：给定一个单向链表的头节点head，以及两个整数from、to，在单链表把from到to的这一部分反转
 * 要求：时间复杂度O(n),空间复杂度O(1)，如果不满足1<=from,to<=N,则不用调整
 * 思路：思路比较简单，首先找到from节点的前一个节点和to节点的后一个节点，因为这是翻转后要重新连接的；
 * 然后对from到to这一部分进行反转操作即可；这里有一个要注意的地方，就是可能会碰到from节点就是head节点，
 * 此时应该返回的不是head，而是反转部分的尾节点（就是from）节点
 */
public class ReversePartList {
	/*
	 * 在此说明：单链表节点的定义不再给出
	 */
	
	public static Node reversePart(Node head, int from, int to) {
		//参数合法性,这里还有一个没有判断就是to是否大于链表长度，这里留到下面
		if (head == null || from < 1 || from >= to) {
			return head;
		}
		
		int len = 0; 
		Node moveNode = head; //设置一个从头到尾移动的节点
		Node fPre = null; //表示from节点的前一个
		Node tNext = null; //表示to节点的后一个
		
		//通过循环遍历，找到他们的位置
		while (moveNode != null) {
			len++;
			if (len == from - 1) {
				fPre = moveNode;
			}
			if (len == to + 1) {
				tNext = moveNode;
			}
			
			moveNode = moveNode.next;
		}
		//判断参数合法性
		if (len < to) {
			return head;
		}
		
		//找到了位置，接下来就是反转这部分链表了
		//注意这个！！！如果要反转的部分的头是头节点，那么fpre肯定为空，此时反转应该从头节点开始
		//反之，就是fpre的下一个开始
		Node preNode = fPre == null ? head : fPre.next; //这里表示反转部分的第一个节点
		preNode.next = tNext; //反转前先连接到尾部，因为翻转后preNode会丢失
		moveNode = preNode.next; //当前节点表示为moveNode
		
		Node nextNode = null;
		//下面是反转操作
		while (moveNode != tNext) {
			nextNode = moveNode.next;
			moveNode.next = preNode;
			preNode = moveNode;
			moveNode = nextNode;
		}
		//反转完要重新连接头部.
		if (fPre == null) {
			return moveNode;
		}
		fPre.next = moveNode;
		return head;
	}
}










