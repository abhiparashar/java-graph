# 🎯 DAY 4: PATTERN RECOGNITION DRILL + COMPLETE SOLUTIONS

## 🧠 **INSTANT PATTERN RECOGNITION (5-10 SECONDS)**

### **Recognition Framework:**

```
INPUT ANALYSIS → PATTERN → TEMPLATE
     ↓             ↓         ↓
  Array Type → Pointer Style → Code Structure
```

---

## **⚡ SPEED DRILL: IDENTIFY PATTERN INSTANTLY**

### **ROUND 1: Pattern Matching**

1. **"Find pair with target sum in sorted array"** → ?
2. **"Remove duplicates from sorted array in-place"** → ?
3. **"Longest substring without repeating characters"** → ?
4. **"Detect cycle in linked list"** → ?
5. **"Container with most water"** → ?
6. **"Move all zeros to end of array"** → ?
7. **"Minimum window substring"** → ?
8. **"Find middle of linked list"** → ?

### **✅ ANSWERS:**
1. **Opposite Direction** (sorted + target)
2. **Same Direction** (in-place modification)
3. **Sliding Window** (substring optimization)
4. **Fast/Slow** (cycle detection)
5. **Opposite Direction** (maximize area)
6. **Same Direction** (element partitioning)
7. **Sliding Window** (window with constraints)
8. **Fast/Slow** (linked list traversal)

---

## **ROUND 2: Template Selection**

### **Given Problem Types, Choose Template:**

```java
// TEMPLATE A: Opposite Direction
while (left < right) {
    if (condition) return result;
    else if (sum < target) left++;
    else right--;
}

// TEMPLATE B: Same Direction  
while (fast < n) {
    if (valid) arr[slow++] = arr[fast];
    fast++;
}

// TEMPLATE C: Sliding Window
for (right = 0; right < n; right++) {
    expand_window();
    while (invalid) contract_window();
    update_result();
}

// TEMPLATE D: Fast/Slow
while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

**Match these problems to templates:**

1. **Valid Palindrome** → Template ?
2. **Remove Element** → Template ?
3. **Find All Anagrams** → Template ?
4. **Linked List Cycle II** → Template ?

**Answers:** A, B, C, D

---

## 📋 **COMPLETE EASY PROBLEMS SOLUTIONS**

## **🟢 PROBLEM 1: Valid Palindrome (LeetCode 125)**

```java
public boolean isPalindrome(String s) {
    int left = 0, right = s.length() - 1;
    
    while (left < right) {
        // Skip non-alphanumeric characters
        while (left < right && !Character.isAlphaNumeric(s.charAt(left))) {
            left++;
        }
        while (left < right && !Character.isAlphaNumeric(s.charAt(right))) {
            right--;
        }
        
        // Compare characters (case-insensitive)
        if (Character.toLowerCase(s.charAt(left)) != 
            Character.toLowerCase(s.charAt(right))) {
            return false;
        }
        
        left++;
        right--;
    }
    return true;
}
```

## **🟢 PROBLEM 2: Reverse String (LeetCode 344)**

```java
public void reverseString(char[] s) {
    int left = 0, right = s.length - 1;
    
    while (left < right) {
        // Swap characters
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        
        left++;
        right--;
    }
}
```

## **🟢 PROBLEM 3: Move Zeros (LeetCode 283)**

```java
public void moveZeroes(int[] nums) {
    int slow = 0; // Next position for non-zero
    
    // Move all non-zeros to front
    for (int fast = 0; fast < nums.length; fast++) {
        if (nums[fast] != 0) {
            nums[slow] = nums[fast];
            slow++;
        }
    }
    
    // Fill remaining with zeros
    while (slow < nums.length) {
        nums[slow] = 0;
        slow++;
    }
}
```

## **🟢 PROBLEM 4: Squares of Sorted Array (LeetCode 977)**

```java
public int[] sortedSquares(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int left = 0, right = n - 1;
    int pos = n - 1; // Fill from right to left
    
    while (left <= right) {
        int leftSquare = nums[left] * nums[left];
        int rightSquare = nums[right] * nums[right];
        
        if (leftSquare > rightSquare) {
            result[pos] = leftSquare;
            left++;
        } else {
            result[pos] = rightSquare;
            right--;
        }
        pos--;
    }
    
    return result;
}
```

## **🟢 PROBLEM 5: Merge Sorted Array (LeetCode 88)**

```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int p1 = m - 1;     // Last element in nums1
    int p2 = n - 1;     // Last element in nums2
    int pos = m + n - 1; // Last position in merged array
    
    // Merge from right to left
    while (p1 >= 0 && p2 >= 0) {
        if (nums1[p1] > nums2[p2]) {
            nums1[pos] = nums1[p1];
            p1--;
        } else {
            nums1[pos] = nums2[p2];
            p2--;
        }
        pos--;
    }
    
    // Copy remaining elements from nums2
    while (p2 >= 0) {
        nums1[pos] = nums2[p2];
        p2--;
        pos--;
    }
}
```

---

## 📋 **REMAINING MEDIUM/HARD SOLUTIONS**

## **🟡 PROBLEM: Find All Anagrams (LeetCode 438)**

```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length()) return result;
    
    int[] pCount = new int[26];
    int[] windowCount = new int[26];
    
    // Count characters in p
    for (char c : p.toCharArray()) {
        pCount[c - 'a']++;
    }
    
    int windowSize = p.length();
    
    // Sliding window
    for (int i = 0; i < s.length(); i++) {
        // Add right character
        windowCount[s.charAt(i) - 'a']++;
        
        // Remove left character if window too large
        if (i >= windowSize) {
            windowCount[s.charAt(i - windowSize) - 'a']--;
        }
        
        // Check if anagram found
        if (i >= windowSize - 1 && Arrays.equals(pCount, windowCount)) {
            result.add(i - windowSize + 1);
        }
    }
    
    return result;
}
```

## **🟡 PROBLEM: Palindrome Linked List (LeetCode 234)**

```java
public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    
    // Step 1: Find middle using fast/slow pointers
    ListNode slow = head;
    ListNode fast = head;
    
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    // Step 2: Reverse second half
    ListNode secondHalf = reverseList(slow.next);
    
    // Step 3: Compare first half with reversed second half
    ListNode p1 = head;
    ListNode p2 = secondHalf;
    boolean isPalin = true;
    
    while (p2 != null) {
        if (p1.val != p2.val) {
            isPalin = false;
            break;
        }
        p1 = p1.next;
        p2 = p2.next;
    }
    
    // Step 4: Restore original list (optional)
    slow.next = reverseList(secondHalf);
    
    return isPalin;
}

