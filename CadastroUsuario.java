import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroUsuario {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Usuário");

        // Frame config
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Declaração dos label
        JLabel labelNome = new JLabel("Nome");
        JLabel labelEmail = new JLabel("Email");
        JLabel labelIdade = new JLabel("Idade");

        // Declaração dos campos
        JTextField campoNome = new JTextField(40);
        JTextField campoEmail = new JTextField(30);
        JTextField campoIdade = new JTextField(2);
        // RadioButton
        JRadioButton masculino = new JRadioButton("Masculino");
        JRadioButton feminino = new JRadioButton("Feminino");
        ButtonGroup seletorGenero = new ButtonGroup();
        seletorGenero.add(masculino);
        seletorGenero.add(feminino);

        // Botões
        JButton botaoCadastro = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar");

        // ActionListener

        botaoCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String email = campoEmail.getText();
                String idade = campoIdade.getText();
                String genero = masculino.isSelected() ? "Masculino"
                        : feminino.isSelected() ? "Feminino" : "Não informado";
                // Adicionar o radiobutton

                JOptionPane.showMessageDialog(frame,
                        "Usuário Cadastrado:\nNome: " + nome + "\nE-mail: " + email + "\nIdade: " + idade + "\nGênero: " + genero);

            }
        });

        botaoCadastro.setSize(100, 50);

        frame.setLayout(new FlowLayout());
        frame.add(labelNome);
        frame.add(campoNome);
        frame.add(labelEmail);
        frame.add(campoEmail);
        frame.add(labelIdade);
        frame.add(campoIdade);
        frame.add(masculino);
        frame.add(feminino);
        frame.add(botaoCadastro);


        frame.setVisible(true);
    }
}