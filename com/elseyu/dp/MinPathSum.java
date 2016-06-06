package com.elseyu.dp;
/*
 * 矩阵的最小路径和：
 * 从左上角开始，每次只能向右走或者向下走，最后到达右下角的位置，
 * 路径上所有数字加起来的结果就是路径和，返回所有路径中最小的路径和
 * 思路：经典的动态规划解法：假设矩阵m的大小是M*N，先生成一个大小和m一样的的矩阵dp
 * dp[i][j]的值就是表示从左上角[0][0]位置走到[i][j]的最小路径和。
 * 1.当i=0时，dp[0][j] = dp[0][j-1] + m[0][j],因为这个时候只能向右走
 * 2.当j=0时，dp[i][0] = dp[i-1][0] + m[i][0],因为这个时候只能向下走
 * 3.在其他情况，dp[i][j] = min(dp[i][j-1],dp[i-1][j]) + m[i][j],因为这个时候
 * 有两种走法，上面走下来的是dp[i-1][j]，左边向右走的是dp[i][j-1]，所以肯定取最小的一个
 * 4.当到走到下角，过程结束
 */
public class MinPathSum {
	public static int minPathSum(int[][] m) {
		if (m == null || m.length == 0 || m[0].length == 0) {
			return 0;
		}
		//行数
		int row = m.length;
		//列
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		//当j=0时，dp[i][0] = dp[i-1][0] + m[i][0],因为这个时候只能向下走
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i-1][0] + m[i][0];
		}
		//当i=0时，dp[0][j] = dp[0][j-1] + m[0][j],因为这个时候只能向右走
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j-1] + m[0][j];
		}
		
		//其他情况
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}
}
