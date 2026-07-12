class Solution {
    public boolean isAnagram(String s, String t) {
                int n=s.length();
        int m=t.length();

        if(n!=m)
            return false;
        HashMap<Character,Integer> mp1=new HashMap();
        HashMap<Character,Integer> mp2=new HashMap();

        for(char c:s.toCharArray()){
            mp1.put(c,mp1.getOrDefault(c,0)+1);
        }

        for(char c:t.toCharArray()){
            mp2.put(c,mp2.getOrDefault(c,0)+1);
        }

        for (Map.Entry<Character, Integer> entry : mp1.entrySet()) {
            if (!entry.getValue().equals(mp2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
