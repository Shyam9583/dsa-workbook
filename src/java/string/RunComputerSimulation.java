package java.string;

public class RunComputerSimulation {
    public static void main(String[] args) {
        int nComputers = 1;
        String sequence = "ABCBCADEED";
        System.out.println(unableCount(nComputers, sequence));
    }

    // 0 - not in cafe, 1 - in cafe but doesn't have computer, 2 - in cafe and has computer
    private static int unableCount(int nComputers, String sequence) {
        int[] hasComputer = new int[26];
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int customer = sequence.charAt(i) - 'A';
            if (hasComputer[customer] == 0) {
                if (nComputers > 0) {
                    nComputers--;
                    hasComputer[customer] = 2;
                } else {
                    count++;
                    hasComputer[customer] = 1;
                }
            } else {
                if (hasComputer[customer] == 2) {
                    nComputers++;
                }
                hasComputer[customer] = 0;
            }
        }
        return count;
    }
}
