package com.elseyu.binarytree;

import java.util.Stack;

/*
 * 分别用递归和非递归的方式先序、中序、后序遍历二叉树
 * 1.递归方法，书上的基础内容，不多说
 * 2.这里给出树节点的定义，后面不再给出
 */
public class TraverseTree {
	//遍历过程中的操作方法
	public static void oper(Node node) {
		System.out.println(node.value);
	}
	
	//1.先序遍历
	public static void preOrderTraverse(Node head) {
		if (head == null) {
			return;
		}
		oper(head);
		preOrderTraverse(head.left);
		preOrderTraverse(head.right);
	}
	
	//2.中序遍历
	public static void inOrderTraverse(Node head) {
		if (head == null) {
			return;
		}
		inOrderTraverse(head.left);
		oper(head);
		inOrderTraverse(head.right);
	}
	
	//3.后序遍历
	public static void posOrderTraverse(Node head) {
		if (head == null) {
			return;
		}
		preOrderTraverse(head.left);
		preOrderTraverse(head.right);
		oper(head);
	}
	
	/*
	 * 下面是非递归的遍历方法
	 */
	
	/*
	 * 1.非递归先序遍历:
	 * (1)申请一个栈，先将头节点head放入栈中
	 * (2)栈顶出栈，处理出栈的节点，然后将出栈节点的右孩子压入栈中；再将左孩子
	 * 压入栈中
	 * (3)不断重复(2)过程，知道栈为空
	 */
	public static void preOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> stack = new Stack<>();
			stack.push(head);
			Node cur = null; //用来保存弹出的节点
			while (!stack.isEmpty()) {
				cur = stack.pop();
				oper(cur); //先操作，再分别将右、左孩子放入
				if (cur.right != null) {
					stack.push(cur.right);
				}
				if (cur.left != null) {
					stack.push(cur.left);
				}
			}
		}
	}
	
	/*
	 * 2.中序非递归遍历
	 * (1)cur=head，将head压入栈中，然后不断令cur = cur.left，不断压入栈中
	 * 直到cur为空,
	 * (2)此时弹出一个节点，记为node，操作给节点，然后令cur = node.riht，再不断重复
	 * 步骤1
	 * (3)当栈为空而且cur = null时结束
	 */
	
	public static void inOrderUnRecur(Node head) {
		if (head != null) {
			Node cur = head;
			Stack<Node> stack = new Stack<>();
			while (!stack.isEmpty() || cur != null) {
				//左节点不为空
				if (cur != null) {
					stack.push(cur);
					cur = cur.left;
					//左节点已经全部入栈，弹出打印
				} else {
					cur = stack.pop();
					oper(cur);
					//重要
					cur = cur.right;
				}
			}
		}
	}
	
	/**
	 * 3.后序非递归遍历
	 * (1)用两个栈实现
	 * (2)将head压入s1中
	 * (3)s1弹出，将弹出节点的左孩子、右孩子分别压入栈s1中，弹出的节点存入
	 * s2中
	 * (4)不断重复，直到栈为空；最后从s2栈中依次弹出打印
	 */
	
	public static void posOrderUnRecur(Node head) {
		if (head != null) {
			Stack<Node> s1 = new Stack<>();
			Stack<Node> s2 = new Stack<>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				s1.push(head.left);
				s1.push(head.right);
			}
			//依次弹出遍历就是后续便利
			while (!s2.isEmpty()) {
				oper(s2.pop());
			}
		}
	}
	
}

//树节点定义
class Node {
	int value;
	Node left;
	Node right;
	public Node(int val) {
		this.value = val;
	}
}
