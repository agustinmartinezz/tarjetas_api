package com.tarjetas.tarjetas.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPrincipal extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuPrincipal() {
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/com/tarjetas/tarjetas/img/appImage.png")));
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 410, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(175, 119, 234));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[20%][20%][20%][20%][20%]", "[16%][16%][16%][16%][16%][16%]"));

        JLabel lblTitulo = new JLabel("Menu Principal");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        contentPane.add(lblTitulo, "cell 2 0,alignx center,aligny center");

        JButton btnCompras = new JButton("Compras");
        btnCompras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    PantallaCompras frame = new PantallaCompras();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
            }
        });
        btnCompras.setForeground(new Color(0, 0, 0));
        btnCompras.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCompras.setFocusable(false);
        contentPane.add(btnCompras, "cell 2 2,alignx center,aligny center");

        JButton btnTotales = new JButton("Totales");
        btnTotales.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        btnTotales.setForeground(new Color(0, 0, 0));
        btnTotales.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnTotales.setFocusable(false);
        contentPane.add(btnTotales, "cell 2 3,alignx center,aligny center");

        JButton btnTiendas = new JButton("Tiendas");
        btnTiendas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getModifiersEx() == 16) {

                }
            }
        });
        btnTiendas.setForeground(new Color(0, 0, 0));
        btnTiendas.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnTiendas.setFocusable(false);
        contentPane.add(btnTiendas, "cell 2 4,alignx center,aligny center");
    }

}