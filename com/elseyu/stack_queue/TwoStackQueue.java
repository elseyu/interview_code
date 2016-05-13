package com.elseyu.stack_queue;

import java.util.Stack;

/**
 * 经典题目：两个栈实现一个队列
 * @author Administrator
 *
 */
public class TwoStackQueue {
	private Stack<Integer> pushStack;
	private Stack<Integer> popStack;
	
	public TwoStackQueue() {
		this.popStack = new Stack<>();
		this.pushStack = new Stack<>();
	}
	
	public void push(int num) {
		this.pushStack.push(num);
	}
	
	public int poll() {
		//判断队列是否为空 增加程序鲁棒性
		if(popStack.isEmpty() && pushStack.isEmpty()) {
			throw new RuntimeException();
			//如果弹出栈为空，将压入栈所有元素“倒进”弹出栈
		} else if(popStack.isEmpty()) {
			while(!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		//弹出栈弹出栈顶元素
		return popStack.pop();
	}
	
	//和pop同理
	public int peek() {
		if(popStack.isEmpty() && pushStack.isEmpty()) {
			throw new RuntimeException();
		} else if(popStack.isEmpty()) {
			while(!pushStack.isEmpty()) {
				popStack.push(pushStack.pop());
			}
		}
		
		return popStack.peek();
	}
}
