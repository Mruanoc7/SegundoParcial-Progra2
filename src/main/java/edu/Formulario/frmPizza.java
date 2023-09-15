package edu.Formulario;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;
import edu.pizza.especialidades.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class frmPizza {
    private JPanel JpanelPrincipal;
    private JComboBox comboBoxTopping;

    private JButton btnAddIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JButton btnPreparar;
    private JComboBox ComboBoxPizza;
    private JRadioButton radioPequena;
    private JRadioButton radioMediana;
    private JRadioButton radioGrande;
    private JLabel lblTotalF;
    private JButton Reset;
    private JList lista2;


    private List<Topping> ingredientes = new ArrayList<>();
    private DefaultListModel modelolista = new DefaultListModel();

    private DefaultListModel modelolista2 = new DefaultListModel();
    public JPanel getJpanelPrincipal() {
        return JpanelPrincipal;
    }
    private double total = 0;

    private double totalF = 0;
    // Definir precios
    private double precioBase = 10.0;  // Precio base de la pizza
    private double porcentajeMediana = 0.20;  // Aumento del 20% para pizza mediana
    private double porcentajeGrande = 0.40;  // Aumento del 40% para pizza grande


    public frmPizza() {
        cargarToppings();
        cargarEspecialidades();





        btnAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingrediente = (Topping) comboBoxTopping.getSelectedItem();

                modelolista.addElement(ingrediente);
                lista1.setModel(modelolista);

                total += ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(total));


            }
        });
        btnPreparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //No se puede preparar sin ingredientes
                if (modelolista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se puede preparar sin ingredientes");
                    return;
                }
                //No se puede preparar sin seleccionar tamaño
                if (!radioPequena.isSelected() && !radioMediana.isSelected() && !radioGrande.isSelected()) {
                    JOptionPane.showMessageDialog(null, "No se puede preparar sin seleccionar tamaño");
                    return;
                }
                //No se puede preparar sin seleccionar especialidad
                if (ComboBoxPizza.getSelectedIndex() == -1) {
                    JOptionPane.showMessageDialog(null, "No se puede preparar sin seleccionar especialidad");
                    return;
                }
                //Obtener la especialidad seleccionada
                String especialidad = ComboBoxPizza.getSelectedItem().toString();
                //Obtener el tamaño seleccionado
                String tamano = "";
                if (radioPequena.isSelected()) {
                    tamano = radioPequena.getText();
                } else if (radioMediana.isSelected()) {
                    tamano = radioMediana.getText();
                } else if (radioGrande.isSelected()) {
                    tamano = radioGrande.getText();
                }

                //Obtener los ingredientes seleccionados
                List<Topping> ingredientes = new ArrayList<>();
                for (int i = 0; i < modelolista.size(); i++) {
                    ingredientes.add((Topping) modelolista.get(i));
                }
                //Obtener el precio de la pizza
                double precio = 0;
                if (tamano.equals("Pequeña")) {
                    precio = precioBase;
                } else if (tamano.equals("Mediana")) {
                    precio = precioBase + (precioBase * porcentajeMediana);
                } else if (tamano.equals("Grande")) {
                    precio = precioBase + (precioBase * porcentajeGrande);
                }
                //Obtener el precio total de la pizza
                double precioTotal = precio + total;
                //Obtener el precio final de la pizza
                double precioFinal = precioTotal;
                //Mostrar el precio final de la pizza
                lblTotalF.setText(String.valueOf(precioFinal));
                //Mandar nombre de la especialidad y toppings a lista2
                modelolista2.addElement(especialidad + " " + tamano);


                //Mostrar ingredientes ya establecidos en la clase de cada especialidad
                if (especialidad.equals("PizzaItaliana")) {
                    PizzaItaliana pizzaItaliana = new PizzaItaliana(especialidad, "Tomate", precio);
                    //Mostrar un timer de 5 segundos añaadiendo los ingredientes
                    modelolista2.addElement("Ingredientes predeterminados de la especialidad:");
                    List<Topping> ingredientesPredeterminados = pizzaItaliana.getToppings();
                    for (Topping ingredientePredeterminado : ingredientesPredeterminados) {
                        modelolista2.addElement("   " + ingredientePredeterminado.getNombre() + " - $" + ingredientePredeterminado.getPrecio());
                    }

                } else if (especialidad.equals("PizzaMargarita")) {
                    PizzaMargarita pizzaMargarita = new PizzaMargarita(especialidad, "Tomate", precio);
                    modelolista2.addElement("Ingredientes predeterminados de la especialidad:");
                    List<Topping> ingredientesPredeterminados = pizzaMargarita.getToppings();
                    for (Topping ingredientePredeterminado : ingredientesPredeterminados) {
                        modelolista2.addElement("   " + ingredientePredeterminado.getNombre() + " - $" + ingredientePredeterminado.getPrecio());
                    }
                } else if (especialidad.equals("PizzaChapina")) {
                    PizzaChapina pizzaChapina = new PizzaChapina(especialidad, "Tomate", precio);
                    modelolista2.addElement("Ingredientes predeterminados de la especialidad:");
                    List<Topping> ingredientesPredeterminados = pizzaChapina.getToppings();
                    for (Topping ingredientePredeterminado : ingredientesPredeterminados) {
                        modelolista2.addElement("   " + ingredientePredeterminado.getNombre() + " - $" + ingredientePredeterminado.getPrecio());
                    }
                } else if (especialidad.equals("PizzaTailandesa")) {
                    PizzaTailandesa pizzaTailandesa = new PizzaTailandesa(especialidad, "Tomate", precio);
                    modelolista2.addElement("Ingredientes predeterminados de la especialidad:");
                    List<Topping> ingredientesPredeterminados = pizzaTailandesa.getToppings();
                    for (Topping ingredientePredeterminado : ingredientesPredeterminados) {
                        modelolista2.addElement("   " + ingredientePredeterminado.getNombre() + " - $" + ingredientePredeterminado.getPrecio());
                    }
                } else if (especialidad.equals("PizzaJaponesa")) {
                    PizzaJaponesa pizzaJaponesa = new PizzaJaponesa(especialidad, "Tomate", precio);
                    modelolista2.addElement("Ingredientes predeterminados de la especialidad:");
                    List<Topping> ingredientesPredeterminados = pizzaJaponesa.getToppings();
                    for (Topping ingredientePredeterminado : ingredientesPredeterminados) {
                        modelolista2.addElement("   " + ingredientePredeterminado.getNombre() + " - $" + ingredientePredeterminado.getPrecio());
                    }
                } else if (especialidad.equals("YoLaArmo")) {
                    YoLaArmo yoLaArmo = new YoLaArmo(especialidad, "Tomate", precio);
                    modelolista2.addElement("Esta Pizza no tiene ingredientes predeterminados");


                }

                // Mostrar ingredientes adicionales como "Ingredientes extra"
                modelolista2.addElement("Ingredientes extra:");
                lista2.setModel(modelolista2);
                // Usar un temporizador para agregar ingredientes extra después de 1 segundo
                Timer timer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {

                        if (!ingredientes.isEmpty()) {
                            for (Topping ingredienteExtra : ingredientes) {

                                modelolista2.addElement("   " + ingredienteExtra.getNombre() + " - $" + ingredienteExtra.getPrecio());
                            }
                            lista2.setModel(modelolista2);
                        }
                    }
                });

                timer.setRepeats(false); // Para que el temporizador se ejecute solo una vez después de 2 segundo
                timer.start();

            }
        });
        //Resetear
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total = 0;

                modelolista.clear();
                modelolista.removeAllElements();
                lista1.removeAll();
                lista1.setModel(modelolista);
                lista2.removeAll();
                lista2.setModel(modelolista2);
                modelolista2.removeAllElements();
                lblTotal.setText("0.0");
                lblTotalF.setText("0.0");
                radioPequena.setSelected(false);
                radioMediana.setSelected(false);
                radioGrande.setSelected(false);

            }
        });
        lista1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedIndex = lista1.getSelectedIndex();
                    if (selectedIndex != -1) {
                        // Se ha hecho doble clic en un ingrediente
                        Topping selectedTopping = (Topping) modelolista.get(selectedIndex);
                        // Lógica para quitar el ingrediente
                        modelolista.remove(selectedIndex);
                        total -= selectedTopping.getPrecio();
                        lblTotal.setText(String.valueOf(total));
                    }
                }
                //Borrar lista2
                lista2.removeAll();
                modelolista2.removeAllElements();
            }
        });
        // Tamaño pequeño
        radioPequena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioPequena.isSelected()) {
                    radioMediana.setSelected(false);
                    radioGrande.setSelected(false);

                }
            }
        });

        // Tamaño mediano
        radioMediana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioMediana.isSelected()) {
                    radioPequena.setSelected(false);
                    radioGrande.setSelected(false);


                }
            }
        });

        // Tamaño grande
        radioGrande.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioGrande.isSelected()) {
                    radioPequena.setSelected(false);
                    radioMediana.setSelected(false);

                }
            }
        });



    }
