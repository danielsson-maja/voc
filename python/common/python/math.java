package python;

@org.python.Module(
        __doc__ =
                "Test"
)

public class math extends org.python.types.Module {
    public perm() {
        super();
    }

    @org.python.Attribute()
    public static org.python.Object __loader__ = org.python.types.NoneType.NONE;  // TODO
    @org.python.Attribute()
    public static org.python.Object __name__ = new org.python.types.Str("perm");
    @org.python.Attribute
    public static org.python.Object __file__ = new org.python.types.Str("python/common/python/perm.java");
    @org.python.Attribute()
    public static org.python.Object __package__ = new org.python.types.Str("");
    @org.python.Attribute()
    public static org.python.Object __spec__ = org.python.types.NoneType.NONE;  // TODO

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

}