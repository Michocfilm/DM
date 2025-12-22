import java.util.Scanner;
class Calculator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Base 10 : ");
        int Input = sc.nextInt();
        sc.close();
        try {
            Result(Input);   
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }

    static void Result(int A){
        System.out.printf("Input(Base 10) : %s \nBinary : %s \nOctal : %s \nHexadecimal : %s",
                            A,ConvertToBinary(A)
                            ,ConvertToOctal(A)
                            ,ConvertToHex(A)); 
    }
    static String ConvertToBinary(int B){
        String binary = ""; 
        if (B == 0) {
            binary = "0";
        } else {
            while (B > 0) {
                int remainder = B % 2; // หาเศษ
                binary = remainder + binary; // นำเศษมาวางไว้ด้านหน้าสตริง
                B = B / 2;       // หารเอาส่วนเพื่อทำรอบถัดไป
            }
        }
        return binary;
    }
    static String ConvertToOctal(int C){
        String octal = ""; 
        if (C == 0) {
            octal = "0";
        } else {
            while (C > 0) {
                int remainder = C % 8; // หาเศษจากการหารด้วย 8
                octal = remainder + octal;    // นำเศษมาวางไว้ด้านหน้า
                C = C / 8;        // หารเอาส่วนเพื่อคำนวณรอบถัดไป
            }
        }
        return octal;
    }
    static String ConvertToHex(int D){
        String hex = "";
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        if (D == 0) {
            hex = "0";
        } else {
            while (D > 0) {
                int remainder = D % 16;   // หาเศษจากการหารด้วย 16
                hex = hexChars[remainder] + hex; // นำเศษไปเทียบตัวอักษรแล้ววางไว้ด้านหน้า
                D = D / 16;         // หารเอาส่วนเพื่อทำรอบถัดไป
            }
        }
        return hex;
    }

}