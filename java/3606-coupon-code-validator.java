class Solution {
    private static String[] businessLineConstants = {"electronics", "grocery", "pharmacy", "restaurant"};

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> ans = new ArrayList<>();
        HashMap<String, List<String>> valid = new HashMap<>();

        for (String businessLineConstant : businessLineConstants) {
            valid.put(businessLineConstant, new ArrayList<>());
        }

        for (int i = 0; i < code.length; ++i) {
            if (isActive[i] && isValid(code[i]) && check(businessLine[i])) {
                valid.get(businessLine[i]).add(code[i]);
            }
        }

        for (String businessLineConstant : businessLineConstants) {
            Collections.sort(valid.get(businessLineConstant));
            ans.addAll(valid.get(businessLineConstant));
        }
        return ans;
    }
    private boolean isValid (String str) {
        return !str.isEmpty() && str.matches("^[a-zA-Z0-9_]+$");
    }
    private boolean check (String str) {
        for (String businessLineConstant : businessLineConstants) {
            if (str.equals(businessLineConstant)) {
                return true;
            }
        }
        return false;
    }
}