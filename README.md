# ocp
Repo for OCP Preparation and Examples.

Miscellaneous Notes:

1. Big O Notation
   Big O notation lets you compare the order of magnitude (something that take an unknown time, say between 1 and 10 
   seconds) rather than exact performance. It assumes worst case response time i.e. if it is sometimes instantaneous
   and sometimes it takes 10 minutes, big O uses the longer one. It uses n to reflect the number of elements or size 
   of the data. Common notations:
   * O(1) --> constant time. It doesn't matter what the size of the collection is, it always takes the same time to
              return. E.g. Returning a String literal always takes the same time.
   * O(log n) --> logarithmic time. A logarithm is a mathematical function that grows more slowly that the data size.
              It is better than liner time since it grows more slowly. E.g. Binary search because it doesn't lool at
              the majority of elements in a large collection.
   * O(n) --> linear time. Performance grows linearly with respect to the size of the collection. E.g. Looping through
              a growing list of elements.
   * O(n2) --> n squared time. Code that has nested loops where each loop goes through the data.
2. Note that functional interfaces do not declare checked exceptions - this can be a problem for methods that do declare
   checked exceptions. Recommended solution is to wrap method in another method which has a try/catch - see page 216.