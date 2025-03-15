package com.leetcode.Medium;

import java.util.*;

/**
 * This class contains methods to determine the winners and losers of matches,
 * identifying players who have not lost any matches and players who have lost exactly one match.
 * The results are returned as two separate lists, sorted in increasing order.
 */
public class FindPlayersWithZeroorOneLosses {

    /**
     * This method returns two lists of players:
     * - Players who have not lost any matches.
     * - Players who have lost exactly one match.
     *
     * @param matches A 2D array where each element `matches[i] = [winneri, loseri]` represents a match
     *                where `winneri` defeated `loseri`.
     * @return A list containing two lists:
     *         - The first list contains players with no losses (winners).
     *         - The second list contains players with exactly one loss.
     */
    public List<List<Integer>> findWinners2(int[][] matches) {
        // A map to track the loss count for each player.
        Map<Integer, Integer> lossCount = new HashMap<>();
        // A set to track all players that have played at least one match.
        HashSet<Integer> players = new HashSet<>();

        // Loop through each match to update loss count and players set.
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // Increment the loss count for the loser, and initialize the winner with 0 losses.
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
            lossCount.putIfAbsent(winner, 0);

            // Add both winner and loser to the set of players.
            players.add(winner);
            players.add(loser);
        }

        // Lists to store players with no losses and exactly one loss.
        List<Integer> noLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        // Iterate through all players and classify them based on their loss count.
        for (int player : players) {
            int nLosses = lossCount.get(player);
            if (nLosses == 0) {
                noLosses.add(player);
            } else if (nLosses == 1) {
                oneLoss.add(player);
            }
        }

        // Sort both lists in increasing order.
        Collections.sort(noLosses);
        Collections.sort(oneLoss);

        // Return both lists as a result.
        return Arrays.asList(noLosses, oneLoss);
    }

    /**
     * This method returns two lists of players:
     * - Players who have not lost any matches.
     * - Players who have lost exactly one match.
     *
     * @param matches A 2D array where each element `matches[i] = [winneri, loseri]` represents a match
     *                where `winneri` defeated `loseri`.
     * @return A list containing two lists:
     *         - The first list contains players with no losses.
     *         - The second list contains players with exactly one loss.
     */
    public List<List<Integer>> findWinners(int[][] matches) {
        // Lists to store the winners and losers
        List<Integer> winners = new ArrayList<>();
        List<Integer> losers = new ArrayList<>();

        // A map to track wins and losses for each player.
        // The map stores an array of size 2:
        //   - index 0 stores the number of wins
        //   - index 1 stores the number of losses
        HashMap<Integer, int[]> map = new HashMap<>();

        // Loop through each match to update wins and losses
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // Ensure the winner and loser are in the map
            if (!map.containsKey(winner)) {
                map.put(winner, new int[2]);  // Initialize with [wins=0, losses=0]
            }

            if (!map.containsKey(loser)) {
                map.put(loser, new int[2]);  // Initialize with [wins=0, losses=0]
            }

            // Increment the win count for the winner and loss count for the loser
            int[] auxW = map.get(winner);
            int[] auxL = map.get(loser);

            auxW[0] = auxW[0] + 1;
            auxL[1] = auxL[1] + 1;
        }

        // Iterate through the map and classify players based on their win/loss records
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] values = entry.getValue();
            if (values[0] > 0 && values[1] == 0) {
                // Player has won all matches (no losses)
                winners.add(entry.getKey());
            } else if (values[1] == 1) {
                // Player has lost exactly one match
                losers.add(entry.getKey());
            }
        }

        // Sort both lists in increasing order.
        Collections.sort(winners);
        Collections.sort(losers);

        // Return the list containing both the winners and losers.
        return Arrays.asList(winners, losers);
    }
}