//Cargar toppings establecidos
    private void cargarToppings(){
        ingredientes.add(new Topping("Champiñones", 1.5));
        ingredientes.add(new Topping("Mozzarella", 2.0));
        ingredientes.add(new Topping("Cebolla", 1.5));
        ingredientes.add(new Topping("Tomate", 1.25));
        ingredientes.add(new Topping("Pepperoni", 3.0));

        DefaultComboBoxModel modelT = new DefaultComboBoxModel(ingredientes.toArray());
        comboBoxTopping.setModel(modelT);



    }

    //Cargar especialidades
    private void cargarEspecialidades() {
        // Agrega las especialidades al ComboBox
        DefaultComboBoxModel modelEspecialidades = new DefaultComboBoxModel<>();

        // Agregar nombres de las especialidades al ComboBox
        modelEspecialidades.addElement(PizzaItaliana.class.getSimpleName());
        modelEspecialidades.addElement(PizzaMargarita.class.getSimpleName());
        modelEspecialidades.addElement(PizzaChapina.class.getSimpleName());
        modelEspecialidades.addElement(PizzaTailandesa.class.getSimpleName());
        modelEspecialidades.addElement(PizzaJaponesa.class.getSimpleName());
        modelEspecialidades.addElement(YoLaArmo.class.getSimpleName());


        // Establecer el modelo de las especialidades
        ComboBoxPizza.setModel(modelEspecialidades);
    }





}
