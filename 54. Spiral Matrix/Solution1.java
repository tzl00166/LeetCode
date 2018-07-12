class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {       
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int startx = 0;
        int starty = 0;
        
        while(res.size() < m * n){
            int i = startx;
            int j = starty;
            do{
                res.add(matrix[i][j]);
                if(res.size() == m * n)
                    break;
                if(i == startx){
                    if(j < n - starty - 1)
                        j++;
                    else
                        i++;
                }
                else if(j == n - starty - 1){
                    if(i < m - startx - 1)
                        i++;
                    else
                        j--;
                }
                else if(i == m - startx - 1){
                    if(j > starty)
                        j--;
                    else
                        i--;
                }
                else
                    i--; 
            }
            while(i != startx || j != starty);
            startx++;
            starty++;
        }
        
        return res;
    }
}