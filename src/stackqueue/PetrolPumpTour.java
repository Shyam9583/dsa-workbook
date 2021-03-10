package stackqueue;

public class PetrolPumpTour {
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(tour(petrol, distance));
    }

    private static int tour(int[] petrol, int[] distance) {
        int n = petrol.length, front = 0, rear = 0;
        int cnt = 0, balance = 0, i = 0;
        while (cnt < n && i < n) {
            balance += (petrol[rear] - distance[rear]);
            rear = (rear + 1) % n;
            if (balance < 0) {
                i++;
                front = rear;
                balance = 0;
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return cnt == n ? front : -1;
    }
}
