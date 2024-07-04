/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 97.48%)
 * Memory: 44.39 MB (beats 61.89%)
 * tags: binary tree
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }

        if (cloned.val == target.val) {
            return cloned;
        }

        var r = getTargetCopy(original, cloned.right, target);
        if (r != null) {
            return r;
        }
        var l = getTargetCopy(original, cloned.left, target);
        if (l != null) {
            return l;
        }
        return null;
    }
}