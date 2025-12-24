function minimumBoxes(apple: number[], capacity: number[]): number {
    capacity.sort((a, b) => b - a);

    let totalApples = 0;

    apple.forEach(item => totalApples += item);

    let res = 0, index = 0;
    while (totalApples > 0) {
        totalApples -= capacity[index++];
        res++;
    }

    return res;
};