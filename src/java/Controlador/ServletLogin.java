/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ServicioLogin;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class ServletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombreInicio");
        String clave = request.getParameter("claveInicio");

        boolean resultado = ServicioLogin.instance().autenticacion(nombre, clave);
        
        List<Usuario> lista = ServicioLogin.instance().listaUsuarios(); 
        
        if (resultado) {
            
            if (nombre.equals("admin") && clave.equals("0000")) {
                
                request.getSession().setAttribute("nombreUsuario", nombre);
                request.getSession().setAttribute("lista", lista);
                response.sendRedirect("admin.jsp");
                request.getSession().setAttribute("mensaje", "Sesion cerrada.");       
                
            }else{
                request.getSession().setAttribute("nombreUsuario", nombre);
                response.sendRedirect("paginaInicio.jsp");
                request.getSession().setAttribute("mensaje", "Sesion cerrada.");
            }
            
            
        } else {
            request.getSession().setAttribute("mensaje", "Nombre y/o clave incorrecta");
            response.sendRedirect("inicioSesion.jsp");
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
