package menu;
import java.sql.SQLException;
import java.util.Scanner;
import service.InsumoService;
import produtos.Insumos;


public class MenuInsumos {
	 private InsumoService insumoService;

	 public MenuInsumos(InsumoService insumoService) {
	        this.insumoService = insumoService;
	    }
	 
	    public MenuInsumos() throws SQLException{
	        insumoService = new InsumoService(); 
	    }

	    public void exibirMenu(Scanner scanner) {
	        int opcao = 0;
	        
	        while(opcao!=6) {
	        	 System.out.println("\n--- Menu Insumos ---");
	        	    System.out.println("1. Criar Insumo");
	        	    System.out.println("2. Listar Insumos");
	        	    System.out.println("3. Buscar Insumo por ID");
	        	    System.out.println("4. Atualizar Insumo");
	        	    System.out.println("5. Deletar Insumo");
	        	    System.out.println("6. Voltar");
	        	    System.out.print("Escolha uma opção: ");
	        	    opcao = scanner.nextInt();
	        	    scanner.nextLine();
	        
	        switch (opcao) {
	        case 1: criarInsumo(scanner); 
	        break;
	        
	        case 2: listarInsumo(); 
	        break;
	        
	        case 3: buscarInsumo(scanner); 
	        break;
	        
	        case 4: atualizarInsumo(scanner); 
	        break;
	        
	        case 5: deletarInsumo(scanner); 
	        break;
	        
	        case 6: System.out.println("Voltando ao menu principal..."); 
	        break;
	        
	        default: System.out.println("Opção inválida!"); 
	        break;
	    }
	        }
	    }
	    
	    
	private void criarInsumo(Scanner sc) {
		String nome;
		int quantidade;
		System.out.println("Qual nome do insumo?");
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
		
		Insumos insumo = new Insumos(nome, quantidade);
		
		try {
			int id = insumoService.criarInsumo(insumo);
			System.out.println("Insumo criado com sucesso, ID gerado: " + id);
		}catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
}
	
	private void atualizarInsumo(Scanner sc) {
		System.out.println("Digite o ID do insumo que deseja atualizar");
		int id = sc.nextInt();
		sc.nextLine();
		
		try {
			Insumos insumoExistente = insumoService.buscarporId(id);
					
			if(insumoExistente==null) {
				System.out.println("Insumo não encontrando");
				return;
			}
			
			System.out.println("Insumo atual: "+ insumoExistente);
			System.out.println("Novo nome:");
			String novoNome= sc.nextLine();
			System.out.println("Nova quantidade:");
			int novaQuantidade = sc.nextInt();
			
			if(!novoNome.trim().isEmpty()) insumoExistente.setNome(novoNome);
			if(novaQuantidade>=-1) insumoExistente.setQuantidade(novaQuantidade);
			
			boolean atualizado = insumoService.atualizarInsumo(insumoExistente);
			
			if(atualizado){
				System.out.println("Insumo atualizado com sucesso!");
			}else {
				System.out.println("Não foi possível atualizar o Insumo");
			}	
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	
	private void listarInsumo() {
		try {
			for(Insumos insumo: insumoService.listarInsumos()) {
				System.out.println(insumo);
			}
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	private void buscarInsumo(Scanner scanner) {
     System.out.print("ID do insumo: ");
     int id = scanner.nextInt();
     try {
        Insumos insumo = insumoService.buscarporId(id);
         System.out.println(insumo);
     } catch (Exception e) {
         System.out.println("Erro: " + e.getMessage());
     }
 }
	
	
	private void deletarInsumo(Scanner sc) {
		System.out.println("Digite o ID do insumo:");
		int id = sc.nextInt();
		try {
			if(insumoService.deletar(id)) {
				System.out.println("Insumo deletado com sucesso");
			}else {
				System.out.println("Insumo não encontrado");
			}
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
