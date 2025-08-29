import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1) Listar\n2) Inserir\n3) Excluir\n4) Atualizar\n5) Sair");
		int escolha = sc.nextInt();
		switch(escolha) {
			case 1:
				System.out.println("==== Mostrar alunos === ");
				Aluno[] alunos = dao.getAlunos();
				for(int i = 0; i < alunos.length; i++) {
					System.out.println((i + 1) + alunos[i].toString());
				}
				break;
			case 2:
				System.out.println("Digite o id:");
				int id = sc.nextInt();

				System.out.println("Digite o nome:");
				String nome = sc.next();

				System.out.println("Digite a idade:");
				int idade = sc.nextInt();

				System.out.println("Digite a nota:");
				double nota = sc.nextDouble();

				Aluno novoAluno = new Aluno(id, nome, idade, nota);
				if(dao.inserirAluno(novoAluno) == true) {
					System.out.println("Inserção com sucesso -> " + novoAluno.toString());
				}
				break;
			case 3:
				System.out.println("Digite o codigo do aluno que deseja excluir");
				int n = sc.nextInt();
				dao.excluirAluno(n);
				break;
			case 4:
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
				break;
			case 5:
				break;
		}
		dao.close();
		sc.close();
	}
}