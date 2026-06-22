class Solution {
    // find last index of key using binary search
    public int solve(int n, int key, List<Integer> v) {
        // initialize search bounds and result
        int start = 0;
        int end = n - 1;
        int res = -1;

        // binary search loop
        while (start <= end) {
            // compute mid safely
            int mid = start + (end - start) / 2;
            // when match found, store index and move right
            if (v.get(mid) == key) {
                res = mid;
                start = mid + 1;
            }
            // when key is smaller, move left
            else if (key < v.get(mid)) {
                end = mid - 1;
            }
            // otherwise move right
            else {
                start = mid + 1;
            }
        }
        // return last occurrence or -1
        return res;
    }
}
