import javax.swing.JOptionPane;
//import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
       
        //ArrayList<Cliente> clientes = new ArrayList<>();
        //ArrayList<Funcionario> funcionarios = new ArrayList<>();
        
        //ClienteDAO clienteDao = new ClienteDAO();
        //FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        
        while (true) {
            String[] options = {"Criar um cliente", "Atualizar um cliente", "Listar clientes", "Excluir um cliente", 
            		"Criar um funcionário", "Atualizar um funcionário", "Listar funcionários", "Excluir um funcionário", "Sair"};
            int escolha = JOptionPane.showOptionDialog(null, "O que você gostaria de fazer?", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                	criarCliente();
                    break;
                case 1:                    
                	atualizarCliente();
                    break;
                case 2:
                	listarClientes();
                    break;
                case 3:
                	excluirCliente();
                    break;
                case 4:
                	criarFuncionario();
                    break;
                case 5:                    
                	atualizarFuncionario();
                    break;
                case 6:
                	listarFuncionarios();
                    break;
                case 7:
                	excluirFuncionario();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
    
    //Cliente
    public static void criarCliente() {
    	Cliente cliente = new Cliente();
    	ClienteDAO clienteDao = new ClienteDAO();
        
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente: "));
        cliente.setId(id);
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
        cliente.setNome(nome);
        String endereco = JOptionPane.showInputDialog("Digite o endereço do cliente: ");
        cliente.setEndereco(endereco);
        String telefone = JOptionPane.showInputDialog("Digite o telefone do cliente: ");
        cliente.setTelefone(telefone);
        String cpf = JOptionPane.showInputDialog("Digite o CPF do cliente: ");
        cliente.setCpf(cpf);
        
        clienteDao.inserirCliente(cliente);
    }
    
    public static void atualizarCliente() {
    	ClienteDAO clienteDao = new ClienteDAO();
    	
    	int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente que deseja atualizar: "));
        
        Cliente clienteAtual = null;
        for (Cliente cli : clienteDao.listarClientes()) {
            if (cli.getId() == id) {
                clienteAtual = cli;
                break;
            }
        }

        if (clienteAtual == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            return;
        }

        String nome = JOptionPane.showInputDialog("Digite o novo nome do cliente: ");
        clienteAtual.setNome(nome);
        String endereco = JOptionPane.showInputDialog("Digite o novo endereço do cliente: ");
        clienteAtual.setEndereco(endereco);
        String telefone = JOptionPane.showInputDialog("Digite o novo telefone do cliente: ");
        clienteAtual.setTelefone(telefone);
        String cpf = JOptionPane.showInputDialog("Digite o novo CPF do cliente: ");
        clienteAtual.setCpf(cpf);
        
        clienteDao.atualizarCliente(clienteAtual);    	
    }
    
    public static void listarClientes() {
    	ClienteDAO clienteDao = new ClienteDAO();
    	StringBuilder clientesList = new StringBuilder();
		for(Cliente cli: clienteDao.listarClientes()) {
			clientesList.append("ID: ").append(cli.getId()).append(" |Nome: ").append(cli.getNome()).append(" |Endereço: ").append(cli.getEndereco()).append(" |Telefone: ").append(cli.getTelefone()).append(" |CPF: ").append(cli.getCpf()).append("\n");
		}
		
        JOptionPane.showMessageDialog(null, clientesList.toString());
    }
    
    public static void excluirCliente() {
    	ClienteDAO clienteDao = new ClienteDAO();
    	int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente que deseja excluir: "));
        
        Cliente clienteAtual = null;
        for (Cliente cli : clienteDao.listarClientes()) {
            if (cli.getId() == id) {
                clienteAtual = cli;
                break;
            }
        }

        if (clienteAtual == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            return;
        }

        clienteDao.removerCliente(clienteAtual);
    }
    
    //Funcionario
    public static void criarFuncionario() {
    	Funcionario funcionario = new Funcionario();
    	FuncionarioDAO funcionarioDao = new FuncionarioDAO();

        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do funcionário: "));
        funcionario.setId(id);
        String nome = JOptionPane.showInputDialog("Digite o nome do funcionário: ");
        funcionario.setNome(nome);
        String endereco = JOptionPane.showInputDialog("Digite o endereço do funcionário: ");
        funcionario.setEndereco(endereco);
        String telefone = JOptionPane.showInputDialog("Digite o telefone do funcionário: ");
        funcionario.setTelefone(telefone);
        String cargo = JOptionPane.showInputDialog("Digite o cargo do funcionário: ");
        funcionario.setCargo(cargo);
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário: "));
        funcionario.setSalario(salario);
        String anoAdmissao = JOptionPane.showInputDialog("Digite o ano de admissão do funcionário: ");
        String mesAdmissao = JOptionPane.showInputDialog("Digite o mês do ano de admissão do funcionário: ");
        String diaAdmissao = JOptionPane.showInputDialog("Digite o dia do mês de admissão do funcionário: ");
        String dataAdmissao = anoAdmissao+"-"+mesAdmissao+"-"+diaAdmissao;
        funcionario.setDataAdmissao(dataAdmissao);
        
        funcionarioDao.inserirFuncionario(funcionario);
    }
    
    public static void atualizarFuncionario() {
    	int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do funcionário que deseja atualizar: "));
    	
    	FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    	
        Funcionario funcionarioAtual = null;
        for (Funcionario func : funcionarioDao.listarFuncionarios()) {
            if (func.getId() == id) {
                funcionarioAtual = func;
                break;
            }
        }

        if (funcionarioAtual == null) {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
            return;
        }

        String nome = JOptionPane.showInputDialog("Digite o novo nome da funcionário: ");
        funcionarioAtual.setNome(nome);
        String endereco = JOptionPane.showInputDialog("Digite o novo endereço do funcionário: ");
        funcionarioAtual.setEndereco(endereco);
        String telefone = JOptionPane.showInputDialog("Digite o novo telefone do funcionário: ");
        funcionarioAtual.setTelefone(telefone);
        String cargo = JOptionPane.showInputDialog("Digite o novo cargo do funcionário: ");
        funcionarioAtual.setCargo(cargo);
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo salário do funcionário: "));
        funcionarioAtual.setSalario(salario);
        String dataAdmissao = JOptionPane.showInputDialog("Digite a nova data de admissão do funcionário: ");
        funcionarioAtual.setDataAdmissao(dataAdmissao);
        
        funcionarioDao.atualizarFuncionario(funcionarioAtual);	
    }
    
    public static void listarFuncionarios() {
    	FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    	StringBuilder pessoasListF = new StringBuilder();
        for (Funcionario func : funcionarioDao.listarFuncionarios()) {
            pessoasListF.append("ID: ").append(func.getId()).append(" |Nome: ").append(func.getNome()).append(" |Endereço: ").append(func.getEndereco()).append(" |Telefone: ").append(func.getTelefone()).append(" |Cargo: ").append(func.getCargo()).append(" |Salário: ").append(func.getSalario()).append(" |Data de Admissão: ").append(func.getDataAdmissao()).append("\n");
        }
        JOptionPane.showMessageDialog(null, pessoasListF.toString());
    }
    
    public static void excluirFuncionario() {
    	FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    	int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do funcionário que deseja excluir: "));
        
        Funcionario funcionarioAtual = null;
        for (Funcionario func : funcionarioDao.listarFuncionarios()) {
            if (func.getId() == id) {
                funcionarioAtual = func;
                break;
            }
        }
        
        if (funcionarioAtual == null) {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
            return;
        }
        
        funcionarioDao.removerFuncionario(funcionarioAtual);
    }
}