package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaItaliana extends Pizza {
    private String salsa;
    double precio=10.0;

    public PizzaItaliana(String name, String salsa,double precio, Topping... toppings) {
        super(name,precio, toppings); // Pasa los toppings proporcionados al constructor de la clase base
        this.salsa = salsa;
        addTopping(new Topping("Queso", 1.0));
        addTopping(new Topping("Jamon", 7.0));
        addTopping(new Topping("Pepperoni", 3.0));
    }

    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
}
