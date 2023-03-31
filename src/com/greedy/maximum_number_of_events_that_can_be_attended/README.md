### Approach 1: TreeSet

The idea behind this solution is to simulate attending the events and keeping track of the available days.

The algorithm first sorts the events by their ending date in increasing order. Then, it creates a set to keep track of which days are available. It adds all days from 1 to 100000 to the set.

For each event, it gets the start and end dates of the event. It then finds the earliest available day for the event using the ceiling() method of the TreeSet class. If there is no available day or if the earliest available day is after the end date of the event, it skips the event and moves on to the next one. If there is an available day, it removes that day from the set and increases the count of attended events.

Finally, the function returns the count of attended events.


### Approach 2: PriorityQueue

The code starts by sorting the events by their start day using a lambda expression as the comparator function for Arrays.sort(). Then, it creates a min heap of the end days using a PriorityQueue. The variable day is initialized to 1, and the variable count is initialized to 0.

The code then enters a loop that runs until all events have been attended.

At each iteration of the loop, it first adds end date, of any events that start on or are before the current day to the min heap using a while loop.

It then removes any events from the min heap that have already ended using another while loop.

Finally, it attends an event on the current day if one is available in the min heap, and increments the count variable.

The loop continues until all events have been attended. The count variable is then returned as the maximum number of events that can be attended.