package com.elseyu.binarytree;

import java.util.Stack;

/*
 * 调整搜索二叉树中两个错误的节点：
 * 一棵二叉树原本是搜索二叉树，但是有两个节点调换了位置，使得这棵不再是搜索二叉树。
 * 请找出这两个节点并返回。
 * 思路：
 * 1.我们知道搜索二叉树的中序遍历是是按升序排列的，假如有两个节点互换了位置，那么
 * 这个排列最多只有两次降序（两次或一次）
 * 2.举例说明两次的情况：1-2-3-4-5，2、4互换了位置，1-4-3-2-5，降序出现在4-3,3-2
 * 所以错误的节点是第一次降序的较大的那个和第二次降序较小的那个（4,2）
 * 3.说明降序一次的情况：1-2-3-4-5，2、3互换了位置，1-3-2-4-5，降序只有3-2，所以错的
 * 节点就是降序的两个。总的来说就是错误的节点是第一次降序的节点值最大值和最后一次的最小值
 * 4.知道了规律就可以利用中序遍历去找了，这里用了非递归的中序遍历（复习）
 */
public class TwoErrorNodeInBST {
	public static Node[] getTwoErrorNodes(Node head) {
		if (head == null) {
			return null;
		}
		//记录的错误的节点
		Node[] errs = new Node[2];
		Stack<Node> stack = new Stack<>();
		//用来记录前一个节点，为了判断是否为降序
		Node pre = null;
		while (!stack.isEmpty() || head == null) {
			if (head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				//说明出现了降序
				if (pre != null && pre.value > head.value) {
					//比较有技巧的地方：用errs[0]是否为null来判断是否是第一次降序
					//如果是第一次降序，那么errs[0]必为null，此时最大值就是pre
					//如果errs[0]不为null，则最大值肯定不变
					errs[0] = errs[0] == null ? pre : errs[0];
					errs[1] = head;
				}
				//保存pre,而且head往右走
				pre = head;
				head = head.right;
			}
		}
		return errs;
	}
}
