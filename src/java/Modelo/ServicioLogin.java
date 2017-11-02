/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Asus
 */
public class ServicioLogin {
    
    public static ServicioLogin instance = null;
    
    public static ServicioLogin instance() {

        if (instance == null) {
            instance = new ServicioLogin();
        }

        return instance;
    }
    
    public boolean autenticacion(String nombre, String clave) {

        boolean aut = false;
        
        Usuario usuario = buscarUsuarioPorNombre(nombre);
        if (usuario != null && usuario.getNombreUsuario().equals(nombre) && usuario.getClaveUsuario().equals(clave)) {
            aut = true;
        }
        
        return aut;
    }
    
    

    public Usuario buscarUsuarioPorNombre(String nombre) {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        Usuario usuario = null;
        
        try {
            tr = sesion.getTransaction();
            tr.begin();
            Query query = sesion.createQuery("from Usuario where nombreUsuario='" + nombre + "'");
            usuario = (Usuario) query.uniqueResult();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            sesion.close();
        }
        return usuario;
    }
    
    public List<Usuario> listaUsuarios() {
        
        List<Usuario> listaUsuarios = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        
        try {
            tr = session.getTransaction();
            tr.begin();
            listaUsuarios = session.createQuery("from Usuario").list();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return listaUsuarios;
    }
    
}
