class ProductOfNumbers {
    List<Integer> products;
    private void init() {
        products = new ArrayList<>();
    }
    public ProductOfNumbers() {
        init();
    }
    
    public void add(int num) {
        if (num == 0) {
            init();
        }
        else if (products.isEmpty()) {
            products.add(num);
        }
        else {
            products.add(products.get(products.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = products.size();
        if (size == k) {
            return products.get(size - 1);
        }
        else if (size < k) {
            return 0;
        }
        return products.get(size - 1) / products.get(size - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */