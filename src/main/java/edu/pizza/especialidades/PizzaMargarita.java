package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaMargarita extends Pizza {
    private String salsa;
double precio=10.0;
    public PizzaMargarita(String name, String salsa,double precio, Topping... toppings){
        super(name,
precio,
         toppings);
        this.salsa=salsa;
        addTopping(new Topping("Queso", 1.0));
        addTopping(new Topping("Tomate", 7.0));
        addTopping(new Topping("Albahaca", 3.0));


    }
    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
}
