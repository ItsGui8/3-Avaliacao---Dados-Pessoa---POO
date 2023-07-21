import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements OperacoesCliente {
	
	public void inserirCliente(Cliente cliente) {
		
		String sql = "INSERT cliente(id, cpf, nome, endereco, telefone) VALUES (?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) connection.prepareStatement(sql);
			pstm.setInt(1, cliente.getId());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getNome());
			pstm.setString(4, cliente.getEndereco());
			pstm.setString(5, cliente.getTelefone());
			
			pstm.execute();
			
			System.out.println("Cliente salvo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void atualizarCliente(Cliente cliente) {
		String sql = "UPDATE cliente SET nome = ?, cpf = ?, endereco = ?, telefone = ? WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) connection.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getEndereco());
			pstm.setString(4, cliente.getTelefone());
			pstm.setInt(5, cliente.getId());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removerCliente(Cliente cliente) {
		String sql = "DELETE FROM cliente WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) connection.prepareStatement(sql);
			
			pstm.setInt(1, cliente.getId());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Cliente> listarClientes() {
		String sql = "SELECT * FROM cliente";
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			pstm = connection.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rset.getInt("id"));
				cliente.setNome(rset.getString("nome"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setEndereco(rset.getString("endereco"));
				cliente.setTelefone(rset.getString("telefone"));
				clientes.add(cliente);
			} 
		} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rset != null) {
						rset.close();
					}
				
					if (pstm != null) {
						pstm.close();
					}
				
					if (connection != null) {
						connection.close();
					} 
				}catch (Exception e) {
						e.printStackTrace();
					}
				}
			
			return clientes;
	}
}
