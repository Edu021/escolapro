package escolapro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Turma {
	
    private int id;
    private String curso;
    private String turma;
    	
	
	//SELECT * FROM CURSOS C INNER JOIN TURMAS T WHERE C.NOME = T.CURSO;
	public Turma(int id2, String curso2, String turma2) {
        this.setId(id2);
		this.curso = curso2;
        this.turma = turma2;

	}
	
    public static List<Turma> comboBoxCursos() {
    	List<Turma> objetos = new ArrayList<>();
        try (Connection conexao = Banco.obterConexao();
        		
        		// Enviando e executando statement
                PreparedStatement statement = conexao.prepareStatement("SELECT * FROM CURSOS C INNER JOIN TURMAS T WHERE C.NOME = T.CURSO;");
                ResultSet resultSet = statement.executeQuery()) {

        		// Printando resultados
               while (resultSet.next()) {
                   int id = resultSet.getInt("ID_TURMA");
                   String turma = resultSet.getString("T.NOME");
                   String curso = resultSet.getString("CURSO");
                   System.out.println("-");
                   Turma turmas = new Turma(id, curso, turma);
                   objetos.add(turmas);
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
	
    public static void listarTurmas() {
        try (Connection conexao = Banco.obterConexao();
        		
        		// Enviando e executando statement
                PreparedStatement statement = conexao.prepareStatement("SELECT ID_TURMA ID, CURSO, NOME FROM TURMAS;");
                ResultSet resultSet = statement.executeQuery()) {

        		// Printando resultados
               while (resultSet.next()) {
                   int id = resultSet.getInt("ID");
                   String turma = resultSet.getString("NOME");
                   String curso = resultSet.getString("CURSO");
                   System.out.println("ID: " + id + " CURSO: " + curso + " TURMA: " + turma);
                   System.out.println("-");
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
    }
    public static void inserirTurma (String curso, String turma) {
    	// INSERT INTO TURMAS (CURSO, NOME) VALUES ("Engenharia de Software", "TURMA A");
    	String query = "INSERT INTO TURMAS (CURSO, NOME) VALUES (?,?);";
    	
        try (Connection conexao = Banco.obterConexao()) {
        	
        	// Executando query
        	PreparedStatement statement = conexao.prepareStatement(query);
    		statement.setString(1, curso);
    		statement.setString(2, turma);
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
    
    public String getCurso () {
    	return curso;
    }
    public String getTurma () {
    	return turma;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
