package produtos;

public class Insumos {
	private String nome;
	private int quantidade, id;
	
	
	public Insumos(int id, String nome, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.quantidade= quantidade;
		
	}	
	
	public Insumos(String nome, int quantidade) {
		this(0, nome, quantidade);
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public int getId() {
		return id;
	}

	public void setNome(String nome) {
		if(nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode estar vazio!");
		}
		
		this.nome = nome.trim();
	}
	
	public void setQuantidade(int quantidade) {
		
		if(quantidade<0) {
			throw new IllegalArgumentException("Quantidade não pode ser negativa!");
		}
		
		this.quantidade = quantidade;
	}
	
	public void setId(int id) {
	this.id = id;
	}

	@Override
	 public String toString() {
        return "Pote{id=" + id + ", nome='" + nome + "', quantidade=" + quantidade + "}";
    }
}
