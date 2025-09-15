class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        HashSet<Character> set = new HashSet<>();
        for(char c : brokenLetters.toCharArray()){
            set.add(c);
        }

        int res =0;
        String [] letter = text.split(" ");
        for(int i = 0; i<letter.length; i++){
            char[] cArr = letter[i].toCharArray(); 
            for(int j = 0; j<cArr.length; j++){
                if(set.contains(cArr[j])) break; //continue;
                if(j==cArr.length-1) res++;
            }
        }

        return res;

        
    }
}