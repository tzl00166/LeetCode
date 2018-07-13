class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;
        
        List<Integer> layer1 = new ArrayList<>();
        layer1.add(1);
        res.add(layer1);
        for(int i = 1; i < numRows; i++){
            List<Integer> layer = new ArrayList<>();
            layer.add(1);
            for(int j = 1; j < i; j++){
                int first = res.get(i - 1).get(j - 1);
                int second = res.get(i - 1).get(j);
                layer.add(first + second);
            }
            layer.add(1);
            res.add(layer);
        }
        return res;
    }
}