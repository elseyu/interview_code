package com.elseyu.stack_queue;

import java.util.HashMap;
import java.util.Stack;

/**
 *	题目：构造数组的MaxTree：
 *	给定一个数组，此数组没有重复值，用此数组的所有值构造一棵二叉树，使得这个树的的每一棵子树的树头都是最大值
 *	思路：有点容易想出用构造最大堆的方法，但是时间复杂度是O(nlgn)；如果要求时间复杂度为O(n),
 *	空间复杂度也为O(n)，上述方法就无能为力了。下面给出O(n)的方法。
 */

/**
 *	首先给出树节点的定义：
 */

class Node {
	public int value;
	public Node left;
	public Node right;
	
	public Node(int value) {
		this.value = value;
	}
}

/**
 *	主要思路如下：
 *	1.给定一个数组arr[]，我们从头遍历，加入到达任意i的位置，只需要找到arr[i]左边（0 ... i-1）和右边
 *	(i+1 ... length)的第一个比arr[i]大的数，而且找出最小的一个，这个数就是arr[i]的父亲节点
 *	2.如果左边和右边都没有比它大的数，则这个数就是整棵树的父节点
 *	3.现在问题是，如何在最短的时间内找到任意位置左右两边的第一个比arr[i]大的数。利用栈！！
 */

public class MaxTree {
	/**
	 * 这个就是生成最大数的方法，会申请一个栈和两个HashMap作为辅助,具体什么作用请看代码
	 * @param arr 给定的数组
	 * @return 返回这个树的父节点
	 */
	public static Node getMaxTree(int[] arr) {
		//树节点数组
		Node[] nodeArr = new Node[arr.length];
		//对所有节点初始化
		for(int i = 0; i < arr.length; i++) {
			nodeArr[i] = new Node(arr[i]);
		}
		//辅助栈
		Stack<Node> stack = new Stack<>();
		//辅助HashMap，rMaxMap保存每一个节点右边第一个比arr[i]大的数，lMaxMap保存每一个节点左边第一个比arr[i]大的数
		//这样的好处是，只要给每一个值初始化了左右两边的最大值，只需要查HashMap就可以很快得到左右两边的最大值
		HashMap<Node, Node> rMaxMap = new HashMap<>();
		HashMap<Node, Node> lMaxMap = new HashMap<>();
		
		//下面是利用栈这个数据结构，对lMaxMap进行初始化（这里说的初始化是给每一个节点找出左右两边的第一个比arr[i]大的数）
		//在这里，我们保持栈从下往上，是递减序列，也就是说栈顶元素右边第一个比它大的数一定是它底下压着的数
		for (int i = 0; i < nodeArr.length; i++) {
			//拿到当前遍历的节点
			Node curNode = nodeArr[i];
			//这一步很关键，如果栈非空，并且栈顶的节点值小于当前节点，则栈顶出栈（如果不出栈直接压入，则破坏了栈从下往上，是递减序列），
			//出栈的节点的左边第一个比它大的数一定是它下面的数值，得把它们的关系保存到Hash表里面
			while ((!stack.empty()) && stack.peek().value < curNode.value) {
				//栈顶元素出栈
				Node topNode = stack.pop();
				//判断此时栈是否为空，为空则左边无比它大的元素，非空，则现在的栈顶元素就是第一个元素
				if(stack.isEmpty()) {
					lMaxMap.put(topNode, null);
				} else {
					lMaxMap.put(topNode, stack.peek());
				}
			}
			
			//最后要把当前节点入栈
			stack.push(curNode);
		}
		
		//栈中剩下的所有节点肯定是按左到右递减的顺序的，所以一个个pop出来存进lMaxMap
		while(!stack.isEmpty()) {
			Node topNode = stack.pop();
			//判断此时栈是否为空，为空则左边无比它大的元素，非空，则现在的栈顶元素就是第一个元素
			if(stack.isEmpty()) {
				lMaxMap.put(topNode, null);
			} else {
				lMaxMap.put(topNode, stack.peek());
			} 
			//实际上可以把这一段抽出来作为一个方法，但是为了便于理解，这里并没有这样做
		}
		
		//下面对rMaxMap进行初始化，道理是一样的，只不过遍历顺序是从后往前遍历
		for (int i = nodeArr.length - 1; i >= 0; i--) {
			Node curNode = nodeArr[i];
			//这一步很关键，如果栈非空，并且栈顶的节点值小于当前节点，则栈顶出栈（如果不出栈直接压入，则破坏了栈从下往上，是递减序列），
			//出栈的节点的右边边第一个比它大的数一定是它下面的数值，得把它们的关系保存到Hash表里面
			while ((!stack.empty()) && stack.peek().value < curNode.value) {
				//栈顶元素出栈
				Node topNode = stack.pop();
				//判断此时栈是否为空，为空则左边无比它大的元素，非空，则现在的栈顶元素就是第一个元素
				if(stack.isEmpty()) {
					rMaxMap.put(topNode, null);
				} else {
					rMaxMap.put(topNode, stack.peek());
				}
			}
			
			//最后要把当前节点入栈
			stack.push(curNode);
		}
		
		while(!stack.isEmpty()) {
			Node topNode = stack.pop();
			//判断此时栈是否为空，为空则左边无比它大的元素，非空，则现在的栈顶元素就是第一个元素
			if(stack.isEmpty()) {
				rMaxMap.put(topNode, null);
			} else {
				rMaxMap.put(topNode, stack.peek());
			} 
			//实际上可以把这一段抽出来作为一个方法，但是为了便于理解，这里并没有这样做
		}
		
		/************************************************************/
		//上面已经把所有节点左右关系都找出来了，剩下的就是生成树
		
		Node head = null;
		for (int i = 0; i < nodeArr.length; i++) {
			Node curNode = nodeArr[i];
			//分别找到左右两边第一个比它大的节点
			Node rightBig = rMaxMap.get(curNode);
			Node leftBig = lMaxMap.get(curNode);
			
			//如果一个节点左右两边都没有比他大的值，则它肯定是头节点
			if(leftBig == null && rightBig == null) {
				head = curNode;
				//如果一个节点左边没有比它大的（leftBig == null），那么它的父节点肯定是右边rightBig
			} else if (leftBig == null) {
				//左边为空则存到左节点，否则存到右节点
				if(rightBig.left == null) {
					rightBig.left = curNode;
				} else {
					rightBig.right = curNode;
				}
				//和上面同理
			} else if (rightBig == null) {
				if(leftBig.left == null) {
					leftBig.left = curNode;
				} else {
					leftBig.right = curNode;
				}
				//左右两边都有值
			} else {
				//比较左右两边，取较小值
				Node parent = rightBig.value > leftBig.value ? leftBig : rightBig; 
				if(parent.left == null) {
					parent.left = curNode;
				} else {
					parent.right = curNode;
				}
			}
		}
		return head;
	}
	
}
