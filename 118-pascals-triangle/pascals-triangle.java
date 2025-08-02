class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);

        for(int i = 1; i< numRows; i++){
            System.out.println("| size-> " + ans.size());
            List<Integer> temp1 = ans.get(i-1);
            List<Integer> temp2 = new ArrayList<>();
            temp2.add(1);
            for(int j = 1; j < i ; j++){
                temp2.add(temp1.get(j-1) + temp1.get(j));
            }
            temp2.add(1);
            ans.add(temp2);
        }

        return ans;
    }
}