class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> hm = new HashMap<>();
            for(int j = 0; j < strs[i].length(); j++) {
                hm.put(strs[i].charAt(j), hm.getOrDefault(strs[i].charAt(j), 0) + 1);
            }

            if(!map.containsKey(hm)) {
                map.put(hm, new ArrayList<>());
            }

            map.get(hm).add(strs[i]);
        }

        List<List<String>> list = new ArrayList<>();
        Set<HashMap<Character, Integer>> keys = map.keySet();

        for(HashMap<Character, Integer> key: keys) {
            list.add(map.get(key));
        }

        return list;
    }
}