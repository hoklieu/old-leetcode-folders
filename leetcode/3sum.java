public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                sum = 0 - nums[i];
                while (lo < hi) {
                if  (nums[hi] + nums[lo] == sum) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[lo] == nums[lo + 1]) {
                        lo ++;
                    }
                    while (lo < hi && nums[hi] == nums[hi - 1]) {
                        hi --;
                    }
                    lo ++;
                    hi ++;
                } else if (nums[hi] + nums[lo] > sum) {
                    hi --;
                } else {
                    lo ++;
                }
                }
            }
        }
        return res;
    }
}