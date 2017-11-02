/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Asus
 */
public class ServicioRegistro {

    public static ServicioRegistro instance = null;
    
    public static ServicioRegistro instance() {

        if (instance == null) {
            instance = new ServicioRegistro();
        }

        return instance;
    }
    
    public boolean registrar(Usuario usuario) {

        boolean reg = false;

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        if (existeUsuario(usuario)) {
            reg = false;
        }

        Transaction tr = null;
        try {
            if (!usuario.getNombreUsuario().isEmpty() && !usuario.getClaveUsuario().isEmpty()) {
                tr = sesion.getTransaction();
                tr.begin();
                sesion.saveOrUpdate(usuario);
                tr.commit();
                reg = true;
            }

        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            sesion.close();
        }
        return reg;
    }
    
    public void eliminarUsuario(Usuario usuario){

        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Transaction tr = null;
        try {
            if (!usuario.getNombreUsuario().isEmpty() && !usuario.getClaveUsuario().isEmpty()) {
                tr = sesion.getTransaction();
                tr.begin();
                sesion.delete(usuario);
                tr.commit();
            }

        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            ex.printStackTrace();
        } finally {
            sesion.close();
        }
        
    }

    public boolean existeUsuario(Usuario usuario) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean resultado = false;
        Transaction tr = null;

        try {
            tr = session.getTransaction();
            tr.begin();
            Query query = session.createQuery("from Usuario where nombreUsuario='" + usuario.getNombreUsuario() + "'");
            Usuario u = (Usuario) query.uniqueResult();
            tr.commit();
            if (u != null) {
                resultado = true;
            }
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
        } finally {
            session.close();
        }
        return resultado;
    }

}
