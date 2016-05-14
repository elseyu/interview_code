package com.elseyu.stack_queue;

import java.util.Stack;

/**
 * 如何仅用递归函数逆序一个栈
 * 要求：只能用递归函数来实现，不能使用其他数据结构
 * @author Administrator
 *
 */
public class ReverseStack {
	/**
	 * 设计第一个递归函数，返回栈底元素并移除
	 * @param stack
	 * @return
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.empty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	/**
	 * 第二个递归函数
	 * 思路分析：1.拿到并移除栈底元素 2.如果剩下的元素已经反转，则直接把之前移除的元素插入
	 * 有点像分治，把一个问题分解成若干个子问题，这里子问题就是剩下元素的反转，直接用递归实现
	 * @param stack
	 */
	public static void reverse(Stack<Integer> stack) {
		if (stack.empty()) {
			return;
		}
		
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
}
