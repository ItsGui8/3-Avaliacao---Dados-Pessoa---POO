import java.util.List;

public interface OperacoesFuncionario {
	void inserirFuncionario(Funcionario funcionario);
    void atualizarFuncionario(Funcionario funcionario);
    void removerFuncionario(Funcionario funcionario);
    List<Funcionario> listarFuncionarios();
}
