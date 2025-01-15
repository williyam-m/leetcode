class Solution {
    public int minimizeXor(int num1, int num2) {
        int num1_bitCount = Integer.bitCount(num1);
        int num2_bitCount = Integer.bitCount(num2);
        int[] bit = convertToBitArray(num1);

        int count = num2_bitCount - num1_bitCount;
        if (count < 0)
            removeLowBit(bit, Math.abs(count));
        else if (count > 0)
            addLowBit(bit, count);

        return ConvertBitArrayToNumber(bit);
    }
    private int ConvertBitArrayToNumber(int[] bit) {
        int num = 0;
        for (int i = 0; i < 32; ++i)
            num += bit[31 - i] * (1 << i);
        return num;
    }
    private void removeLowBit (int[] bit, int count) {
        for (int i = 31; i >= 0 && count > 0; --i) {
            if (bit[i] == 1) {
                bit[i] = 0;
                --count;
            }
        }
    }
    private void addLowBit (int[] bit, int count) {
        for (int i = 31; i >= 0 && count > 0; --i) {
            if (bit[i] == 0) {
                bit[i] = 1;
                --count;
            }
        }
    }
    private int[] convertToBitArray (int n) {
        int[] bit = new int[32];
        for (int i = 0; i < 32; ++i) {
            bit[31 - i] = (n >> i) & 1;
        }
        return bit;
    }
}