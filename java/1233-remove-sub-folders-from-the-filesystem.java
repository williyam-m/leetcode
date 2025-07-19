class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        String last_root = folder[0] + "/";
        for (int i = 1; i < folder.length; ++i) {
            if (folder[i].startsWith(last_root)) {
                continue;
            }
            ans.add(folder[i]);
            last_root = folder[i] + "/";
        }
        return ans;
    }
}