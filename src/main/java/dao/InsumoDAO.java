package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.estoque.estoque_system.Conexao;
import produtos.Insumos;


public class InsumoDAO implements  GenericDAO<Insumos> {
private Connection conn;
	

    public InsumoDAO() throws SQLException {
        this.conn = Conexao.conectar();
    }
    
    @Override
    public int inserir(Insumos insumo) throws SQLException{
    	String SQL = "INSERT INTO insumos (nome, quantidade) VALUES (?, ?)";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS) ){
    		ps.setString(1, insumo.getNome());
    		ps.setInt(2, insumo.getQuantidade());
    		
    		ps.executeUpdate();

    		ResultSet rs = ps.getGeneratedKeys();
    		
    		if(rs.next()) {
    			return(rs.getInt(1));
    		}
    		
    		
    		
    	}
    	
    	return 0;
    	
    }
    
    
    @Override
    public List<Insumos> listar() throws SQLException{
    	List<Insumos> lista = new ArrayList<>();
    	
    	String SQL = "SELECT * FROM insumos";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL);   		
    		ResultSet rs = ps.executeQuery()){
    		
    		while(rs.next()) {
    			Insumos p = new Insumos(
    			
    			rs.getInt("id"),
    			rs.getString("nome"),
    			rs.getInt("quantidade"));
    			
    			lista.add(p);
    		}
    		
    	}
    
      return lista;
    }
    
    
    @Override
    public Insumos buscarporId(int id) throws SQLException{
    	String SQL= "SELECT * FROM insumos where id= ? ";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL);){
    		
    		ps.setInt(1, id);
    		
			ResultSet rs = ps.executeQuery();
    				if(rs.next()) {
    					return new Insumos(
    						rs.getInt("id"),
    						rs.getString("nome"),
    						rs.getInt("quantidade")
    						);
    				}
    					
    			}
    	
    	return null;
    }
    
    @Override
    public boolean atualizar(Insumos insumo) throws SQLException{
    	String SQL = "UPDATE insumos SET nome = ?, quantidade = ? WHERE id = ?";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL)){
    		ps.setString(1, insumo.getNome());
    		ps.setInt(2, insumo.getQuantidade());
    		ps.setInt(3, insumo.getId());
    		
    		int linhasAfetadas = ps.executeUpdate();
    		
    		return linhasAfetadas>0;
    	}
    			
    }
    
    @Override
    public boolean deletar(int id) throws SQLException{
    	String SQL = "DELETE FROM insumos WHERE id = ?";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL)){
    		ps.setInt(1, id);
    		
    		int linhasAfetadas = ps.executeUpdate();
    		
    		return linhasAfetadas>0;
    	}
    }
}
