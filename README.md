# HeapsDataSet
HeapsDataSet

A DataSet that could perform the following on the following Runtime efficiency:

- Build the data set - O(N)
- Insert a value to it - O(logN)
- Find Maximum Value - O(1)
- Find Minimum Value - O(1)
- Delete the Maximum value - O(logN)
- Delete the Minimum value - O(logN)

The data set is holding two heaps (Maximum and Minimum Heap), where each value in one heap is holding another value which is a pointer to the same value in the other heap.
when we deleting one value from one heap, we are deleting the same value in the other heap by the pointer, running MaxHeapify's algorithm to maintain the heap structure.

building heaps is done using Heap classic algorithm.

to run an interactive UI, run the main method in Driver.java

Jafar.
