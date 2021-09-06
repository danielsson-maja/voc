import static java.lang.Math.floor;
@org.python.Method(
    _doc_ = "Return floor of the input",
    args = ("num")
)

public org.python.Object inc(org.python.Object num) {
    if (num == null) {
        System.out.print("Error, number is null");
    }else {
        return Math.floor(num);
    }
}