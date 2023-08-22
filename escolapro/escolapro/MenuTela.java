package escolapro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

public class MenuTela {

	private JFrame frmSistemaAcadmico;
	private JTextField nomeField;
	private JTextField idadeField;
	private JTable table;
	private JTextField nomeProfField;
	private JTable tabelaProf;
	private JTable tabelaTurma;
	private JTable tabelaCurso;
	private JTable tabelaSala;
	private JTextField cpfField;
	private JTextField telefoneField;
	private JTextField emailField;
	private JTextField cpfProfField;
	private JTextField enderecoProfField;
	private JTextField celularProfField;
	private JTextField emailProfField;
	private JTextField turmaField;
	private JTextField nomeCursoField;
	private JTextField duracaoField;
	private JTextField nomeDaSalaField;
	private JTextField capacidadeField;
	private JTextField dataField;
	private JTable tabelaAgenda;
	private JLabel sucessoCadastroProfLabelAnterior = new JLabel("");
	private JLabel sucessoCadastroAlunoLabelAnterior = new JLabel("");
	private JLabel sucessoCadastroTurmaLabelAnterior = new JLabel("");
	private JLabel sucessoCadastroCursoLabelAnterior = new JLabel("");
	private JLabel sucessoCadastroCronogramaLabelAnterior = new JLabel("");
	private JLabel sucessoCadastroSalaLabelAnterior = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuTela window = new MenuTela();
					window.frmSistemaAcadmico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSistemaAcadmico = new JFrame();
		frmSistemaAcadmico.setTitle("Sistema Acadêmico");
		frmSistemaAcadmico.setBounds(100, 100, 630, 485);
		frmSistemaAcadmico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane painelInicial = new JTabbedPane(JTabbedPane.TOP);
		painelInicial.setBackground(new Color(240, 240, 240));
		frmSistemaAcadmico.getContentPane().add(painelInicial, BorderLayout.CENTER);
		
		JPanel inicio = new JPanel();
		inicio.setBorder(null);
		painelInicial.addTab("Início", null, inicio, null);
		inicio.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo ao EscolaPro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setBounds(94, 69, 428, 159);
		inicio.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Luana de Paula Ribeiro, Ruan Paixão ®");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(353, 369, 246, 38);
		inicio.add(lblNewLabel_1);
		
		JPanel cadastros = new JPanel();
		cadastros.setBorder(null);
		painelInicial.addTab("Cadastros", null, cadastros, null);
		painelInicial.setBackgroundAt(1, Color.LIGHT_GRAY);
		cadastros.setLayout(null);
		
		JTabbedPane painelCadastros = new JTabbedPane(JTabbedPane.TOP);
		painelCadastros.setBackground(Color.LIGHT_GRAY);
		painelCadastros.setBorder(null);
		painelCadastros.setBounds(0, 0, 609, 418);
		cadastros.add(painelCadastros);
		
		JPanel alunoCadastro = new JPanel();
		alunoCadastro.setBorder(null);
		alunoCadastro.setBackground(Color.WHITE);
		painelCadastros.addTab("Aluno", null, alunoCadastro, null);
		SpringLayout sl_alunoCadastro = new SpringLayout();
		alunoCadastro.setLayout(sl_alunoCadastro);
		
