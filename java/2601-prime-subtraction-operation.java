class Solution {
    public boolean primeSubOperation(int[] nums) {
        int kMax = 1000;
        List<Integer> primes = sieveEratosthenes(kMax);
        
        int prev = 0;
        for (int num : nums) {
            int i = firstGreaterEqual(primes, num - prev);
            if (i > 0)
               num -= primes.get(i - 1);
            if (num <= prev)
               return false;
            prev = num;
        }
        return true;
    }
    private int firstGreaterEqual(List<Integer> A, int target) {
        final int i = Collections.binarySearch(A, target);
        return i < 0 ? -i - 1 : i;
    }
    private List<Integer> sieveEratosthenes(int n) {
        boolean[] isPrime = new boolean[n];
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < n; ++i) {
            if (isPrime[i])
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;
        }
        for (int i = 2; i < n; ++i) {
            if (isPrime[i])
                primes.add(i);
        }
        return primes;
    }
}