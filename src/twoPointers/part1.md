# 🎯 TWO POINTERS MASTERY - COMPLETE IMPLEMENTATION

## 📋 **DAY 1: CORE PATTERNS & TEMPLATES**

---

## **PATTERN 1: OPPOSITE DIRECTION (Left/Right Pointers)**

### **📝 Template:**
```java
public int oppositePointers(int[] arr) {
    int left = 0, right = arr.length - 1;
    int result = 0; // or initialize as needed
    
    while (left < right) {
        // Process current pair
        int sum = arr[left] + arr[right];
        
        if (sum == target) {
            // Found answer
            result++;
            left++;
            right--;
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return result;
}
```

### **⚡ When to Use:**
- Sorted arrays
- Target sum problems
- Palindrome validation
- Container problems

### **🔥 Example Problem: Two Sum II (LeetCode 167)**

**Problem:** Find two numbers that add up to target in sorted array.

```java
public int[] twoSum(int[] numbers, int target) {
    int left = 0, right = numbers.length - 1;
    
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        
        if (sum == target) {
            return new int[]{left + 1, right + 1}; // 1-indexed
        } else if (sum < target) {
            left++;
        } else {
            right--;
        }
    }
    return new int[]{-1, -1}; // Not found
}
```

**Dry Run:** `[2,7,11,15], target=9`
```
Step 1: left=0(2), right=3(15) → sum=17 > 9 → right--
Step 2: left=0(2), right=2(11) → sum=13 > 9 → right--  
Step 3: left=0(2), right=1(7)  → sum=9 = 9 → return [1,2]
```

---

## **PATTERN 2: SAME DIRECTION (Slow/Fast Pointers)**

### **📝 Template:**
```java
public int[] sameDirection(int[] arr) {
    int slow = 0; // Write pointer
    int fast = 0; // Read pointer
    
    while (fast < arr.length) {
        if (condition) {
            arr[slow] = arr[fast];
            slow++;
        }
        fast++;
    }
    return Arrays.copyOf(arr, slow); // New length = slow
}
```

### **⚡ When to Use:**
- Remove duplicates
- Move elements (zeros, negatives)
- In-place array modifications
- Partition problems

### **🔥 Example Problem: Remove Duplicates (LeetCode 26)**

**Problem:** Remove duplicates from sorted array in-place.

```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    
    int slow = 1; // Next position to write
    
    for (int fast = 1; fast < nums.length; fast++) {
        if (nums[fast] != nums[fast - 1]) {
            nums[slow] = nums[fast];
            slow++;
        }
    }
    return slow; // New length
}
```

**Dry Run:** `[1,1,2,2,3]`
```
fast=1: nums[1]=1 == nums[0]=1 → skip
fast=2: nums[2]=2 != nums[1]=1 → nums[1]=2, slow=2
fast=3: nums[3]=2 == nums[2]=2 → skip  
fast=4: nums[4]=3 != nums[3]=2 → nums[2]=3, slow=3
Result: [1,2,3] with length=3
```

---

## **PATTERN 3: SLIDING WINDOW**

### **📝 Template:**
```java
public int slidingWindow(String s) {
    int left = 0, maxLen = 0;
    Map<Character, Integer> window = new HashMap<>();
    
    for (int right = 0; right < s.length(); right++) {
        // Expand window
        char rightChar = s.charAt(right);
        window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
        
        // Contract window if invalid
        while (windowInvalid()) {
            char leftChar = s.charAt(left);
            window.put(leftChar, window.get(leftChar) - 1);
            if (window.get(leftChar) == 0) {
                window.remove(leftChar);
            }
            left++;
        }
        
        // Update result
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

### **⚡ When to Use:**
- Substring problems
- Continuous subarrays
- "Longest/Shortest" with constraints
- Character frequency problems

### **🔥 Example Problem: Longest Substring Without Repeating Characters (LeetCode 3)**

```java
public int lengthOfLongestSubstring(String s) {
    int left = 0, maxLen = 0;
    Set<Character> window = new HashSet<>();
    
    for (int right = 0; right < s.length(); right++) {
        // Contract window until no duplicates
        while (window.contains(s.charAt(right))) {
            window.remove(s.charAt(left));
            left++;
        }
        
        // Expand window
        window.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

**Dry Run:** `"abcabcbb"`
```
right=0('a'): window=['a'], maxLen=1
right=1('b'): window=['a','b'], maxLen=2  
right=2('c'): window=['a','b','c'], maxLen=3
right=3('a'): 'a' exists → remove 'a', left=1, window=['b','c','a'], maxLen=3
right=4('b'): 'b' exists → remove 'b', left=2, window=['c','a','b'], maxLen=3
...
```

---

## **PATTERN 4: FAST/SLOW POINTERS (LinkedList)**

### **📝 Template:**
```java
public ListNode fastSlowPointers(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode slow = head;
    ListNode fast = head;
    
    // Move pointers
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        // Check condition (e.g., cycle detection)
        if (slow == fast) {
            // Found cycle or middle
            return slow;
        }
    }
    
    return slow; // Middle node or no cycle
}
```

### **⚡ When to Use:**
- Cycle detection
- Find middle of LinkedList
- Remove nth from end
- Palindrome LinkedList

### **🔥 Example Problem: Detect Cycle (LeetCode 141)**

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        
        if (slow == fast) {
            return true; // Cycle detected
        }
    }
    
    return false; // No cycle
}
```

**Visualization:**
```
1 → 2 → 3 → 4 → 5
    ↑           ↓
    8 ← 7 ← 6 ←

Step 1: slow=1, fast=1
Step 2: slow=2, fast=3  
Step 3: slow=3, fast=5
Step 4: slow=4, fast=7
Step 5: slow=5, fast=3
Step 6: slow=6, fast=5
Step 7: slow=7, fast=7 → CYCLE FOUND!
```

---

## 🎯 **PATTERN RECOGNITION DRILL**

### **Quick Identification:**

1. **"Two sum in sorted array"** → **Opposite Direction**
2. **"Remove duplicates in-place"** → **Same Direction**
3. **"Longest substring with..."** → **Sliding Window**
4. **"Find middle/cycle in LinkedList"** → **Fast/Slow**
5. **"Container with most water"** → **Opposite Direction**
6. **"Move all zeros to end"** → **Same Direction**
7. **"Minimum window covering"** → **Sliding Window**
8. **"Palindrome LinkedList"** → **Fast/Slow + Reverse**

### **Template Selection Logic:**
- **Sorted array + target?** → Opposite Direction
- **In-place modification?** → Same Direction
- **Substring/subarray optimization?** → Sliding Window
- **LinkedList traversal?** → Fast/Slow

---

## 📊 **DAY 1 SUMMARY**

✅ **Mastered:** 4 core patterns with templates  
✅ **Memorized:** When to use each pattern  
✅ **Practiced:** Real interview problems  
✅ **Ready for:** Day 2 problem solving marathon

**Tomorrow:** Solve 8-10 problems across all patterns! 🚀