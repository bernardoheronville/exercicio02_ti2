import java.util.Scanner;

public class Principal {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void listar(DAO dao) {
		System.out.println("==== Mostrar alunos === ");
		Aluno[] alunos = dao.getAlunos();
		for(int i = 0; i < alunos.length; i++) {
			System.out.println((i + 1)+ " - " + alunos[i].toString());
		}
	}
	
	public static void inserir(DAO dao) {
		System.out.println("Digite o id:");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Digite o nome:");
		String nome = sc.nextLine();

		System.out.println("Digite a idade:");
		int idade = sc.nextInt();

		System.out.println("Digite a nota:");
		double nota = sc.nextDouble();

		Aluno novoAluno = new Aluno(id, nome, idade, nota);
		if(dao.inserirAluno(novoAluno) == true) {
			System.out.println("Inserção com sucesso -> " + novoAluno.toString());
		}
	}
	
	public static void excluir(DAO dao) {
		System.out.println("Digite o codigo do aluno que deseja excluir");
		int n = sc.nextInt();
		dao.excluirAluno(n);
	}
	
	public static void atualizar(DAO dao) {
		System.out.println("Digite o código do aluno que deseja atualizar:");
		int idUpdate = sc.nextInt();
		sc.nextLine();
		System.out.println("Digite o novo nome:");
		String nomeNovo = sc.nextLine();
		System.out.println("Digite a idade");
		int novaIdade = sc.nextInt();
		System.out.println("Digite a nova nota");
		double novaNota = sc.nextDouble();
		Aluno aluno = new Aluno(idUpdate, nomeNovo, novaIdade, novaNota); 
		dao.atualizarAluno(aluno);
	}
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();	
		
		if (!dao.conectar()) {
	        System.out.println("Erro ao conectar no banco!");
	        return;
	    }
		
		int escolha = 0;
		do {
			System.out.println("1) Listar\n2) Inserir\n3) Excluir\n4) Atualizar\n5) Sair");
			System.out.println("Escolha a sua opcao");
			escolha = sc.nextInt();
			sc.nextLine();
			switch(escolha) {
			case 1:
				listar(dao);
				break;
			case 2:
				inserir(dao);
				break;
			case 3:
				excluir(dao);
				break;
			case 4:
				atualizar(dao);
				break;
			case 5:
				dao.close();
				sc.close();
				System.out.println("Conexao finalizada");
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		} while (escolha != 5);
	}
}