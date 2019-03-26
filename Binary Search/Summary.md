# Binary Search (二分法)
## 什么时候用？
（1）OOXX的问题，即找到第一个出现的位置或者最后一个出现的位置或者有没有出现（第一个X或者最后一个O）；
  a. sorted array
  b. rotated array
（2）保留一半 Half half

## 通用模版
```
start + 1 < end
start + (end - start) / 2
A[mid] ==, <, >
A[start] A[end] ? target
```
