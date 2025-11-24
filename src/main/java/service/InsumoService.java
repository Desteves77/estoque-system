package service;

import java.sql.SQLException;
import java.util.List;

import dao.InsumoDAO;

import produtos.Insumos;

public class InsumoService {
	private InsumoDAO dao;
	
	public InsumoService(InsumoDAO dao) {
	    this.dao = dao;
	}

	public InsumoService() throws SQLException {
		this.dao = new InsumoDAO();
	}
		
		public int criarInsumo(Insumos insumo) throws SQLException{
			if (insumo.getNome() == null || insumo.getNome().trim().isEmpty()) {
				throw new IllegalArgumentException("Nome não pode ser vazio");
			}
			
			if(insumo.getQuantidade()<0) {
				throw new IllegalArgumentException("Quantidade não pode ser negativa");
			}
			
			return dao.inserir(insumo);
		}
		
		public List<Insumos> listarInsumos() throws SQLException{
			return dao.listar();
		}
		
		public Insumos buscarporId(int id) throws SQLException{
			Insumos insumo = dao.buscarporId(id);
			
			if(insumo==null) {
				throw new IllegalArgumentException("Insumo não encontrado");
			}
			return insumo;
		}
		
		public boolean atualizarInsumo(Insumos insumo) throws SQLException{
			if (insumo.getNome() == null || insumo.getNome().trim().isEmpty()) {
				throw new IllegalArgumentException("Nome não pode ser vazio");
			}
			
			if(insumo.getQuantidade()<0) {
				throw new IllegalArgumentException("Quantidade não pode ser negativa");
			}
			return dao.atualizar(insumo);
			
		}
		
		public boolean deletar(int id) throws SQLException{
			return dao.deletar(id);
		}
}
