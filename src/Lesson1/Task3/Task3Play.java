package Lesson1.Task3;

public class Task3Play {
    public static void main(String[] args) {
        //Создаем фрукты каждого вида
        Fruit countApple = new Apple(10);   //10 штук
        Fruit countOrange = new Orange(8);  //8 штук

        //Создаем пустые коробки каждого вида
        Box boxApple = new Box("AppleOnly", "Apple");
        Box boxOrange = new Box("OrangeOnly", "Orange");

        //Добавляем в коробки фрукты
        boxApple.setCount(countApple.getCount());
        boxOrange.setCount(countOrange.getCount());

        //Получаем вес коробок
        float weightBoxApple = boxApple.getWeight();
        float weightBoxOrange = boxOrange.getWeight();

        System.out.println("Вес коробки с яблоками: " + weightBoxApple);
        System.out.println("Вес коробки с апельсинами: " + weightBoxOrange);

        //Сравниваем коробки по весу
        System.out.println(boxApple.compare(boxOrange));

        //Создаем еще пустые коробки каждого вида для пересыпания
        Box secondBoxApple = new Box("SecondAppleOnly", "Apple");
        Box secondBoxOrange = new Box("SecondOrangeOnly", "Orange");

        boxApple.throwFruit(secondBoxApple);    //Перемещение аблок
        boxApple.throwFruit(secondBoxOrange);   //Пример неверного перемещения
        boxOrange.throwFruit(secondBoxOrange);  //Перемещение апельсинов
    }
}
