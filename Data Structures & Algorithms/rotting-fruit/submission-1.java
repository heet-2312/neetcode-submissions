class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int rotten=0;
        int fresh=0;
        Queue<int[]>que = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    que.offer(new int[]{i,j,0});
                }
            }
        }
        int minTime=0;

        int[][] dirs ={{0,-1},{0,1},{-1,0},{1,0}};

        while(!que.isEmpty()){
            int[] cell = que.poll();
            int cx=cell[0];
            int cy=cell[1];
            int ct=cell[2];

            for(int[] dir:dirs){
                int nr = cx + dir[0];
                int nc = cy + dir[1];
                int nt = ct + 1;

                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    que.offer(new int[]{nr,nc,nt});
                    grid[nr][nc]=2;
                    minTime = Math.max(nt,minTime);
                    rotten++;
                }
            }
        }

        return rotten!=fresh ? -1 : minTime;
    }
}
