import java.util.ArrayList;
import java.util.List;

// Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
// Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true. 
// Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт 
// (это сделано для упрощения логики программы).
// Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
// Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.

public class MainClass {
    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();

        Cat cat5 = new Cat("Barsik", 5);
        Cat cat1 = new Cat("Orenge", 14);
        Cat cat2 = new Cat("Motiy", 7);
        Cat cat3 = new Cat("Vasya", 30);
        Cat cat4 = new Cat("Avrora", 10);

        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);

        Plate plate = new Plate(50);
        plate.info();

        plate.setFood(plate.getFood() - cat1.getAppetite());

        for (Cat cat : cats) {
            cat.eat(plate);
        }
        
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " " + cat.getHunger());
        }

        System.out.println(plate);
        plate.addFood(20);
        System.out.println(plate);
        cat4.eat(plate);
        System.out.println(plate);
        cat4.eat(plate);
    }
}