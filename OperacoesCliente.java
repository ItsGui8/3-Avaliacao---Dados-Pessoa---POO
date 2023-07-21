import java.util.List;

public interface OperacoesCliente {
    void inserirCliente(Cliente cliente);
    void atualizarCliente(Cliente cliente);
    void removerCliente(Cliente cliente);
    List<Cliente> listarClientes();
}