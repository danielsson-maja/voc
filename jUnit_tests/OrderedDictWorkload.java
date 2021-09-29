import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OrderedDictWorkload {
    public static void main(String[] args) {


    }


    void InsertExample(){

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

        dict = new OrderedDict(args2, kwargs2);
        System.out.println(dict.__str__().toJava());
    }

    void DeleteExample() {
        org.python.Object[] args = { null };
        Map<String, org.python.Object> kwargs = new HashMap<String, org.python.Object>();
        kwargs.put("Three", Int.getInt(3));
        kwargs.put("Two", Int.getInt(2));
        kwargs.put("One", Int.getInt(1));

        kwargs.remove("One");
        OrderedDict od1 = new OrderedDict(args, kwargs);
        System.out.println(od1.__str__().toJava());
    }

}
