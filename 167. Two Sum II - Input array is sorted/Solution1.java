class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int index = 0; index < numbers.length; index++){
            int left = index;
            int right = numbers.length - 1;
            
            while(left <= right){
                int mid = left + (right - left)/2;
                if(numbers[mid] == target - numbers[index] && mid != index)
                    return new int[]{index + 1, mid + 1};
                else if(numbers[mid] > target - numbers[index])
                    right = mid - 1;
				// This has 2 cases
				// when: numbers[mid] == target - numbers[index] && mid == index
				// need to go right, so belongs to this "else"
                else
                    left = mid + 1;                
            }
        }
        
        return new int[]{-1, -1};
    }
}