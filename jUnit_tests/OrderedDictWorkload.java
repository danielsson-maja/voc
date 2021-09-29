import org.junit.jupiter.api.Order;
import org.python.Object;
import org.python.stdlib.collections.OrderedDict;
import org.python.types.Dict;
import org.python.types.List;
import org.python.types.Str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderedDictWorkload {
    public static void main(String[] args) {

        workload1_update();

    }

    private static void workload1_update() {
        List tuple_list = new List();

        ArrayList<Object> tuple = new ArrayList<>(2);
        tuple.add(new Str("a"));
        tuple.add(org.python.types.Int.getInt(1L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        org.python.Object[] args2 = { tuple_list };
        HashMap<String, Object> kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();

        OrderedDict od = new OrderedDict(args2, kwargs2);

        org.python.Object[] args = { null };
        Map<String, Object> kwargs = new HashMap<String, Object>();
        Dict dict = new Dict(args, kwargs);
        od.update(null, dict);

        System.out.println(od);

    }


}
