class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0, absLateCount = 0;

        for(char ch: s.toCharArray()) {
            if(ch == 'A') absentCount++;
        }

        return absentCount < 2 && s.indexOf("LLL") == -1;
    }
}