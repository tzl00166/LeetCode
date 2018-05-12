class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ss = new ArrayList<>();
        for(int i : arr)
            ss.add(i);
        
        // a == b, same
        // abs(a - x) < abs(b - x), a is closer to x, so a is better
        // abs(a - x) > abs(b - x), b is closer to x, so b is better
        Collections.sort(ss, (a, b) -> a == b ? 0 : Math.abs(a - x) - Math.abs(b - x));
        ss = ss.subList(0, k);
        Collections.sort(ss);
        return ss;
    }
}