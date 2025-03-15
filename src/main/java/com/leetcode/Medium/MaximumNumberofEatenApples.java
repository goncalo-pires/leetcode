package com.leetcode.Medium;

public class MaximumNumberofEatenApples {

    /**
     * Function to calculate the maximum number of apples that can be eaten given constraints.
     *
     * On each day, apples are grown that will rot after a certain number of days.
     * The goal is to eat at most one apple per day, starting from day 0.
     * If apples are available, you should eat the one with the closest expiry date first.
     *
     * @param apples an array representing the number of apples grown each day.
     * @param days an array representing the number of days after which the apples will rot.
     * @return the maximum number of apples that can be eaten.
     */
    public static int eatenApples(int[] apples, int[] days) {
        int n = apples.length; // Get the number of days
        int[] applesExpiry = new int[n + 20001]; // Array to track how many apples will expire on each day
        int count = 0; // To keep track of how many apples we've eaten
        int lastDay = n; // This will track the last day we need to consider (starting from the number of days)
        int latestExpiryPointer = 0; // This will point to the day when apples are expiring

        // Loop through each day
        for (int currentDay = 0; currentDay < lastDay; currentDay++) {

            // Add the apples that grow on the current day to the expiry array
            if (currentDay < n) {
                int currentExpiry = days[currentDay] + currentDay; // Calculate when apples from today will rot
                applesExpiry[currentExpiry] += apples[currentDay]; // Increment the number of apples that will rot on that day
                if (currentExpiry > lastDay) lastDay = currentExpiry; // Update the last day if we have new expiry days
                if (currentExpiry < latestExpiryPointer) latestExpiryPointer = currentExpiry; // Adjust pointer if needed
            }

            // Find the next day where apples are available to eat (i.e., not rotten)
            while ((latestExpiryPointer <= currentDay || applesExpiry[latestExpiryPointer] == 0) && latestExpiryPointer < lastDay) {
                latestExpiryPointer++; // Move the pointer to the next available expiry day
            }

            // If we have apples available to eat, eat one apple
            if (applesExpiry[latestExpiryPointer] != 0) {
                applesExpiry[latestExpiryPointer]--; // Decrease the number of apples that expire on that day
                count++; // Increase the count of apples eaten
            }
        }

        // Return the total count of apples eaten
        return count;
    }

}
