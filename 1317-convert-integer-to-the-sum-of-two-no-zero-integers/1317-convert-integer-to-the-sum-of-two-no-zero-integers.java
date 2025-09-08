class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];

        for(int i = 0; i<n; i++){
            int a = i;
            int b = n-i;

            String aS = String.valueOf(a);
            String bS = String.valueOf(b);

            boolean good = true;
            for(int j = 0; j<aS.length(); j++){
                if(aS.charAt(j)=='0'){
                    good = false;
                }
            }

            if(good == true){
                for(int j = 0; j<bS.length(); j++){
                    if(bS.charAt(j)=='0'){
                        good = false;
                    }
                }
            }
            
            if(good){
                res[0] = a;
                res[1] = b;
                return res;
            }
        }
        return res;
    }
}