/**
 * Author: Arman Yekkehkhani
 * Runtime: 20ms (beats 96.37%)
 * Memory: 47.80 MB (beats 13.13%)
 * tags: binary tree, array
 */


class FindElements {
    boolean[] arr = new boolean[1 << 20];

    public FindElements(TreeNode root) {
        root.val = 0;
        decontaminate(root);
    }

    void decontaminate(TreeNode r) {
        arr[r.val] = true;
        if (r.right != null) {
            r.right.val = 2 * r.val + 2;
            decontaminate(r.right);
        }

        if (r.left != null) {
            r.left.val = 2 * r.val + 1;
            decontaminate(r.left);
        }
    }

    public boolean find(int target) {
        return arr[target];
    }
}