function maxPower(s: string): number {
    let maxLen = 1, len = 1;
    for (let i = 1; i < s.length; i++) {
        if (s[i] == s[i - 1]) {
            len++;
        } else {
            len = 1;
        }
        maxLen = Math.max(maxLen, len);
    }
    return maxLen;
};