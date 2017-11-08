/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9,return [0, 1].
 */
import java.lang.IllegalArgumentException;
import java.util.Map;
import java.util.HashMap;

public class TwoSum{

    /**
     * 最容易想到的一种解法，两个变量循环遍历，时间复杂度为O(n^2),空间复杂度O(1)
     */
    public int[] twoSum(int[] nums, int target){
	for(int i = 0; i < nums.length; i++){
	    for(int j = i + 1; j < nums.length; j++){
		if(nums[i] + nums[j] == target){
		    return new int[]{i, j};
		}
	    }
	}
	throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 空间换时间，使用map存放另一个结果，时间复杂度O(n)，空间复杂度O(n)
     */
    public int[] twoSum2(int[] nums, int target){
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	for(int i = 0; i < nums.length; i++){
	    if(map.containsKey(target-nums[i])){
		return new int[]{i, map.get(target-nums[i])};
	    }
	    map.put(nums[i], i);
	}
        throw new IllegalArgumentException("No two sum solution");
    }
    
    public static void main(String[] args){
	TwoSum ts = new TwoSum();
	int[] nums = {3,5,5,6};
	int target = 9;
	int[] result = ts.twoSum2(nums, target);
	for(int i = 0; i < result.length; i++){
	    System.out.println(result[i]);
	}
    }
}
