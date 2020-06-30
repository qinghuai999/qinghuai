//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 方案一: 冒泡(暴力破解法)
        // 时间复杂度: O(n^2),空间复杂的O(1)
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[j] + nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");*/

        // 方案二: 两遍哈希表 --> 支持近似恒定的时间进行快速查找
        // 时间复杂度: O(n),空间复杂度: O(n)
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complment = target - nums[i];
            // 如果Map的元素不重复且符合要求,则放如数组
            if (map.containsKey(complment) && map.get(complment) != i) {
                return new int[]{i, map.get(complment)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");*/

        // 方案三: 一遍哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complment = target - nums[i];
            if (map.containsKey(complment)) {
                return new int[]{map.get(complment), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
