package br.com.estoque.estoque_system;
import java.sql.Connection;
import java.util.Scanner;
import java.util.Locale;
import menu.MenuPrincipal;


public class Main {

	public static void main(String[] args) {//2
        try (Connection conn = Conexao.conectar();
             Scanner sc = new Scanner(System.in)) {//3

            if (conn == null) {
                System.out.println("❌ Não foi possível conectar ao banco.");
                return;
            }

            Locale.setDefault(Locale.US);
            
            MenuPrincipal menuPrincipal = new MenuPrincipal();
            
            
          menuPrincipal.exibir();
            

	
	}catch (Exception e) {
            e.printStackTrace();
        }
		

	}
}
	
	
	
