class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> set = Set.of('a','e','i','o','u');
        
        int idx = 0;
        while(idx<s.length()){
            if(set.contains(s.charAt(idx))) return true;
            idx++;
        }

        return false;
    }
}