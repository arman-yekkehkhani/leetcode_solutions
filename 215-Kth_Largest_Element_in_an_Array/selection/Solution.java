class Solution {
    class Item {
        int n;
        int i;

        public Item(int n, int i) {
            this.i = i;
            this.n = n;
        }

        int getI() {
            return i;
        }

        int getN() {
            return n;
        }
    }

    Item findk(Item[] nums, int k) {
        var comparator = Comparator.comparingInt(Item::getN).thenComparingInt(Item::getI);
        if (nums.length <= 5) {
            Arrays.sort(nums, comparator.reversed());
            return nums[k - 1];
        }

        Item[] med = new Item[Math.ceilDiv(nums.length, 5)];
        for(int i = 0; i < Math.ceilDiv(nums.length, 5); i++) {
            int j = Math.min((i + 1) * 5, nums.length - 1);
            Arrays.sort(nums, i * 5, j, comparator);
            med[i] = nums[(i + j) / 2];
        }

        Item m = findk(med, med.length / 2);

        Item[] p =  new Item[nums.length];
        int hi = nums.length - 1;
        int lo = 0;
        for (Item n : nums) {
            if (comparator.compare(n, m) == 1) {
                p[lo++] = n;
            }
            if (comparator.compare(n, m) == -1) {
                p[hi--] = n;
            }
        }

        if (k == lo + 1) {
            return m;
        } else if (k <= lo) {
            return findk(Arrays.copyOfRange(p, 0, lo), k);
        } else {
            hi++;
            return findk(Arrays.copyOfRange(p, ++hi, p.length), k - lo - 1);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        Item[] items = new Item[nums.length];
        for (int i = 0; i < nums.length; i++) {
            items[i] = new Item(nums[i], i);
        }
        return findk(items, k).n;
    }
}