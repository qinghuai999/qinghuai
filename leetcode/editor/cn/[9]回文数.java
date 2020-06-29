//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        // 边界判断,负数一定为false
        if (x < 0) {
            return false;
        }

        // 方法一: 从左到右遍历与从右到左遍历对比是否相等
        /*int num = x;
        int cur = 0;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;*/

        // 方法二: 首位和末尾对比
        /*int div = 1;
        // 通过总位数得出求左边第一位数的倍数
        while (x / div >= 10) {
            div *= 10;
        }

        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            // 去掉第一位和最后一位
            x = (x % div) / 10;
            div /= 100;
        }
        return true;*/

        // 方法三: 取出后半段进行翻转(要注意数字个数有奇有偶) --> 二分思想
        // 判断边界 --> 负数或者10的倍数,不可能成为回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // 翻转数字
        int revertNum = 0;
        // 如果x比翻转后的数字长度大,则继续循环
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
