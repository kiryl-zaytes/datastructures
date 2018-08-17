**Stack implementation with open boundaries**

    - Java historical way to create array of type T storage = (T[]) new Object[size]
    - [N++] first find object then ++
    - [--N] first -- then get object
    - resize rules l*2 when no space left, and l/2 when only 1/4 of array filled.
    - Implements iterable method and carrying nested class that implements Iterator (from end to start)

**Loitering**. Java’s garbage collection policy is to reclaim the memory associated with any objects that can no longer be accessed. 
In our pop() implementations, the reference to the popped item remains in the array. 
The item is effectively an orphan—it will be never be accessed again—but the Java garbage collector has no way to know this until it is overwritten.
Even when the client is done with the item, the reference in the array may keep it alive. 
This condition (holding a reference to an item that is no longer needed) is known as loitering. 
In this case, loitering is easy to avoid, by setting the array entry corresponding to the popped item to null, 
thus overwriting the unused refer- ence and making it possible for the system to reclaim the memory associated with the popped item when the client is finished with it.