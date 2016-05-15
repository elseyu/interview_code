package com.elseyu.stack_queue;

import java.util.Stack;

/**
 *	用一个栈实现另一个栈的排序
 *	要求：只能额外申请一个栈，允许使用变量，但是不能申请其它数据结构 
 *	思路：当前栈是stack，辅助栈是helpStack，当前栈不断弹出元素，
 *	和辅助栈栈顶比较，若小，直接压入；如大，则辅助栈不断弹出元素压入
 *	当前栈，直到出现比变量大的元素为止。不断重复此过程，当前栈为空时完成排序
 */
public class SortStack {
	
	public static void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> helpStack = new Stack<>();
		while (!stack.empty()) {
			int value = stack.pop();
			while (!helpStack.isEmpty() && value > helpStack.peek()) {
				stack.push(helpStack.pop());
			}
			helpStack.push(value);
		}
		
		while (!helpStack.isEmpty()) {
			stack.push(helpStack.pop());
		}
	}
}
