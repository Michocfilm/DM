public class TwoComplement {
    public int binaryToDecimal(String binary) {
        // ถ้าบิตซ้ายสุดเป็น 0 แสดงว่าเป็นค่า +
        if (binary.charAt(0) == '0') {
            //แปลง String ฐาน 2 เป็น Integer จำนวนเต็ม
            return Integer.parseInt(binary, 2); 
        }
        // ถ้าบิตซ้ายสุดเป็น 1 แสดงว่าเป็นค่าลบ
        String inverted = invertBits(binary);
        int value = Integer.parseInt(inverted, 2) + 1;
        return -value;
    }
    private String invertBits(String binary) {
        // เรียกใช้class StringBuilder เป็นแพ็กเกจที่มีการimportให้อัตโนมัติ
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            //ขั้นตอนการสลับบิต0เป็น1/1เป็น0
            if (binary.charAt(i) == '0') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        return result.toString();
    }
}