private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
```

## **🟡 PROBLEM: Remove Duplicates II (LeetCode 80)**

```java
public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) return nums.length;
    
    int slow = 2; // Position to write next element
    
    for (int fast = 2; fast < nums.length; fast++) {
        // Allow element if it's different from element 2 positions back
        if (nums[fast] != nums[slow - 2]) {
            nums[slow] = nums[fast];
            slow++;
        }
    }
    
    return slow;
}
```

**Key Insight:** Element at position `slow` should be different from element at `slow-2`.

---

## 📋 **ADVANCED HARD PROBLEMS**

## **🔴 PROBLEM: Smallest Range Covering Elements (LeetCode 632)**

```java
public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    int max = Integer.MIN_VALUE;
    
    // Initialize: add first element from each list
    for (int i = 0; i < nums.size(); i++) {
        int val = nums.get(i).get(0);
        pq.offer(new int[]{val, i, 0}); // {value, list_index, element_index}
        max = Math.max(max, val);
    }
    
    int[] result = {pq.peek()[0], max};
    
    while (pq.size() == nums.size()) {
        int[] curr = pq.poll();
        int val = curr[0], listIdx = curr[1], elemIdx = curr[2];
        
        // Update result if current range is smaller
        if (max - val < result[1] - result[0]) {
            result[0] = val;
            result[1] = max;
        }
        
        // Add next element from same list if exists
        if (elemIdx + 1 < nums.get(listIdx).size()) {
            int nextVal = nums.get(listIdx).get(elemIdx + 1);
            pq.offer(new int[]{nextVal, listIdx, elemIdx + 1});
            max = Math.max(max, nextVal);
        }
    }
    
    return result;
}
```

## **🔴 PROBLEM: Minimum Window Subsequence (LeetCode 727)**

```java
public String minWindow(String s, String t) {
    int sLen = s.length(), tLen = t.length();
    int minLen = Integer.MAX_VALUE;
    String result = "";
    
    for (int i = 0; i < sLen; i++) {
        if (s.charAt(i) == t.charAt(0)) {
            int sIdx = i, tIdx = 0;
            
            // Forward pass: find subsequence
            while (sIdx < sLen && tIdx < tLen) {
                if (s.charAt(sIdx) == t.charAt(tIdx)) {
                    tIdx++;
                }
                sIdx++;
            }
            
            if (tIdx == tLen) { // Found subsequence
                int end = sIdx - 1;
                tIdx--;
                sIdx--;
                
                // Backward pass: minimize window
                while (tIdx >= 0) {
                    if (s.charAt(sIdx) == t.charAt(tIdx)) {
                        tIdx--;
                    }
                    sIdx--;
                }
                
                int start = sIdx + 1;
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    result = s.substring(start, end + 1);
                }
            }
        }
    }
    
    return result;
}
```

---

## 🎯 **FINAL MASTERY TEST**

### **Speed Challenge: Solve in 2 minutes each**

1. **Two Sum II** → Expected: Opposite Direction, O(n)
2. **Remove Element** → Expected: Same Direction, O(n)
3. **Longest Substring K Distinct** → Expected: Sliding Window, O(n)
4. **Find Duplicate Number** → Expected: Fast/Slow, O(n)

### **Pattern Recognition Quiz:**

```java
// Code Snippet 1
while (left < right) {
    if (nums[left] + nums[right] == target) return true;
    else if (nums[left] + nums[right] < target) left++;
    else right--;
}
```
**Pattern:** Opposite Direction ✅

```java
// Code Snippet 2  
while (fast < nums.length) {
    if (nums[fast] != 0) {
        nums[slow++] = nums[fast];
    }
    fast++;
}
```
**Pattern:** Same Direction ✅

```java
// Code Snippet 3
for (int right = 0; right < s.length(); right++) {
    map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
    while (map.size() > k) {
        // shrink window
    }
}
```
**Pattern:** Sliding Window ✅

---

## 🏆 **MASTERY CHECKLIST**

### **✅ Technical Skills Mastered:**
- [x] **Pattern Recognition:** < 10 seconds
- [x] **Template Selection:** Instant
- [x] **Edge Case Handling:** Automatic
- [x] **Time Complexity:** Always optimal
- [x] **Space Optimization:** In-place when possible

### **✅ Problem-Solving Speed:**
- [x] **Easy Problems:** 5-10 minutes
- [x] **Medium Problems:** 15-20 minutes
- [x] **Hard Problems:** 25-30 minutes

### **✅ Interview Readiness:**
- [x] **Striver Sheet:** 95%+ coverage
- [x] **LeetCode Patterns:** All major variations
- [x] **Optimization Tricks:** Memory & time
- [x] **Communication:** Clear explanation of approach

---

## 🎯 **POST-MASTERY MAINTENANCE**

### **Weekly Practice Routine:**
**Monday:** 2 Easy problems (confidence boost)  
**Wednesday:** 1 Medium + 1 Hard (skill maintenance)  
**Friday:** Pattern recognition drill (5 problems, 10 seconds each)

### **Before Interviews:**
1. **Review all 4 templates** (5 minutes)
2. **Practice pattern recognition** (10 problems, 2 minutes)
3. **Solve 1 problem from each pattern** (20 minutes total)

### **Red Flags to Watch:**
- Taking > 15 seconds to identify pattern
- Mixing up templates between patterns
- Forgetting edge cases (empty arrays, single elements)
- Not optimizing space when possible

---

## 🚀 **CONGRATULATIONS!**

### **You've Successfully Mastered:**
✅ **4 Core Patterns** with memorized templates  
✅ **20+ Interview Problems** across all difficulty levels  
✅ **Instant Pattern Recognition** in under 10 seconds  
✅ **Optimal Solutions** with proper time/space complexity  
✅ **Interview Confidence** for any Two Pointers problem

### **Your Two Pointers Arsenal:**
```java
// MEMORIZED TEMPLATES
1. Opposite Direction → Sorted arrays, target problems
2. Same Direction    → In-place modifications  
3. Sliding Window    → Substring/subarray optimization
4. Fast/Slow        → LinkedList problems

// PROBLEM SOLVING SPEED
Easy:   5-10 minutes  ⚡
Medium: 15-20 minutes ⚡  
Hard:   25-30 minutes ⚡

// INTERVIEW SUCCESS RATE
Striver Sheet: 95%+ ✅
LeetCode:      90%+ ✅
```

**You're now ready to dominate Two Pointers in any coding interview!** 🎯💪

**Next Step:** Apply these patterns during your graph algorithm studies for confidence boosts! 🚀