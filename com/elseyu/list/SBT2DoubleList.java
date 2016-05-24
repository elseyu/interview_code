package com.elseyu.list;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 将搜索二叉树转换成双向链表：现在有一颗搜索二叉树，请将它转换为有序的双向链表
 * 思路：
 * 1.先弄一个简单的版本：中序遍历二叉树，将节点收集到一个队列里面；然后不断弹出队列的元素，
 * 按左右连接即可
 * 2.利用递归函数，除此之外不使用任何其他容器。这里时间复杂度为O(n),空间复杂度为O(h) **h为树的深度
 * （1）实现递归函数process，他可以将一颗搜索二叉树转换为结构有点特殊的双向链表：此双向连表的尾指针right
 * 指向头节点
 * （2）尾首断开，返回头部
 */
public class SBT2DoubleList {
	//思路1：
	public static TNode recover1(TNode head) {
		Queue<TNode> queue = new LinkedList<>();
		inOrderToQueue(head, queue);
		if (queue.isEmpty()) {
			return head;
		}
		//定义新的head
		head = queue.poll();
		TNode pre = head;
		pre.left = null;
		TNode cur = null;
		//左右连接操作
		while (!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		cur.right = null;
		return head;
	}

	//中序遍历，并将节点放进队列
	private static void inOrderToQueue(TNode head, Queue<TNode> queue) {
		if (head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right, queue);
	}
	
	//思路二，首先实现递归函数process
	public static TNode process(TNode head) {
		if (head == null) {
			return null;
		}
		//因为返回的时最后一个节点，先遍历左子树，拿到最后一个节点
		TNode leftEnd = process(head.left);
		//拿到右子树最后一个节点
		TNode rightEnd = process(head.right);
		//拿到左右子树开始节点
		TNode leftStart = leftEnd == null ? null : leftEnd.right;
		TNode rightStart = rightEnd == null ? null : rightEnd.right;
		//开始判断连接，一个个分析
		//这个时候是到达叶子节点
		if (leftEnd == null && rightEnd == null) {
			//只有一个节点情况下，他的尾部指向自身
			head.right = head;
			return head;
			//只有左边有节点
		} else if (rightEnd == null) {
			leftEnd.right = head;
			head.left = leftEnd;
			head.right = leftStart;
			return head;
			//只有右边节点
		} else if (leftEnd == null) {
			head.right = rightStart;
			rightStart = head;
			rightEnd.right = head;
			return rightEnd;
			//左右子树都不为空
		} else {
			leftEnd.right = head;
			head.left = leftEnd;
			head.right = rightStart;
			rightStart.left = head;
			rightEnd.right = leftStart;
			return rightEnd;
		}
	}
	
	//下面利用这个函数
	public static TNode recover2(TNode head) {
		if (head == null) {
			return head;
		}
		//返回的时尾
		TNode last = process(head);
		//头是尾的右边
		head = last.right;
		last.right = null; //断开
		return head;
	}
}

//二叉树节点定义
class TNode {
	public int value;
	public TNode left;
	public TNode right;
	public TNode(int val) {
		this.value = val;
	}
}