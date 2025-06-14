class Solution {
    public int minMaxDifference(int num) {

        int x = num;

        int maxR = -1;
        int FirstDigit = 0;

        while (x != 0) {
            int rem = x % 10;
            x = (x - rem) / 10;
            // System.out.println(x + " , " + rem);
            FirstDigit = rem;
            if(rem == 9 && maxR != -1) continue;
            if (x == 0 && rem == 9) {
                continue;
            } else  {
                maxR = rem;
            }

        }

        int maxNumber = maximumN(num,maxR);
        int minNumber = minimumN(num,FirstDigit);
        // System.out.println("maxNumber,minNumber-> (" + maxNumber +" , "+minNumber +" )");

        return maxNumber - minNumber;
    }

    public int maximumN(int num, int maxR){
        String st = String.valueOf(num);
        st = st.replace((char)  (maxR + '0'), '9');
        // System.out.println("num-> " + num + " | maxR-> " + maxR + " | st->" + st);

        return Integer.parseInt(st);
    }
    public int minimumN(int num, int minR){
        String st = String.valueOf(num);
        String new1 = st.replace((char) (minR + '0'), '0');
        // System.out.println("num-> " + num + " | minR-> " + minR + " | st->" + st + " | new-> " + new1);

        return Integer.parseInt(new1);
    }
}