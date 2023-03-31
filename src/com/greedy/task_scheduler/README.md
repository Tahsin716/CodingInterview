### Approach

#### Intuition of the problem
We have to find the least number of intervals to finish all tasks. Given that, each task requires one interval, for tasks of size t, we need at least t intervals to complete it.

Now the problem is reduced to finding the minimum idle time when no task is executing.
Our result would be idle Time + t (size of task array)