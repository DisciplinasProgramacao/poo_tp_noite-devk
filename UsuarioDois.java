package pooMain;

	import java.util.ArrayList;
	import java.util.List;


	public class Usuario {
		private String name;
		private String username;
	    private String senha;
	    private List<Serie> seriesAssistidas = new ArrayList<>();
	    private List<Serie> seriesParaAssistir;

	  
	    
	    
	    
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public List<Serie> getSeriesAssistidas() {
			return seriesAssistidas;
		}

		public void setSeriesAssistidas(List<Serie> seriesAssistidas) {
			this.seriesAssistidas = seriesAssistidas;
		}

		public List<Serie> getSeriesParaAssistir() {
			return seriesParaAssistir;
		}

		public void setSeriesParaAssistir(List<Serie> seriesParaAssistir) {
			this.seriesParaAssistir = seriesParaAssistir;
		}

		public Usuario(String name ,String username, String senha) {
			super();
			this.name= name;
			this.username = username;
			this.senha = senha;
		}
		
		public  boolean checarCredenciais(String username, String senha) {
	       if (username.equals(this.username) && senha.equals(this.senha)) {
			return true;
	       }
		 return false;
		}

	    public void assistirSerie(Serie serie) {
	        if (!this.seriesAssistidas.contains(serie)) {
	            this.seriesAssistidas.add(serie);
	        }
	    }

	    public void adicionarListaSeriesParaAssistir(Serie serie) {
	        if (!this.seriesParaAssistir.contains(serie)) {
	            this.seriesParaAssistir.add(serie);
	        }
	    }

	    public void removerListaSeriesParaAssistir(Serie serie) {
	        if (this.seriesParaAssistir.contains(serie)) {
	            this.seriesParaAssistir.remove(serie);
	        }
	    }

	    public List<Serie> buscarSerieAssistidaPorGenero(String genero) {
	        List<Serie> seriesFiltradas = new ArrayList<>();

	        for (Serie serie : this.seriesAssistidas) {
	            if (serie.getGenero().equals(genero)) {
	                seriesFiltradas.add(serie);
	            }
	        }

	        return seriesFiltradas;
	    }

	    public List<Serie> buscarSerieAssistidaPorNome(String nome) {
	        List<Serie> seriesFiltradas = new ArrayList<>();

	        for (Serie serie : this.seriesAssistidas) {
	            if (serie.getGenero().equals(nome)) {
	                seriesFiltradas.add(serie);
	            }
	        }

	        return seriesFiltradas;
	    }

	    public List<Serie> buscarSerieAssistidaPorIdioma(String idioma) {
	        List<Serie> seriesFiltradas = new ArrayList<>();

	        for (Serie serie : this.seriesAssistidas) {
	            if (serie.getIdioma().equals(idioma)) {
	                seriesFiltradas.add(serie);
	            }
	        }

	        return seriesFiltradas;
	    }

	    public List<Serie> buscarSerieParaAssistirPorGenero(String genero) {
	        List<Serie> seriesFiltradas = new ArrayList<>();

	        for (Serie serie : this.seriesParaAssistir) {
	            if (serie.getGenero().equals(genero)) {
	                seriesFiltradas.add(serie);
	            }
	        }

	        return seriesFiltradas;
	    }

	    public List<Serie> buscarSerieParaAssistirPorNome(String nome) {
	        List<Serie> seriesFiltradas = new ArrayList<>();

	        for (Serie serie : this.seriesParaAssistir) {
	            if (serie.getGenero().equals(nome)) {
	                seriesFiltradas.add(serie);
	            }
	        }

	        return seriesFiltradas;
	    }

	    public List<Serie> buscarSerieParaAssistirPorIdioma(String idioma) {
	        List<Serie> seriesFiltradas = new ArrayList<>();

	        for (Serie serie : this.seriesParaAssistir) {
	            if (serie.getIdioma().equals(idioma)) {
	                seriesFiltradas.add(serie);
	            }
	        }

	        return seriesFiltradas;
	    }
	}
