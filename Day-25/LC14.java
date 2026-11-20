class Solution {
    public String longestCommonPrefix(String[] strs) {
        int l = strs.length;
        String str1 = strs[0];
        String str2 = "";
        for(int i = 1; i < l; i++){
            if(strs[i].length() == 0) {
                return "";
            }
            else {
            if(str1.length() < strs[i].length()){
                for(int j = 0; j < str1.length(); j++){
                    if(str1.charAt(j) == strs[i].charAt(j)){
                        if(j == 0) {
                            str2 = strs[i].charAt(j) + "";
                        } else {
                            str2 = str2 + strs[i].charAt(j);
                        }
                    } else if(str1.charAt(j) != strs[i].charAt(j)) {
                        if(j == 0){
                            return "";
                        }
                        else {
                            break;
                        }
                    }
                }
            } else {
                for(int j = 0; j < strs[i].length(); j++){
                    if(str1.charAt(j) == strs[i].charAt(j)){
                        if(j == 0) {
                            str2 = strs[i].charAt(j) + "";
                        } else {
                            str2 = str2 + strs[i].charAt(j);
                        }
                    } else if(str1.charAt(j) != strs[i].charAt(j)) {
                        if(j == 0){
                            return "";
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            str1 = str2;
        }
        }
        return str1;
    }
}