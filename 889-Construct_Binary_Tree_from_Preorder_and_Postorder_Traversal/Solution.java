/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 43.19 MB (beats 61.11 %)
 * tags:
 */

class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        var tn = build(preorder, 0, preorder.length, postorder, 0, postorder.length);
        return tn;
    }

    TreeNode build(int[] preorder, int preStart, int preFinish,
                   int[] postorder, int postStart, int postFinish) {
        if (preFinish - preStart == 0) {
            return null;
        }

        var node = new TreeNode(preorder[preStart]);
        if (preFinish - preStart == 1) {
            return node;
        }

        int v = postorder[postFinish - 2];

        int idx = preStart;
        for (int i = preStart; i < preFinish; i++) {
            if (preorder[i] == v) {
                idx = i;
                break;
            }
        }

        node.left = build(
                preorder, preStart + 1, idx,
                postorder, postStart, postStart + (idx - preStart) - 1
        );

        node.right = build(
                preorder, idx, preFinish,
                postorder, postStart + (idx - preStart) - 1, postFinish - 1
        );
        return node;
    }
}