		nomeField = new JTextField();
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, nomeField, 127, SpringLayout.NORTH, alunoCadastro);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, nomeField, 146, SpringLayout.WEST, alunoCadastro);
		sl_alunoCadastro.putConstraint(SpringLayout.EAST, nomeField, 337, SpringLayout.WEST, alunoCadastro);
		alunoCadastro.add(nomeField);
		nomeField.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome:");
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, nomeLabel, 0, SpringLayout.WEST, nomeField);
		alunoCadastro.add(nomeLabel);
		
		JLabel cadastrarAlunoLabel = new JLabel("Cadastrar aluno");
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, cadastrarAlunoLabel, 66, SpringLayout.NORTH, alunoCadastro);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, cadastrarAlunoLabel, 146, SpringLayout.WEST, alunoCadastro);
		sl_alunoCadastro.putConstraint(SpringLayout.EAST, cadastrarAlunoLabel, 286, SpringLayout.WEST, alunoCadastro);
		cadastrarAlunoLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		alunoCadastro.add(cadastrarAlunoLabel);
		
		JLabel cursoLabel = new JLabel("Curso:");
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, cursoLabel, 6, SpringLayout.SOUTH, nomeField);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, cursoLabel, 146, SpringLayout.WEST, alunoCadastro);
		alunoCadastro.add(cursoLabel);
		
		JLabel turmaLabel = new JLabel("Turma:");
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, turmaLabel, 29, SpringLayout.SOUTH, cursoLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, turmaLabel, 146, SpringLayout.WEST, alunoCadastro);
		alunoCadastro.add(turmaLabel);
		
		JLabel idadeLabel = new JLabel("Idade:");
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, idadeLabel, 182, SpringLayout.EAST, nomeLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, nomeLabel, 0, SpringLayout.NORTH, idadeLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, idadeLabel, 111, SpringLayout.NORTH, alunoCadastro);
		alunoCadastro.add(idadeLabel);
		
		idadeField = new JTextField();
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, idadeField, 22, SpringLayout.EAST, nomeField);
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, idadeField, 0, SpringLayout.NORTH, nomeField);
		sl_alunoCadastro.putConstraint(SpringLayout.EAST, idadeField, -169, SpringLayout.EAST, alunoCadastro);
		idadeField.setColumns(10);
		alunoCadastro.add(idadeField);
		

		
		// 
		// COMBO BOX CURSO
		//
		
		List<Curso> cursos = Curso.listarCursos();
		JComboBox<String> cursoComboBox = new JComboBox<String>();
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, cursoComboBox, 1, SpringLayout.SOUTH, cursoLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, cursoComboBox, 146, SpringLayout.WEST, alunoCadastro);
		sl_alunoCadastro.putConstraint(SpringLayout.EAST, cursoComboBox, 0, SpringLayout.EAST, idadeField);
		DefaultComboBoxModel<String> cursoComboBoxModel = new DefaultComboBoxModel<>();
		
		for (Curso curso : cursos) {
		    cursoComboBoxModel.addElement(curso.getNome());
		}
		cursoComboBox.setModel(cursoComboBoxModel);
		alunoCadastro.add(cursoComboBox);
		
		//
		// COMBO BOX TURMA
		//
		
		List<Turma> turmas = Turma.comboBoxCursos();
		JComboBox<String> turmaComboBox = new JComboBox<String>();
		DefaultComboBoxModel<String> turmaComboBoxModel = new DefaultComboBoxModel<>();
		
		int selectedIndex = cursoComboBox.getSelectedIndex();
		if (selectedIndex != -1) {
		    String valorSelecionado = (String) cursoComboBox.getSelectedItem();
		    for (Turma turma : turmas) {
		    	if(valorSelecionado.equals(turma.getCurso())) {
		    		turmaComboBoxModel.addElement(turma.getTurma());
		    		//System.out.println(turma.getCurso());
		    	}
		    	
		    }
		} else {
			turmaComboBoxModel.addElement("");
		}
		
		turmaComboBox.setModel(turmaComboBoxModel);
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, turmaComboBox, 5, SpringLayout.SOUTH, turmaLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, turmaComboBox, 146, SpringLayout.WEST, alunoCadastro);
		sl_alunoCadastro.putConstraint(SpringLayout.EAST, turmaComboBox, 244, SpringLayout.WEST, alunoCadastro);
		alunoCadastro.add(turmaComboBox);
		
		cursoComboBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // ação a ser executada
		    	List<Turma> turmas = Turma.comboBoxCursos();
		    	DefaultComboBoxModel<String> turmaComboBoxModel = new DefaultComboBoxModel<>();
		        String valorSelecionado = (String) cursoComboBox.getSelectedItem();
		        System.out.println(valorSelecionado);
			    for (Turma turma : turmas) {
			    	if(valorSelecionado.equals(turma.getCurso())) {
			    		turmaComboBoxModel.addElement(turma.getTurma());
			    		//System.out.println(turma.getCurso());
			    	}
			    	
			    }
			    turmaComboBox.setModel(turmaComboBoxModel);
		    }
		});
		
		//
		//
		//
		
		//
		// BOTAO CADASTRAR ALUNO
		//
		
		JButton btnCadastrarAluno = new JButton("Cadastrar");
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, btnCadastrarAluno, 256, SpringLayout.WEST, alunoCadastro);
		sl_alunoCadastro.putConstraint(SpringLayout.SOUTH, btnCadastrarAluno, -33, SpringLayout.SOUTH, alunoCadastro);
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String turmaSelecionada = (String) turmaComboBox.getSelectedItem();
		        String cursoSelecionado = (String) cursoComboBox.getSelectedItem();
		        
		        // INSERE O ALUNO NO BANCO
		        Aluno.inserirAluno(nomeField.getText(), idadeField.getText(), turmaSelecionada, cursoSelecionado, cpfField.getText(), telefoneField.getText(), emailField.getText());
		        
		        // Remove a JLabel anterior, se existir
		        if (sucessoCadastroAlunoLabelAnterior != null) {
		            alunoCadastro.remove(sucessoCadastroAlunoLabelAnterior);
		        }
		        
		        // Cria uma JLabel de sucesso no cadastro
		        JLabel sucessoCadastroAlunoLabel = new JLabel(nomeField.getText() + " cadastrado com sucesso.");
		        
		        // Atribui a nova JLabel à variável de instância
		        sucessoCadastroAlunoLabelAnterior = sucessoCadastroAlunoLabel;
		        
		        alunoCadastro.add(sucessoCadastroAlunoLabel);
		        alunoCadastro.revalidate();
		        alunoCadastro.repaint();
			}
		});
		btnCadastrarAluno.setBackground(Color.LIGHT_GRAY);
		alunoCadastro.add(btnCadastrarAluno);
		
		cpfField = new JTextField();
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, cpfField, 0, SpringLayout.WEST, btnCadastrarAluno);
		sl_alunoCadastro.putConstraint(SpringLayout.EAST, cpfField, 0, SpringLayout.EAST, idadeField);
		alunoCadastro.add(cpfField);
		cpfField.setColumns(10);
		
		JLabel cpfLabel = new JLabel("CPF:");
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, cpfField, 3, SpringLayout.SOUTH, cpfLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, cpfLabel, 0, SpringLayout.WEST, btnCadastrarAluno);
		alunoCadastro.add(cpfLabel);
		
		telefoneField = new JTextField();
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, telefoneField, 0, SpringLayout.WEST, nomeField);
		sl_alunoCadastro.putConstraint(SpringLayout.EAST, telefoneField, 0, SpringLayout.EAST, turmaComboBox);
		alunoCadastro.add(telefoneField);
		telefoneField.setColumns(10);
		
		JLabel telefoneLabel = new JLabel("Telefone:");
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, cpfLabel, 0, SpringLayout.NORTH, telefoneLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, telefoneField, 3, SpringLayout.SOUTH, telefoneLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, telefoneLabel, 6, SpringLayout.SOUTH, turmaComboBox);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, telefoneLabel, 0, SpringLayout.WEST, nomeField);
		alunoCadastro.add(telefoneLabel);
		
		JLabel emailLabel = new JLabel("Email:");
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, emailLabel, 0, SpringLayout.NORTH, turmaLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, emailLabel, 0, SpringLayout.WEST, btnCadastrarAluno);
		alunoCadastro.add(emailLabel);
		
		emailField = new JTextField();
		sl_alunoCadastro.putConstraint(SpringLayout.NORTH, emailField, 6, SpringLayout.SOUTH, emailLabel);
		sl_alunoCadastro.putConstraint(SpringLayout.WEST, emailField, 0, SpringLayout.WEST, btnCadastrarAluno);
		sl_alunoCadastro.putConstraint(SpringLayout.EAST, emailField, 0, SpringLayout.EAST, idadeField);
		emailField.setColumns(10);
		alunoCadastro.add(emailField);
		
		JPanel professorCadastro = new JPanel();
		painelCadastros.addTab("Professor", null, professorCadastro, null);
		professorCadastro.setLayout(null);
		
		JLabel profTituloLabel = new JLabel("Cadastrar professor");
		profTituloLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		profTituloLabel.setBounds(220, 41, 167, 22);
		professorCadastro.add(profTituloLabel);
		
		nomeProfField = new JTextField();
		nomeProfField.setBounds(142, 98, 167, 20);
		professorCadastro.add(nomeProfField);
		nomeProfField.setColumns(10);
		
		JLabel nomeProfLabel = new JLabel("Nome");
		nomeProfLabel.setBounds(142, 81, 167, 14);
		professorCadastro.add(nomeProfLabel);
		
		//
		// BOTAO CADASTRAR PROFESSOR
		//
		
		JButton btnCadastrarProf = new JButton("Cadastrar");
		btnCadastrarProf.setBounds(266, 238, 89, 23);
		btnCadastrarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Insere professor no banco de dados
				Professor.inserirProfessor(nomeProfField.getText(), cpfProfField.getText(), enderecoProfField.getText(), celularProfField.getText(), emailProfField.getText());
				
		        // Remove a JLabel anterior, se existir
		        professorCadastro.remove(sucessoCadastroProfLabelAnterior);
		        
		        // Cria um novo JLabel com a mensagem de sucesso
		        JLabel sucessoCadastroProfLabel = new JLabel(nomeProfField.getText() + " cadastrado.");
		        sucessoCadastroProfLabel.setBounds(230, 51, 177, 32);
		        
		        // Atribui a nova JLabel à variável de instância
		        sucessoCadastroProfLabelAnterior = sucessoCadastroProfLabel;
		        
		        professorCadastro.add(sucessoCadastroProfLabel);
		        professorCadastro.revalidate();
		        professorCadastro.repaint();
			}
		});
		professorCadastro.add(btnCadastrarProf);
		
		cpfProfField = new JTextField();
		cpfProfField.setBounds(319, 98, 167, 20);
		professorCadastro.add(cpfProfField);
		cpfProfField.setColumns(10);
		
		enderecoProfField = new JTextField();
		enderecoProfField.setColumns(10);
		enderecoProfField.setBounds(142, 146, 167, 20);
		professorCadastro.add(enderecoProfField);
		
		JLabel enderecoProfLabel = new JLabel("Endereço");
		enderecoProfLabel.setBounds(142, 129, 167, 14);
		professorCadastro.add(enderecoProfLabel);
		
		JLabel cpfProfLabel = new JLabel("CPF");
		cpfProfLabel.setBounds(319, 81, 167, 14);
		professorCadastro.add(cpfProfLabel);
		
		celularProfField = new JTextField();
		celularProfField.setColumns(10);
		celularProfField.setBounds(319, 146, 167, 20);
		professorCadastro.add(celularProfField);
		
		JLabel celularProfLabel = new JLabel("Celular");
		celularProfLabel.setBounds(319, 129, 167, 14);
		professorCadastro.add(celularProfLabel);
		
		emailProfField = new JTextField();
		emailProfField.setColumns(10);
		emailProfField.setBounds(142, 194, 167, 20);
		professorCadastro.add(emailProfField);
		
		JLabel emailProfLabel = new JLabel("Email");
		emailProfLabel.setBounds(142, 177, 167, 14);
		professorCadastro.add(emailProfLabel);
		
		
		JPanel turmaCadastro = new JPanel();
		painelCadastros.addTab("Turma", null, turmaCadastro, null);
		turmaCadastro.setLayout(null);
		
		JLabel cadastrarTurma = new JLabel("Cadastrar Turma");
		cadastrarTurma.setFont(new Font("Tahoma", Font.BOLD, 16));
		cadastrarTurma.setBounds(227, 59, 167, 22);
		turmaCadastro.add(cadastrarTurma);
		
		JLabel turmaCursoLabel = new JLabel("Curso");
		turmaCursoLabel.setBounds(213, 103, 167, 14);
		turmaCadastro.add(turmaCursoLabel);
		
		JLabel nomeTurmaLabel = new JLabel("Nome da turma");
		nomeTurmaLabel.setBounds(213, 151, 167, 14);
		turmaCadastro.add(nomeTurmaLabel);
		
		//
		// COMBO BOX CADASTRAR TURMAS MOSTRA AS TURMAS
		//
		
		JComboBox<String> turmaComboBox1 = new JComboBox<String>();
		DefaultComboBoxModel<String> turmaComboBoxModel1 = new DefaultComboBoxModel<>();

		for (Curso curso : cursos) {
		    turmaComboBoxModel1.addElement(curso.getNome());
		}

		turmaComboBox1.setModel(turmaComboBoxModel1);
		turmaComboBox1.setBounds(213, 118, 167, 22);
		turmaCadastro.add(turmaComboBox1);

		//
		// BTN CADASTRAR TURMA
		//
		
		JButton btnCadastrarTurma = new JButton("Cadastrar");
		btnCadastrarTurma.setBounds(257, 217, 89, 23);
		btnCadastrarTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cursoSelecionado = (String) turmaComboBox1.getSelectedItem();
				// Insere a turma no banco de dados
				Turma.inserirTurma(cursoSelecionado, turmaField.getText());
				
		        // Remove a JLabel anterior, se existir
				turmaCadastro.remove(sucessoCadastroTurmaLabelAnterior);
		        
		        // Cria um novo JLabel com a mensagem de sucesso
		        JLabel sucessoCadastroTurmaLabel = new JLabel(turmaField.getText() + " cadastrada.");
		        sucessoCadastroTurmaLabel.setBounds(230, 21, 127, 32);
		        
		        // Atribui a nova JLabel à variável de instância
		        sucessoCadastroTurmaLabelAnterior = sucessoCadastroTurmaLabel;
		        
		        turmaCadastro.add(sucessoCadastroTurmaLabel);
		        turmaCadastro.revalidate();
		        turmaCadastro.repaint();
			}
		});
		turmaCadastro.add(btnCadastrarTurma);
		
		turmaField = new JTextField();
		turmaField.setColumns(10);
		turmaField.setBounds(213, 168, 167, 20);
		turmaCadastro.add(turmaField);

		
		JPanel cursoCadastro = new JPanel();
		painelCadastros.addTab("Curso", null, cursoCadastro, null);
		cursoCadastro.setLayout(null);
		
		JLabel lblCadastrarCurso = new JLabel("Cadastrar Curso");
		lblCadastrarCurso.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastrarCurso.setBounds(227, 54, 167, 22);
		cursoCadastro.add(lblCadastrarCurso);
		
		nomeCursoField = new JTextField();
		nomeCursoField.setColumns(10);
		nomeCursoField.setBounds(126, 119, 167, 20);
		cursoCadastro.add(nomeCursoField);
		
		JTextArea descricaoTextArea = new JTextArea();
		descricaoTextArea.setBounds(184, 175, 233, 56);
		cursoCadastro.add(descricaoTextArea);
		
		JLabel nomeProfLabel_1_1 = new JLabel("Nome do curso");
		nomeProfLabel_1_1.setBounds(126, 102, 167, 14);
		cursoCadastro.add(nomeProfLabel_1_1);
		
		//
		// BOTAO CADASTRAR CURSO
		//
		
		JButton btnCadastrarCurso = new JButton("Cadastrar");
		btnCadastrarCurso.setBounds(258, 259, 89, 23);
		btnCadastrarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Insere a turma no banco de dados
				Curso.inserirCurso(nomeCursoField.getText(), duracaoField.getText(), descricaoTextArea.getText());
				
		        // Remove a JLabel anterior, se existir
				cursoCadastro.remove(sucessoCadastroCursoLabelAnterior);
		        
		        // Cria um novo JLabel com a mensagem de sucesso
		        JLabel sucessoCadastroCursoLabel = new JLabel(nomeCursoField.getText() + " cadastrado.");
		        sucessoCadastroCursoLabel.setBounds(230, 21, 127, 32);
		        
		        // Atribui a nova JLabel à variável de instância
		        sucessoCadastroCursoLabelAnterior = sucessoCadastroCursoLabel;
		        
		        cursoCadastro.add(sucessoCadastroCursoLabel);
		        cursoCadastro.revalidate();
		        cursoCadastro.repaint();
			}
		});
		cursoCadastro.add(btnCadastrarCurso);
		
		duracaoField = new JTextField();
		duracaoField.setColumns(10);
		duracaoField.setBounds(303, 119, 167, 20);
		cursoCadastro.add(duracaoField);
		
		JLabel enderecoProfLabel_1_1 = new JLabel("Descrição");
		enderecoProfLabel_1_1.setBounds(184, 160, 167, 14);
		cursoCadastro.add(enderecoProfLabel_1_1);
		
		JLabel duracaoLabel = new JLabel("Duração");
		duracaoLabel.setBounds(303, 102, 167, 14);
		cursoCadastro.add(duracaoLabel);
		
		JPanel salaDeAulaCadastro = new JPanel();
		painelCadastros.addTab("Sala de aula", null, salaDeAulaCadastro, null);
		salaDeAulaCadastro.setLayout(null);
		
		JLabel cadastrarSala = new JLabel("Cadastrar Sala de Aula");
		cadastrarSala.setFont(new Font("Tahoma", Font.BOLD, 16));
		cadastrarSala.setBounds(205, 68, 207, 22);
		salaDeAulaCadastro.add(cadastrarSala);
		
		nomeDaSalaField = new JTextField();
		nomeDaSalaField.setColumns(10);
		nomeDaSalaField.setBounds(223, 130, 167, 20);
		salaDeAulaCadastro.add(nomeDaSalaField);
		
		JLabel nomeDaSalaLabel = new JLabel("Nome da sala");
		nomeDaSalaLabel.setBounds(223, 113, 167, 14);
		salaDeAulaCadastro.add(nomeDaSalaLabel);
		
		JButton btnCadastrarSala = new JButton("Cadastrar");
		btnCadastrarSala.setBounds(261, 222, 89, 23);
		btnCadastrarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Insere a sala de aula no banco de dados
				String capacidadeTexto = capacidadeField.getText();
				int capacidade = Integer.parseInt(capacidadeTexto);
				
				SalaDeAula.inserirSala(nomeDaSalaField.getText(), capacidade);
				
		        // Remove a JLabel anterior, se existir
				salaDeAulaCadastro.remove(sucessoCadastroSalaLabelAnterior);
		        
		        // Cria um novo JLabel com a mensagem de sucesso
		        JLabel sucessoCadastroSalaLabel = new JLabel(nomeDaSalaField.getText() + " cadastrada.");
		        sucessoCadastroSalaLabel.setBounds(230, 21, 127, 32);
		        
		        // Atribui a nova JLabel à variável de instância
		        sucessoCadastroSalaLabelAnterior = sucessoCadastroSalaLabel;
		        
		        salaDeAulaCadastro.add(sucessoCadastroSalaLabel);
		        salaDeAulaCadastro.revalidate();
		        salaDeAulaCadastro.repaint();
			}
		});
		salaDeAulaCadastro.add(btnCadastrarSala);
		
		capacidadeField = new JTextField();
		capacidadeField.setColumns(10);
		capacidadeField.setBounds(223, 178, 167, 20);
		salaDeAulaCadastro.add(capacidadeField);
		
		JLabel capacidadeLabel = new JLabel("Capacidade");
		capacidadeLabel.setBounds(223, 161, 167, 14);
		salaDeAulaCadastro.add(capacidadeLabel);
		
		JPanel cronogramaCadastro = new JPanel();
		painelCadastros.addTab("Cronograma", null, cronogramaCadastro, null);
		cronogramaCadastro.setLayout(null);
		
		JLabel cadastrarCronograma = new JLabel("Agendar Aula");
		cadastrarCronograma.setFont(new Font("Tahoma", Font.BOLD, 16));
		cadastrarCronograma.setBounds(243, 39, 207, 22);
		cronogramaCadastro.add(cadastrarCronograma);
		
		JLabel lblNewLabel_4 = new JLabel("Professor");
		lblNewLabel_4.setBounds(199, 84, 162, 14);
		cronogramaCadastro.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Curso");
		lblNewLabel_5.setBounds(199, 140, 46, 14);
		cronogramaCadastro.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Turma");
		lblNewLabel_6.setBounds(199, 193, 46, 14);
		cronogramaCadastro.add(lblNewLabel_6);
		
		JComboBox<String> professorComboBoxAgenda = new JComboBox<String>();
		professorComboBoxAgenda.setBounds(199, 97, 207, 22);
		cronogramaCadastro.add(professorComboBoxAgenda);

		// Obter a lista de todos os professores
		List<Professor> professores = Professor.listarProfessores();

		// Adicionar os professores ao combobox
		for (Professor professor : professores) {
		    professorComboBoxAgenda.addItem(professor.getNome());
		}

		
		JComboBox<String> cursoComboBoxAgenda = new JComboBox<String>();
		DefaultComboBoxModel<String> cursoComboBoxAgendaModel = new DefaultComboBoxModel<>();
		
		for (Curso curso : cursos) {
			cursoComboBoxAgendaModel.addElement(curso.getNome());
		}
		
		cursoComboBoxAgenda.setModel(cursoComboBoxAgendaModel);
		cursoComboBoxAgenda.setBounds(199, 153, 207, 22);
		cronogramaCadastro.add(cursoComboBoxAgenda);
		
		JComboBox<String> turmaComboBoxAgenda = new JComboBox<String>();
		turmaComboBoxAgenda.setBounds(199, 206, 207, 22);
		cronogramaCadastro.add(turmaComboBoxAgenda);

		cursoComboBoxAgenda.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        List<Turma> turmas = Turma.comboBoxCursos();
		        DefaultComboBoxModel<String> turmaComboBoxModel = new DefaultComboBoxModel<>();
		        String valorSelecionado = (String) cursoComboBoxAgenda.getSelectedItem();
		        
		        for (Turma turma : turmas) {
		            if (valorSelecionado.equals(turma.getCurso())) {
		                turmaComboBoxModel.addElement(turma.getTurma());
		            }
		        }
		        
		        turmaComboBoxAgenda.setModel(turmaComboBoxModel);
		    }
		});

		JComboBox<String> salaComboBoxAgenda = new JComboBox<String>();
		salaComboBoxAgenda.setBounds(199, 252, 207, 22);
		cronogramaCadastro.add(salaComboBoxAgenda);

		cursoComboBoxAgenda.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        List<SalaDeAula> salas = SalaDeAula.listarSalas();
		        salaComboBoxAgenda.removeAllItems(); // Limpar os itens anteriores

		        // Obter as salas de aula do banco de dados
		        SalaDeAula.listarSalas();

		        // Adicionar as salas ao combobox
		        for (SalaDeAula sala : salas) {
		            salaComboBoxAgenda.addItem(sala.getNome());
		        }
		    }
		});
		JLabel lblNewLabel_6_1 = new JLabel("Sala");
		lblNewLabel_6_1.setBounds(199, 239, 46, 14);
		cronogramaCadastro.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Data");
		lblNewLabel_6_2.setBounds(199, 285, 46, 14);
		cronogramaCadastro.add(lblNewLabel_6_2);
		
		dataField = new JTextField();
		dataField.setBounds(199, 298, 207, 20);
		cronogramaCadastro.add(dataField);
		dataField.setColumns(10);
		
		JButton btnAgendarAula = new JButton("Agendar");
		btnAgendarAula.setBounds(261, 339, 89, 23);
		btnAgendarAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String professorSelecionado = (String) professorComboBoxAgenda.getSelectedItem();
				String cursoSelecionado = (String) cursoComboBoxAgenda.getSelectedItem();
				String turmaSelecionada = (String) turmaComboBoxAgenda.getSelectedItem();
				String salaSelecionada = (String) salaComboBoxAgenda.getSelectedItem();
				
				// "INSERT INTO CRONOGRAMA (PROFESSOR, TURMA, SALA, CURSO, DATA) VALUES (?,?,?,?,?)" 2023-06-24 18:30:00
				
				// Insere a turma no banco de dados
				Agenda.inserirCronograma(professorSelecionado, turmaSelecionada, salaSelecionada, cursoSelecionado, dataField.getText());
				
		        // Remove a JLabel anterior, se existir
				cronogramaCadastro.remove(sucessoCadastroCronogramaLabelAnterior);
		        
		        // Cria um novo JLabel com a mensagem de sucesso
		        JLabel sucessoCadastroCronogramaLabel = new JLabel("Aula agendada.");
		        sucessoCadastroCronogramaLabel.setBounds(230, 21, 127, 32);
		        
		        // Atribui a nova JLabel à variável de instância
		        sucessoCadastroCronogramaLabelAnterior = sucessoCadastroCronogramaLabel;
		        
		        cronogramaCadastro.add(sucessoCadastroCronogramaLabel);
		        cronogramaCadastro.revalidate();
		        cronogramaCadastro.repaint();
			}
		});
		
		cronogramaCadastro.add(btnAgendarAula);
		
		JPanel consultas = new JPanel();
		consultas.setBorder(null);
		painelInicial.addTab("Consultas", null, consultas, null);
		consultas.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 609, 418);
		consultas.add(tabbedPane);
		
		JPanel alunoConsulta = new JPanel();
		alunoConsulta.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Aluno", null, alunoConsulta, null);
		alunoConsulta.setLayout(null);
		
		List<Aluno> alunos = Aluno.listarAlunos(); // Obtenha a lista de objetos Aluno
		table = new JTable();
		table.setEnabled(false);
		DefaultTableModel modeloTabela = new DefaultTableModel(
		    new Object[][] {{"Matrícula", "Nome", "Idade", "Curso", "Turma", "Dura\u00E7\u00E3o", "Email", "CPF", "Telefone"},},
		    new String[] {"Matrícula", "Nome", "Idade", "Curso", "Turma", "Dura\u00E7\u00E3o", "Email", "CPF", "Telefone"}
		);

		for (Aluno aluno : alunos) {
		    Object[] linha = {
		            aluno.getMatricula(),
		            aluno.getNome(),
		            aluno.getIdade(),
		            aluno.getCurso(),
		            aluno.getTurma(),
		            aluno.getDuracao(),
		            aluno.getCpf(),
		            aluno.getEmail(),
		            aluno.getCelular()
		    };
		    modeloTabela.addRow(linha);
		}

		table.setModel(modeloTabela);
		table.getColumnModel().getColumn(0).setPreferredWidth(27);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(59);
		table.getColumnModel().getColumn(5).setPreferredWidth(54);
	
		table.setRowSelectionAllowed(false);
		table.setBounds(10, 22, 584, 357);
		alunoConsulta.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("Registro de Alunos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(233, 0, 136, 22);
		alunoConsulta.add(lblNewLabel_2);
		
		JPanel professorConsulta = new JPanel();
		professorConsulta.setBackground(SystemColor.control);
		tabbedPane.addTab("Professor", null, professorConsulta, null);
		
		tabelaProf = new JTable();
		tabelaProf.setCellSelectionEnabled(true);
		tabelaProf.setRowSelectionAllowed(true);
		tabelaProf.setBounds(10, 22, 584, 357);
		tabelaProf.setBackground(new Color(255, 255, 255));
		tabelaProf.setEnabled(false);
		DefaultTableModel modeloTabelaProf = new DefaultTableModel(
				new Object[][] {{"MATRI...", "Nome", "Endere\u00E7o", "CPF", "Telefone", "Email"},},
				new String[] {"MATRI..", "Nome", "Endere\u00E7o", "CPF", "Telefone", "Email"}
		);
		
		for (Professor professor : professores) {
			Object[] row = {
					professor.getMatricula(),
					professor.getNome(),
					professor.getEndereco(),
					professor.getCpf(),
					professor.getCelular(),
					professor.getEmail()
			};
			modeloTabelaProf.addRow(row);
		}
		
		tabelaProf.setModel(modeloTabelaProf);
		tabelaProf.getColumnModel().getColumn(1).setPreferredWidth(220);
		professorConsulta.setLayout(null);
		professorConsulta.add(tabelaProf);
		
		JLabel lblNewLabel_3 = new JLabel("Registro de Professores");
		lblNewLabel_3.setBounds(215, 0, 171, 17);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		professorConsulta.add(lblNewLabel_3);
		
		JPanel turmaConsulta = new JPanel();
		tabbedPane.addTab("Turma", null, turmaConsulta, null);
		turmaConsulta.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("Registro de Turmas");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(215, 0, 171, 17);
		turmaConsulta.add(lblNewLabel_3_1);
		
		tabelaTurma = new JTable();
		
		tabelaTurma.setRowSelectionAllowed(false);
		tabelaTurma.setEnabled(false);
		tabelaTurma.setBackground(Color.WHITE);
		tabelaTurma.setBounds(10, 22, 584, 357);
		DefaultTableModel modeloTabelaTurma = new DefaultTableModel(
				new Object[][] {{"ID", "Curso", "Turma"},},
				new String[] {"ID", "Curso", "Turma"}
		);
		
		for(Turma turma : turmas) {
			Object[] row = {
				turma.getId(),
				turma.getCurso(),
				turma.getTurma()
			};
			modeloTabelaTurma.addRow(row);
		}
		
		tabelaTurma.setModel(modeloTabelaTurma);
		turmaConsulta.add(tabelaTurma);
		
		JPanel cursoConsulta = new JPanel();
		tabbedPane.addTab("Curso", null, cursoConsulta, null);
		cursoConsulta.setLayout(null);
		
		JLabel lblNewLabel_3_2 = new JLabel("Registro de Cursos");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(215, 0, 171, 17);
		cursoConsulta.add(lblNewLabel_3_2);
		
		tabelaCurso = new JTable();
		tabelaCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaCurso.setEnabled(false);
		tabelaCurso.setCellSelectionEnabled(true);
		tabelaCurso.setColumnSelectionAllowed(true);
		tabelaCurso.setFillsViewportHeight(true);
		tabelaCurso.setRowSelectionAllowed(false);
		tabelaCurso.setBackground(Color.WHITE);
		tabelaCurso.setBounds(10, 22, 584, 357);
		DefaultTableModel modeloTabelaCurso = new DefaultTableModel(
				new Object[][] {{"ID", "CURSO", "DURA\u00C7\u00C3O", "DESCRIÇÃO"},},
				new String[] {"ID", "CURSO", "DURA\u00C7\u00C3O", "DESCRIÇÃO"}
		);

		for (Curso curso : cursos) {
			Object [] row = {
					curso.getId(),
					curso.getNome(),
					curso.getDuracao(),
					curso.getDescricao()
			};
			modeloTabelaCurso.addRow(row);
 		}
		
		tabelaCurso.setModel(modeloTabelaCurso);
		tabelaCurso.getColumnModel().getColumn(0).setPreferredWidth(50);
		tabelaCurso.getColumnModel().getColumn(1).setPreferredWidth(110);
		tabelaCurso.getColumnModel().getColumn(2).setPreferredWidth(110);
		tabelaCurso.getColumnModel().getColumn(3).setPreferredWidth(250);
		cursoConsulta.add(tabelaCurso);
		
		JPanel salaDeAulaConsulta = new JPanel();
		tabbedPane.addTab("Sala de aula", null, salaDeAulaConsulta, null);
		salaDeAulaConsulta.setLayout(null);
		
		JLabel lblNewLabel_3_3 = new JLabel("Registro de Salas de Aula");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3.setBounds(215, 0, 190, 17);
		salaDeAulaConsulta.add(lblNewLabel_3_3);
		
		tabelaSala = new JTable();
		
		DefaultTableModel modeloTabelaSala = new DefaultTableModel(
			new Object[][] {{"ID", "SALA", "CAPACIDADE"},},
			new String[] {"ID", "SALA", "CAPACIDADE"}
		);
		
		List<SalaDeAula> salas = SalaDeAula.listarSalas();
		for (SalaDeAula sala : salas) {
			Object [] row = {
				sala.getId(),
				sala.getNome(),
				sala.getCapacidade()
			};
			modeloTabelaSala.addRow(row);
		}
		
		tabelaSala.setModel(modeloTabelaSala);
		tabelaSala.setRowSelectionAllowed(false);
		tabelaSala.setEnabled(false);
		tabelaSala.setBackground(Color.WHITE);
		tabelaSala.setBounds(10, 22, 584, 357);
		salaDeAulaConsulta.add(tabelaSala);
		
		JPanel cronogramaConsulta = new JPanel();
		tabbedPane.addTab("Agenda", null, cronogramaConsulta, null);
		cronogramaConsulta.setLayout(null);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Registro de Salas de Aula");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_3_1.setBounds(207, 0, 190, 17);
		cronogramaConsulta.add(lblNewLabel_3_3_1);
		
		tabelaAgenda = new JTable();

		tabelaAgenda.setRowSelectionAllowed(false);
		tabelaAgenda.setEnabled(false);
		tabelaAgenda.setBackground(Color.WHITE);
		tabelaAgenda.setBounds(10, 22, 584, 357);
		
		DefaultTableModel modeloTabelaAgenda = new DefaultTableModel(
			new Object[][] {
				{"MATRICULA", "PROFESSOR", "TURMA", "CURSO", "SALA", "DATA"},
			},
			new String[] {
				"MATRICULA", "PROFESSOR", "TURMA", "CURSO", "SALA", "DATA"
			}
		);

		List<Agenda> agenda = Agenda.listarCronograma();
		
		for (Agenda i : agenda) {
			Object [] row = {
				i.getMatricula(),
				i.getProfessor(),
				i.getTurma(),
				i.getCurso(),
				i.getSala(),
				i.getData()
			};
			modeloTabelaAgenda.addRow(row);
		}
		
		tabelaAgenda.setModel(modeloTabelaAgenda);
		cronogramaConsulta.add(tabelaAgenda);
	}
}
