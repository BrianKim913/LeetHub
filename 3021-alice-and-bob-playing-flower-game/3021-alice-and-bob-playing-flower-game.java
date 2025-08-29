//문제는 간단, x+y가 홀수 인 모든 가능한 조합을 반환 하면 됨, 하지만 아래 처럼 문제를 풀면 time exeeded 에러,
//constraint에 n,m은 최대 10^5 값을 가질 수 있어 아래와 같은 O(n^2)의 풀이는 10^10의 연산을 진행,

// class Solution {
//     public long flowerGame(int n, int m) {

//         if(n==1 && m==1) return (long)0;
        
//         long res = 0;
//         for(int i = 1; i<=n; i++){
//             for(int j = 1; j<=m; j++){
//                 if((i+j)%2==1){
//                     res++;
//                 }
//             }
//         }

//         return res;
//     }
// }

class Solution {
    public long flowerGame(int n, int m) {
        return ((long) m * n) / 2;
    }
}