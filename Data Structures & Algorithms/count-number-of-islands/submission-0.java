class Solution 
{
    public void dfs(int node_x, int node_y, char[][] grid, int[][] visited, int[][] dir)
    {
        visited[node_x][node_y] = 1;

        for(int[] d: dir)
        {
            int dx = d[0];
            int dy = d[1];

            int new_node_x = node_x + dx;
            int new_node_y = node_y + dy;
            if(new_node_x >= 0 && new_node_y >= 0 && new_node_x < grid.length && new_node_y < grid[0].length && grid[new_node_x][new_node_y] == '1' && visited[new_node_x][new_node_y] != 1) dfs(new_node_x, new_node_y, grid, visited, dir);
        }
    }
    public int numIslands(char[][] grid) 
    {
        int numberOfIslands = 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        int[][] dir = new int[][] {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1' && visited[i][j] != 1)
                {
                    numberOfIslands++;
                    dfs(i, j, grid, visited, dir);
                }
            }
        }

        return numberOfIslands;
    }
}
