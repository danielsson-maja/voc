package profiling;

import org.python.exceptions.AttributeError;
import org.python.exceptions.KeyError;
import org.python.exceptions.TypeError;
import org.python.types.*;
import org.python.types.List;
import org.python.types.Object;
import org.python.types.Set;

import java.util.*;
import java.util.ArrayList;
import java.util.Map;

public class DictWorkload {

    public static void main(String[] args) {
        Map<org.python.Object, org.python.Object> dict_map = new HashMap<>();
        dict_map.put(new Str("a"), Int.getInt(1));
        dict_map.put(new Str("b"), Int.getInt(2));
        Dict dict = new Dict(dict_map);
        System.out.println(dict.__repr__().toString());
    }
}
