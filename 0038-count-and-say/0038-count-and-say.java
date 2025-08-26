class Solution {
    public String countAndSay(int n) {
        String current = "1";
        for (int i = 2; i <= n; i++) {
            String next = "";
            for (int j = 0, k = 0; j < current.length(); j = k) {
                while (
                    k < current.length() &&
                    current.charAt(k) == current.charAt(j)
                ) k++;
                next += Integer.toString(k - j) + current.charAt(j);
            }
            current = next;
        }
        return current;
    }
}