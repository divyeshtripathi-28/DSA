class Solution {
    public boolean isValid(String[] str, int[] i) {
        if(i[0] >= str.length) return false;
        if(str[i[0]].equals("#")) {
            i[0]++;
            return true;
        }
        
        i[0]++;
        boolean left = isValid(str, i);
        boolean right = isValid(str, i);

        return right && left;
    }
    public boolean isValidSerialization(String preorder) {
        String[] str = preorder.split(",");

        int [] i = {0};

        return isValid(str, i) && i[0] == str.length;
    }
}