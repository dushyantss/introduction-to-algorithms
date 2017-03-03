### Insertion Sort

#### Description
Let the input be an array A.

So, basically what we do is we move each element left till it is no longer smaller than the element to its left. The implementation is slightly optimized so that we only move the key element only once.

We start with the second element, mark it as key and move each element before it one step right till we reach an element which is not greater than it. Then we put the key in the place of the last moved element.

We continue this till we reach the end of the array.

The loop invariant is that we ensure that there is a sorted array to the left of the key element.

#### Complexity

O(n^2) worst case.

#### Pseudocode

``` 
for j = 2 to A.length
  key = A[j]
  // Insert A[j] into the sorted sequence A[1..j - 1].
  i = j - 1
  while i > 0 and A[i] > key
    A[i + 1] = A[i]
    i = i - 1
  A[i + 1] = key
```
