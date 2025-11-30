# Dynamic Programming Cheat Sheet (Pattern-Based)

## 1. Kadane Pattern – “Extend or Restart”
Use when the choice is:
Continue the streak OR start fresh at current element.

Recurrence:
dp[i] = max(nums[i], nums[i] + dp[i-1])

Keywords:
- maximum subarray
- streak continuation
- contiguous maximum sum

Problems:
- Maximum Subarray (LC 53)
- Maximum alternating sum
- Max circular subarray

---

## 2. House Robber Pattern – “Pick or Skip (no adjacency)”
Picking an item forbids picking neighbors.

Recurrence:
dp[i] = max(dp[i-1], dp[i-2] + nums[i])

Keywords:
- non-adjacent
- include/exclude
- adjacency restriction

Problems:
- House Robber I/II
- Delete and Earn
- Max sum of non-adjacent elements

---

## 3. Fibonacci / Climbing Stairs Pattern
dp[i] depends on dp[i-1] and dp[i-2].

Recurrence:
dp[i] = dp[i-1] + dp[i-2]

Keywords:
- number of ways
- steps, jumps

Problems:
- Climbing Stairs
- Min cost climbing stairs
- Domino tiling

---

## 4. Knapsack Pattern – Capacity + Items
Use when there is a weight/capacity constraint.

0/1 Knapsack Recurrence:
dp[c] = max(dp[c], dp[c - weight] + value)

Keywords:
- capacity/limit
- pick items
- optimize value

Problems:
- 0/1 Knapsack
- Subset Sum
- Partition Equal Subset Sum
- Coin Change I/II
- Target Sum
- Rod Cutting

---

## 5. LCS / Edit Distance – 2D String DP
Comparing two sequences.

LCS Recurrence:
if s1[i] == s2[j]:
    dp[i][j] = 1 + dp[i-1][j-1]
else:
    dp[i][j] = max(dp[i-1][j], dp[i][j-1])

Edit Distance:
dp[i][j] = 1 + min(insert, delete, replace)

Keywords:
- comparing sequences
- subsequences/substrings
- strings grid DP

Problems:
- LCS
- Edit Distance
- Longest common substring
- Longest palindromic subsequence

---

## 6. Matrix Path DP – Grid Movement
Typical recurrences:

Min path sum:
dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])

Unique paths:
dp[i][j] = dp[i-1][j] + dp[i][j-1]

Keywords:
- grid
- right/down
- path count or path cost

Problems:
- Unique Paths
- Minimum Path Sum
- Dungeon Game

---

## 7. Interval DP – “dp[i][j] depends on splits at k”
Recurrence structure:

dp[i][j] = min/max over k in (i..j):
              dp[i][k] + dp[k+1][j] + cost

Keywords:
- interval segments
- merging/splitting
- chain operations

Problems:
- Burst Balloons
- Matrix Chain Multiplication
- Stone Game variants

---

## 8. Palindrome DP – Substring DP
Typical recurrence:

dp[l][r] = (s[l] == s[r]) && dp[l+1][r-1]

Keywords:
- palindromes
- substrings/subsequences

Problems:
- Longest Palindromic Substring
- Longest Palindromic Subsequence

---

## 9. Tree DP – Postorder DP
dp[node] = combine(dp[child1], dp[child2], ...)

Keywords:
- tree structure
- postorder traversal
- subtree properties

Problems:
- Diameter of Binary Tree
- House Robber III
- Max path sum in tree

---

## 10. Bitmask DP – Subset as State
dp[mask] = best value using subset = mask

Keywords:
- subsets
- small N (<=20)
- permutations
- exponential DP

Problems:
- Traveling Salesman
- Stickers to Spell Word
- Partition to K subsets
- Minimum incompatibility

---

## 11. DAG DP / Graph DP
Topological order DP.

General recurrence:
dp[node] = best over dp[parent] + weight

Keywords:
- DAG
- longest/shortest path
- counting paths

---

## 12. State Machine DP
Used when system has multiple states per index.

Example (stock trading):
dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price)
dp[i][1] = max(dp[i-1][1], dp[i-1][0] - price)

Keywords:
- mode/state transitions
- stock problems
- cooldown, fee, k transactions

---

## How to Identify DP Quickly

1. Is there optimal substructure?
2. Are subproblems overlapping?
3. Do you see words like max/min/ways/count?
4. Is there a constraint (capacity, adjacency, order)?
5. Can a state be defined by i, (i,j), or a bitmask?

---

## How to Solve Any DP

1. Identify DP pattern.
2. Define dp state(s).
3. Write recurrence.
4. Set base cases.
5. Choose bottom-up / top-down.
6. Optimize space if needed.
