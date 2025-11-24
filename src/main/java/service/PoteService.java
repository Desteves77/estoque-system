package service;
import dao.PoteDAO;
import produtos.Potes;
import java.sql.SQLException;
import java.util.List;

public class PoteService {

private PoteDAO dao;

public PoteService(PoteDAO dao) {
    this.dao = dao;
}

public PoteService() throws SQLException {
	this.dao = new PoteDAO();
}
	
	public int criarPote(Potes pote) throws SQLException{
		if (pote.getNome() == null || pote.getNome().trim().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		}
		
		if(pote.getQuantidade()<0) {
			throw new IllegalArgumentException("Quantidade não pode ser negativa");
		}
		
		return dao.inserir(pote);
	}
	
	public List<Potes> listarPotes() throws SQLException{
		return dao.listar();
	}
	
	public Potes buscarporId(int id) throws SQLException{
		Potes pote = dao.buscarporId(id);
		
		if(pote==null) {
			throw new IllegalArgumentException("Pote não encontrado");
		}
		return pote;
	}
	
	public boolean atualizarPote(Potes pote) throws SQLException{
		if (pote.getNome() == null || pote.getNome().trim().isEmpty()) {
			throw new IllegalArgumentException("Nome não pode ser vazio");
		}
		
		if(pote.getQuantidade()<0) {
			throw new IllegalArgumentException("Quantidade não pode ser negativa");
		}
		return dao.atualizar(pote);
		
	}
	
	public boolean deletar(int id) throws SQLException{
		return dao.deletar(id);
	}

	
	

}
