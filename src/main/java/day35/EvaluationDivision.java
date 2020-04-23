package day35;

import java.util.*;

/**
 * @author Heng Yu
 * @date 4/22/20 7:30 PM
 */


public class EvaluationDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Set<Integer>> indices = new HashMap<>();
        int len = values.length;
        for (int i = 0; i < len; ++i) {
            List<String> equation = equations.get(i);
            for (String s : equation) {
                if (!indices.containsKey(s)) {
                    indices.put(s, new HashSet<>());
                }
                indices.get(s).add(i);
            }
        }
        Map<String, Double> variables = new HashMap<>();
        Map<String, Integer> components = new HashMap<>();
        int count = 0;
        for (String s : indices.keySet()) {
            if (!variables.containsKey(s)) {
                variables.put(s, 1.0);
                helper(s, indices, variables, components, values, equations, count);
                components.put(s, count);
                ++count;
            }
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            List<String> query = queries.get(i);
            String first = query.get(0);
            String second = query.get(1);
            if (!variables.containsKey(first) || !variables.containsKey(second) || !components.get(first).equals(components.get(second))) {
                res[i] = -1.0;
            } else {
                res[i] = variables.get(first) / variables.get(second);
            }
        }
        return res;
    }

    private void helper(String s, Map<String, Set<Integer>> indices, Map<String, Double> variables, Map<String, Integer> components, double[] values, List<List<String>> equations, int count) {
        Set<Integer> index = indices.get(s);
        for (int i : index) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String first = equation.get(0);
            String second = equation.get(1);
            if (s.equals(first)) {
                if (!variables.containsKey(second)) {
                    double nextValue = variables.get(s) / value;
                    variables.put(second, nextValue);
                    components.put(second, count);
                    helper(second, indices, variables, components, values, equations, count);
                }
            } else {
                if (!variables.containsKey(first)) {
                    double nextValue = value * variables.get(s);
                    variables.put(first, nextValue);
                    components.put(first, count);
                    helper(first, indices, variables, components, values, equations, count);
                }
            }
        }
    }
}
