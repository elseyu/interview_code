package com.elseyu.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 实现二叉树的序列化和反序列化
 * 二叉树被记录成文件的过程叫做序列化，通过文件内容重建原来二叉树的过程叫做
 * 二叉树的反序列化。给定一棵二叉树的头节点head，并已知节点类型为32位的整数，
 * 请设计一种二叉树序列化和反序列化的方案。
 * 思路：通过先序遍历实现二叉树的序列化和反序列化：
 * 先序遍历二叉树，遇到的节点用"数字" + "!"来表示，例如遇到了3，表示成"3!"；
 * 如果遇到空值，用"#!"来表示。
 * （有人可能会想，书上不是说只由先序遍历的结果是还原不了二叉树的吗？为什么这里可以？
 * 其实书上没错，但这里也可以，因为书上遍历二叉树的时候是不会保存空值的，但是这里遍历
 * 的时候会吧空值也保存下来，所以是可以还原的。
 * ）
 */
public class SerializeTree {
	//序列化
	public static String serialByPre(Node head) {
		if (head == null) {
			return "#!";
		}
		//如果涉及很多次拼接操作的话，最好还是用StringBuilder
		String s = head.value + "!";
		s += serialByPre(head.left);
		s += serialByPre(head.right);
		return s;
	}
	
	//反序列化
	//先解析传进来的字符串结果，生成队列（方便遍历，其实不生产也可以，只是稍微麻烦点）
	public static Queue<String> parseString(String s) {
		String[] res = s.split("!");
		Queue<String> queue = new LinkedList<>();
		for (int i = 0; i < res.length; i++) {
			queue.add(res[i]);
		}
		return queue;
	}
	
	public static Node reconPre(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = reconPre(queue);
		head.right = reconPre(queue);
		return head;
	}
}
