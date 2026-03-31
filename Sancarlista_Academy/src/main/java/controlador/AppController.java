package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import modelo.ListaSimple;
import modelo.Usuario;

public class AppController {
    private ListaSimple<Usuario> usuarios;
    private static final String ARCHIVO_DATOS = "datos.ser";


    public  AppController() {
        this.usuarios = new ListaSimple<>();
        cargarUsuarios();
        //Usuario Admin Inicial
        if(usuarios.size() == 0)
        {
            usuarios.agregar(new Usuario.Administrador("admin", "Admin", "IPC1B"));
        }
    }

    public void guardarDatos()
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS)))
        {
            oos.writeObject(usuarios);
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void cargarUsuarios() {
        File file = new File(ARCHIVO_DATOS);
        if(file.exists())
        {
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
            {
                usuarios = (ListaSimple<Usuario>) ois.readObject();
            }catch (Exception ex)
            {
                usuarios = new ListaSimple<>();
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public Usuario autenticar(String usuario, String password)
    {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario u = usuarios.obtener(i);
            //validación de código y contraseña
            if(u.getCodigo().equals(usuario) && u.getPassword().equals(password))
            {
                return u; //retorna el objeto usuario
            }
        }
        return null; //credenciales incorrectas
    }
}
