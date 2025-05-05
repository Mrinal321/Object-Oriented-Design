import java.util.ArrayList;
import java.util.List;

interface Item{
    public String name();
    public Packing packing();
    public float prize();
}

interface Packing{
    public String pack();
}

class Wrapper implements Packing{
    public String pack(){
        return "Wrapper";
    }
}
class Bottle implements Packing{
    public String pack(){
        return "Bottle";
    }
}

abstract class Burger implements Item{
    public Packing packing(){
        return new Wrapper();
    }

    public abstract float prize();
}
abstract class ColdDrink implements Item{
    public Packing packing(){
        return new Bottle();
    }

    public abstract float prize();
}

class VegBurger extends Burger {
    public float prize() {
        return 25.0f;
    }

    public String name() {
        return "Veg Burger";
    }
}

class ChickenBurger extends Burger {
    public float prize() {
        return 50.5f;
    }

    public String name() {
        return "Chicken Burger";
    }
}

class Coke extends ColdDrink {
    public float prize() {
        return 30.0f;
    }

    public String name() {
        return "Coke";
    }
}

class Pepsi extends ColdDrink {
    public float prize() {
        return 35.0f;
    }

    public String name() {
        return "Pepsi";
    }
}


class Meal{
    public List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for(Item item : items){
            cost += item.prize();
        }
        return cost;
    }

    public void showItems(){
        for(Item item : items){
            System.out.print("Item: " + item.name());
            System.out.print(", Packing: " + item.packing().pack());
            System.out.println(", Price: " + item.prize());
        }
    }
}

class MealBuilder{
    public Meal preparrVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
}

public class BuilderPatternDemo{
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.preparrVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total cost: " + vegMeal.getCost());
    }
}