An in- versionisapairofentriesthatareoutoforderinthearray.Forinstance,E X A M P L E has 11 inversions: 
E-A, X-A, X-M, X-P, X-L, X-E, M-L, M-E, P-L, P-E, and L-E. If the number of inversions in an array is less 
than a constant multiple of the array size, we say that the array is partially sorted. Typical examples of partially sorted arrays are the following:
■ An array where each entry is not far from its final position
■ A small array appended to a large sorted array
■ An array with only a few entries that are not in place
Insertion sort is an efficient method for such arrays; selection sort is not. Indeed, when the number of inversions is low, 
**insertion sort is likely to be faster than any sorting method.**
Insertion sort is slow for large un- ordered arrays because the only exchanges 
it does involve adjacent entries, so items can move through the array only one place at a time. 
For example, if the item with the smallest key happens to be at the end of the array, N 1 exchanges are needed to get that one item where it belongs.
**SHELSORT**
The idea is to rearrange the array to give it the property that taking every hth entry (starting anywhere) 
yields a sorted subsequence. Such an array is said to be h-sorted.
One way to implement shellsort would be, for each h, to use insertion sort indepen-
dently on each of the h subsequences. Because the subsequences are independent, we can use an even simpler approach: when h-sorting the array, we insert each item among the previous items in its h-subsequence by exchanging it with those that have larger keys (moving them each one position to the right in the subsequence). We accomplish this task by using the insertion-sort code, but modified to decrement by h instead of 1 when moving through the array. 
This observation reduces the shellsort implementa- tion to an insertion-sort-like pass through the array for each increment.