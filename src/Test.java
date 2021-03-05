import ds.Queue;

public class Test {
    public static void main(String[] args) throws Exception {
        Queue q = new Queue();
        for (int i = 0; i < 5; i++)
            q.add(i);
        while (!q.isEmpty())
            System.out.println(q.remove());
    }
}
