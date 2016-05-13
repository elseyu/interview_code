package com.elseyu.stack_queue;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基础功能上，再返回栈中最小元素的基本操作
 * 第一种做法
 * @author Administrator
 *
 */

public class GetMinStack1 {
	private Stack<Integer> stackData; //保存原始数据的栈
	private Stack<Integer> stackMin; //保存最小值的栈
	
	public GetMinStack1() {
		this.stackData = new Stack<>();
		this.stackMin = new Stack<>();
	}
	
	//插入
	public void push(int newNum) {
		//装最小值的栈为空时直接插入
		if(this.stackMin.isEmpty()) {
			stackMin.push(newNum);
			//如果新压入的数值小于最小值栈顶的数，则也压入最小值的栈中
		} else if(newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}
		//入栈
		this.stackData.push(newNum);
	}

	//弹出
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("栈已经空了！");
		}
		int value = this.stackData.pop();
		//如果弹出的数值等于栈（只会大于或者等于），则最小值栈弹出栈顶元素
		if(value == getMin()) {
			this.stackMin.pop();
		}
		return value;
	}
	
	//获取最小值
	private int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("栈为空！！");
		}
		this.stackMin.peek();
		return 0;
	}
	
}
