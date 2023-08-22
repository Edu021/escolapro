package escolapro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
	
	private int matricula;
	private String professor;
	private String turma;
	private String sala;
	private String curso;
	private String data;
	
	public Agenda (int matricula, String professor, String turma, String sala, String curso, String data) {
		this.matricula = matricula;
		this.professor = professor;
		this.turma = turma;
		this.sala = sala;
		this.curso = curso;
		this.data = data;
	}
	
    public static List<Agenda> listarCronograma() {
    	List<Agenda> objetos = new ArrayList();
        try (Connection conexao = Banco.obterConexao();

        		// Enviando e executando statement
                PreparedStatement statement = conexao.prepareStatement("SELECT P.MATRICULA, P.NOME PROFESSOR, T.NOME TURMA, T.CURSO, S.NOME SALA, CR.DATA FROM CRONOGRAMA CR INNER JOIN PROFESSORES P, TURMAS T, SALAS S, CURSOS C WHERE CR.PROFESSOR = P.MATRICULA AND CR.TURMA = T.ID_TURMA AND CR.SALA = S.ID_SALA AND C.ID_CURSO = CR.CURSO ORDER BY CR.DATA DESC;");
                ResultSet resultSet = statement.executeQuery()) {	
        	
        		// Printando resultados
               	while (resultSet.next()) {
               		int matricula = resultSet.getInt("MATRICULA");
               		String professor = resultSet.getString("PROFESSOR"); // NOME
               		String turma = resultSet.getString("TURMA"); // TURMA A
               		String sala = resultSet.getString("SALA"); // SALA E09
               		String curso = resultSet.getString("CURSO"); // ENGENHARIA 
               		String data = resultSet.getString("DATA"); // 2023-06-21 10:30:00
               		
                    Agenda agenda = new Agenda(matricula, professor, turma, sala, curso, data);
                    objetos.add(agenda);
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
    
    public static void inserirCronograma(String professor, String turma, String sala, String curso, String data) {

        String query1 = "SELECT ID_CURSO FROM CURSOS WHERE NOME = ?"; // PEGA ID DO CURSO
        String query2 = "SELECT ID_TURMA FROM TURMAS WHERE NOME = ? AND CURSO = ?"; // PEGA ID DA TURMA
        String query3 = "INSERT INTO CRONOGRAMA (PROFESSOR, TURMA, SALA, CURSO, DATA) VALUES (?,?,?,?,?)"; // INSER
        String query4 = "SELECT ID_SALA FROM SALAS WHERE NOME = ?;"; // PEGA ID DA SALA
        String query5 = "SELECT MATRICULA FROM PROFESSORES WHERE NOME = ?"; // PEGA MATRICULA DO PROFESSOR
        
        try (Connection conexao = Banco.obterConexao();
                PreparedStatement statement1 = conexao.prepareStatement(query1);
                PreparedStatement statement2 = conexao.prepareStatement(query2);
                PreparedStatement statement3 = conexao.prepareStatement(query3);
        		PreparedStatement statement4 = conexao.prepareStatement(query4);
        		PreparedStatement statement5 = conexao.prepareStatement(query5)){



            //String nomeCurso = "";
            int idTurma = 0;
            int idSala = 0;
            int matriculaProfessor = 0;
            int idCurso = 0;
            
            // STATEMENT 1
            
            statement1.setString(1, curso);
            ResultSet resultSet1 = statement1.executeQuery();
            
            if (resultSet1.next()) {
                idCurso = resultSet1.getInt("ID_CURSO");
            } else {
                System.out.println("Curso não encontrado");
            }
            resultSet1.close();

            // STATEMENT 2
            
            statement2.setString(1, turma);
            statement2.setString(2, curso);
            ResultSet resultSet2 = statement2.executeQuery();

            if (resultSet2.next()) {
            	idTurma = resultSet2.getInt("ID_TURMA");
            } else {
                System.out.println("Turma " + turma + " não encontrada");
            }
            resultSet2.close();

            // STATEMENT 4
            
            statement4.setString(1, sala);
            ResultSet resultSet4 = statement4.executeQuery();

            if (resultSet4.next()) {
            	idSala = resultSet4.getInt("ID_SALA");
            } else {
                System.out.println("Sala " + sala + " não encontrada");
            }
            resultSet4.close();
            
            // STATEMENT 5
            
            statement5.setString(1, professor);
            ResultSet resultSet5 = statement5.executeQuery();
            if (resultSet5.next()) {
            	matriculaProfessor = resultSet5.getInt("MATRICULA");
            }
            
            // STATEMENT 3
            // DEFINE OS CAMPOS E INSERE NA AGENDA
            
            statement3.setInt(1, matriculaProfessor);
            statement3.setInt(2, idTurma);
            statement3.setInt(3, idSala);
            statement3.setInt(4, idCurso);
            statement3.setString(5, data);
            statement3.executeUpdate();

            // Fechando as operações
            statement1.close();
            statement2.close();
            statement3.close();
            statement4.close();
            statement5.close();
            
            // Fechando a conexão
            conexao.close();

        } catch (SQLException e) {
            System.out.println("Erro ao executar o INSERT SQL:");
            e.printStackTrace();
        }
    }
    
    public static void removerCronograma(String sala) {
    	
    }
	

	public int getMatricula() {
		return matricula;
	}

	public int setMatricula(int matricula) {
		this.matricula = matricula;
		return matricula;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
