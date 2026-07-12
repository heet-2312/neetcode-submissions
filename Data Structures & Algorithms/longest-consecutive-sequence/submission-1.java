class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> mp = new HashMap<>();

        for(int num:nums){
            mp.put(num,true);
        }
        int ans1=0;
        for(int key:mp.keySet()){
            if(mp.get(key)){
                int ans=0;
                int x = key;
                int y= x;
                while(mp.containsKey(x)){
                    mp.put(x,false);
                    ans++;
                    x--;
                }
                while(mp.containsKey(y)){
                    mp.put(y,false);
                    ans++;
                    y++;
                }
                ans1=Integer.max(ans-1,ans1);
            }
        }   
        return ans1;
    }
}
