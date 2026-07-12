class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i:nums){
            mp.put(i,mp.getOrDefault(i,0)+1);
        }
        
        List<Integer>[] bucket = new ArrayList[n+1];


        for(int key:mp.keySet()){
            int freq = mp.get(key);

            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }   
            bucket[freq].add(key);
        }

        int ans[] = new int[k];
        int index=0;

        for(int i=n;i>=0 && index<k;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    ans[index++]=num;
                }                
            }
        }

        return ans;

    }
}
