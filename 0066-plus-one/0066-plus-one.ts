function plusOne(digits: number[]): number[] {
    let index = digits.length - 1;

    while(index >= 0) {
        digits[index]++;

        if(digits[index] === 10) {
            digits[index] = 0;
        } else {
            break;
        }

        index--;
    }

    if(digits[0] === 0) digits.unshift(1);

    return digits;
};