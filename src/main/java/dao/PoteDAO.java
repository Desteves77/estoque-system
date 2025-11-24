package dao;
import java.sql.*;
import java.util.*;
import produtos.Potes;
import br.com.estoque.estoque_system.Conexao;

public class PoteDAO implements GenericDAO<Potes> {
	
	private Connection conn;
	
    public PoteDAO() throws SQLException {
        this.conn = Conexao.conectar();
    }
    
    @Override
    public int inserir(Potes pote) throws SQLException{
    	String SQL = "INSERT INTO potes (nome, quantidade) VALUES (?, ?)";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS) ){
    		ps.setString(1, pote.getNome());
    		ps.setInt(2, pote.getQuantidade());
    		
    		ps.executeUpdate();

    		ResultSet rs = ps.getGeneratedKeys();
    		
    		if(rs.next()) {
    			return(rs.getInt(1));
    		}
    		
    		
    		
    	}
    	
    	return 0;
    	
    }
    
    
    @Override
    public List<Potes> listar() throws SQLException{
    	List<Potes> lista = new ArrayList<>();
    	
    	String SQL = "SELECT * FROM potes";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL);   		
    		ResultSet rs = ps.executeQuery()){
    		
    		while(rs.next()) {
    			Potes p = new Potes(
    			
    			rs.getInt("id"),
    			rs.getString("nome"),
    			rs.getInt("quantidade"));
    			
    			lista.add(p);
    		}
    		
    	}
    
      return lista;
    }
    
    
    @Override
    public Potes buscarporId(int id) throws SQLException{
    	String SQL= "SELECT * FROM potes where id= ? ";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL);){
    		
    		ps.setInt(1, id);
    		
			ResultSet rs = ps.executeQuery();
    				if(rs.next()) {
    					return new Potes(
    						rs.getInt("id"),
    						rs.getString("nome"),
    						rs.getInt("quantidade")
    						);
    				}
    					
    			}
    	
    	return null;
    }
    
    @Override
    public boolean atualizar(Potes pote) throws SQLException{
    	String SQL = "UPDATE potes SET nome = ?, quantidade = ? WHERE id = ?";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL)){
    		ps.setString(1, pote.getNome());
    		ps.setInt(2, pote.getQuantidade());
    		ps.setInt(3, pote.getId());
    		
    		int linhasAfetadas = ps.executeUpdate();
    		
    		return linhasAfetadas>0;
    	}
    			
    }
    
    @Override
    public boolean deletar(int id) throws SQLException{
    	String SQL = "DELETE FROM potes WHERE id = ?";
    	
    	try(PreparedStatement ps = conn.prepareStatement(SQL)){
    		ps.setInt(1, id);
    		
    		int linhasAfetadas = ps.executeUpdate();
    		
    		return linhasAfetadas>0;
    	}
    }

	
    
    
    
    
    
    
}
