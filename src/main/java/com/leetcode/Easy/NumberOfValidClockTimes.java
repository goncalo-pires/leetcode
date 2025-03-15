package com.leetcode.Easy;

public class NumberOfValidClockTimes {

    /**
     * This function calculates the number of valid clock times that can be formed by replacing
     * every '?' symbol in the given time string with a valid digit from 0 to 9.
     * The time string follows the format "hh:mm".
     *
     * The valid clock times must satisfy the constraints:
     * - The hour must be between 00 and 23.
     * - The minutes must be between 00 and 59.
     *
     * @param time A string representing the current time with some '?' symbols.
     * @return The number of valid clock times that can be created by replacing '?' with digits.
     */
    public int countTime(String time) {

        // Extract the individual characters representing the hour and minute components of the time.
        char hourFirst = time.charAt(0);
        char hourSecond = time.charAt(1);
        char minuteFirst = time.charAt(3);
        char minuteSecond = time.charAt(4);

        // Determine how many possibilities there are for the first minute digit (minuteFirst).
        int minutes = minuteFirst == '?' ? 6 : 1;  // If '?' in minuteFirst, 6 possibilities (0, 1, 2, 3, 4, 5)
        int seconds = minuteSecond == '?' ? 10 : 1; // If '?' in minuteSecond, 10 possibilities (0-9)

        int hoursTotal = 1;

        // Calculate the possibilities for the hour based on the '?' characters.
        if (hourFirst == '?') {
            // If hourFirst is '?', check hourSecond and calculate valid hours:
            hoursTotal = hourSecond == '?' ? 24 : (hourSecond - '0' < 4 ? 3 : 2); // 24 if both '?', otherwise 3 or 2 possibilities based on hourSecond
        } else if (hourSecond == '?') {
            // If hourSecond is '?', check hourFirst:
            hoursTotal = hourFirst - '0' < 2 ? 10 : 4; // If hourFirst is 0 or 1, 10 possibilities for hourSecond; else 4 possibilities for hourSecond
        }

        // The total number of valid times is the product of the possibilities for hours, minutes, and seconds.
        return hoursTotal * minutes * seconds;
    }

}
