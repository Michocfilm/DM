import java.util.Scanner;
public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== โปรแกรม Tower of Hanoi (แบบ OOP) ===");
        System.out.print("กรุณาระบุจำนวนจาน (Disks): ");
        int numberOfDisks = scanner.nextInt();

        HanoiSolver solver = new HanoiSolver();
        System.out.println("\n--- เริ่มต้นการย้าย ---");
        solver.solve(numberOfDisks, 'A', 'C', 'B');
        System.out.println("สรุปจำนวนการย้ายทั้งหมด: " + solver.getMoveCount() + " ครั้ง");
        scanner.close();
    }

}

class HanoiSolver{
    private int moveCount;
    public void solve(int n, char source, char target, char auxiliary){
        if (n == 1) {
            moveDisk(1, source, target);
            return;
        }
        solve(n - 1, source, auxiliary, target);
        moveDisk(n, source, target);
        solve(n - 1, auxiliary, target, source);
    }

    private void moveDisk(int disk, char from, char to){
        moveCount++;
        System.out.println("ครั้งที่ " + moveCount + ": ย้ายแผ่นดิสก์ " + disk + " จาก " + from + " ไปยัง " + to);
    }

    public int getMoveCount(){
        return moveCount;
    }
}
