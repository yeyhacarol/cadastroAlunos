package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;

public class FrameCadastroAlunos extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtNome;

	private int posicao;

	public FrameCadastroAlunos() {

		// String[] dias = { "domingo", "segunda", "terça", "quarta", "quinta", "sexta",
		// "sábado" };

		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMatricula = new JLabel("Matrícula:");
		lblMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatricula.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMatricula.setBounds(10, 11, 86, 14);
		contentPane.add(lblMatricula);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(10, 30, 130, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNome.setBounds(10, 61, 86, 14);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(10, 80, 130, 20);
		contentPane.add(txtNome);

		JLabel lblPeriodo = new JLabel("Período:");
		lblPeriodo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPeriodo.setBounds(10, 111, 86, 14);
		contentPane.add(lblPeriodo);

		JComboBox comboPeriodo = new JComboBox();
		DefaultComboBoxModel<Periodo> modelPeriodo = new DefaultComboBoxModel<Periodo>(Periodo.values());

		comboPeriodo.setModel(modelPeriodo);
		comboPeriodo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboPeriodo.setBounds(10, 136, 130, 22);
		contentPane.add(comboPeriodo);

		/// outra maneira de alterar o combo, exibindo sua descrição, do qual não
		/// precisa do override no enum
		// JComboBox comboPeriodo = new JComboBox();
		// DefaultComboBoxModel<String> modelPeriodo =
		// new DefaultComboBoxModel<String>();

		// for (Periodo periodo : Periodo.values()) {

		// modelPeriodo.addElement(periodo.getDescricao());
		// }
		///

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSalvar.setBounds(27, 217, 89, 33);
		contentPane.add(btnSalvar);

		JLabel lblListaAlunos = new JLabel("Lista de Alunos:");
		lblListaAlunos.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblListaAlunos.setBounds(225, 13, 130, 14);
		contentPane.add(lblListaAlunos);

		JScrollPane scrollPaneListaAlunos = new JScrollPane();
		scrollPaneListaAlunos.setBounds(225, 48, 199, 202);
		contentPane.add(scrollPaneListaAlunos);

		JList listAlunos = new JList();

		// o default model é necessário para que os itens apareçam na área desejada,
		// nesse caso os nomes dos alunos na viewport
		DefaultListModel<String> listaModel = new DefaultListModel<String>();
		listAlunos.setModel(listaModel);

		listAlunos.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		scrollPaneListaAlunos.setViewportView(listAlunos);

		JButton btnMostrarAluno = new JButton("Exibir aluno");
		btnMostrarAluno.setBounds(27, 183, 89, 23);
		contentPane.add(btnMostrarAluno);

		AlunoRepository turma = new AlunoRepository(2);

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Aluno aluno = new Aluno();

				aluno.setMatricula(txtMatricula.getText());
				aluno.setNome(txtNome.getText());

				turma.salvarAluno(aluno, posicao);

				aluno.setPeriodo(definirPeriodo(comboPeriodo.getSelectedIndex()));

				posicao++;

				listaModel.addElement(aluno.getNome());

				// isso bloqueia o botão quando a quantidade de alunos na turma igual ao limite
				if (posicao == turma.getTamanho()) {
					btnSalvar.setEnabled(false);

					// essa classe envia mensagens para os usuários
					// null pois a mensagem aparecerá na janela que executou a ação
					JOptionPane.showMessageDialog(null, "Turma cheia!", "CHEIO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		listAlunos.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				Aluno aluno = turma.listarAluno(listAlunos.getSelectedIndex());
				txtMatricula.setText(aluno.getMatricula());
				txtNome.setText(aluno.getNome());
				comboPeriodo.setSelectedIndex(aluno.getPeriodo().ordinal());
			}
		});

		// teste para saber se está funcionando esperadamente
		btnMostrarAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				for (Aluno aluno : turma.listarTodos()) {

					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getNome());
					System.out.println(aluno.getPeriodo().getDescricao());
				}

			}
		});

	}

	// esse método define qual será o período selecionado
	private Periodo definirPeriodo(int periodoSelecionado) {

		if (periodoSelecionado == 0) {
			return Periodo.MANHA;
		} else if (periodoSelecionado == 1) {
			return Periodo.TARDE;
		} else {
			return Periodo.NOITE;
		}

	}
}
