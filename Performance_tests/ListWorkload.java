import java.util.Random;

public class ListWorkload {
    private static org.python.types.List list1 = new org.python.types.List();
    private static org.python.types.List list2 = new org.python.types.List();

    private static void setUpLists() {
        Random rand = new Random();
        for (int i = 0; i < 2000; i++) {
            list1.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i + rand.nextInt(100)));
        }

        for (int i = 0; i < 2000; i++) {
            list2.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i + rand.nextInt(100)));
        }
    }

    public static void workLoad() {
        list1.sort(null, null);
        list2.sort(null, null);
        list1.__lt__(list2);
        list1.extend(list2);
        list1.sort(null, null);
        list1.reverse();
        list1.count(org.python.types.Int.getInt(50));

    }

    public static void main(String[] args) {
        setUpLists();
        workLoad();
    }

}
