package menu;
import java.util.Scanner;
import dao.PoteDAO;
import dao.InsumoDAO;
import service.InsumoService;
import service.PoteService;

public class MenuPrincipal {
	
	public void exibir() {
		Scanner sc = new Scanner(System.in);
		
		try {
			 PoteDAO poteDAO = new PoteDAO();
	            PoteService poteService = new PoteService(poteDAO);
	            MenuProdutos menuPotes = new MenuProdutos(poteService);
	            
	         InsumoDAO insumoDAO = new InsumoDAO();
	         	InsumoService insumoService = new InsumoService(insumoDAO);
	         	MenuInsumos menuInsumos = new MenuInsumos(insumoService);
	         	
	         int opcao = 0;
	         
	         while(opcao != 3) {
	        	 System.out.println("Menu Principal");
	        	 System.out.println("1. Gerenciar Potes");
	        	 System.out.println("2. Gerenciar Insumos");
	        	 System.out.println("3. Sair");
	        	 System.out.println("Escolha uma opção");
	        opcao = sc.nextInt();
	        
	        switch(opcao) {
	        	case 1: menuPotes.exibirMenu(sc);
	        	break;
	        
	        	case 2: menuInsumos.exibirMenu(sc);
	        	break;
       
	        	case 3: System.out.println("Saindo");
	        	break;
       
	        	default:
	        	System.out.println("Opção inválida");
	        	break;
	        }
	         }
			
		}catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            sc.close();
        }
	}
	
	
}
