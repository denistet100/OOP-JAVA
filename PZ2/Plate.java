public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public int getFood() {
        return this.food;
    }

    public void setFood(int food) {
        if (food  > 0) {
            this.food = food;
        }
    }

    public void addFood(int food) {
        if (food  > 0) {
            this.food += food;
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("В миске %d корма", this.food);
    }

}