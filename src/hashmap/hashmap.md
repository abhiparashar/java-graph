# 🎯 Complete Mastery Guide: Kadane's Algorithm & HashMap/Set Patterns

## Table of Contents
1. [Kadane's Algorithm Problems](#kadanes-algorithm-problems)
2. [HashMap/Set Operations Problems](#hashmapset-operations-problems)
3. [Combined Patterns](#combined-patterns)
4. [Practice Schedule](#practice-schedule)
5. [Progress Tracker](#progress-tracker)

---

## 📊 Kadane's Algorithm Problems

### **Level 1: Fundamentals (Easy)**
Master these first to understand the core concept.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 1 | Maximum Subarray | 53 | Easy | Basic Kadane's |
| 2 | Best Time to Buy and Sell Stock | 121 | Easy | Single pass tracking |
| 3 | Minimum Cost Climbing Stairs | 746 | Easy | DP with Kadane's mindset |
| 4 | Maximum Average Subarray I | 643 | Easy | Fixed window variant |
| 5 | Divisor Game | 1025 | Easy | Game theory + DP |

---

### **Level 2: Standard Variations (Easy-Medium)**
Apply Kadane's to different scenarios.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 6 | Maximum Sum Subarray of Size K | - | Easy | Fixed size window |
| 7 | Longest Subarray of 1's After Deleting One Element | 1493 | Medium | Modified Kadane's |
| 8 | Maximum Absolute Sum of Any Subarray | 1749 | Medium | Both max and min |
| 9 | K Concatenation Maximum Sum | 1191 | Medium | Circular extension |
| 10 | Maximum Score of a Good Subarray | 1793 | Hard | Two-pointer + Kadane's |

---

### **Level 3: Product & Multiplication (Medium)**
Handle multiplication and sign changes.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 11 | Maximum Product Subarray | 152 | Medium | Track both max & min |
| 12 | Maximum Product of Three Numbers | 628 | Easy | Edge cases with negatives |
| 13 | Maximum Product Difference Between Two Pairs | 1913 | Easy | Product optimization |
| 14 | Maximum Strength of a Group | 2708 | Medium | Product with negatives |

---

### **Level 4: 2D Arrays (Medium-Hard)**
Extend Kadane's to 2D matrices.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 15 | Max Sum of Rectangle No Larger Than K | 363 | Hard | 2D Kadane's + TreeSet |
| 16 | Maximum Sum Rectangle | - | Medium | Kadane's on columns |
| 17 | Maximal Rectangle | 85 | Hard | Histogram + Kadane's |
| 18 | Maximal Square | 221 | Medium | DP variant |

---

### **Level 5: Circular Arrays (Medium-Hard)**
Handle wrap-around scenarios.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 19 | Maximum Sum Circular Subarray | 918 | Medium | Max in middle OR wrapped |
| 20 | House Robber II | 213 | Medium | Circular constraint |
| 21 | Circular Array Loop | 457 | Medium | Cycle detection |

---

### **Level 6: Turbulent/Alternating Patterns (Medium)**
Sequences with alternating properties.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 22 | Longest Turbulent Subarray | 978 | Medium | Alternating comparisons |
| 23 | Wiggle Subsequence | 376 | Medium | Alternating directions |
| 24 | Longest Mountain in Array | 845 | Medium | Peak detection |
| 25 | Flip String to Monotone Increasing | 926 | Medium | Transition tracking |

---

### **Level 7: With Constraints (Medium-Hard)**
Additional constraints on subarrays.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 26 | Maximum Subarray Sum with One Deletion | 1186 | Medium | Optional deletion |
| 27 | Maximum Subarray Min-Product | 1856 | Medium | Min as multiplier |
| 28 | Maximum Sum of Two Non-Overlapping Subarrays | 1031 | Medium | Two segments |
| 29 | Maximum Length of Repeated Subarray | 718 | Medium | DP + sliding window |
| 30 | Minimum Operations to Reduce X to Zero | 1658 | Medium | Complement thinking |

---

### **Level 8: Advanced Applications (Hard)**
Complex variations requiring deep understanding.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 31 | Substring with Concatenation of All Words | 30 | Hard | Sliding window variant |
| 32 | Minimum Window Substring | 76 | Hard | Variable window |
| 33 | Trapping Rain Water | 42 | Hard | Height-based Kadane's |
| 34 | Largest Rectangle in Histogram | 84 | Hard | Stack + area maximization |
| 35 | Count Subarrays With Fixed Bounds | 2444 | Hard | Multiple constraints |

---

## 🗺️ HashMap/Set Operations Problems

### **Level 1: Basic Lookups (Easy)**
Foundation: O(1) lookups and uniqueness.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 1 | Two Sum | 1 | Easy | Complement lookup |
| 2 | Contains Duplicate | 217 | Easy | HashSet uniqueness |
| 3 | Valid Anagram | 242 | Easy | Character frequency |
| 4 | Missing Number | 268 | Easy | Set membership |
| 5 | Find the Difference | 389 | Easy | Character comparison |
| 6 | Intersection of Two Arrays | 349 | Easy | Set intersection |
| 7 | Intersection of Two Arrays II | 350 | Easy | With duplicates |
| 8 | Happy Number | 202 | Easy | Cycle detection |
| 9 | Single Number | 136 | Easy | XOR or HashSet |
| 10 | Majority Element | 169 | Easy | Frequency counting |

---

### **Level 2: Frequency Counting (Easy-Medium)**
Track occurrences and patterns.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 11 | First Unique Character in a String | 387 | Easy | Order + frequency |
| 12 | Unique Number of Occurrences | 1207 | Easy | Frequency uniqueness |
| 13 | Find All Numbers Disappeared in an Array | 448 | Easy | Range checking |
| 14 | Sort Characters By Frequency | 451 | Medium | Bucket sort |
| 15 | Top K Frequent Elements | 347 | Medium | Heap or bucket sort |
| 16 | Top K Frequent Words | 692 | Medium | String frequency + sorting |
| 17 | Find All Anagrams in a String | 438 | Medium | Sliding window + map |
| 18 | Word Pattern | 290 | Easy | Bijection mapping |
| 19 | Isomorphic Strings | 205 | Easy | Character mapping |
| 20 | Longest Palindrome | 409 | Easy | Pair counting |

---

### **Level 3: Grouping & Categorization (Medium)**
Group related elements together.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 21 | Group Anagrams | 49 | Medium | Sorted string as key |
| 22 | Group Shifted Strings | 249 | Medium | Pattern as key |
| 23 | Encode and Decode TinyURL | 535 | Medium | Bidirectional mapping |
| 24 | Valid Sudoku | 36 | Medium | Set per row/col/box |
| 25 | Brick Wall | 554 | Medium | Edge frequency |
| 26 | Logger Rate Limiter | 359 | Easy | Timestamp tracking |
| 27 | Design HashMap | 706 | Easy | Implement from scratch |
| 28 | Design HashSet | 705 | Easy | Implement from scratch |

---

### **Level 4: Indices & Positions (Easy-Medium)**
Track positions for range queries.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 29 | Contains Duplicate II | 219 | Easy | Index distance |
| 30 | Contains Duplicate III | 220 | Hard | Sliding window + TreeSet |
| 31 | Max Points on a Line | 149 | Hard | Slope as key |
| 32 | Line Reflection | 356 | Medium | Symmetric pairs |
| 33 | Find Duplicate File in System | 609 | Medium | Content as key |

---

### **Level 5: Subarray/Substring Patterns (Medium-Hard)**
Continuous sequences with HashMap.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 34 | Subarray Sum Equals K | 560 | Medium | Prefix sum |
| 35 | Continuous Subarray Sum | 523 | Medium | Prefix sum mod k |
| 36 | Subarray Sums Divisible by K | 974 | Medium | Modulo arithmetic |
| 37 | Find Two Non-overlapping Sub-arrays Each With Target Sum | 1477 | Medium | Multiple subarrays |
| 38 | Longest Substring Without Repeating Characters | 3 | Medium | Sliding window |
| 39 | Longest Substring with At Most K Distinct Characters | 340 | Medium | Window + map size |
| 40 | Longest Substring with At Most Two Distinct Characters | 159 | Medium | Fixed distinct count |
| 41 | Minimum Window Substring | 76 | Hard | Template pattern |
| 42 | Substring with Concatenation of All Words | 30 | Hard | Word frequency |
| 43 | Longest Repeating Character Replacement | 424 | Medium | Frequency in window |

---

### **Level 6: Consecutive Sequences (Medium-Hard)**
Finding runs and sequences.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 44 | Longest Consecutive Sequence | 128 | Medium | Set membership |
| 45 | Binary Tree Longest Consecutive Sequence | 298 | Medium | Tree traversal |
| 46 | Binary Tree Longest Consecutive Sequence II | 549 | Medium | Bidirectional |
| 47 | Longest Consecutive Sequence II | - | Hard | With gaps allowed |
| 48 | Number of Equivalent Domino Pairs | 1128 | Easy | Pair encoding |

---

### **Level 7: Array Relationships (Medium)**
Relationships between array elements.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 49 | 4Sum II | 454 | Medium | Split into pairs |
| 50 | 3Sum | 15 | Medium | HashMap + two pointers |
| 51 | 4Sum | 18 | Medium | Extension of 3Sum |
| 52 | Count of Smaller Numbers After Self | 315 | Hard | Index mapping |
| 53 | Pairs of Songs With Total Durations Divisible by 60 | 1010 | Medium | Modulo complement |
| 54 | Check If Array Pairs Are Divisible by k | 1497 | Medium | Remainder pairing |

---

### **Level 8: Design Problems (Medium-Hard)**
Implementing data structures.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 55 | LRU Cache | 146 | Medium | HashMap + DLL |
| 56 | LFU Cache | 460 | Hard | Frequency tracking |
| 57 | Insert Delete GetRandom O(1) | 380 | Medium | ArrayList + HashMap |
| 58 | Insert Delete GetRandom O(1) - Duplicates allowed | 381 | Hard | Handle duplicates |
| 59 | All O`one Data Structure | 432 | Hard | Multiple hashmaps |
| 60 | Time Based Key-Value Store | 981 | Medium | TreeMap for versions |

---

### **Level 9: Advanced String Patterns (Hard)**
Complex string manipulations.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 61 | Palindrome Pairs | 336 | Hard | Trie or HashMap |
| 62 | Alien Dictionary | 269 | Hard | Topological sort |
| 63 | Word Ladder | 127 | Hard | BFS + set |
| 64 | Word Ladder II | 126 | Hard | BFS + backtrack |
| 65 | Repeated DNA Sequences | 187 | Medium | Rolling hash |
| 66 | Minimum Window Subsequence | 727 | Hard | DP + HashMap |

---

### **Level 10: Mathematical & Combinatorial (Medium-Hard)**
Number theory with HashMap.

| # | Problem | LeetCode # | Difficulty | Key Concept |
|---|---------|-----------|------------|-------------|
| 67 | Fraction to Recurring Decimal | 166 | Medium | Division tracking |
| 68 | Valid Square | 593 | Medium | Distance mapping |
| 69 | Rectangle Overlap | 836 | Easy | Coordinate checking |
| 70 | Max Points on a Line | 149 | Hard | Slope calculation |
| 71 | Count Primes | 204 | Medium | Sieve of Eratosthenes |
| 72 | Continuous Subarray Sum | 523 | Medium | Prefix mod tracking |

---

## 🔗 Combined Patterns

Problems that use BOTH Kadane's AND HashMap/Set concepts.

| # | Problem | LeetCode # | Difficulty | Combines |
|---|---------|-----------|------------|----------|
| 1 | Maximum Size Subarray Sum Equals k | 325 | Medium | Kadane's + HashMap |
| 2 | Contiguous Array | 525 | Medium | Balance + prefix sum |
| 3 | Longest Well-Performing Interval | 1124 | Medium | Prefix sum + HashMap |
| 4 | Maximum Equal Frequency | 1224 | Hard | Frequency + sliding window |
| 5 | Make Sum Divisible by P | 1590 | Medium | Modulo + HashMap |
| 6 | Count Number of Nice Subarrays | 1248 | Medium | Prefix + at most k |
| 7 | Max Consecutive Ones III | 1004 | Medium | Window + tracking |
| 8 | Binary Subarrays With Sum | 930 | Medium | Prefix sum technique |
| 9 | Number of Submatrices That Sum to Target | 1074 | Hard | 2D Kadane's + HashMap |
| 10 | K-diff Pairs in an Array | 532 | Medium | HashMap + difference |

---

## 📅 30-Day Practice Schedule

### **Week 1: Kadane's Fundamentals**

#### Day 1-2: Easy Foundations
- [ ] Maximum Subarray (LC 53)
- [ ] Best Time to Buy and Sell Stock (LC 121)
- [ ] Minimum Cost Climbing Stairs (LC 746)
- [ ] Maximum Average Subarray I (LC 643)
- [ ] Divisor Game (LC 1025)

**Goal:** Understand basic Kadane's template

#### Day 3-4: Standard Variations
- [ ] Maximum Sum Subarray of Size K
- [ ] Longest Subarray of 1's After Deleting One Element (LC 1493)
- [ ] Maximum Absolute Sum of Any Subarray (LC 1749)
- [ ] K Concatenation Maximum Sum (LC 1191)
- [ ] Maximum Score of a Good Subarray (LC 1793)

**Goal:** Apply Kadane's to different scenarios

#### Day 5: Product Variants
- [ ] Maximum Product Subarray (LC 152)
- [ ] Maximum Product of Three Numbers (LC 628)
- [ ] Maximum Product Difference Between Two Pairs (LC 1913)
- [ ] Maximum Strength of a Group (LC 2708)

**Goal:** Handle multiplication and negatives

#### Day 6: Review Day
- [ ] Code basic Kadane's from scratch (5 times)
- [ ] Solve 3 random problems from Week 1
- [ ] Write down key insights

#### Day 7: Timed Practice
- [ ] Solve 3 Easy problems (10 min each)
- [ ] Solve 2 Medium problems (25 min each)
- [ ] Review and optimize solutions

---

### **Week 2: HashMap/Set Basics**

#### Day 8-9: Basic Lookups
- [ ] Two Sum (LC 1)
- [ ] Contains Duplicate (LC 217)
- [ ] Valid Anagram (LC 242)
- [ ] Missing Number (LC 268)
- [ ] Find the Difference (LC 389)
- [ ] Intersection of Two Arrays (LC 349)
- [ ] Intersection of Two Arrays II (LC 350)
- [ ] Happy Number (LC 202)
- [ ] Single Number (LC 136)
- [ ] Majority Element (LC 169)

**Goal:** Master O(1) lookups

#### Day 10-11: Frequency Counting
- [ ] First Unique Character in a String (LC 387)
- [ ] Unique Number of Occurrences (LC 1207)
- [ ] Find All Numbers Disappeared in an Array (LC 448)
- [ ] Sort Characters By Frequency (LC 451)
- [ ] Top K Frequent Elements (LC 347)
- [ ] Top K Frequent Words (LC 692)
- [ ] Find All Anagrams in a String (LC 438)
- [ ] Word Pattern (LC 290)
- [ ] Isomorphic Strings (LC 205)
- [ ] Longest Palindrome (LC 409)

**Goal:** Track frequencies efficiently

#### Day 12-13: Grouping & Categorization
- [ ] Group Anagrams (LC 49)
- [ ] Group Shifted Strings (LC 249)
- [ ] Encode and Decode TinyURL (LC 535)
- [ ] Valid Sudoku (LC 36)
- [ ] Brick Wall (LC 554)
- [ ] Logger Rate Limiter (LC 359)
- [ ] Design HashMap (LC 706)
- [ ] Design HashSet (LC 705)

**Goal:** Group related elements

#### Day 14: Review & Mixed Practice
- [ ] Code HashMap operations from scratch
- [ ] Solve 5 random Easy problems
- [ ] Identify common patterns

---

### **Week 3: Intermediate Patterns**

#### Day 15-16: 2D & Circular Arrays (Kadane's)
- [ ] Max Sum of Rectangle No Larger Than K (LC 363)
- [ ] Maximum Sum Rectangle
- [ ] Maximal Rectangle (LC 85)
- [ ] Maximal Square (LC 221)
- [ ] Maximum Sum Circular Subarray (LC 918)
- [ ] House Robber II (LC 213)
- [ ] Circular Array Loop (LC 457)

**Goal:** Extend Kadane's to complex scenarios

#### Day 17-18: Turbulent & Constraints (Kadane's)
- [ ] Longest Turbulent Subarray (LC 978)
- [ ] Wiggle Subsequence (LC 376)
- [ ] Longest Mountain in Array (LC 845)
- [ ] Flip String to Monotone Increasing (LC 926)
- [ ] Maximum Subarray Sum with One Deletion (LC 1186)
- [ ] Maximum Subarray Min-Product (LC 1856)
- [ ] Maximum Sum of Two Non-Overlapping Subarrays (LC 1031)

**Goal:** Handle additional constraints

#### Day 19-20: Subarray/Substring Patterns (HashMap)
- [ ] Contains Duplicate II (LC 219)
- [ ] Subarray Sum Equals K (LC 560)
- [ ] Continuous Subarray Sum (LC 523)
- [ ] Subarray Sums Divisible by K (LC 974)
- [ ] Longest Substring Without Repeating Characters (LC 3)
- [ ] Longest Substring with At Most K Distinct Characters (LC 340)
- [ ] Minimum Window Substring (LC 76)

**Goal:** Master prefix sum + HashMap

#### Day 21: Combined Patterns
- [ ] Maximum Size Subarray Sum Equals k (LC 325)
- [ ] Contiguous Array (LC 525)
- [ ] Longest Well-Performing Interval (LC 1124)
- [ ] Make Sum Divisible by P (LC 1590)
- [ ] Count Number of Nice Subarrays (LC 1248)

**Goal:** Use both patterns together

---

### **Week 4: Advanced Mastery**

#### Day 22-23: Hard Kadane's Problems
- [ ] Substring with Concatenation of All Words (LC 30)
- [ ] Minimum Window Substring (LC 76)
- [ ] Trapping Rain Water (LC 42)
- [ ] Largest Rectangle in Histogram (LC 84)
- [ ] Count Subarrays With Fixed Bounds (LC 2444)
- [ ] Maximum Length of Repeated Subarray (LC 718)
- [ ] Minimum Operations to Reduce X to Zero (LC 1658)

**Goal:** Tackle complex variations

#### Day 24-25: Advanced HashMap Problems
- [ ] Longest Consecutive Sequence (LC 128)
- [ ] 4Sum II (LC 454)
- [ ] 3Sum (LC 15)
- [ ] 4Sum (LC 18)
- [ ] Pairs of Songs With Total Durations Divisible by 60 (LC 1010)
- [ ] Check If Array Pairs Are Divisible by k (LC 1497)

**Goal:** Complex relationships

#### Day 26-27: Design & String Patterns
- [ ] LRU Cache (LC 146)
- [ ] LFU Cache (LC 460)
- [ ] Insert Delete GetRandom O(1) (LC 380)
- [ ] Palindrome Pairs (LC 336)
- [ ] Word Ladder (LC 127)
- [ ] Repeated DNA Sequences (LC 187)

**Goal:** System design + advanced strings

#### Day 28: Final Combined Problems
- [ ] Maximum Equal Frequency (LC 1224)
- [ ] Max Consecutive Ones III (LC 1004)
- [ ] Binary Subarrays With Sum (LC 930)
- [ ] Number of Submatrices That Sum to Target (LC 1074)
- [ ] K-diff Pairs in an Array (LC 532)

**Goal:** Master integration

#### Day 29: Mock Interview
- [ ] Set 50-minute timer
- [ ] Solve 1 Easy (10 min)
- [ ] Solve 2 Medium (20 min each)
- [ ] Review and optimize

#### Day 30: Final Review
- [ ] Review all marked difficult problems
- [ ] Create personal cheat sheet
- [ ] Code 5 templates from memory
- [ ] Celebrate progress! 🎉

---

## 🎯 Milestone Checklist

### **Kadane's Algorithm Mastery**
- [ ] Can explain Kadane's algorithm in simple terms
- [ ] Solved all 5 Level 1 problems
- [ ] Solved at least 15 Level 2-4 problems
- [ ] Coded basic Kadane's from scratch 10+ times
- [ ] Understand when to track both max AND min
- [ ] Can handle 2D array problems
- [ ] Understand circular array technique
- [ ] Solved at least 5 Hard problems
- [ ] Can identify Kadane's pattern in 30 seconds

### **HashMap/Set Mastery**
- [ ] Know when to use HashMap vs HashSet
- [ ] Solved all 10 Level 1 problems
- [ ] Solved at least 20 Level 2-5 problems
- [ ] Master frequency counting
- [ ] Understand prefix sum + HashMap technique
- [ ] Can handle sliding window + HashMap
- [ ] Implemented LRU cache successfully
- [ ] Solved at least 5 Hard problems
- [ ] Can choose right data structure instantly

### **Overall Competency**
- [ ] Identify pattern from problem in 1 minute
- [ ] Solve Easy in < 10 minutes consistently
- [ ] Solve Medium in < 25 minutes
- [ ] Can optimize brute force to optimal
- [ ] Completed 10+ combined problems
- [ ] Pass 3 mock interviews
- [ ] Total: 50+ problems solved

---

## 📊 Progress Tracker

### Overall Statistics
```
Kadane's Algorithm:    [___________] 0/35 problems
HashMap/Set:           [___________] 0/72 problems
Combined Patterns:     [___________] 0/10 problems
──────────────────────────────────────────────────
Total Progress:        [___________] 0/117 problems
```

### Weekly Progress
```
Week 1: [___________] 0/25 problems
Week 2: [___________] 0/28 problems
Week 3: [___________] 0/27 problems
Week 4: [___________] 0/27 problems
```

### Difficulty Breakdown
```
Easy:    [___________] 0/40 problems
Medium:  [___________] 0/60 problems
Hard:    [___________] 0/17 problems
```

---

## 📝 Personal Notes Section

### This Week's Goals
```
Week of: ___________

Goals:
1. 
2. 
3. 

Daily Schedule:
Monday:    
Tuesday:   
Wednesday: 
Thursday:  
Friday:    
Weekend:   
```

### Struggling With
```
Concepts I need to review:
- 
- 
- 

Problems to redo:
- 
- 
- 
```

### Breakthrough Moments
```
Date: ___________
Problem: 
Insight: 


Date: ___________
Problem: 
Insight: 
```

### Pattern Recognition Notes
```
Kadane's Triggers:
- "maximum/minimum sum subarray"
- "contiguous array"
- "best time to buy/sell"
- 

HashMap/Set Triggers:
- "two sum", "complement"
- "frequency", "count"
- "duplicate", "unique"
- "group by", "anagram"
- 
```

---

## 💡 Pro Tips & Strategies

### Problem-Solving Framework
1. **Read carefully** - Understand constraints
2. **Identify pattern** - Kadane's or HashMap?
3. **Think out loud** - Explain approach
4. **Start simple** - Brute force first
5. **Optimize** - Apply pattern
6. **Test** - Edge cases
7. **Analyze** - Time & space complexity

### Common Mistakes to Avoid
- ❌ Not handling negative numbers in Kadane's
- ❌ Forgetting to initialize HashMap
- ❌ Missing edge cases (empty array, single element)
- ❌ Not considering integer overflow
- ❌ Confusing HashMap.put() vs HashMap.get()

### Time Complexity Quick Reference
```
Kadane's Algorithm:     O(n) time, O(1) space
HashMap Lookup:         O(1) average
HashSet Lookup:         O(1) average
Sorting for grouping:   O(n log n)
```

### Code Templates to Memorize

#### Basic Kadane's
```java
int maxSum = nums[0], currentSum = nums[0];
for (int i = 1; i < nums.length; i++) {
    currentSum = Math.max(nums[i], currentSum + nums[i]);
    maxSum = Math.max(maxSum, currentSum);
}
```

#### HashMap Frequency Counter
```java
HashMap<Integer, Integer> freq = new HashMap<>();
for (int num : nums) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```

#### Prefix Sum + HashMap
```java
HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, 1);
int sum = 0, count = 0;
for (int num : nums) {
    sum += num;
    count += map.getOrDefault(sum - k, 0);
    map.put(sum, map.getOrDefault(sum, 0) + 1);
}
```

---

## 🏆 Certification Checklist

Before claiming mastery, ensure you can:

### Kadane's Algorithm
- [ ] Explain the algorithm to a beginner
- [ ] Code it from memory in under 2 minutes
- [ ] Identify it in problem statements
- [ ] Handle max AND min tracking
- [ ] Solve 2D variations
- [ ] Handle circular arrays
- [ ] Solve under time pressure

### HashMap/Set
- [ ] Choose correct data structure
- [ ] Implement from scratch (basic version)
- [ ] Use getOrDefault() naturally
- [ ] Handle collisions conceptually
- [ ] Combine with other patterns
- [ ] Debug hash-related issues
- [ ] Optimize space when needed

---

## 🚀 Next Steps After Mastery

Once you've completed this guide:

1. **Sliding Window Pattern** (natural extension)
2. **Two Pointers** (complements HashMap)
3. **Binary Search** (for sorted arrays)
4. **Dynamic Programming** (advanced Kadane's)
5. **Graph Algorithms** (uses HashSet heavily)

---

## 📚 Additional Resources

### Recommended Reading
- "Cracking the Coding Interview" - Chapter 1, 10
- LeetCode Discuss - Pattern-based solutions
- GeeksforGeeks - Kadane's Algorithm variations

### Video Tutorials
- NeetCode - HashMap/Set playlist
- Abdul Bari - Kadane's Algorithm
- Back To Back SWE - Sliding Window

### Practice Platforms
- LeetCode (primary)
- HackerRank (additional practice)
- Codeforces (competitive programming)

---

## 🎓 Final Motivation

> "The expert in anything was once a beginner."

**Remember:**
- Consistency > Intensity
- Understanding > Memorization
- Progress > Perfection

**You've got this! Start with Day 1 and keep going! 💪**

---

## 📅 Daily Log Template

```
Date: ___________
Problems Solved: ___/___
Time Spent: ___ hours

Problems Completed:
1. [Problem Name] - [Time] - [Difficulty] - ✓
2. 
3. 

Key Learnings:
- 

Tomorrow's Plan:
- 
```

---

*Last Updated: November 2024*
*Version: 1.0*
*Good luck on your coding journey! 🚀*