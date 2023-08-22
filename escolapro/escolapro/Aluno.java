package escolapro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private int matricula;
    private String nome;
    private int idade;
    private String curso;
    private String turma;
    private String duracao;
    private String email;
    private String cpf;
    private String celular;

    public Aluno(int matricula, String nome, int idade, String curso, String turma, String duracao, String cpf, String email, String celular) {
        this.setMatricula(matricula);
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.turma = turma;
        this.duracao = duracao;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
    }

    public static List<Aluno> listarAlunos() {
        List<Aluno> objetos = new ArrayList<>();
        try (Connection conexao = Banco.obterConexao();
             PreparedStatement statement = conexao.prepareStatement("SELECT A.MATRICULA, A.NOME, A.IDADE, C.NOME CURSO, A.CPF, A.CELULAR, A.EMAIL, T.NOME TURMA, C.DURACAO FROM ALUNOS A INNER JOIN TURMAS T ON A.TURMAS_ID_TURMA = T.ID_TURMA INNER JOIN CURSOS C ON C.ID_CURSO = A.CURSOS_ID_CURSO ORDER BY MATRICULA;");
             ResultSet resultSet = statement.executeQuery()) {

             while (resultSet.next()) {
                int id = resultSet.getInt("MATRICULA");
                String nome = resultSet.getString("NOME");
                int idade = resultSet.getInt("IDADE");
                String nomeCurso = resultSet.getString("CURSO");
                String nomeTurma = resultSet.getString("TURMA");
                String duracao = resultSet.getString("DURACAO");
                String cpf = resultSet.getString("CPF");
                String email = resultSet.getString("EMAIL");
                String celular = resultSet.getString("CELULAR");
                
                Aluno aluno = new Aluno(id, nome, idade, nomeCurso, nomeTurma, duracao, cpf, email, celular);
                objetos.add(aluno);
             }

            statement.close();
            resultSet.close();
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta SQL:");
            e.printStackTrace();
        }
        return objetos;
    }
    public static void inserirAluno(String nome, String idade, String turma, String curso, String cpf, String celular, String email) {
    	// INSERT INTO ALUNOS(NOME,IDADE,TURMAS_ID_TURMA,CURSOS_ID_CURSO)VALUES ("Eduardo de Paula Ribeiro", "21", 1, 1);
    	String queryInsert = "INSERT INTO ALUNOS(NOME,IDADE,TURMAS_ID_TURMA,CURSOS_ID_CURSO,CPF,CELULAR,EMAIL)VALUES (?,?,?,?,?,?,?);";
    	
    	String querySelect1 = "SELECT ID_CURSO FROM CURSOS WHERE NOME = ?;";
    	String querySelect2 = "SELECT ID_TURMA FROM TURMAS WHERE NOME = ? AND CURSO = ?;";
        try (Connection conexao = Banco.obterConexao()) {
        	
        	int turmaId;
        	int cursoId;
        	
        	// Monstando query de insert
        	PreparedStatement statement3 = conexao.prepareStatement(queryInsert);
        	statement3.setString(1, nome);
        	statement3.setString(2, idade);
        	statement3.setString(5, cpf);
        	statement3.setString(6, celular);
        	statement3.setString(7, email);
        	
        	// Buscando id do curso para colocar na query
        	PreparedStatement statement1 = conexao.prepareStatement(querySelect1);
        	statement1.setString(1, curso);
            ResultSet resultSet1 = statement1.executeQuery();
            
			if (resultSet1.next()) {
				cursoId = resultSet1.getInt("ID_CURSO");
				statement3.setInt(4, cursoId);
	        }
			
			// Buscando id da turma para colocar na query
        	PreparedStatement statement2 = conexao.prepareStatement(querySelect2);
        	statement2.setString(1, turma);
        	statement2.setString(2, curso);
            ResultSet resultSet2 = statement2.executeQuery();

			if (resultSet2.next()) {
				turmaId = resultSet2.getInt("ID_TURMA");
				statement3.setInt(3, turmaId);
	        }
        	
        	// Executando query de insert
        	statement3.executeUpdate();
            
            // Fechando as operações
        	statement1.close();
        	statement2.close();
        	statement3.close();
            resultSet1.close();
            resultSet2.close();
            // Fechando a conexão
            conexao.close();
            
        } catch (SQLException e) {
               System.out.println("Erro ao executar o INSERT SQL:");
               e.printStackTrace();
           }

           
    }

	public int getMatricula() {
		return matricula;
	}

	public int setMatricula(int matricula) {
		this.matricula = matricula;
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public String getTurma() {
		return turma;
	}
	
	public String getDuracao() {
		return duracao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String telefone) {
		this.celular = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
