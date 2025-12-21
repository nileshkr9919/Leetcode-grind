function lengthOfLastWord(s: string): number {
    const words = s.trim().split(" ").filter(Boolean);

    return words[words.length - 1].length;
};