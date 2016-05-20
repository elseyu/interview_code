package com.elseyu.list;

import java.util.HashMap;

/*
 * 复制含有随机节点的链表
 * 下面是随即节点的定义
 */

class RandNode {
	int value;
	RandNode next;
	RandNode rand; //随机节点，可能指向链表当中任何节点或者null
	public RandNode(int value) {
		this.value = value;
	}
}

/*
 * 思路：
 * 1.思路1很简单，遍历链表，把当前节点根据值复制一份，并用一个HashMap保存所有复制的节点；
 * 再次遍历链表，便利的过程中复制next节点和rand节点
 * 看代码吧，代码比较清晰
 */
public class CopyListWithRand {
	public static RandNode copyListWithRand1(RandNode head) {
		if (head == null) {
			return head;
		}
		HashMap<RandNode, RandNode> hashMap = new HashMap<>();
		RandNode cur = head;
		while (cur != null) {
			hashMap.put(cur, new RandNode(cur.value)); //复制并存进HashMap
			cur = cur.next;
		}
		cur = head;
		//复制next和rand
		while (cur != null) {
			hashMap.get(cur).next = hashMap.get(cur.next);
			hashMap.get(cur).rand = hashMap.get(cur.rand);
			cur = cur.next;
		}
		//返回
		return hashMap.get(head);
	}
	
	/*
	 * 进阶解法：
	 * 假如有如下链表：1->2->3->4->null,然后进行这样的复制
	 * 1->(1)->2->(2)->3->(3)->4->(4)->null
	 * 然后继续遍历链表，复制其next和rand节点
	 * 我们知道，cur.next对应(cur.next).next.next
	 * cur.rand对应(cur.next).rand
	 * 最后我们在把他们拆开即可
	 */
	public static RandNode copyListWithRand2(RandNode head) {
		if (head == null) {
			return head;
		}
		
		RandNode cur = head;
		RandNode next = null;
		//复制节点
		while (cur != null) {
			next = cur.next; //保存下一个节点
			cur.next = new RandNode(cur.value); //当前节点下一个指向新复制的节点
			cur.next.next = next; //新的节点和后面连起来
			cur = next; //向后移动
		}
		//复制随机节点（next节点不用管，因为已经隐藏在链表里面了）
		cur = head;
		RandNode copyNode = null;
		while (cur != null) {
			next = cur.next.next;
			copyNode = cur.next;
			//重要！！
			copyNode.rand = cur.rand == null ? null : cur.rand.next;
			cur = next;
		}
		
		RandNode copyHead = head.next; //复制链表的头节点
		cur = head;
		//拆分
		while (cur != null) {
			next = cur.next.next;
			copyNode = cur.next;
			cur.next = next;
			//重要！！
			copyNode.next = next == null ? null : next.next;
			cur = next;
		}
		
		return copyHead;
	}
}











