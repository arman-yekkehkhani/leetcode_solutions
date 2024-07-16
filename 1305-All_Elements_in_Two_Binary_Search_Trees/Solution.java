/**
 * Author: Arman Yekkehkhani
 * Runtime: 7ms (beats 99.33%)
 * Memory: 46.10 MB (beats 59.05%)
 * tags: binary tree
 */

class Solution {
    int s1 = 0;
    int s2 = 0;
    int i = 0;

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        int[] arr1 = new int[5_000];
        int[] arr2 = new int[5_000];

        inOrder(root1, arr1);
        s1 = i;
        i = 0;
        inOrder(root2, arr2);
        s2 = i;

        int j = 0;
        int k = 0;
        int jk = 0;
        Integer[] res = new Integer[s1 + s2];
        while (j + k < res.length) {
            if (j >= s1) {
                res[jk++] = arr2[k++];
            } else if (k >= s2) {
                res[jk++] = arr1[j++];
            } else if (arr1[j] < arr2[k]) {
                res[jk++] = arr1[j++];
            } else {
                res[jk++] = arr2[k++];
            }
        }
        return Arrays.asList(res);
    }

    void inOrder(TreeNode r, int[] arr) {
        if (r == null) {
            return;
        }
        inOrder(r.left, arr);
        arr[i++] = r.val;
        inOrder(r.right, arr);
    }
}