/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 44.22 MB (beats 5.12%)
 * tags: binary search tree
 */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        int m = nums.length / 2;
        var r = new TreeNode(nums[m]);
        r.right = sortedArrayToBST(Arrays.copyOfRange(nums, m + 1, nums.length));
        r.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, m));
        return r;
    }
}