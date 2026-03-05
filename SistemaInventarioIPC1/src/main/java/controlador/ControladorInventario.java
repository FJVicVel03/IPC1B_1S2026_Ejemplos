package controlador;

import modelo.Inventario;
import modelo.Producto;
import vista.VistaInventario;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

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
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(vista, "Ingrese el código del producto:"));
            String nombre = JOptionPane.showInputDialog(vista, "Ingrese el nombre del producto:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog(vista, "Ingrese el precio del producto:"));
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(vista, "Ingrese la cantidad del producto:"));
            String detalle = JOptionPane.showInputDialog(vista, "Ingrese un detalle adicional del producto:");
            String tipo = JOptionPane.showInputDialog(vista, "Ingrese el tipo del producto (Camisa/Accesorio):");
            if(tipo.equalsIgnoreCase("Camisa"))
            {
                String talla = JOptionPane.showInputDialog(vista, "Ingrese la talla de la camisa:");
                inventario.agregarProductos("Camisa", codigo, nombre, precio, cantidad, detalle); // Agrega una camisa
            } else if(tipo.equalsIgnoreCase("Accesorio"))
            {
                String tipoAccesorio = JOptionPane.showInputDialog(vista, "Ingrese el tipo de accesorio:");
                inventario.agregarProductos("Accesorio", codigo, nombre, precio, cantidad, detalle); // Agrega un accesorio
            } else {
                JOptionPane.showMessageDialog(vista, "Tipo de producto no válido. Por favor ingrese 'Camisa' o 'Accesorio'.");
            }
        });

        vista.btnEliminarProducto.addActionListener((evento) -> {
            int codigoEliminar = Integer.parseInt(JOptionPane.showInputDialog(vista, "Ingrese el codigo del producto:"));
            try
            {
                for(int i = 0; i < inventario.getContadorProductos(); i++)
                {
                    if(inventario.getProductos()[i].getCodigo() == codigoEliminar)
                    {
                        // Desplazamos los productos restantes para eliminar el producto
                        for(int j = i; j < inventario.getContadorProductos() - 1; j++)
                        {
                            inventario.getProductos()[j] = inventario.getProductos()[j + 1];
                        }
                        inventario.getProductos()[inventario.getContadorProductos() - 1] = null; // Limpiamos la última posición
                        JOptionPane.showMessageDialog(vista, "Producto eliminado exitosamente.");
                        return;
                    }
                }
            } catch(ArrayIndexOutOfBoundsException ex)
            {
                JOptionPane.showMessageDialog(vista, "Error al eliminar el producto: " + ex.getMessage());
            }


        });

        vista.btnSalir.addActionListener((evento) -> {
            System.exit(0);
        });

        vista.btnBuscarProducto.addActionListener((evento) -> {
            String codigoStr = JOptionPane.showInputDialog(vista, "Ingrese el código del producto a buscar:");
            if(codigoStr != null) {
                try {
                    int codigo = Integer.parseInt(codigoStr);
                    Producto[] productos = inventario.getProductos();
                    boolean encontrado = false;
                    for(int i = 0; i < inventario.getContadorProductos(); i++) {
                        if(productos[i].getCodigo() == codigo) {
                            JOptionPane.showMessageDialog(vista, "Producto encontrado:\n" + productos[i].obtenerDetalles());
                            encontrado = true;
                            break;
                        } else if (productos[i] == null) {
                            break; // Si encontramos una posición nula, no hay más productos que revisar
                        }
                    }
                    if(!encontrado) {
                        JOptionPane.showMessageDialog(vista, "Producto no encontrado.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(vista, "Código inválido. Por favor ingrese un número.");
                } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(vista, "Error al buscar el producto: " + e.getMessage());
                }
            }
        });
        vista.btnGenerarReporte.addActionListener((evento) -> {
           StringBuilder reporte = new StringBuilder("Reporte:\n");
            try
            {
           Producto[] productos = inventario.getProductos();
              reporte = new StringBuilder("<html><body><h1>Reporte de Inventario</h1><ul>");
              for(int i = 0; i < inventario.getContadorProductos(); i++)              {
                  reporte.append("<li>").append(productos[i].obtenerDetalles()).append("</li>");
              }
              reporte.append("</ul></body></html>");
              String rutaArchivo = "reporte_inventario.html";

                    FileOutputStream fos = new FileOutputStream(new File(rutaArchivo));
                    fos.write(reporte.toString().getBytes());
                    fos.close();
                    JOptionPane.showMessageDialog(vista, "Reporte generado exitosamente en: " + rutaArchivo);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(vista, "Error al generar el reporte: " + e.getMessage());
              } catch (NullPointerException e) {
                    JOptionPane.showMessageDialog(vista, "Error al generar el reporte: " + e.getMessage());
            }
        });
    }
    public void iniciar() {
        vista.setVisible(true);
    }
}
