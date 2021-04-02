package graph;

import java.util.*;

public class WaterJugProblem {
    public static void main(String[] args) {
        int a = 4, b = 3, target = 2;
        solve(a, b, target);
    }

    private static void solve(int a, int b, int target) {
        Set<State> visited = new HashSet<>();
        Queue<State> q = new LinkedList<>();
        ArrayList<State> result = new ArrayList<>();
        boolean notSolvable = true;
        q.add(new State(0, 0));
        while (!q.isEmpty()) {
            State curr = q.remove();
            if (visited.contains(curr)) continue;
            if (curr.a > a || curr.b > b || curr.a < 0 || curr.b < 0) continue;
            result.add(curr);
            visited.add(curr);

            // Target State Reached
            if (curr.a == target || curr.b == target) {
                notSolvable = false;
                if (curr.a == target) {
                    if (curr.b != 0) result.add(new State(target, 0));
                } else {
                    if (curr.a != 0) result.add(new State(0, target));
                }
                result.forEach(System.out::println);
                break;
            }

            // Fill Jug2 and Jug1
            q.add(new State(curr.a, b));
            q.add(new State(a, curr.b));

            // Pour Jug2 -> Jug1 and vice versa
            for (int ap = 0; ap <= Math.max(a, b); ap++) {
                int c = curr.a - ap;
                int d = curr.b + ap;
                if (d == b || c == 0) q.add(new State(c, d));
                c = curr.a + ap;
                d = curr.b - ap;
                if (c == a || d == 0) q.add(new State(c, d));
            }

            // Empty Jug2 and fill Jug1 and vice versa
            q.add(new State(a, 0));
            q.add(new State(0, b));
        }
        if (notSolvable) System.out.println("NO SOLUTION EXISTS!");
    }

    private static class State {
        int a, b;

        State(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            return a == state.a && b == state.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }
    }
}
