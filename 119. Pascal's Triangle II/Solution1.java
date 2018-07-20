class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if(rowIndex == 0)
            return res;
        
        res.add(1);
        for(int i = 2; i <= rowIndex; i++){
            int first = 1;
            int second = res.get(1);
            for(int j = 1; j < i; j++){
                res.set(j, first + second);
                if(j == i - 1)
                    break;
                first = second;
                second = res.get(j + 1);
            }
            res.add(1);
        }
        return res;
    }
}