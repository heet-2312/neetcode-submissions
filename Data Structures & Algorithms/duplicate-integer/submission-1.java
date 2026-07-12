class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> seen = new HashMap();
        for(int n:nums){
            if(seen.containsKey(n)){
                return true;
            }
            seen.put(n, seen.getOrDefault(n, 0) + 1);
        }
        return false;
    }
}