
import org.junit.jupiter.api.Order;
import org.python.Object;
import org.python.stdlib.collections.OrderedDict;
import org.python.types.Dict;
import org.python.types.List;
import org.python.types.Str;
import org.python.types.Int;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// Improvements?
// - change linkedhashmap to be a linkedmap instead? Can iterate the elements in both directions but will probably use more space
// - move_to_end: create a check to see if the item to be moved to the beginning already is there?... will in most cases not be there so it will probably only add time for checking this...
// - keys(): instead of calling superclasses and creating a...

public class OrderedDictWorkload {
    public static void main(String[] args) {

        OrderedDict od = createOrderedDict();

        for (int i =0; i <60000; i++) {
            updateExample();
            InsertExample();
            move_to_endExample();
            DeleteExample();
            od.__reversed__();
            od.keys();
            od.values();
            od.copy();
        }

    }

    private static void updateExample() {
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

        //System.out.println(od);

    }


    static void InsertExample(){

        List tuple_list = new List();

        ArrayList<org.python.Object> tuple = new ArrayList<>(2);
        tuple.add(new Str("One"));
        tuple.add(org.python.types.Int.getInt(1L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Two"));
        tuple.add(org.python.types.Int.getInt(2L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Three"));
        tuple.add(org.python.types.Int.getInt(3L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Four"));
        tuple.add(org.python.types.Int.getInt(4L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Five"));
        tuple.add(org.python.types.Int.getInt(5L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Six"));
        tuple.add(org.python.types.Int.getInt(6L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Seven"));
        tuple.add(org.python.types.Int.getInt(7L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Eight"));
        tuple.add(org.python.types.Int.getInt(8L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        ArrayList<org.python.Object> list = new ArrayList<>(2);
        list.add(new Str("Nine"));
        list.add(org.python.types.Int.getInt(9L));
        tuple_list.append(new org.python.types.List(list));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Ten"));
        tuple.add(org.python.types.Int.getInt(10L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        org.python.Object[] args2 = { tuple_list };
        HashMap<String, Object> kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();

        OrderedDict dict = new OrderedDict(args2, kwargs2);
        //System.out.println(dict.__str__().toJava());
    }

    private static OrderedDict createOrderedDict() {

        List tuple_list = new List();

        ArrayList<org.python.Object> tuple = new ArrayList<>(2);
        tuple.add(new Str("One"));
        tuple.add(org.python.types.Int.getInt(1L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Two"));
        tuple.add(org.python.types.Int.getInt(2L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Three"));
        tuple.add(org.python.types.Int.getInt(3L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Four"));
        tuple.add(org.python.types.Int.getInt(4L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Five"));
        tuple.add(org.python.types.Int.getInt(5L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Six"));
        tuple.add(org.python.types.Int.getInt(6L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Seven"));
        tuple.add(org.python.types.Int.getInt(7L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Eight"));
        tuple.add(org.python.types.Int.getInt(8L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        ArrayList<org.python.Object> list = new ArrayList<>(2);
        list.add(new Str("Nine"));
        list.add(org.python.types.Int.getInt(9L));
        tuple_list.append(new org.python.types.List(list));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("Ten"));
        tuple.add(org.python.types.Int.getInt(10L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        org.python.Object[] args2 = {tuple_list};
        HashMap<String, Object> kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();

        OrderedDict dict = new OrderedDict(args2, kwargs2);
        return dict;
    }

    private static void DeleteExample() {
        org.python.Object[] args = { null };
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("Three", Int.getInt(3));
        kwargs.put("Two", Int.getInt(2));
        kwargs.put("One", Int.getInt(1));

        kwargs.remove("One");
        OrderedDict od1 = new OrderedDict(args, kwargs);
        //System.out.println(od1.__str__().toJava());
    }

    private static void move_to_endExample() {
        List tuple_list = new List();

        ArrayList<Object> tuple = new ArrayList<>(2);
        tuple.add(new Str("a"));
        tuple.add(org.python.types.Int.getInt(1L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("aa"));
        tuple.add(org.python.types.Int.getInt(11L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("bb"));
        tuple.add(org.python.types.Int.getInt(22L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        tuple = new ArrayList<>(2);
        tuple.add(new Str("cc"));
        tuple.add(org.python.types.Int.getInt(33L));
        tuple_list.append(new org.python.types.Tuple(tuple));

        org.python.Object[] args2 = { tuple_list };
        HashMap<String, Object> kwargs2 = new java.util.HashMap<java.lang.String, org.python.Object>();

        OrderedDict od = new OrderedDict(args2, kwargs2);

        //System.out.println(od);
        od.move_to_end(new Str("bb"), null);
        //System.out.println(od);
        od.move_to_end(new Str("bb"), org.python.types.Bool.FALSE);
        //System.out.println(od);
        od.move_to_end(new Str("bb"), org.python.types.Bool.TRUE);
        //System.out.println(od);

    }


}
