# mp-sorting-maven Redo 1 CHANGES

1. Decomposed all sorting algorithms to comply with E guidelines. 

Insertion sort has a separate `insert` method.

Selection sort has a separate `select` method.

Merge sort has a separate `merge` method.

Quicksort has a separate `partition` method.

2. Redesigned merge sort to comply with E guidelines.

Only makes one helper array in `MergeSort`.

3. Fixed all checkstyle violations from my changes.