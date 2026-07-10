///////////////////////////      BRUTE FORCE         ////////////////////////////////////
class Solution {
    private boolean dfs(int cur, int target, Map<Integer, List<Integer>> adj, boolean[] visited) {
        if (cur == target)
            return true;

        visited[cur] = true;

        for (int ngbr : adj.getOrDefault(cur, new ArrayList<>())) {
            if (!visited[ngbr]) {
                if (dfs(ngbr, target, adj, visited))
                    return true;
            }
        }

        return false;
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
                adj.computeIfAbsent(i + 1, k -> new ArrayList<>()).add(i);
            }
        }

        boolean[] result = new boolean[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int u = queries[j][0];
            int v = queries[j][1];
            boolean[] visited = new boolean[n];
            result[j] = dfs(u, v, adj, visited);
        }
        return result;
    }
}


//Approach-2 (Using DFS once and then mark component) - TLE
//T.C : O((V+E) + q), V + E is for DFS, V = number of vertices, E = number of edges
//S.C : O(V+E), V = number of vertices, E = number of edges
class Solution {
    private void dfs(int cur, int compId, Map<Integer, List<Integer>> adj, int[] component) {
        component[cur] = compId;
        for (int ngbr : adj.getOrDefault(cur, new ArrayList<>())) {
            if (component[ngbr] == -1) {
                dfs(ngbr, compId, adj, component);
            }
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
                adj.computeIfAbsent(i + 1, k -> new ArrayList<>()).add(i);
            }
        }

        int[] component = new int[n];
        Arrays.fill(component, -1);
        int compId = 0;
        for (int i = 0; i < n; i++) {
            if (component[i] == -1) {
                dfs(i, compId, adj, component);
                compId++;
            }
        }

        boolean[] result = new boolean[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = (component[queries[j][0]] == component[queries[j][1]]);
        }
        return result;
    }
}


//Approach-3 (Simple observation - assign components)
//T.C : O(n+q)
//S.C : O(n)
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int compId = 0;
        component[0] = compId;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                compId++;
            }
            component[i] = compId;
        }

        boolean[] result = new boolean[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = (component[queries[j][0]] == component[queries[j][1]]);
        }
        return result;
    }
}
