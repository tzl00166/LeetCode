\\ BFS

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    res++;
                    grid[i][j] = '0';
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        int k = curr[0];
                        int t = curr[1];                      
                        if(k > 0 && grid[k - 1][t] == '1'){
                            queue.offer(new int[]{k - 1, t});
                            grid[k - 1][t] = '0';
                        }                           
                        if(k < m - 1 && grid[k + 1][t] == '1'){
                            queue.offer(new int[]{k + 1, t});
                            grid[k + 1][t] = '0';
                        }
                        if(t > 0 && grid[k][t - 1] == '1'){
                            queue.offer(new int[]{k, t - 1});
                            grid[k][t - 1] = '0';
                        }
                        if(t < n - 1 && grid[k][t + 1] == '1'){
                            queue.offer(new int[]{k, t + 1});
                            grid[k][t + 1] = '0';
                        }   
                    }                 
                }
            }
        }
        
        return res;
    }
}