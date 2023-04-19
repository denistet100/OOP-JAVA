// Создать новый продукт на основе Product, сделать ему хотя одно свойства (например, шоколад и каллории) 
// и включить в список продуктов в вендинг машину.
// Продемонстрировать работу класса по продаже товаров (как мы это делали на уроке).
public class ChocolateBar extends Product {
    private int weight;
    private int bitterness;

    public int getWeight() {
        return weight;
    }

    public int getBitterness() {
        return bitterness;
    }

    public void setWeight(int weight) {
        if (weight < 0)
            this.weight = 10;
        else
            this.weight = weight;
    }

    public void setBitterness(int bitterness) {
        if (bitterness < 0 || bitterness > 100)
            this.bitterness = 15;
        else
            this.bitterness = bitterness;
    }


    /**
     * @param name
     * @param price
     */
    public ChocolateBar(String name, double price){
        this(name, price, 100, 15);
    }


    /**
     * @param name
     * @param price
     * @param weight
     * @param bitterness
     */
    public ChocolateBar(String name, double price, int weight, int bitterness){
        super(name, price);
        this.weight = weight;
        this.bitterness = bitterness;
    }


    @Override
    String displayInfo(){
        return String.format("Шоколадка %s - %s - %f - вес: %d, - горькость: %d", this.brand, this.name, this.price, this.weight, this.bitterness);
    }
}  

    

    

     

    


