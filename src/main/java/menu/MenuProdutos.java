package menu;
import java.sql.SQLException;
import java.util.Scanner;
import service.PoteService;
import produtos.Potes;

public class MenuProdutos {
	  private PoteService poteService;

	  public MenuProdutos(PoteService poteService) {
	        this.poteService = poteService;
	    }
	  
	    public MenuProdutos() throws SQLException{
	        poteService = new PoteService(); 
	    }

	    public void exibirMenu(Scanner scanner) {
	        int opcao = 0;
	        
	        while(opcao!=6) {
	        	 System.out.println("\n--- Menu Potes ---");
	        	    System.out.println("1. Criar Pote");
	        	    System.out.println("2. Listar Potes");
	        	    System.out.println("3. Buscar Pote por ID");
	        	    System.out.println("4. Atualizar Pote");
	        	    System.out.println("5. Deletar Pote");
	        	    System.out.println("6. Voltar");
	        	    System.out.print("Escolha uma opção: ");
	        	    opcao = scanner.nextInt();
	        	    scanner.nextLine();
	        
	        
	        switch (opcao) {
	        case 1: criarPote(scanner); 
	        break;
	        
	        case 2: listarPote(); 
	        break;
	        
	        case 3: buscarPote(scanner);
	        break;
	        
	        case 4: atualizarPote(scanner); 
	        break;
	        
	        case 5: deletarPote(scanner); 
	        break;
	        
	        case 6: System.out.println("Voltando ao menu principal..."); 
	        break;
	        
	        default: System.out.println("Opção inválida!"); 
	        break;
	    }
	        }
	    }
	    
	    
	private void criarPote(Scanner sc) {
		String nome;
		int quantidade;
		System.out.println("Qual nome do pote?");
		nome = sc.nextLine();
		
		System.out.println("Qual a quantidade?");
		quantidade = sc.nextInt();
		sc.nextLine();
		while(quantidade<0) {
			System.out.println("Quantidade não pode ser negativa");
			System.out.println("Qual a quantidade?");
			quantidade = sc.nextInt();
			sc.nextLine();
		}
	
		
		Potes pote = new Potes(nome, quantidade);
		
		try {
			int id = poteService.criarPote(pote);
			System.out.println("Pote criado com sucesso, ID gerado: " + id);
		}catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
}
	
	private void atualizarPote(Scanner sc) {
		System.out.println("Digite o ID do pote que deseja atualizar");
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			Potes poteExistente = poteService.buscarporId(id);
					
			if(poteExistente==null) {
				System.out.println("Pote não encontrando");
				return;
			}
			
			System.out.println("Pote atual: "+ poteExistente);
			System.out.println("Novo nome:");
			String novoNome= sc.nextLine();
			System.out.println("Nova quantidade:");
			int novaQuantidade = sc.nextInt();
			
			if(!novoNome.trim().isEmpty()) poteExistente.setNome(novoNome);
			if(novaQuantidade>=-1) poteExistente.setQuantidade(novaQuantidade);
			
			boolean atualizado = poteService.atualizarPote(poteExistente);
			
			if(atualizado){
				System.out.println("Pote atualizado com sucesso!");
			}else {
				System.out.println("Não foi possível atualizar o pote");
			}	
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	
	private void listarPote() {
		try {
			for(Potes pote: poteService.listarPotes()) {
				System.out.println(pote);
			}
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void buscarPote(Scanner scanner) {
        System.out.print("ID do pote: ");
        int id = scanner.nextInt();
        try {
            Potes pote = poteService.buscarporId(id);
            System.out.println(pote);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
	
	
	private void deletarPote(Scanner sc) {
		System.out.println("Digite o ID do pote:");
		int id = sc.nextInt();
		try {
			if(poteService.deletar(id)) {
				System.out.println("Pote deletado com sucesso");
			}else {
				System.out.println("Pote não encontrado");
			}
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
