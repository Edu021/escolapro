package escolapro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaDeAula {
	private int id;
	private String nome;
	private int capacidade;
	
	public SalaDeAula (int id2, String nome2, int capacidade2) {
		this.setId(id2);
		this.setNome(nome2);
		this.setCapacidade(capacidade2);
	}
    public static List<SalaDeAula> listarSalas() {
    	List<SalaDeAula> objetos = new ArrayList<>();
        try (Connection conexao = Banco.obterConexao();
        		
        		// Enviando e executando statement
                PreparedStatement statement = conexao.prepareStatement("SELECT ID_SALA ID, NOME, CAPACIDADE FROM SALAS;");
                ResultSet resultSet = statement.executeQuery()) {

        		// Printando resultados
               while (resultSet.next()) {
                   int id = resultSet.getInt("ID");
                   String nome = resultSet.getString("NOME");
                   int capacidade = resultSet.getInt("CAPACIDADE");

                   SalaDeAula sala = new SalaDeAula(id, nome, capacidade);
                   objetos.add(sala);
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
    
    public static void inserirSala(String sala, int capacidade) {
    	
    	String query = "INSERT INTO SALAS (NOME, CAPACIDADE) VALUES (?,?);";
    	
        try (Connection conexao = Banco.obterConexao()) {
        
        	// Executando query
        	PreparedStatement statement = conexao.prepareStatement(query);
        	statement.setString(1, sala);
        	statement.setInt(2, capacidade);
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
    
    public static void removerSala(String sala) {
    	
    }
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
