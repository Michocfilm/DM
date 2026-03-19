import java.util.Scanner;
public class GraphMatrix {

    private static final int[][] A = {
        {0, 1, 0, 1},
        {1, 1, 2, 1},
        {0, 2, 0, 0},
        {1, 1, 0, 1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== โปรแกรมสร้างกราฟ G จากเมทริกซ์ A^n (แบบแยก Class) ===");
        System.out.print("กรุณาป้อนเลขชี้กำลัง (n): ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("ข้อผิดพลาด: เลขชี้กำลังต้องเป็นจำนวนเต็มบวกหรือศูนย์");
            return;
        }

        int[][] resultMatrix = MatrixCalculator.power(A, n);

        System.out.println("\n--- เมทริกซ์ผลลัพธ์ A^" + n + " ---");
        GraphDisplayer.printMatrix(resultMatrix);

        System.out.println("\n--- รายละเอียดเส้นเชื่อมของกราฟ G (Edges) ---");
        GraphDisplayer.printEdges(resultMatrix);

        scanner.close();
    }
}
class MatrixCalculator {

    public static int[][] power(int[][] base, int n) {
        int size = base.length;

        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            result[i][i] = 1; 
        }

        // นำเมทริกซ์มาคูณกันจำนวน n ครั้ง
        for (int i = 0; i < n; i++) {
            result = multiply(result, base);
        }
        
        return result;
    }

    private static int[][] multiply(int[][] m1, int[][] m2) {
        int size = m1.length;
        int[][] res = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }
}
class GraphDisplayer {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[ ");
            for (int val : row) {
                // จัดหน้าให้ตัวเลขตรงกัน (ความกว้าง 4 ตัวอักษร)
                System.out.printf("%4d ", val);
            }
            System.out.println("]");
        }
    }

    public static void printEdges(int[][] matrix) {
        int size = matrix.length;
        boolean hasEdges = false;

        System.out.println("รูปแบบ: (จุดเริ่มต้น) ---> (จุดปลายทาง) : [จำนวนเส้นทาง]");
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int walkCount = matrix[i][j];

                if (walkCount > 0) {
                    System.out.printf("จุดยอด v%d  --->  v%d  : มี %d เส้นทาง\n", (i + 1), (j + 1), walkCount);
                    hasEdges = true;
                }
            }
        }

        if (!hasEdges) {
            System.out.println("ไม่มีเส้นเชื่อมใดๆ ในกราฟนี้");
        }
    }
}