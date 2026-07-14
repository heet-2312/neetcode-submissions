class Solution {
    private int n,m;
    private int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n=heights.length;
        m=heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for(int i=0;i<n;i++){
            dfs(i,0,pacific,heights);
        }
        for(int i=0;i<m;i++){
            dfs(0,i,pacific,heights);
        }
        for(int j=0;j<n;j++){
            dfs(j,m-1,atlantic,heights);
        }
        for(int j=0;j<m;j++){
            dfs(n-1,j,atlantic,heights);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;

    }

    void dfs(int x,int y, boolean[][] visited, int[][] heights){
        if(visited[x][y]){
            return ;
        }
        visited[x][y]=true;
        for(int[] dir:directions){
            int i=x+dir[0];
            int j=y+dir[1];

            if(i>=0 && i<n && j>=0 && j<m){
                if(heights[i][j]<heights[x][y]) continue;
                dfs(i,j,visited,heights);
            }
        }
    }
}
