class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        int m = heights.length;
        int n = heights[0].length;

        for(int i=0; i<n; i++) queue.add(new int[] {0, i});
        for(int i=0; i<m; i++) queue.add(new int[] {i, 0});

        int[][] visp = new int[m][n];
        int[][] visa = new int[m][n];

        while(!queue.isEmpty())
        {
            int[] curr = queue.remove();

            visp[curr[0]][curr[1]] = 1;
            for(int[] d: dir)
            {
                int dx = curr[0] + d[0];
                int dy = curr[1] + d[1];

                if(dx < 0 || dy < 0 || dx >= m || dy >= n || visp[dx][dy] == 1) continue;
                if(heights[dx][dy] >= heights[curr[0]][curr[1]])
                {
                    queue.add(new int[] {dx, dy});
                }
            }
        }

        for(int i=0; i<n; i++) queue.add(new int[] {m-1, i});
        for(int i=0; i<m; i++) queue.add(new int[] {i, n-1});

        while(!queue.isEmpty())
        {
            int[] curr = queue.remove();

            visa[curr[0]][curr[1]] = 1;
            for(int[] d: dir)
            {
                int dx = curr[0] + d[0];
                int dy = curr[1] + d[1];

                if(dx < 0 || dy < 0 || dx >= m || dy >= n || visa[dx][dy] == 1) continue;
                if(heights[dx][dy] >= heights[curr[0]][curr[1]])
                {
                    queue.add(new int[] {dx, dy});
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                List<Integer> t = new ArrayList<>();
                t.add(i);
                t.add(j);
                if(visa[i][j] == 1 && visp[i][j] == 1) res.add(t);
            }
        }

        return res;
    }
}
