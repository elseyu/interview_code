package com.elseyu.binarytree;
/*
 * 判断t1树是否包含t2树全部的拓扑结构：
 * 分析：首先从t1每个子树开始匹配（也就是遍历t1），如果某个子树头想等，则
 * 同时遍历t1、t2开始匹配。如果都相等返回true
 */
public class CheckContains {
	public static boolean contains(Node t1, Node t2) {
		//对每一个子树都要匹配
		return check(t1,t2) || contains(t1.left, t2) || contains(t1.right, t2);
	}
	
	public static boolean check(Node h, Node t2) {
		if (t2 == null) {
			return true;
		}
		
		if (h == null || h.value != t2.value) {
			return false;
		}
		
		return check(h.left, t2.left) && check(h.right, t2.right); 
	}
}
