package com.elseyu.binarytree;
/*
 * 根据有序数组生成平衡搜索二叉树
 * 1.递归过程比较简单：找到数组中间的数作为头，左边部分作为左子树，右边部分作为右子树
 * 2.分别递归左右子树
 */
public class CreateBST {
	public static Node toBST(int[] arr) {
		if (arr == null || arr.length < 1) {
			return null;
		}
		return createBST(arr, 0, arr.length-1);
	}

	private static Node createBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = (start + end)/2;
		Node head = new Node(arr[mid]);
		head.left = createBST(arr, start, mid - 1);
		head.right = createBST(arr, mid + 1, end);
		return head;
	}
}
