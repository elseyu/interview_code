package com.elseyu.stack_queue;

import java.util.Stack;

/**
 *	求最大子矩阵的大小：
 *	给定一个整数矩阵map，其中值只有0,1两种，求其中全是1的所有矩阵区域中，最大矩阵区域为1的数量
 *	思路：如果矩阵的大小为（N*M）,则本题的时间复杂度可以为O(N*M);
 *	1.以每一行进行分割，统计每一行往上1的数量
 *	2.对每一行都求出最大的子矩阵的1的数量
 *	3.迭代每一行的最大值并返回
 */
public class MaxChildMatrix {
	public static int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		//记录每一行的最大值
		int maxArea = 0;
		//表示每一行对应往上的1的数量
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < height.length; j++) {
				//对每一行的1都和上面的叠加起来
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			//把每一行放到某个方法中，求出最大子矩阵的数值
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}

	private static int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < height.length; i++) {
			while(!stack.isEmpty() && stack.peek() >= height[i]) {
				//j表示栈顶元素的位置
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		
		return maxArea;
		
	}
}
