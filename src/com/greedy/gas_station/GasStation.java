package com.greedy.gas_station;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;   // number of gas stations
        int totalSurplus = 0; // total surplus of gas over all stations, it will give us a difference b/w gas & cost
        int surplus = 0;      // surplus of gas at each station, our tank
        int start = 0;        // starting station index

        // iterate over all gas stations
        for (int i = 0; i < n; i++) {
            totalSurplus += gas[i] - cost[i]; // update total surplus
            surplus += gas[i] - cost[i];      // update current surplus

            // if current surplus is negative, move to next station
            // if we run out of fuel say at some ith gas station.
            // all the gas station between ith and starting point are bad starting point as well,
            // so we move to i+1'th gas station
            if (surplus < 0) {
                surplus = 0;         // reset current surplus
                start = i + 1;       // move to next station
            }
        }

        // if total surplus is positive, return starting station index, else return -1
        return totalSurplus >= 0 ? start : -1;
    }
}

