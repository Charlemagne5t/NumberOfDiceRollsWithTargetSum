public class Solution {
    public int numRollsToTarget(int n, int k, int target) {

        Integer[][] memo = new Integer[n + 1][target + 1];
        return dfs(n, k, target, memo);
    }

    private int dfs(int n, int k, int target, Integer[][] memo) {
        int mod = 1_000_000_007;
        if (target == 0 && n == 0) {
            return 1;
        }
        if (target < 0 || n <= 0) {
            return 0;
        }
        if (memo[n][target] != null) {
            return memo[n][target];
        }
        int result = 0;
        for (int i = 1; i <= k; i++) {
            result = (result + dfs(n - 1, k, target - i, memo)) % mod;
        }
        memo[n][target] = result % mod;
        return result % mod;

    }
}
