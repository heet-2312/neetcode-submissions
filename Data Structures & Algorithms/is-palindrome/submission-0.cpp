class Solution {
public:
    bool isPalindrome(string s) {
        int n=s.length();
        int i=0;
        int j=n-1;
        while(i<j){
            while(i<j && !isalnum(s[i])){
                i++;
            }
            while(j>i && !isalnum(s[j])){
                j--;
            }
            if(i!=j && tolower(s[i])!=tolower(s[j])){
                return false;
            }
            cout<<i<<" "<<j<<endl;
            i++;
            j--;
        }
        return true;
    }
};
