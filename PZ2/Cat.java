public class Cat {
    private String name;
    private int appetite;
    private boolean hunger;

    public Cat(String name, int appetite) {
        this.name = name;
        if (appetite > 0) {
            this.appetite = appetite;
        }else{
            this.appetite = 5;
        }
        this.hunger = true;
    }

    public void eat(Plate plate) { 
        if (plate.getFood() > 0 && plate.getFood() > this.appetite){
            plate.setFood(plate.getFood() - this.appetite);
            this.hunger = false;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getAppetite() {
        return this.appetite;
    }

    public boolean getHunger() {
        return this.hunger;
    }

    public int Appetite() {
        return this.appetite;
    }

    String displayInfo(){
        return String.format("Кличка %s аппетит %d голод %b", this.name, this.appetite, this.hunger);
    }

    @Override
    public String toString() {
        return String.format("Кличка %s аппетит %d голод %b", this.name, this.appetite, this.hunger);
    }

}