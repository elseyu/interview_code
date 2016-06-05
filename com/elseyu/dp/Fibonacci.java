package com.elseyu.dp;

/*
 * 斐波那契系列问题的递归和动态规划
 * 问题一：给定整数N，返回斐波那契额数列的第N项
 * 问题二：给定整数N，代表台阶数，一次可以跨一个或者两个台阶，返回有多少种走法
 * 问题三：假设农场中成熟的奶牛每年会生1头小母牛，并且永远不会死。第一年农场有只成熟的母牛，
 * 从第二年开始，母牛开始生小奶牛。每只小母牛3年后成熟又可以生小母牛。给定整数N，求N年后
 * 牛的数量。
 * 要求：对已以上所有题目，实现时间复杂度为O(logN)的解法
 * 
 * 思路：
 * 1.O(2^N)解法：直接递归公式就好
 * 2.O(N)：迭代法
 * 3.O(logN):矩阵法
 */
public class Fibonacci {
	//关于问题一：可以知道递归公式是：f(1)=1,f(2)=1,....,f(n) = f(n-1) + f(n-2)
	public static int fib1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		
		return fib1(n - 1) + fib1(n - 2);
	}
	
	//上面的解法时间复杂度明显达到了O(2^N)，是很不可取的，应该用迭代法
	public static int fib2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int pre = 1;
		int res = 1;
		int tmp = 0;
		//从第三个开始迭代
		for (int i = 3; i <= n; i++) {
			tmp = res;
			res = res + pre;
			pre = tmp;
		}
		return res;
	}
	
	/*
	 * O(logN)解法：由f(n) = f(n-1) + f(n-2)，可以知道
	 * [f(n),f(n-1)] = [f(n-1),f(n-2)] * {[1,1],[1,0]}
	 * 所以最后化简为:[f(n),f(n-1)] = [1,1] * {[1,1],[1,0]}^(n-2)
	 * 所以这里的核心是：
	 * 1.矩阵的乘法
	 * 2.矩阵快速幂（因为如果不用快速幂的算法，时间复杂度也只能达到O(N)）
	 * 下面先给矩阵乘法：
	 */
	//矩阵乘法
	public static int[][] multiMatrix(int[][] m1,int[][] m2) {
		//参数判断什么的就不给了，如果矩阵是n*m和m*p,那结果是n*p
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}
	/*
	 * 矩阵的快速幂：
	 * 1.假如不是矩阵，叫你求m^n,如何做到O(logn)？答案就是整数的快速幂：
	 * 假如不会溢出，如10^75,把75用用二进制表示：1001011,那么对应的就是：
	 * 10^75 = 10^64*10^8*10^2*10
	 * 2.把整数换成矩阵，是一样的
	 */
	public static int[][] matrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		//先把res设为单位矩阵
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		} //单位矩阵乘任意矩阵都为原来的矩阵
		//用来保存每次的平方
		int[][] tmp = m;
		//p每循环一次右移一位
		for ( ; p != 0; p >>= 1) {
			//如果该位不为零，应该乘
			if ((p&1) != 0) {
				res = multiMatrix(res, tmp);
			}
			//每次保存一下平方的结果
			tmp = multiMatrix(tmp, tmp);
		}
		return res;
	}
	
	//所以O(logN)的解法如下
	public static int fib3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		//底
		int[][] base = {{1,1},{1,0}};
		//求底为base矩阵的n-2次幂
		int[][] res = matrixPower(base, n - 2);
		//根据[f(n),f(n-1)] = [1,1] * {[1,1],[1,0]}^(n-2)，f(n)就是
		//1*res[0][0] + 1*res[1][0]
		return res[0][0] + res[1][0];
	}
}
