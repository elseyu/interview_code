package com.elseyu.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 二叉树的按层打印
 * 思路：
 * 按层打印首先想到的就是层次遍历，但是层次遍历并没有换行，所以主要的问题是如何在层次
 * 遍历的基础上并实现换行。
 * 1.创建两个Node类型的节点：last——当前层最后一个节点（毫无疑问，就是根据他来决定是否换行）；
 * nLast——下一层最后一个节点（当换行后，就把last=nLast）
 * 2.如何确定nNast（因为last就是根据nLast来决定的）？我们知道层次遍历会利用队列的性质，当某一层
 * 到达最后一个节点后，这一层的所有节点都会放到队列中去，所以可以知道当前层打印到最后一个节点，那么队列
 * 尾的节点必定是nLast。
 * 3.可以看代码了
 */
public class PrintbyLevel {
	public static void printByLevel(Node head) {
		if (head == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		int level = 1; //表示打印的层数
		Node last = head; //保存第一层的最后一个节点
		Node nLast = null;
		queue.offer(head);
		System.out.print("Level " + level++ + " : ");
		while (!queue.isEmpty()) {
			head = queue.poll();
			System.out.print(head.value + " "); //打印当前节点
			if (head.left != null) {
				queue.offer(head.left);
				nLast = head.left; //不断迭代
			}
			if (head.right != null) {
				queue.offer(head.right); //层次遍历的核心
				nLast = head.right;
			}
			//到达当前最后一个节点，并且不为二叉树最后一个叶子节点
			if (head == last && !queue.isEmpty()) {
				//换行
				System.out.println();
				//下一行的层数提示
				System.out.print("Level " + level++ + " : ");
				last = nLast;
			}
		}
		//整个过程结束
		System.out.println();
	}
}
