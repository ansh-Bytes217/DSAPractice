class Sol{
  public int[] twoSum(int nums,int target){
    int left = 0;
    int right = nums.length - 1;

    while(left <= right){
      int total = nums[left] + nums[right];

      if(total == target){
        return new int[] {left + 1,right + 1};
      }else if(total > target){
        right--;
      }else{
        left++;
      }
    }
     return new int[]{-1,-1};
  }
}
          
