## Question

[160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists)

### Approach: With Length

* Traverse both linked lists and find their lengths.
* Calculate the difference between their lengths.
* Traverse the longer linked list by the difference between their lengths.
* Traverse both linked lists in parallel until they intersect.
* Return the intersection node.

### Approach: Without Length

First, two objects of the ListNode class named nodeA and nodeB are initialized with headA and headB, respectively.

Then, a while loop is started that checks if nodeA and nodeB are not equal. Inside the loop, nodeA is set to nodeA.next if it is not null; otherwise, it is set to headB. Similarly, nodeB is set to nodeB.next if it is not null; otherwise, it is set to headA. This is done to ensure that both nodeA and nodeB traverse through the same number of nodes in both linked lists.

Once the while loop exits, it means that nodeA and nodeB are pointing to the same node, which is the intersection point of the two linked lists.

Finally, nodeA is returned, which is the intersection node.
