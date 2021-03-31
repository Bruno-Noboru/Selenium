package entities;

import java.io.Serializable;

public class Linha implements Serializable {

	private static final long serialVersionUID = 1L;







	public final Linha StandardCharsets = null;

	

		private  String nome;
		private String sobrenome;
		private String cargo;
		private String email;
		private String telefone;
		private String empresa;
		private String recebe;
		private String comp;
		private String paises;
		
		
		
		public Linha() {		
			
		}


		public Linha(String nome, String sobrenome, String cargo, String email, String telefone, String empresa,
				String recebe, String comp, String paises) {
			super();
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.cargo = cargo;
			this.email = email;
			this.telefone = telefone;
			this.empresa = empresa;
			this.recebe = recebe;
			this.comp = comp;
			this.paises = paises;
			
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getSobrenome() {
			return sobrenome;
		}


		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}


		public String getCargo() {
			return cargo;
		}


		public void setCargo(String cargo) {
			this.cargo = cargo;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getTelefone() {
			return telefone;
		}


		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}


		public String getEmpresa() {
			return empresa;
		}


		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}


		public String getRecebe() {
			return recebe;
		}


		public void setRecebe(String recebe) {
			this.recebe = recebe;
		}


		public String getComp() {
			return comp;
		}


		public void setComp(String comp) {
			this.comp = comp;
		}

		
		  public String getPaises() { 
			  return paises; 
		  }
		  
		  
		  public void setPaises(String paises) {
			  this.paises = paises;
		  }
		  
		  
			/*
			 * public String getEstado() { return estado; }
			 */
		  
		  
			/*
			 * public void setEstado(String estado) { this.estado = estado;
			 * 
			 * }
			 */
		 
	    


		

	}



