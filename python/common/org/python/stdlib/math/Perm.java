package org.python.stdlib.math;

@org.python.Method(
    __doc__ = "Return the number of ways to choose k items from n items 
            without repetition and with order.",
    args = {"n", "k"}
)
public org.python.Object perm(org.python.Object n, org.python.Object k) {
    if type(n) != int {
        throw new TypeError("n must be an integer");
    }
    if (k == null) {
        k = org.python.types.Int.getInt(n);
    }
    if (n < 0 || k < 0) {
        throw new ValueError("Both arguments must be positive integers");
    }

    if (k <= n) {
            return fact(n)/fact(n-k);
        } else {
            return 0;
        }
}