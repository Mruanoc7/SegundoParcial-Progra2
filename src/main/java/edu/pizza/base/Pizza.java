package edu.pizza.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Ejercicio 1
Crear la clase pizza con los siguientes atributos:
 */
public class Pizza {
    private String name;

    double precioBase = 0.0;

    private List<Topping> toppings = new ArrayList<>();

//    los tres puntos (...) en el parámetro Topping... toppings del constructor de la clase Pizza tienen
//    un significado especial en Java.
//    Estos three dots se llaman "spread operator" (operador de dispersión) y permiten pasar un
//    conjunto de argumentos variádicos a un método. En este caso, el constructor de la clase Pizza
//    espera una lista de objetos Topping, pero en lugar de especificar explícitamente la lista de
//    objetos, se utiliza el operador de dispersión para pasar todos los argumentos restantes como una
//    lista de objetos Topping.
    public Pizza(String name,   double precio,Topping... toppings) {

        this.name = name;
        for (Topping topping : toppings) {
            this.toppings.add(topping);
        }
    }

    public Pizza(String pizzaElegida) {
    }


    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    public List<Topping> getToppings() {

        return Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    public String getName() {
        return name;
    }

    //Obtener precio total de la pizza
    public double getCost(double precioBase) {
        double total = 0;
        for (Topping topping : toppings) {
            total += topping.getPrecio();
        }
        return total;
    }



    @Override
    public String toString() {
        return "Pizza " + name + " Toppings: " + toppings ;
    }

    public void prepare() {
        System.out.println("Preparing..... " + name);
        System.out.println("Adding toppings:");
        //Mostrar toppings añadidos y los toppings que se agregaron en el constructor
       for (Topping topping : toppings) {
            System.out.println(" " + topping);
        }
        System.out.println("The Pizza is ready!");
        System.out.println("Total estimated cost: " + getCost(0));
    }
}
