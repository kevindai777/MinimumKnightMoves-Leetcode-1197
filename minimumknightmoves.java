//Java Solution

class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] directions = {{2,1}, {2,-1}, {1,2}, {1,-2}, {-2,1}, {-2,-1}, {-1,2}, {-1,-2}};
        LinkedList<Pair<Integer, Integer>> stack = new LinkedList<>();
        stack.add(new Pair(0, 0));
        Set<Integer> set = new HashSet<>();
        int steps = 0;
        
        while (!stack.isEmpty()) {
            LinkedList<Pair<Integer, Integer>> next = new LinkedList<>();
            
            while (!stack.isEmpty()) {
                Pair<Integer, Integer> curr = stack.poll();
                if (curr.getKey() == x && curr.getValue() == y) {
                    return steps;
                }
                
                for (int[] dir : directions) {
                    int nextX = curr.getKey() + dir[0];
                    int nextY = curr.getValue() + dir[1];
                    
                    if (!set.contains(nextX + ',' + nextY)) {
                        set.add(nextX + ',' + nextY);
                        next.add(new Pair(nextX, nextY));
                    }
                }
            }
            
            stack = next;
            steps++;
        }
        
        return -1;
    }
}