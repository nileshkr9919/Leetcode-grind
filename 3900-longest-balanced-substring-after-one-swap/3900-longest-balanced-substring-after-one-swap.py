from bisect import bisect_left
from collections import defaultdict


class Solution:
    def longestBalanced(self, s: str) -> int:
        n = len(s)
        # prefix count of zeros
        pref = [0] * (n + 1)
        for i, ch in enumerate(s):
            pref[i + 1] = pref[i] + (1 if ch == "0" else 0)
        Z = pref[n]  # total zeros

        # f[i] = 2 * zeros_in_prefix - i
        f = [2 * pref[i] - i for i in range(n + 1)]

        # group indices by f value
        groups = defaultdict(list)
        for i, val in enumerate(f):
            groups[val].append(i)

        ans = 0

        # case 1: already balanced (difference 0)
        for lst in groups.values():
            if len(lst) >= 2:
                ans = max(ans, lst[-1] - lst[0])

        # case 2: difference = +2  -> need one extra zero (z = k+1)
        bound = 2 * (n - Z)  # maximum L for which outside '1' exists
        for j in range(n + 1):
            target = f[j] - 2
            if target in groups:
                lst = groups[target]
                # need i >= j - bound  (since L = j-i <= bound)
                lo = j - bound
                if lo < 0:
                    lo = 0
                idx = bisect_left(lst, lo)
                if idx < len(lst) and lst[idx] < j:
                    L = j - lst[idx]
                    ans = max(ans, L)

        # case 3: difference = -2 -> need one extra one (z = k-1)
        bound = 2 * Z  # maximum L for which outside '0' exists
        for j in range(n + 1):
            target = f[j] + 2
            if target in groups:
                lst = groups[target]
                lo = j - bound
                if lo < 0:
                    lo = 0
                idx = bisect_left(lst, lo)
                if idx < len(lst) and lst[idx] < j:
                    L = j - lst[idx]
                    ans = max(ans, L)

        # whole string already balanced
        if 2 * Z == n:
            ans = max(ans, n)

        return ans
