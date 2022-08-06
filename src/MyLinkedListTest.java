public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>(1);

        list.add(0, 2);
        list.add(0, 2);
        list.add(0, 2);
        list.add(0, 2);
        list.add(0, 2);


        MyLinkedList<Integer> list2 = list.clone();

        list.remove(5);
        list.remove(2);
        System.out.println(list.size());
        System.out.println(list2.size());
    }
}