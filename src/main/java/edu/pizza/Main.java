package edu.pizza;


import edu.Formulario.frmPizza;
import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;
import edu.pizza.especialidades.PizzaItaliana;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("frmPizza");
        frame.setContentPane(new frmPizza().getJpanelPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200,720);
        frame.pack();
        frame.setVisible(true);
    }
}
