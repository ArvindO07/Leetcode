class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0;
        int n = s.length();

        int east = 0, west = 0, north = 0, south = 0;
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'N') { y++; north++; }
            else if (c == 'S') { y--; south++; }
            else if (c == 'E') { x++; east++; }
            else if (c == 'W') { x--; west++; }

            int currDist = Math.abs(x) + Math.abs(y);

            int vertMin = Math.min(north, south);
            int horiMin = Math.min(east, west);

            int gain = Math.min(k, vertMin + horiMin) * 2;
            maxi = Math.max(maxi, currDist + gain);
        }
        return maxi;
    }
}