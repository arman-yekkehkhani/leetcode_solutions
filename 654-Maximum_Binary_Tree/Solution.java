/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 100%)
 * Memory: 44.88 MB (beats 35.28%)
 * tags: binary tree
 */

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return mbt(nums, 0, nums.length);
    }

    TreeNode mbt(int[] nums, int s, int f) {
        int max = Integer.MIN_VALUE;
        int idx = s;
        for (int i = s; i < f; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }

        var r = new TreeNode(nums[idx]);
        if (idx + 1 < f) {
            r.right = mbt(nums, idx + 1, f);
        }
        if (idx > s) {
            r.left = mbt(nums, s, idx);
        }
        return r;
    }
}§