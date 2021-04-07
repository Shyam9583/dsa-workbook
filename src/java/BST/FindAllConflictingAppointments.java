package java.BST;

public class FindAllConflictingAppointments {

    private static Node insert(Node root, Interval interval) {
        if (root == null) return new Node(interval);
        if (root.interval.low < interval.low)
            root.left = insert(root.left, interval);
        else
            root.right = insert(root.right, interval);
        if (root.max < interval.high)
            root.max = interval.high;
        return root;
    }

    public static void main(String[] args) {
        int[][] appointments = {{1, 5}, {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}};
        printConflicts(appointments);
    }

    private static void printConflicts(int[][] appointments) {
        Node root = new Node(new Interval(appointments[0][0], appointments[0][1]));
        for (int i = 1; i < appointments.length; i++) {
            Interval interval = new Interval(appointments[i][0], appointments[i][1]);
            Interval conflicting = conflict(root, interval);
            if (conflicting != null)
                System.out.println(interval + " conflicts with " + conflicting);
            root = insert(root, interval);
        }
    }

    private static Interval conflict(Node root, Interval key) {
        if (root == null) return null;
        if (key.low < root.interval.high) return root.interval;
        if (root.left != null && root.left.max > key.low)
            return conflict(root.left, key); // only search left subtree if there exists a high > key.low
        return conflict(root.right, key);
    }

    private static class Interval {
        int low, high;

        Interval(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "low=" + low +
                    ", high=" + high +
                    '}';
        }
    }

    private static class Node {
        Interval interval;
        int max; // necessary for finding conflicts
        Node left, right;

        Node(Interval interval) {
            this.interval = interval;
            this.max = interval.high;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "interval=" + interval +
                    ", max=" + max +
                    '}';
        }
    }

}
