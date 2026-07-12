class Solution {
public:
    void dfs(vector<bool>&visited,vector<bool>&path, vector<vector<int>>&adj,int node){
        visited[node] = path[node] =true;
        for(auto x:adj[node]){
            if(!visited[x]){
                cout<<"here "<< node <<endl;
                dfs(visited,path,adj,x);
            }
        }
        return;
    }
    int countComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>>adj(n);
        for(int i=0;i<edges.size();i++){
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }

        vector<bool>visited(n,false);
        vector<bool>path(n,false);
        int c=0;
        for(int i=0;i<n;i++){
            if(!visited[i] && adj[i].size()>0){
                dfs(visited,path,adj,i);
                c++;
            }
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                c++;
            }
        }
        return c;
    }
};
