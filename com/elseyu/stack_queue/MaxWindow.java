package com.elseyu.stack_queue;

import java.util.LinkedList;

/**
 *	生成窗口最大值数组：如果数组长为n，窗口为w，则窗口数组为n-w+1，
 *	它记录着每个窗口的最大值。
 *	思路：很容易想到直接遍历，但是这样时间复杂度为O(n*w)，pass！现在考虑用
 *	双端队列，该队列每次记录窗口的最大值的位置：看代码吧。一时间很难说清楚
 */
public class MaxWindow {
	public static int[] getMaxWindows(int[] arr,int w) {
		//判断参数的合法性
		if (arr == null || w < 1 || w > arr.length) {
			return null;
		}
		//保存最大下标的双端队列，双端队列的好处是可以从首尾两端进行插入删除操作
		LinkedList<Integer> qMax = new LinkedList<>();
		//应该返回的结果集：保存每个窗口最大值的窗口数组
		int[] res = new int[arr.length - w + 1];
		//窗口数组的下标
		int index = 0;
		
		//对目标数组arr进行遍历
		for(int i = 0; i < arr.length; i++) {
			//如果双端队列非空，并且最后一个的下标对应的值小于当前遍历的值，则尾元素出队
			//这样可以保证qMax保存首元素为该窗口最大值的下标
			while(!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
				qMax.pollLast();
			}
			//将该元素插入队尾
			qMax.addLast(i);
			//判断首元素有没偶过期，过期的意思是该双端队列最多只会保存w个值
			if(qMax.peekFirst() == i - w) {
				qMax.pollFirst();
			}
			
			//从i >= w - 1开始才会有窗口出现
			if(i >= w - 1) {
				res[index++] = qMax.peekFirst();
			}
		}
		
		return res;
	}
}
