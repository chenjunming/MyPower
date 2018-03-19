package cn.cjm.interview11;

/*
 * 实现函数double Power（double base, int exponent），
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 解题思路：
 * 	首先将指数变成绝对值，然后关键是利用n = n/2 +n/2 (n为偶数）
 * 									n = n/2 + n/2 +1(n为奇数)
 */
public class MyPower {
	public static void main(String[] args) {
		double base = 2.5;
		int exponent = -3;
		System.out.println(power(base, exponent));
		//System.out.println(Math.abs(exponent));
	}
	
	public static double power(double base,int exponent) {
		// 处理底为0的情况
		if(Math.abs(base-0.0)<=0.00000001) {
			return 0.0;
		}
		// 判断底是否未负数
		boolean flag = false;
		if(exponent<0)flag = true;
		// 计算当指数为正数时的值
		double powerPositive = powerPositive(base,Math.abs(exponent));
		if(flag) {//指数是负数
			powerPositive = 1/powerPositive;
		}
		return powerPositive;
	}

	private static double powerPositive(double base, int exponent) {
		if(exponent==1)return base;
		if((exponent&1)==1) {//如果是奇数
			double half = powerPositive(base, exponent>>1);
			return half*half*base;
		}else {//如果是偶数
			double half = powerPositive(base, exponent>>1);
			return half*half;
		}
		
	}
	
	
}
