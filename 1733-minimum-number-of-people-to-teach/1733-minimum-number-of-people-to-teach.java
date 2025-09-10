class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        HashMap<Integer, HashSet<Integer>> userLangs = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            userLangs.put(i + 1, new HashSet<>());
            for (int lang : languages[i]) {
                userLangs.get(i + 1).add(lang);
            }
        }
        
        HashSet<Integer> problematicUsers = new HashSet<>();
        
        for (int[] friendship : friendships) {
            int user1 = friendship[0];
            int user2 = friendship[1];
            
            HashSet<Integer> langs1 = userLangs.get(user1);
            HashSet<Integer> langs2 = userLangs.get(user2);
            
            boolean canCommunicate = false;
            for (int lang : langs1) {
                if (langs2.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            
            if (!canCommunicate) {
                problematicUsers.add(user1);
                problematicUsers.add(user2);
            }
        }
        
        int minTeach = problematicUsers.size(); 
        
        for (int lang = 1; lang <= n; lang++) {
            int needToTeach = 0;
            for (int user : problematicUsers) {
                if (!userLangs.get(user).contains(lang)) {
                    needToTeach++;
                }
            }
            minTeach = Math.min(minTeach, needToTeach);
        }
        
        return minTeach;
    }
}