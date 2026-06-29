class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int row = 0; row < n; row++) {
            ArrayList<Integer> list = new ArrayList<>();

            int r = row;
            int c = 0;

            while (r < n && c < n) {
                list.add(grid[r][c]);
                r++;
                c++;
            }

            Collections.sort(list, Collections.reverseOrder());

            r = row;
            c = 0;
            int idx = 0;

            while (r < n && c < n) {
                grid[r][c] = list.get(idx++);
                r++;
                c++;
            }
        }

        for (int col = 1; col < n; col++) {
            ArrayList<Integer> list = new ArrayList<>();

            int r = 0;
            int c = col;

            while (r < n && c < n) {
                list.add(grid[r][c]);
                r++;
                c++;
            }

            Collections.sort(list);

            r = 0;
            c = col;
            int idx = 0;

            while (r < n && c < n) {
                grid[r][c] = list.get(idx++);
                r++;
                c++;
            }
        }

        return grid;
    }
}