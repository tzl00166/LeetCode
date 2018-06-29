class TwoSum {

    private List<Integer> dict;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        dict = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        dict.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Collections.sort(dict);
        int left = 0;
        int right = dict.size() - 1;
        while(left < right){
            if(dict.get(left) + dict.get(right) == value)
                return true;
            else if(dict.get(left) + dict.get(right) < value)
                left++;
            else
                right--;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */