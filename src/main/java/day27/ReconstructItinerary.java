package day27;

import java.util.*;

/**
 * @author Heng Yu
 * @date 3/27/20 3:30 PM
 */

/**
 * leetcode 332: Reconstruct Itinerary
 */

public class ReconstructItinerary {
    public static void main(String[] args) {
        ReconstructItinerary solution = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK","MUC"));
        tickets.add(Arrays.asList("SFO","SJC"));
        tickets.add(Arrays.asList("LHR","SFO"));
        List<String> result = solution.findItinerary(tickets);
        System.out.println(result);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> matrix = new HashMap<>();
        for (List<String> ticket : tickets) {
            String dpt = ticket.get(0);
            String dst = ticket.get(1);
            if (!matrix.containsKey(dpt)) {
                matrix.put(dpt, new PriorityQueue<>());
            }
            matrix.get(dpt).offer(dst);
        }
        List<String> res = new ArrayList<>();
        helper("JFK", matrix, res);
        Collections.reverse(res);
        return res;
    }

    private void helper(String dpt, Map<String, PriorityQueue<String>> matrix, List<String> res) {
        PriorityQueue<String> destinations = matrix.get(dpt);
        while (destinations != null && !destinations.isEmpty()) {
            String dst = destinations.poll();
            helper(dst, matrix, res);
        }
        res.add(dpt);
    }
}
