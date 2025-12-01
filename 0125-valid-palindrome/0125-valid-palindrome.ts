function isPalindrome(s: string): boolean {
    const chars = s.split('').filter(char => /[a-zA-Z0-9]/.test(char))
    let left = 0, right = chars.length - 1;
    while (left < right) {
        if (chars[left].toLowerCase() !== chars[right].toLowerCase()) return false;
        left++;
        right--;
    }
    return true;
};