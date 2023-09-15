package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class YoLaArmo extends Pizza {
    private String salsa;
    double precio=10.0;
//Esta es la pizza por default que se llame “yo la armo”, esto quiere decir que no tendrá
//ingredientes predeterminados, y el usuario deberá de seleccionar sus
//ingredientes.
    public YoLaArmo(String name, String salsa, double precio, Topping... toppings){
        super(name,
precio,
                toppings);
        this.salsa=salsa;

    }
    public String getSalsa() {
        return salsa;
    }

    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }


}
