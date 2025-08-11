import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CadastroUsuario {
    public static void main(String[] args) {

        // Frame principal
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Painel principal
        JPanel panel = new JPanel(); //Panel Principal
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Formatação Lateral (no eixo Y)

        JPanel painelBotoes = new JPanel(); // Painel para os botões
        painelBotoes.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0)); // Formatação no centro com espaçamento

        // Declaração dos label
        JLabel labelNome = new JLabel("Nome");
        JLabel labelEmail = new JLabel("Email");
        JLabel labelIdade = new JLabel("Idade");
        JLabel labelGenero = new JLabel("Gênero: (Opcional)");

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

        // Adicionar no panel
        panel.add(labelNome);
        campoNome.setAlignmentX(Component.LEFT_ALIGNMENT); // Formatação para esquerda
        panel.add(campoNome);

        panel.add(labelEmail);
        campoEmail.setAlignmentX(Component.LEFT_ALIGNMENT); // Formatação para esquerda
        panel.add(campoEmail);

        panel.add(labelIdade);
        campoIdade.setAlignmentX(Component.LEFT_ALIGNMENT); // Formatação para esquerda
        panel.add(campoIdade);

        panel.add(labelGenero);
        masculino.setAlignmentX(Component.LEFT_ALIGNMENT); // Formatação para esquerda
        feminino.setAlignmentX(Component.LEFT_ALIGNMENT); // Formatação para esquerda
        panel.add(masculino);
        panel.add(feminino);

        painelBotoes.add(botaoCadastro);
        painelBotoes.add(botaoLimpar);

        painelBotoes.setAlignmentX(Component.LEFT_ALIGNMENT); // Formatação para esquerda
        panel.add(painelBotoes); // Adição do painel (Ao coloca-los no painel diferente do principal, é necessário adicionar o painel num geral)

        int larguraPadrao = Integer.MAX_VALUE; // Formatação com ajuste de largura para cobrir toda a tela
        campoNome.setMaximumSize(new Dimension(larguraPadrao, campoNome.getPreferredSize().height));
        campoEmail.setMaximumSize(new Dimension(larguraPadrao, campoEmail.getPreferredSize().height));
        campoIdade.setMaximumSize(new Dimension(larguraPadrao, campoIdade.getPreferredSize().height));

        // Métodos (ActionListener)

        botaoCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String email = campoEmail.getText();
                String idade = campoIdade.getText();
                // Verificação do RadioButton, mudando o texto conforme o selecionado
                String genero = masculino.isSelected() ? "Masculino"
                        : feminino.isSelected() ? "Feminino" : "Não informado";

                // Verificação se todos os campos (obrigatórios) estão preenchidos
                if (nome.isEmpty() || email.isEmpty() || idade.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Preencha todos os campos.");
                    return;
                }
                // Verificação de email (Variavel declarada fora do main)
                if (!emailValido(email)) {
                    JOptionPane.showMessageDialog(frame, "E-mail inválido. Por favor, insira um e-mail válido.");
                    return;
                }

                // Mostrar a mensagem final
                JOptionPane.showMessageDialog(frame, "Usuário Cadastrado:\nNome: " + nome + "\nE-mail: " + email + "\nIdade: " + idade + "\nGênero: " + genero);

            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Limpa todos os campos e radiobutton
                campoNome.setText("");
                campoEmail.setText("");
                campoIdade.setText("");
                seletorGenero.clearSelection();
            }
        });

        frame.add(panel); //Conecta o panel com o frame
        frame.setVisible(true);
    }

    public static boolean emailValido(String email) {
        // Verifica se o email tem o formato: 'texto@dominio.extensao'
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"); // Formula para verificação de email, aceitando todos caracteres antes do '@', exigindo '@' e um domínio e uma extensão de no minimo 2 letras
    }
}
