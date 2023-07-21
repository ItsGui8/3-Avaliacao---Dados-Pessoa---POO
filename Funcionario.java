
public class Funcionario extends PessoaBase {
	private String cargo;
	private double salario;
	private String dataAdmissao;
	
	public Funcionario() {
		//super();
	}
	
	public Funcionario(int id, String nome, String endereco, String telefone) {
		super(id, nome, endereco, telefone);
	}
	
	public void setId(int id) {
		super.setId(id);
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getCargo() {
		return cargo;
	}

	public double getSalario() {
		return salario;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}
	
	public int getId() {
		return super.getId();
	}
	
	public String getNome() {
		return super.getNome();
	}
	
	public String getEndereco() {
		return super.getEndereco();
	}
	
	public String getTelefone() {
		return super.getTelefone();
	}
}
