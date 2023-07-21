import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO implements OperacoesFuncionario {
	
	public void inserirFuncionario(Funcionario funcionario) {
		
		String sql = "INSERT funcionario(id, nome, endereco, telefone, cargo, salario, dataAdmissao) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) connection.prepareStatement(sql);
			pstm.setInt(1, funcionario.getId());
			pstm.setString(2, funcionario.getNome());
			pstm.setString(3, funcionario.getEndereco());
			pstm.setString(4, funcionario.getTelefone());
			pstm.setString(5, funcionario.getCargo());
			pstm.setDouble(6, funcionario.getSalario());
			pstm.setString(7, funcionario.getDataAdmissao());
			
			pstm.execute();
			
			System.out.println("Funcionario salvo");
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
	
	public void atualizarFuncionario(Funcionario funcionario) {
		String sql = "UPDATE cliente SET nome = ?, endereco = ?, telefone = ?, cargo = ?, salario = ?, dataAdmissao = ? WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) connection.prepareStatement(sql);
			
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getEndereco());
			pstm.setString(3, funcionario.getTelefone());
			pstm.setString(4, funcionario.getCargo());
			pstm.setDouble(5, funcionario.getSalario());
			pstm.setString(6, funcionario.getDataAdmissao());
			pstm.setInt(7, funcionario.getId());
			
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
	
	public void removerFuncionario(Funcionario funcionario) {
		String sql = "DELETE FROM funcionario WHERE id = ?";
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) connection.prepareStatement(sql);
			
			pstm.setInt(1, funcionario.getId());
			
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

	public List<Funcionario> listarFuncionarios() {
		String sql = "SELECT * FROM funcionario";
		
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		
		Connection connection = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			connection = ConnectionFactory.createConnectionToMySQL();
			
			pstm = connection.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId(rset.getInt("id"));
				funcionario.setNome(rset.getString("nome"));
				funcionario.setEndereco(rset.getString("endereco"));
				funcionario.setTelefone(rset.getString("telefone"));
				funcionario.setCargo(rset.getString("cargo"));
				funcionario.setSalario(rset.getDouble("salario"));
				funcionario.setDataAdmissao(rset.getString("dataAdmissao"));
				funcionarios.add(funcionario);
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
			
			return funcionarios;
	}
}
