/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t3;

/**
 *
 * @author user
 */
    import javax.swing.*;
    import java.awt.event.*;
    import java.util.ArrayList;

    public class GestionLibros extends JFrame {
        private JTextField txtCodigo, txtTitulo, txtAutor, txtCantidad;
        private JButton btnGuardar, btnListar;
        private JTextArea areaLibros;
        private ArrayList<Libro> listaLibros;

    public GestionLibros() {
        setTitle("Gestión de Libros");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 100, 25);
        add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(150, 20, 200, 25);
        add(txtCodigo);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 60, 100, 25);
        add(lblTitulo);

        txtTitulo = new JTextField();
        txtTitulo.setBounds(150, 60, 200, 25);
        add(txtTitulo);

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setBounds(20, 100, 100, 25);
        add(lblAutor);

        txtAutor = new JTextField();
        txtAutor.setBounds(150, 100, 200, 25);
        add(txtAutor);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(20, 140, 100, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(150, 140, 200, 25);
        add(txtCantidad);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(20, 180, 150, 25);
        add(btnGuardar);

        btnListar = new JButton("Listar");
        btnListar.setBounds(200, 180, 150, 25);
        add(btnListar);

        areaLibros = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaLibros);
        scroll.setBounds(20, 220, 330, 120);
        add(scroll);

        listaLibros = new ArrayList<>();

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                int cantidad = Integer.parseInt(txtCantidad.getText());
                listaLibros.add(new Libro(codigo, titulo, autor, cantidad));
                JOptionPane.showMessageDialog(null, "Libro guardado correctamente.");
                limpiarCampos();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                areaLibros.setText("");
                for (Libro libro : listaLibros) {
                    areaLibros.append("Código: " + libro.getCodigo() + ", Título: " + libro.getTitulo() + 
                                      ", Autor: " + libro.getAutor() + ", Cantidad: " + libro.getCantidad() + "\n");
                }
            }
        });
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtCantidad.setText("");
    }

    public static void main(String[] args) {
        new GestionLibros().setVisible(true);
    }  
}
