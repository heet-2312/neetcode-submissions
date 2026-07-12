class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>mp = new HashMap();

        for(String word:strs){
            char[] x=word.toCharArray();
            Arrays.sort(x);

            String sortedWord = new String(x);

            if(!mp.containsKey(sortedWord)){
                mp.put(sortedWord,new ArrayList<>());
            }

            mp.get(sortedWord).add(word);
        }

        return new ArrayList<>(mp.values());
    }
}
