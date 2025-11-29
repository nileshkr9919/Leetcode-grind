function merge(intervals: number[][]): number[][] {
    if (intervals.length == 1) return intervals;
    intervals.sort((a, b) => (a[0] - b[0]));
    const res = [];
    console.log(intervals);
    let current = intervals[0];
    for (let i = 1; i < intervals.length; i++) {
        const [start, end] = intervals[i];
        if (current[1] < start) {
            res.push(current);
            current = intervals[i];
        } else {
            current[1] = Math.max(end, current[1]);
        }
    }
    res.push(current);
    return res;
};