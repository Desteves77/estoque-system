package dao;

import java.sql.SQLException;
import java.util.List;


public interface GenericDAO<T> {
	int inserir(T obj) throws SQLException;
	boolean atualizar(T obj) throws SQLException;
	boolean deletar(int id) throws SQLException;
	T buscarporId(int id) throws SQLException;
	List<T> listar() throws SQLException;
}
