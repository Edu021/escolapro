package escolapro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Professor {
	private int matricula;
	private String nome;
	private String endereco;
	private String cpf;
	private String celular;
	private String email;
	
	public Professor (int matricula, String nome, String endereco, String cpf, String celular, String email) {
		this.setMatricula(matricula);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
		this.setCelular(celular);
		this.setEmail(email);
	}
	
	public static void inserirProfessor (String nome, String cpf, String endereco, String celular, String email) {
    	String query = "INSERT INTO PROFESSORES (NOME, CPF, ENDERECO, CELULAR, EMAIL) VALUES (?,?,?,?,?);";
    	
        try (Connection conexao = Banco.obterConexao()) {
        
        	// Executando query
        	PreparedStatement statement = conexao.prepareStatement(query);
    		statement.setString(1, nome);
    		statement.setString(2, cpf);
    		statement.setString(3, endereco);
    		statement.setString(4, celular);
    		statement.setString(5, email);
    		
            statement.executeUpdate();
            
            // Fechando as operações
            statement.close();

            // Fechando a conexão
            conexao.close();
            
        } catch (SQLException e) {
               System.out.println("Erro ao executar o INSERT SQL:");
               e.printStackTrace();
           }
        
	}

    public static List<Professor> listarProfessores() {
    	List<Professor> objetos = new ArrayList<>();
        try (Connection conexao = Banco.obterConexao();
        		
        		// Enviando e executando statement
                PreparedStatement statement = conexao.prepareStatement("SELECT * FROM PROFESSORES;");
                ResultSet resultSet = statement.executeQuery()) {

        		// Printando resultados
               while (resultSet.next()) {
                   int matricula = resultSet.getInt("MATRICULA");
                   String nome = resultSet.getString("NOME");
                   String endereco = resultSet.getString("ENDERECO");
                   String cpf = resultSet.getString("CPF");
                   String celular = resultSet.getString("CELULAR");
                   String email = resultSet.getString("EMAIL");
                   
                   Professor professor = new Professor(matricula, nome, endereco, cpf, celular, email);
                   objetos.add(professor);
               }
               
               // Fechando as operações
               statement.close();
               resultSet.close();

               // Fechando a conexão
               conexao.close();
               
           } catch (SQLException e) {
               System.out.println("Erro ao executar a consulta SQL:");
               e.printStackTrace();
           }
        return objetos;
    }

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
