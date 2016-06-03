package com.elseyu.binarytree;
/*
 * 根据后序数组重建搜索二叉树
 * 1.首先给定一个数组，而且没有重复值，判断是否可能是由搜索二叉树后序遍历的结果
 * 2.已知这个数组是搜索二叉树后序遍历的结果，请重建此棵二叉树
 * 思路：
 * 1.和之前根据前序、中序结果还原二叉树类似，后序便利的过程中，头节点一定是最后一个：
 * 假如有数组arr，那么头节点一定是arr[length-1],存在某个arr[i],使得arr[0]..
 * arr[i]都小于arr[length-1]，arr[i+1]...arr[length-2]大于arr[length-1]。
 * 2.不断递归上述过程，直到数组长度为1
 * 3.在递归的过程中重建二叉树
 */
public class PostArray {
	//判断是否为搜索二叉树后序遍历的结果
	public static boolean isArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		
		return isPost(arr,0,arr.length);
	}

	private static boolean isPost(int[] arr, int start, int end) {
		//证明数组长度为1
		if (start == end) {
			return true;
		}
		
		int less = -1; //存放最后一个小于头节点的位置
		//找到less
		for(int i = start; i < end; i++) {
			if (arr[i] > arr[end]) {
				less = i - 1;
				break;
			}
			//没找到，返回false
			return false;
		}
		//检查大于的情况
		for(int i = less + 1; i < end; i++) {
			if (arr[i] < arr[end]) {
				//存在比它小的数
				return false;
			}
		}
		//递归上述过程
		return isPost(arr, start, less) && isPost(arr, less + 1, end - 1);
	}
	
	//根据后序数组重建搜索二叉树
	public static Node posArrayToBST(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		
		return toBST(arr,0,arr.length);
	}

	private static Node toBST(int[] arr, int start, int end) {
		//证明数组长度为1
				if (start > end) {
					return null;
				}
				
				int less = -1; //存放最后一个小于头节点的位置
				//找到less
				for(int i = start; i < end; i++) {
					if (arr[i] > arr[end]) {
						less = i - 1;
						break;
					}
				}
				//递归上述过程
				Node head = new Node(arr[end]);
				head.left = toBST(arr, start, less);
				head.right = toBST(arr, less + 1, end - 1);
				return head;
	}
}
