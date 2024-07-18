/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 44.58 MB (beats 18.38%)
 * tags: binary search tree, bst
 */

class Solution {
    Integer num;

    public int kthSmallest(TreeNode root, int k) {
        elm(root, k);
        return num;
    }

    int elm(TreeNode r, int k) {
        if (r == null) {
            return 0;
        }

        int left = elm(r.left, k);

        if (num != null) {
            return Integer.MIN_VALUE;
        }

        if (left == k - 1) {
            num = r.val;
            return Integer.MIN_VALUE;
        }

        return left + 1 + elm(r.right, k - left - 1);
    }
}

/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 36.66%)
 * Memory: 44.57 MB (beats 18.38%)
 * tags: binary search tree, bst
 */

class Solution {
    List<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        return list.get(k - 1);
    }

    void inOrder(TreeNode r) {
        if (r == null) {
            return;
        }
        inOrder(r.left);
        list.add(r.val);
        inOrder(r.right);
    }
}