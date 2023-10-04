import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Missing_Number {

    //Using Sorting
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums); // best case: nlog(n)
        for (int i = 0; i < nums.length; i++) // index = 0, 1
        {
            if (nums[i] != i) // nums[1] == 1
            {
                return i;
            }
        }
        return nums.length;
    }

    //Using HashSet
    public int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;

    }

    //Bit Manipulation (using XOR)
    public int missingNumber3(int[] nums) {
        int missingNumber = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingNumber ^= i ^ nums[i];
        }
        return missingNumber;
    }


}
