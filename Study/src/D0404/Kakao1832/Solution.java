package D0404.Kakao1832;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        // 2가지 방향 0:아래 1:오른쪽
        int[][][] dp = new int[m][n][2];
        int answer = 0;
        
        // 세로 방향
        for(int i = 1;i < m;i++){
            if(cityMap[i][0] == 1) break;
            dp[i][0][0] = 1;
        }
        // 가로 방향
        for(int j = 1;j < n;j++){
            if(cityMap[0][j] == 1) break;
            dp[0][j][1] = 1;
        }
        
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                // 통행 불가인 상태
                if(cityMap[i][j] == 1)
                    continue;
                dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][0])% MOD;
                dp[i][j][1] = (dp[i][j][1] + dp[i][j-1][1])% MOD;
                if(cityMap[i-1][j] == 0)
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][1]) % MOD;
                if(cityMap[i][j-1] == 0)
                    dp[i][j][1] = (dp[i][j][1] + dp[i][j-1][0]) % MOD;
                
            }
        }
        answer = (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
        return answer;
    }
}
