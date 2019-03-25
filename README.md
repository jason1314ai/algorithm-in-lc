# java-leetcode
## 时间复杂度计算
```
T(n) = aT(n/b) + f(n) 【a >= 1; b>=1, f(n)为positive function】

if f(n) = O(n^(logb a-e)) T(n) = O(n^logb a)
if f(n) = O(n^logb a) T(n)= O(n^logb a * lgn)
if f(n) = O(n^logb a +e)  T(n) = O(f(n))
```
```
(1) T(n) = T(n/2)+ O(1)  T(n) = O(logn) 【二分法】
(2) T(n) = T(n/2) +O(n)  T(n) = O(n)
(3) T(n) = 2*T(n/2) + O(n) T(n) = O(n*logn) 【mergesort quicksort】
```

## 通过时间复杂度推测算法
```
O(logn) : 二分法
O(n^1/2): 分解质因数
O(nlogn) : 涉及到排序
O(n^2):  数组，枚举，动态规划
O(n^3): 数组，枚举，动态规划
O(2^n): 与组合有关的搜索
O（n!） 与排列有关的搜索
```
