class Solution {
    public int maxFreqSum(String s) {
        HashMap <Character, Integer> vow = new HashMap<>();
        HashMap <Character, Integer> con = new HashMap<>();
        int vows = 0;
        int cons = 0;

        vow.put('a',0);
        vow.put('i',0);
        vow.put('e',0);
        vow.put('o',0);
        vow.put('u',0);
        
        for(char c : s.toCharArray()){
            if(vow.containsKey(c)){
                vow.put(c,vow.get(c)+1);
                vows = Math.max(vows,vow.get(c));
                continue;
            }
            if(!con.containsKey(c)){
                con.put(c,0);
            }
            con.put(c,con.get(c)+1);
            cons = Math.max(cons,con.get(c));
        }

        return cons+vows;
    }
}