package com.elseyu.stack_queue;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基础功能上，再返回栈中最小元素的基本操作
 * 第二种做法
 * @author Administrator
 * 思路和第一种差不多 但是第二种的特点是dataStack和minStack的数量是一样的，
 * 出栈都是同时出栈
 *
 */
public class GetMinStack2 {
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	
	public GetMinStack2() {
		this.dataStack = new Stack<>();
		this.minStack = new Stack<>();
	}

	public void push(int newNum) {
		//minStack为空时直接压入
		if (minStack.empty()) {
			this.minStack.push(newNum);
			//小于最小，也是直接压入
		} else if (newNum < getMin()) {
			this.minStack.push(newNum);
			//否则将栈顶元素继续压入
		} else {
			int num = this.minStack.peek();
			minStack.push(num);
		}
			
		this.dataStack.push(newNum);
	}
	
	//出栈比较省时间，同事出栈
	public int pop() {
		if(this.dataStack.empty()) {
			throw new RuntimeException("栈空了");
		}
		this.minStack.pop();
		return dataStack.pop();
	}
	
	public int getMin() {
		if(this.minStack.empty()) {
			throw new RuntimeException("栈中还没有元素");
		}
		return this.minStack.peek();
	}
}
