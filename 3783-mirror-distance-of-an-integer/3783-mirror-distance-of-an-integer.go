func mirrorDistance(n int) int {
	copy := n
	rev := 0

	for copy > 0 {
		rev = (rev * 10) + (copy % 10)
		copy = copy / 10
	}

	diff := rev - n
	if diff < 0 {
		diff = -diff
	}

	return diff
}