class Solution {
    public String majorityFrequencyGroup(String s) {
        int ans = 0;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }

        Map<Integer, StringBuilder> map = new HashMap<>();
        int length = 0;
        for (int i = 0; i < 26; ++i) {
            int k = count[i];
            if (k == 0) {
                continue;
            }

            if (!map.containsKey(k)) {
                map.put(k, new StringBuilder());
            }
            map.get(k).append((char) (i + 'a'));

            int currLength = map.get(k).length();
            if (length < currLength) {
                ans = k;
                length = currLength;
            }
            else if (length == currLength) {
                ans = Math.max(ans, k);
            }
        }

        return map.get(ans).toString();
    }
}
/*
class Solution {
    public String majorityFrequencyGroup(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            ++count[c - 'a'];
        }

        Map<Integer, StringBuilder> map = new HashMap<>();
        int length = 0;
        for (int i = 0; i < 26; ++i) {
            int k = count[i];
            if (k == 0) {
                continue;
            }
            if (!map.containsKey(k)) {
                map.put(k, new StringBuilder());
            }
            map.get(k).append((char) (i + 'a'));
            length = Math.max(length, map.get(k).length());
        }

        int ans = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key).length() == length) {
                ans = Math.max(ans, key);
            }
        }
        return map.get(ans).toString();
    }
}
*/