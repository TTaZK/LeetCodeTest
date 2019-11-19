package leetcode;

public class Hannoi {
    public static void hannoi(int n, char from, char buffer, char to) {
        if (n <= 0) return;
        // 先把上面 n-1 个盘子从第一个杆子移动到第二个
        hannoi(n - 1, from, to, buffer);
        // 将第 n 个盘子从第一个杆子移动到第三个
        System.out.println("move " + n + " from " + from + " to " + to);
        // 将第       二个杆子上的 n-1 个盘子移动到第三个杆子
        hannoi(n - 1, buffer, from, to);
    }
}
