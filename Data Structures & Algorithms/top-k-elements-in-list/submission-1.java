class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>(); //new hash map
        List<Integer>[] freq = new List[nums.length + 1]; //freq buckets created

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>(); //adds arraylist in every index in freq List
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1); //counts frequency of chars ex: 1: 0, 2: 1
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey()); //sorts the count to freq buckets 
        }

        int[] res = new int[k]; //new result array
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) { //loop starts at the largest freq and moves downward as long i is between 0 and k
            for (int n : freq[i]) { 
                res[index++] = n; //every number in current is added to res
                if (index == k) {
                    return res; //stops when index mets k
                }
            }
        }
        return res;
    }
}
