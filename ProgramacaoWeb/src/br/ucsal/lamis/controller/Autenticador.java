package br.ucsal.lamis.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.lamis.model.Usuario;
import br.ucsal.lamis.util.Repositorio;

/**
 * Servlet implementation class Autenticador
 */
@WebServlet("/Autenticador")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Repositorio repositorio = (Repositorio) request.getSession().getServletContext().getAttribute("repositorio");
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));
		ArrayList<Usuario> usuarios = repositorio.getUsuarios();
		Usuario usuarioEncontrado = null;
		for (int i = 0; i <usuarios.size(); i++) {
			if(usuarios.get(i).getLogin().equals(usuario.getLogin()) &&
					usuarios.get(i).getSenha().equals(usuario.getSenha())){
					usuarioEncontrado = usuarios.get(i);
			}
		}
		
		if(usuarioEncontrado!=null) {
			request.getSession().setAttribute("usuario", usuarioEncontrado);
			response.sendRedirect("Dashboard");
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}

}
