import java.util.Scanner;
public class Exam3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // สร้าง object สำหรับเรียกใช้ twocomlement โดย object ชื่อ TC
        TwoComplement TC = new TwoComplement();
        // สร้าง object สำหรับเรียกใช้ Gcd โดย object ชื่อ gcd
        Gcd gcd = new Gcd();
        System.out.print("ป้อนเลขฐาน 2 ขนาด 8 บิต: ");
        String binary = sc.nextLine();
        if (binary.length() != 8) {
            System.out.println("ต้องป้อนเลขฐาน 2 จำนวน 8 บิตเท่านั้น");
        } else {
            int decimal = TC.binaryToDecimal(binary);
            // แสดงผลลัพธ์ของการ TwoComplement
            System.out.println("ค่าในฐาน 10 คือ: " + decimal);
        }
        System.out.print("ป้อนจำนวนที่ 1: ");
        int a = sc.nextInt();
        System.out.print("ป้อนจำนวนที่ 2: ");
        int b = sc.nextInt();
        //คำนวณและแสดงผลลัพธ์ Gcd
        System.out.println("ค่า GCD = " + gcd.gcd(a, b));
        sc.close();
    }
}
