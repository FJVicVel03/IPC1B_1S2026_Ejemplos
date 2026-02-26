package controlador;

import modelo.Inventario;
import modelo.Producto;
import vista.VistaInventario;

import javax.swing.*;

public class ControladorInventario {

    private VistaInventario vista;
    private Inventario inventario;

    public ControladorInventario(VistaInventario vista, Inventario inventario) {
        this.vista = vista;
        this.inventario = inventario;
        //Inicializamos lis listeners de los botones
        inicializarEventos();
    }

    private void inicializarEventos()
    {
        vista.btnAgregarProducto.addActionListener((evento) -> {
            boolean exito = inventario.agregarProductos(inventario.getContadorProductos());
            if(exito)
            {
                JOptionPane.showMessageDialog(vista, "Inventario agregado exitosamente");
            } else {
                JOptionPane.showMessageDialog(vista, "No se pudo agregar el producto. Inventario lleno.");
            }
        });

        vista.btnEliminarProducto.addActionListener((evento) -> {
            if(inventario.getContadorProductos() == 0)
            {
                JOptionPane.showMessageDialog(vista, "No hay productos para eliminar.");
            }

            StringBuilder reporte = new StringBuilder("Productos en Inventario:\n");
            Producto[] productos = inventario.getProductos();

            for(int i = 0; i < inventario.getContadorProductos(); i++)
            {
                reporte.append(productos[i].obtenerDetalles()).append("\n");
            }
            JOptionPane.showMessageDialog(vista, reporte.toString());

        });

        vista.btnSalir.addActionListener((evento) -> {
            System.exit(0);
        });
    }
    public void iniciar() {
        vista.setVisible(true);
    }
}
