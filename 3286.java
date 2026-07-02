class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] directions = {
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
        };

        int[][] bestHealth = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(bestHealth[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        int startHealth = health - grid.get(0).get(0);

        if(startHealth <= 0)
            return false;

        queue.offer(new int[]{0, 0, startHealth});
        bestHealth[0][0] = startHealth;

        while(!queue.isEmpty()){

            int[] curr = queue.poll();

            int row = curr[0];
            int col = curr[1];
            int currHealth = curr[2];

            if(row == m - 1 && col == n - 1){
                return true;
            }

            for(int[] dir : directions){

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow < 0 || newCol < 0 || newRow >= m || newCol >= n)
                    continue;

                int newHealth = currHealth - grid.get(newRow).get(newCol);

                if(newHealth <= 0)
                    continue;

                if(newHealth > bestHealth[newRow][newCol]){
                    bestHealth[newRow][newCol] = newHealth;
                    queue.offer(new int[]{newRow, newCol, newHealth});
                }
            }
        }

        return false;
    }
}
