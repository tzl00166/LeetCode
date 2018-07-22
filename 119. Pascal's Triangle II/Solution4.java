class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        //formula:  C(n,k) = C(n,k-1) *(n+1-k)/k
        long value = 1;
        list.add((int)value);
        for(int i = 1; i < rowIndex+1; i++){
            value = value *(rowIndex+1-i)/i;
            list.add((int)value);
        }
        return list;
    }
    
}