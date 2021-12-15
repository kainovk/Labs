package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("MyList<Integer>");

        MyList<Integer> list = new MyList<>();

        list.pushFront(3);
        list.pushFront(2);
        if(!list.insert(-1, 45)) {
            System.out.println("Неверный индекс");
        }
        list.pushFront(1);
        list.display();

        list.delete(2);
        list.display();

        list.delete(1);
        list.display();

        list.delete(3);
        list.display();

        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushBack(4);
        list.display();

        list.delete(4);
        list.delete(1);
        list.display();

        //
        System.out.println("\n\n");
        System.out.println("MyList<String>");

        MyList<String> strList = new MyList<>();

        strList.pushFront("3");
        strList.pushFront("2");
        strList.pushFront("1");
        strList.display();

        strList.delete("2");
        strList.display();

        strList.delete("1");
        strList.display();

        strList.delete("3");
        strList.display();

        strList.pushBack("1");
        strList.pushBack("2");
        strList.pushBack("3");
        strList.pushBack("4");
        strList.display();

        strList.delete("4");
        strList.delete("1");
        strList.display();
    }
}
