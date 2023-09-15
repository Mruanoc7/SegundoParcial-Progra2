package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaChapina extends Pizza {
    private String salsa;
double precio=10.0;
    public PizzaChapina(String name, String salsa,double precio, Topping... toppings){
        super(name,
precio,
             toppings   );
        this.salsa=salsa;
        addTopping(new Topping("Queso", 1.0));
        addTopping(new Topping("Chorizo", 7.0));
        addTopping(new Topping("Frijoles", 3.0));

    }
    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
}
