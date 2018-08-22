We assume that “is connected to” is an equivalence relation, which means that it is
■ Reflexive : p is connected to p.
■ Symmetric : If p is connected to q, then q is connected to p.
■ Transitive : If p is connected to q and q is connected to r, then p is connected to r.
An equivalence relation partitions the objects into equivalence classes. In this case, two objects are in the same equivalence class if and only if they are connected.


**Networks.** The integers might represent computers in a large network, and the pairs might represent connections in the network. Then, our program determines whether we need to establish a new direct connection for p and q to be able
to communicate or whether we can use existing connections to set up a communications path. Or, the integers might represent contact sites in an electrical circuit, and the pairs might represent wires connecting the sites.
**Variable-name equivalence.** In certain programming environ- ments, it is possible to declare two variable names as being equiv- alent (references to the same object).
**Mathematical sets.** On a more abstract level, you can think of the integers as belonging to mathematical sets. When we process a pairp q,weareaskingwhethertheybelongtothesameset



**Quick-union.** The next algorithm that we consider is a complementary method that concentrates on speeding up the union() operation. 
It is based on the same data structure—the site-indexed id[] array—but we interpret the values differently, to define more complicated
structures. Specifically, the id[] entry for each site is the name of another site in the same component (possibly
itself)—we refer to this connection as a link. To implement find(), we start at the given site, follow its link to another site, follow that site’s link to yet
another site, and so forth, following links until reaching a root, a site that has a link to itself (which is guaranteed to happen, as you will see). Two
sites are in the same component if and only if this process leads them to the same root.
 
 **Weighted quick-union.** Fortunately, there is an easy modification to quick-union that allows us to guarantee that bad cases such as this one do
 not occur. Rather than arbitrarily connecting the second tree to the first for union(), we keep track of the size of each tree and always connect the
 smaller tree to the larger.Rather than arbitrarily connecting the second tree to the first for union(), we keep track of the size of each tree and always connect the
 smaller tree to the larger.
 
 Corollary. For weighted quick-union with N sites, the worst-case order of growth of the cost of find(), connected(), and union() is log N
 **To implement path compression**, we just add another loop to find() that sets the id[] entry corresponding to each node encountered along the way to link directly to the root. 
 The net result is to flatten the trees almost completely, ap- proximating the ideal achieved by the quick-find algorithm. 