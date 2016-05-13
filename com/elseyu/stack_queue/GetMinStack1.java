package com.elseyu.stack_queue;

import java.util.Stack;

/**
 * ʵ��һ�������ջ����ʵ��ջ�Ļ��������ϣ��ٷ���ջ����СԪ�صĻ�������
 * ��һ������
 * @author Administrator
 *
 */

public class GetMinStack1 {
	private Stack<Integer> stackData; //����ԭʼ���ݵ�ջ
	private Stack<Integer> stackMin; //������Сֵ��ջ
	
	public GetMinStack1() {
		this.stackData = new Stack<>();
		this.stackMin = new Stack<>();
	}
	
	//����
	public void push(int newNum) {
		//װ��Сֵ��ջΪ��ʱֱ�Ӳ���
		if(this.stackMin.isEmpty()) {
			stackMin.push(newNum);
			//�����ѹ�����ֵС����Сֵջ����������Ҳѹ����Сֵ��ջ��
		} else if(newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}
		//��ջ
		this.stackData.push(newNum);
	}

	//����
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("ջ�Ѿ����ˣ�");
		}
		int value = this.stackData.pop();
		//�����������ֵ����ջ��ֻ����ڻ��ߵ��ڣ�������Сֵջ����ջ��Ԫ��
		if(value == getMin()) {
			this.stackMin.pop();
		}
		return value;
	}
	
	//��ȡ��Сֵ
	private int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("ջΪ�գ���");
		}
		this.stackMin.peek();
		return 0;
	}
	
}
