package com.elseyu.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 判断是否为搜索二叉树和完全二叉树
 * 1.给定一个头头节点，判断一颗二叉树是否为搜索二叉树
 * 2.判断是否为完全二叉树
 * 
 * 思路：
 * 1.中序遍历，遍历的过程中看是否是升序
 * 2.层次遍历，如果当前借点有右孩子，而没有左孩子，返回false；如果当前节点的
 * 左右孩子不是全有，那后面的节点一定是叶子节点；如果不返回false，最后返回true
 */
public class IsBST {
	public static boolean isBST(Node head) {
		if (head == null) {
			return true;
		}
		//结果
		boolean res = true;
		//中序非递归遍历
		if (head != null) {
			Node pre = null;
			Node cur = head;
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || cur != null) {
				//左节点不为空
				if (cur != null) {
					stack.push(cur);
					cur = cur.left;
					//左节点已经全部入栈，弹出比较
				} else {
					cur = stack.pop();
					//判断是否为升序
					if (pre != null && pre.value > cur.value) {
						res = false;
					}
					pre = cur;
					//重要
					cur = cur.right;
				}
			}
		}
		return res;
	}
	//判断是否为完全二叉树
	public static boolean isCBT(Node head) {
		if (head == null) {
			return true;
		}
		
		//中序遍历
		Queue<Node> queue = new LinkedList<>();
		Node left = null;
		Node right = null;
		//判断后面的是否应该是叶子节点
		boolean isLeaf = false;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			left = head.left;
			right = head.right;
			//如果到了叶子节点，那么后面的节点一定没有左右孩子，如果有右孩子没有左孩子，也是false
			if ((isLeaf && (left != null || right != null)) || (left == null && right != null)) {
				return false;
			}
			if (left != null) {
				queue.offer(left);
			}
			//注意一下
			if (right != null) {
				queue.offer(right);
			} else {
				isLeaf = true;
			}
		}
		return true;
	}
}
