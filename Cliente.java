
public class Cliente extends PessoaBase {
	private String cpf;
	
	public Cliente() {
		//super();
	}
	
	public Cliente(int id, String nome, String endereco, String telefone) {
		super(id, nome, endereco, telefone);
	}
	
	public void setId(int id) {
		super.setId(id);
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
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
