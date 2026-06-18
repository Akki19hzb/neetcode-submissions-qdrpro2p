class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0, r = n - 1, t = 0, d = m - 1;

        while (l <= r && t <= d) {

            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t++;

            for (int i = t; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            r--;

            if (t <= d) {
                for (int i = r; i >= l; i--) {
                    res.add(matrix[d][i]);
                }
                d--;
            }

            if (l <= r) {
                for (int i = d; i >= t; i--) {
                    res.add(matrix[i][l]);
                }
                l++;
            }
        }
        return res;
    }
}
