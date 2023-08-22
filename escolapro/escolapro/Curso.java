package escolapro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String nome;
    private String duracao;
    private String descricao;
    
	public Curso(int id2, String nome2, String duracao2, String descricao2) {
        this.setId(id2);
		this.nome = nome2;
        this.setDescricao(descricao2);
        this.setDuracao(duracao2);
	}
	
	// INSERT INTO CURSOS (NOME,DURACAO,GRAU) VALUES ("SALA A10","4 ANOS","Bacharelado");
    public static List<Curso> listarCursos() {
    	List<Curso> objetos = new ArrayList<>();
        try (Connection conexao = Banco.obterConexao();
        		
        		// Enviando e executando statement
                PreparedStatement statement = conexao.prepareStatement("SELECT ID_CURSO ID, NOME, DESCRICAO, DURACAO FROM CURSOS;");
                ResultSet resultSet = statement.executeQuery()) {

        		// Printando resultados
               while (resultSet.next()) {
                   int id = resultSet.getInt("ID");
                   String nome = resultSet.getString("NOME");
                   String duracao = resultSet.getString("DURACAO");
                   String descricao = resultSet.getString("DESCRICAO");

                   Curso curso = new Curso(id, nome, duracao, descricao);
                   objetos.add(curso);
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
    public static void inserirCurso(String nome, String duracao, String descricao) {
    	
    	String query = "INSERT INTO CURSOS (NOME,DURACAO,DESCRICAO) VALUES (?,?,?);";
    	
        try (Connection conexao = Banco.obterConexao()) {
        	
        	// Executando query
        	PreparedStatement statement = conexao.prepareStatement(query);
    		statement.setString(1, nome);
    		statement.setString(2, duracao);
    		statement.setString(3, descricao);
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
    
	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

