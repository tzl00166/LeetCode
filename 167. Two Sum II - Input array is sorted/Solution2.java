class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int x= 0,y=numbers.length-1;
        while(x<y) {
            //int mid=x+(y-x)/2;
            if(numbers[x]+numbers[y]==target)return new int[]{x+1,y+1};
            if(numbers[x]+numbers[y]>target)
                y--;
            else
                x++;
        }
        return numbers[x]+numbers[y]==target?new int[]{x+1,y+1}:new int[]{-1,-1};
    }
}