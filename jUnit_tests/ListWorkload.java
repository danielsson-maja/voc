import java.util.Random;

public class ListWorkload {
    private static org.python.types.List list1 = new org.python.types.List();
    private static org.python.types.List list2 = new org.python.types.List();

    private static void setUpLists() {
        Random rand = new Random();
        for (int i = 0; i < 100000; i++) {
            list1.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i + rand.nextInt(100)));
        }

        for (int i = 0; i < 100000; i++) {
            list2.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(i + rand.nextInt(100)));
        }
    }

    public static void workLoad() {
        /*
        org.python.types.Int list2Lenght = list2.__len__();
        for (int i = 0; i < list2Lenght.value; i++) {
            list.__mul__(list2.__getitem__(org.python.types.Int.getInt(i)));
        }*/

        org.python.types.List resultList = new org.python.types.List();
        org.python.types.Int list1Lenght = list1.__len__();
        for (int i = 0; i < list1Lenght.value; i++) {
            org.python.Object list1Obj = list1.__getitem__(org.python.types.Int.getInt(i));
            org.python.Object list2Obj = list2.__getitem__(org.python.types.Int.getInt(i));

            org.python.types.Int list1Int = (org.python.types.Int) list1Obj;
            org.python.types.Int list2Int = (org.python.types.Int) list2Obj;

            resultList.insert(org.python.types.Int.getInt(i), org.python.types.Int.getInt(list1Int.value * list2Int.value));
        }

        list1.sort(null, null);
        list2.sort(null, null);
        list1.__lt__(list2);
        list1.extend(list2);
        list1.reverse();
        list1.count(org.python.types.Int.getInt(50));

    }

    public static void main(String[] args) {
        System.out.println("Hejj");
        setUpLists();
        workLoad();
        System.out.println("Då");
    }

}
