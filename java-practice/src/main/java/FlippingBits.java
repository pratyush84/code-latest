import java.math.MathContext;
import java.util.Arrays;

public class FlippingBits {
    public static void main(String[] args) {

        System.out.println(flippingBits(1));
    }

    static long flippingBits(long n) {
        long[] bitArr = convertToBinary(n);

        for (int i = 0; i < 32; i++) {
            if(bitArr[i] == 1){
                bitArr[i] = 0;
            } else{
                bitArr[i] = 1;
            }
        }

        return convertToDecimal(bitArr);
    }

    static long convertToDecimal(long[] arr){
        int len = arr.length;
        long sum = 0;
        for (int i = len-1; i >= 0 ; i--) {
            sum += arr[i] * Math.pow(2,len-1-i);
        }

        return sum;
    }
    static long[] convertToBinary(long num){
        long[] binary = new long[32];
        int index = 31;
        while(num > 0){
            binary[index--] = num%2;
            num = num/2;
        }
        return binary;
    }
}
