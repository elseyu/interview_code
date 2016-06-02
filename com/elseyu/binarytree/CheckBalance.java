package com.elseyu.binarytree;
/*
 * 判断二叉树是否为平衡二叉树
 * 平衡二叉树定义：要么是一颗空树，要么任何一个节点的左右子树高度差绝对值不超过1
 * 思路：后序遍历，遍历过程中收集左右子树的高度。
 */
public class CheckBalance {
	public static boolean isBalance(Node head) {
		//存放结果的变量（为啥用数组？因为数组是引用传递，基础类型是值传递，起不到全局变量的效果）
		boolean[] res = new boolean[1];
		res[0] = true;
		//获取左右子树高度的方法
		getHeight(head,1,res[0]);
		return res[0];
	}

	private static int getHeight(Node head, int level, boolean res) {
		//传入的是空子树，直接返回之前的层数
		if (head == null) {
			return level;
		}
		//递归拿到左子树的高度
		int lH = getHeight(head.left, level + 1, res);
		//如果左子树已经不是平衡二叉树，那么返回什么已经不重要了，直接退出递归
		if (!res) {
			return level;
		}
		//同理
		int rH = getHeight(head.right, level + 1, res);
		if (!res) {
			return level;
		}
		//如果绝对值大于一，改变结果的值
		if (Math.abs((lH - rH)) > 1) {
			res = false;
		}
		
		return Math.max(lH, rH);
	}
}
