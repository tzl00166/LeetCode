class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> buffer = new ArrayList<Integer>();
        List<Integer> tmp;
        if(rowIndex<0)return result;
        for(int i=0;i<=rowIndex;i++){
            if(i==0)
                result.add(1);
            else{
                buffer.add(1);
                for(int j=0;j<result.size()-1;j++)
                    buffer.add(result.get(j)+result.get(j+1));
                buffer.add(1);
                result.clear();
                tmp = result;
                result = buffer;
                buffer = tmp;
            }
        }
        return result;
    }
}