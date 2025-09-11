class Solution {
    public String sortVowels(String s) {
        HashSet <Character> vowels = new HashSet<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        char[] arr = s.toCharArray();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O'); 
        vowels.add('U');
        
        for (int i = 0; i<s.length(); i++){
            char c = arr[i];
            if(vowels.contains(c)){
                pq.add(c);
                arr[i]='0';
            }
        }
        
        for(int i = 0; i<s.length(); i++){
            if(arr[i]=='0'){
                arr[i] = pq.poll();
            }
        }
        
        return new String(arr); 
    }
}