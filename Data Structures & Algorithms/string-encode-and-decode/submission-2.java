class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "--";
        }
        String encoded="";
        for(String word:strs){
            encoded+=word;
            encoded+="#:";
        }
        System.out.println(encoded);
        return encoded;
    }

    public List<String> decode(String str) {
        if(str=="--"){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        char[] x = str.toCharArray();

        for(int i=0;i<x.length-1;i++){
            String temp="";
            while(!(x[i]=='#' && x[i+1]==':')){
                temp+=x[i];
                i++;
            }
            i=i+1;
            ans.add(temp);
        }
        if(ans.isEmpty()){
            ans.add("");
        }
        return ans;
    }
}
