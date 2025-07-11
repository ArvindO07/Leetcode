class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        long[] lastAvlblAt = new long[n];
        int[] roomCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;
            boolean found = false;

            for (int room = 0; room < n; room++) {

                if (lastAvlblAt[room] <= start) { 
                    lastAvlblAt[room] = end;
                    roomCount[room]++;
                    found = true;
                    break; 
                }


                if (lastAvlblAt[room] < earlyEndRoomTime) {
                    earlyEndRoomTime = lastAvlblAt[room]; 
                    earlyEndRoom = room; 
                }

            }

            if (!found) {
                lastAvlblAt[earlyEndRoom] += duration;

                roomCount[earlyEndRoom]++; 
            }

        }

        int resultRoom = -1;
        int maxUse = 0;

        for (int room = 0; room < n; room++) {
            if (roomCount[room] > maxUse) {
                maxUse = roomCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}