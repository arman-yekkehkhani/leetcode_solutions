/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.68 MB (beats 31.53%)
 * tags: binary tree
 */

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        var r = new TreeNode(preorder[0]);
        int idx = 0;
        while(idx < preorder.length && preorder[idx] <= preorder[0]) {
            idx++;
        }

        if (idx > 1) {
            r.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, idx));
        }

        if (idx < preorder.length) {
            r.right = bstFromPreorder(Arrays.copyOfRange(preorder, idx, preorder.length));
        }
        return r;
    }
}