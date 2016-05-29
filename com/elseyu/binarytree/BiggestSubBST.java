package com.elseyu.binarytree;

/*
 * 找到二叉树中最大的搜索二叉树：
 * 给定一颗二叉树的头节点head，已知其中所有节点的值都不一样，找到含有节点最多的搜索二叉树
 * 思路：
 * 1.假如当前节点是cur，假如他左边最大的搜索二叉树的头是left，而且左边的最大值比当前的点的值
 * value小；假如它右边最大的搜索二叉树的头是right，而且右边的最小值比当前节点的值大，则以cur
 * 节点为头的二叉树就是搜索二叉树。
 * 2.假如上面的假设不成立，则最大二叉树就是左边或右边二叉树之中借点数最多的一个
 */
public class BiggestSubBST {
	public static Node getBigestBST(Node head) {
		int record[] = new int[3]; //这个数组用来全局保存三个变量：当前搜索二叉树的节点数、
								   //左边的最大值、右边的最小值
		return posOrder(head,record); //递归过程就是后序遍历过程
	}	

	private static Node posOrder(Node head, int[] record) {
		//当前节点九孔，说明到底了
		if (head == null) {
			//首先对数组初始化
			record[0] = 0; //搜索二叉树的个数是0
			record[1] = Integer.MAX_VALUE; //设置为默认最大值,记录着当前最小值
			record[2] = Integer.MIN_VALUE; //默认是最小值，记录着当前的最大值
			return null; //可以把null“看作”是一棵“空的搜索二叉树”
		}
		int value = head.value;
		Node left = head.left;
		Node right = head.right;
		Node lBST = posOrder(left, record); //后序遍历的左边最大搜索二叉树
		//记录左子树节点数，最大值，最小值
		int lSize = record[0];
		int lMin = record[1];
		int lMax = record[2];
		Node rBst = posOrder(right,record);
		//记录右子树节点数，最大值，最小值
		int rSize = record[0];
		int rMin = record[1];
		int rMax = record[2];
		//设置当前的最大值最小值
		record[1] = Math.min(lMin, value);
		record[2] = Math.max(rMax, value);
		//搜索二叉树的条件
		if (left == lBST && right == rBst && lMax < value && rMin > value) {
			record[0] = rSize + lSize;
			return head;
		}
		//如果不成立
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize ? lBST : rBst;
	}
}
