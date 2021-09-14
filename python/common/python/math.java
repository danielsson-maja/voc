package python;

@org.python.Module(
        __doc__ =
                "This module provides access to the mathematical functions defined by the C standard. " +
                "These functions cannot be used with complex numbers; use the functions of " +
                "the same name from the cmath module if you require support for complex " +
                "numbers. The distinction between functions which support complex " +
                "numbers and those which don’t is made since most users do not want to " +
                "learn quite as much mathematics as required to understand complex " +
                "numbers. Receiving an exception instead of a complex result allows earlier " +
                "detection of the unexpected complex number used as a parameter, so that " +
                "the programmer can determine how and why it was generated in the first place. " 
)

public class math extends org.python.types.Module {

    @org.python.Method(
            name = "prod",
            __doc__ = "Calculate the product of all the elements in the input iterable. " +
                        "The default start value for the product is 1. " +
                        "When the iterable is empty, return the start value. " +
                        "This function is intended specifically for use with numeric values " +
                        "and may reject non-numeric types.",
            args = {"iterable"},
            default_args = {"start"}
    )
    public static org.python.Object prod(org.python.Object iterable, org.python.Object start) {
        org.python.Object product;
        if (start != null) {
            product = start; 
        } else {
            product = org.python.types.Int.getInt(1);
        }

        org.python.Object iterator = org.Python.iter(iterable);
        while (true) {
            org.python.Object next;
            try {
                next = iterator.__next__();
            } catch (org.python.exceptions.StopIteration si) {
                break;
            }
            product = product.__mul__(next);
        }

        return product;
    }

    @org.python.Method(
        __doc__  = "Return floor of the input"
    )

    public static org.python.Object floor(org.python.Object value) {
        org.python.Object result;
        if (value!=null) {
            result = floor(value);
        } else {
            result = org.python.types.Int.getInt(1);
        }


        return result;
    }
}

