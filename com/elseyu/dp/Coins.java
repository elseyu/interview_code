package com.elseyu.dp;
/*
 * 换钱的方法数：
 * 给定数组arr,arr中所有值都是正数而且不重复，每个值代表一种面值的货币，每种面值的货币可以使用任意张
 * 在给定一个aim代表要找的钱数的目标，求换钱有多少种方法。
 * 1.首先可以用暴力递归的方法来解。如果arr=[5,10,25,1],aim=1000,分析如下：
 * 	用0张5元的，让剩下的[10,25,1]组成1000，最终方法数记为res1
 * 	用1张5元，让剩下的[10,25,1]组成995，最终方法数记为res2
 * 	用2张5元，让剩下的[10,25,1]组成990，最终方法数记为res3
 * 	.....
 * 	用200张5元，让剩下的[10,25,1]组成0，最终方法数记为res200
 * 最终res1+res2+res3+...res200就是总的方法数，具体代码是coin1
 * 2.动态规划的方法：
 * 	生成一个矩阵dp[N-1][aim]的矩阵，dp[i][j]表示用arr[0...i]货币的情况下，组成
 * j有多少种情况
 * 	最优子问题：当dp[i][0]时，表示组成钱数为0有多少情况，明显为1；当dp[0][j]时，用arr[0]
 * 可以组成多少种钱数为0...j的方法？显然，只有arr[0]*k=j时才能组成
 * 	状态转换方程：当dp[i][j]时，则由下面几种情况的结果只和：
 * 	（1）使用0张arr[i]，方法数为dp[i-1][j]
 * 	（2）使用1张arr[i]，方法数为dp[i-1][j-arr[i]]
 * 	（3）使用2张arr[i]，方法数为dp[i-1][j-arr[i]*2]
 * 		...
 * 		使用k张arr[i],方法数为dp[i-1][j-arr[i]*k],其中j-arr[i]*k >= 0，k为非负整数
 * 	最终dp[N-1][aim]就是结果
 */
public class Coins {
	public static int coin1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			 return 0;
		}
		//调用一个新的方法处理
		return process1(arr,0,aim);
	}

	private static int process1(int[] arr, int index, int aim) {
		int res = 0;
		//选择到了最后一个数
		if (index == arr.length) {
			//剩下的钱数是否已经为0，如果是0则方法数为1，不为零则方法数是0
			res = aim == 0 ? 1 : 0;
		} else {
			for (int i = 0; arr[index]*i <= aim; i++) {
				//递归
				res += process1(arr, index + 1, aim - arr[index]*i);
			}
		}
		
		return res;
	}
	
	public static int coin2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			 return 0;
		}
		//定义dp矩阵
		int[][] dp = new int[arr.length][aim + 1];
		//最优子问题
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; j * arr[0] <= aim; j++) {
			dp[0][j] = 1;
		}
		int num = 0;
		//
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= aim; j++) {
				num = 0;
				for (int k = 0; (j - arr[i]*k) >= 0; k++) {
					num += dp[i-1][j-arr[i]*k];
				}
				dp[i][j] = num;
			}
		}
		return dp[arr.length - 1][aim];
	}
}
