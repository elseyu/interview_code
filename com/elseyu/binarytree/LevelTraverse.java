package com.elseyu.binarytree;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的层次遍历
public class LevelTraverse {
	public static void oper(Node node) {
		System.out.println(node.value);
	}
	
	public static void levelTraver(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			oper(head);
			if (head.left != null) {
				queue.add(head.left);
			}
			if (head.right != null) {
				queue.add(head.right);
			}
		}
	}
}
