/**
     Домашняя работа, задача:
     ========================

     * a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
     
     *b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
     *поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

     *c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     * d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
     * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     
     *e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
     *подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
     *Можно сравнивать коробки с яблоками и апельсинами;

     f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;


     *g. Не забываем про метод добавления фрукта в коробку.
 */
import java.util.ArrayList;
public class Homework {
    public static void main(String[] args) {
        Box<Apple> boxOfApples1 = new Box<>();
        Box<Apple> boxOfApples2 = new Box<>();
        Box<Orange> boxOfOranges = new Box<>();

        boxOfApples1.addFruit(new Apple());
        boxOfApples1.addFruit(new Apple());
        boxOfOranges.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками 1: " + boxOfApples1.getWeight());
        System.out.println("Вес коробки с яблоками 2: " + boxOfApples2.getWeight());
        System.out.println("Вес коробки с апельсинами: " + boxOfOranges.getWeight());
    }
}

abstract class Fruit{

    private final float weight;

    public float getWeight() {
        return weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}


class Apple extends Fruit{
    public Apple() {
        super(1.0f);
    }
}

class Orange extends Fruit{
    public Orange() {
        super(1.5f);
    }
}


// class Box<T extends Fruit> implements Comparable<Box<? extends Fruit>>{
class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    // public Box() {
    //     fruits = new ArrayList<T>();
    // }

    public void addFruit(T fruitT){
        fruits.add(fruitT);
    }

    public float getWeight(){
        float weight = 0.0f;
        if (fruits.size() == 0) {
            return weight;
        }
        // for (T item : fruits) {weight += item.getWeight();}
        weight = fruits.get(0).getWeight() * fruits.size();
        return weight;
    }

    public pourInto(Box<T> otherBox){
        if (this == otherBox) {
            System.out.println("Нельзя пересыпать фрукты в ту же коробку");
            return;
        }
        if (fruits.size() == 0) {
            return;
        }
        if (otherBox.fruits.size() > 0 && !otherBox.fruits.get(0).getClass().equals(fruits.get(0).getClass())) {
            System.out.println("Нельзя пересыпать яблоки в коробку с апельсинами и наоборот");
            return;
        }
        otherBox.fruits.addAll(fruits);
        fruits.clear();
    }

    @Override
    public boolean compare(Box<? extends Fruit> o) {        
        return o.getWeight() == this.getWeight() ? true : (o.getWeight() > this.getWeight() ? false : false);
    }
}

