package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int[] S = {1, 3, 0, 5, 8, 5};
        int[] F = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(S, F, S.length));
    }

    private static int maxMeetings(int[] start, int[] end, int n) {
        Appointment[] appointments = new Appointment[n];
        Appointment selection;
        int count = 1;
        for (int i = 0; i < n; i++) {
            appointments[i] = new Appointment(start[i], end[i]);
        }
        Arrays.sort(appointments, Comparator.comparingInt(o -> o.end));
        selection = appointments[0];
        for (int i = 1; i < n; i++) {
            if (selection.end < appointments[i].start) {
                count++;
                selection = appointments[i];
            }
        }
        return count;
    }

    private static class Appointment {
        int start, end;

        Appointment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
