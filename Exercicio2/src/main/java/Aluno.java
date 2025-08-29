public class Aluno {
	private int codigo;
	private String nome;
	private int idade;
	private double nota;
	
	public Aluno() {
		this.codigo = -1;
		this.nome = "";
		this.idade = 0;
		this.nota = 0;
	}
	
	public Aluno(int codigo, String nome, int idade, double nota) {
		this.codigo = codigo;
		this.nome = nome;
		this.idade = idade;
		this.nota = nota;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return " Aluno [codigo=" + codigo + ", nome=" + nome + ", idade=" + idade + ", nota=" + nota + "]";
	}	
}