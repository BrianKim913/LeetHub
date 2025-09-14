class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for(int[] item : items){
            int id = item[0];
            int score = item[1];
            if(!map.containsKey(id)){
                map.put(id,new PriorityQueue<>(Collections.reverseOrder()));
            }
            map.get(id).add(score);
        }
        int[][] res = new int[map.size()][2];

        int idx = 0;
        for(int i : map.keySet()){
            int avg = 0;
            for(int j = 0; j<5; j++){
                avg += map.get(i).poll();
            }
            avg = avg/5;
            res[idx][0] = i; 
            res[idx][1] = avg;
            idx++;
        }
        return res;
    }
}

