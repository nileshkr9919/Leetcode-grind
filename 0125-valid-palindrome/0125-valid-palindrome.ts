function isAlphaNum(c: string): boolean {
    const code = c.charCodeAt(0);
    return (
        (code >= 48 && code <= 57) ||   // 0-9
        (code >= 65 && code <= 90) ||   // A-Z
        (code >= 97 && code <= 122)     // a-z
    );
}

function isPalindrome(s: string): boolean {
    let left = 0, right = s.length - 1;

    while (left < right) {
        while (left < right && !isAlphaNum(s[left])) left++;
        while (left < right && !isAlphaNum(s[right])) right--;

        if (s[left].toLowerCase() !== s[right].toLowerCase()) return false;

        left++;
        right--;
    }

    return true;
}
