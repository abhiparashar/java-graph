# 🎯 TWO POINTERS DAY 2-3: REAL PROBLEMS MARATHON

## 📋 **DAY 2: MEDIUM PROBLEMS (Template Application)**

---

## **🟡 PROBLEM 1: 3Sum (LeetCode 15) - FIXED + TWO POINTERS**

### **Problem Statement:**
Find all unique triplets that sum to zero.

### **💡 Pattern:** Fixed element + Opposite Direction

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums); // CRITICAL: Sort first
    
    for (int i = 0; i < nums.length - 2; i++) {
        // Skip duplicates for first element
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        
        // Two pointers for remaining elements
        int left = i + 1, right = nums.length - 1;
        int target = -nums[i];
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                
                // Skip duplicates
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
    return result;
}
```

**Time:** O(n²), **Space:** O(1)

---

## **🟡 PROBLEM 2: Container With Most Water (LeetCode 11)**

### **Problem Statement:**
Find maximum area that can be formed by two vertical lines.

### **💡 Pattern:** Opposite Direction (Greedy)

```java
public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxArea = 0;
    
    while (left < right) {
        // Calculate current area
        int width = right - left;
        int currentHeight = Math.min(height[left], height[right]);
        int area = width * currentHeight;
        
        maxArea = Math.max(maxArea, area);
        
        // Move pointer with smaller height (greedy choice)
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    
    return maxArea;
}
```

**Key Insight:** Always move the shorter line - moving taller line never improves area.

---

## **🟡 PROBLEM 3: Sort Colors (LeetCode 75) - THREE POINTERS**

### **Problem Statement:**
Sort array with 0s, 1s, 2s in one pass.

### **💡 Pattern:** Three pointers (extension)

```java
public void sortColors(int[] nums) {
    int low = 0;    // Next position for 0
    int mid = 0;    // Current element
    int high = nums.length - 1; // Next position for 2
    
    while (mid <= high) {
        if (nums[mid] == 0) {
            swap(nums, low, mid);
            low++;
            mid++;
        } else if (nums[mid] == 1) {
            mid++;
        } else { // nums[mid] == 2
            swap(nums, mid, high);
            high--; // Don't increment mid (check swapped element)
        }
    }
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```

**Visualization:** `[2,0,2,1,1,0]`
```
Initial: low=0, mid=0, high=5
[2,0,2,1,1,0]
 ↑
 low,mid    high

Step 1: nums[0]=2, swap with high, high--
[0,0,2,1,1,2]
 ↑       ↑
 low,mid high

Continue until mid > high...
```

---

## **🟡 PROBLEM 4: Minimum Size Subarray Sum (LeetCode 209)**

### **Problem Statement:**
Find minimum length subarray with sum ≥ target.

### **💡 Pattern:** Sliding Window

```java
public int minSubArrayLen(int target, int[] nums) {
    int left = 0, sum = 0;
    int minLen = Integer.MAX_VALUE;
    
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        
        // Contract window while valid
        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left];
            left++;
        }
    }
    
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
```

**Pattern:** Expand right, contract left when condition met.

---

## **🟡 PROBLEM 5: Remove Nth Node From End (LeetCode 19)**

### **Problem Statement:**
Remove nth node from end in one pass.

### **💡 Pattern:** Fast/Slow with gap

```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    
    ListNode fast = dummy;
    ListNode slow = dummy;
    
    // Move fast n+1 steps ahead
    for (int i = 0; i <= n; i++) {
        fast = fast.next;
    }
    
    // Move both until fast reaches end
    while (fast != null) {
        fast = fast.next;
        slow = slow.next;
    }
    
    // Remove nth node
    slow.next = slow.next.next;
    
    return dummy.next;
}
```

**Key Insight:** Maintain gap of n+1 between pointers.

---

## 📋 **DAY 3: HARD PROBLEMS (Advanced Patterns)**

---

## **🔴 PROBLEM 6: Trapping Rain Water (LeetCode 42)**

### **Problem Statement:**
Calculate trapped rainwater between elevation bars.

### **💡 Pattern:** Opposite Direction with max tracking

```java
public int trap(int[] height) {
    if (height.length < 3) return 0;
    
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0;
    int water = 0;
    
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                water += leftMax - height[left];
            }
            left++;
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                water += rightMax - height[right];
            }
            right--;
        }
    }
    
    return water;
}
```

**Key Insight:** Water level determined by minimum of left_max and right_max.

---

## **🔴 PROBLEM 7: Minimum Window Substring (LeetCode 76)**

### **Problem Statement:**
Find minimum window in s containing all characters of t.

### **💡 Pattern:** Advanced Sliding Window

```java
public String minWindow(String s, String t) {
    if (s.length() == 0 || t.length() == 0) return "";
    
    Map<Character, Integer> dictT = new HashMap<>();
    for (char c : t.toCharArray()) {
        dictT.put(c, dictT.getOrDefault(c, 0) + 1);
    }
    
    int required = dictT.size(); // Unique characters in t
    int formed = 0; // Characters with desired frequency
    
    Map<Character, Integer> windowCounts = new HashMap<>();
    int left = 0, right = 0;
    
    // Result: [window length, left, right]
    int[] ans = {-1, 0, 0};
    
    while (right < s.length()) {
        // Expand window
        char c = s.charAt(right);
        windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
        
        if (dictT.containsKey(c) && 
            windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
            formed++;
        }
        
        // Contract window
        while (left <= right && formed == required) {
            // Update result if smaller window found
            if (ans[0] == -1 || right - left + 1 < ans[0]) {
                ans[0] = right - left + 1;
                ans[1] = left;
                ans[2] = right;
            }
            
            char leftChar = s.charAt(left);
            windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
            
            if (dictT.containsKey(leftChar) && 
                windowCounts.get(leftChar) < dictT.get(leftChar)) {
                formed--;
            }
            left++;
        }
        right++;
    }
    
    return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
}
```

**Pattern:** Expand until valid, contract while maintaining validity.

---

## **🔴 PROBLEM 8: 4Sum (LeetCode 18)**

### **Problem Statement:**
Find all unique quadruplets that sum to target.

### **💡 Pattern:** Nested Two Pointers

```java
public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length - 3; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        
        for (int j = i + 1; j < nums.length - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;
            
            int left = j + 1, right = nums.length - 1;
            long targetSum = (long) target - nums[i] - nums[j];
            
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == targetSum) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
    
    return result;
}
```

**Note:** Handle integer overflow with long conversion.

---

## 🎯 **PROBLEM-SOLVING CHECKLIST**

### **Before Coding:**
1. ✅ Identify the pattern (5 seconds)
2. ✅ Choose correct template
3. ✅ Consider edge cases
4. ✅ Plan pointer movements

### **Common Pitfalls:**
- **Sorting:** Required for opposite direction
- **Duplicates:** Skip in nested loops
- **Bounds:** Check array/list bounds
- **Overflow:** Use long for large sums

### **Time Complexities:**
- **Opposite Direction:** O(n)
- **Same Direction:** O(n)
- **Sliding Window:** O(n)
- **Fast/Slow:** O(n)
- **3Sum/4Sum:** O(n²)/O(n³)

---

## 📊 **PROGRESS TRACKER**

**Day 2 Complete:** ✅ 5 Medium problems solved  
**Day 3 Complete:** ✅ 3 Hard problems mastered  
**Ready for:** Final pattern recognition drill! 🚀

**Total Problems Solved:** 8/20 from master list