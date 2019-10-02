package br.ucsal.lamis.util;

import java.util.ArrayList;
import java.util.List;

import br.ucsal.lamis.model.Bloco;
import br.ucsal.lamis.model.Laboratorio;
import br.ucsal.lamis.model.Usuario;

public class Repositorio {
	
	private ArrayList<Laboratorio> laboratorios = new ArrayList<Laboratorio>();  
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	private ArrayList<Bloco> blocos = new ArrayList<Bloco>();

	
	
	

	public Repositorio() {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		this.usuarios.add(usuario);
		
		Bloco blocoA = new Bloco();
		blocoA.setId(1);
		blocoA.setNome("BLOCO A");
		
		Bloco blocoB = new Bloco();
		blocoB.setId(2);
		blocoB.setNome("BLOCO B");
		
		this.blocos.add(blocoA);
		this.blocos.add(blocoB);
		
		Laboratorio lab = new Laboratorio();
		lab.setBloco(blocoB);
		lab.setDescricao("Laboratório Mac");
		lab.setId(0);
		lab.setNome("Laboratório computador falido");
		this.laboratorios.add(lab);


	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}  
	
	public void inserirUsuario(Usuario usuario) {
		Usuario ultimo = usuarios.get(this.usuarios.size()-1);
		usuario.setId(ultimo.getId()+1);
		this.usuarios.add(usuario);
	}
	
	public void removerUsuario(Integer id) {
		Usuario usuario = null;
		for (Usuario item : usuarios) {
			if(item.getId()== id) {
				usuario = item;
			}
		}
		if(usuario != null) {
			this.usuarios.remove(usuario);
		}
	}
	
	public void alterarUsuario(Usuario usuario) {
		Usuario update = null;
		for (Usuario item : usuarios) {
			if(item.getId() == usuario.getId()) {
				update = item;
			}
		}
		if(update != null) {
			update.setLogin(usuario.getLogin());
			update.setSenha(usuario.getSenha());

		}
		
	}

	public Usuario obterUsuario(Integer id) {
		Usuario usuario = null;
		for (Usuario item : usuarios) {
			if(item.getId()== id) {
				usuario = item;
			}
		}
		return usuario;
	}
	
	public List<Bloco> getBlocos() {
		return blocos;
	}
	
	public Bloco obterBloco(Integer id) {
		Bloco bloco = null;
		for (Bloco item : blocos) {
			if(item.getId()== id) {
				bloco = item;
			}
		}
		return bloco;
	}
	
	public void removerLaboratorio(int id) {
		for (int i = 0; i < laboratorios.size(); i++) {
			if(laboratorios.get(i).getId()==id) {
				laboratorios.remove(i);
				
			}
		}
	}
	 
	
}
