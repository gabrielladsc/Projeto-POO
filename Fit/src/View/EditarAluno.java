/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Data.Aluno;
import Data.AlunoExercicio;
import Data.Exercicio;
import Data.Instrutor;
import Data.dao.AlunoDao;
import Data.dao.AlunoExercicioDao;
import Data.dao.ExercicioDao;
import Data.dao.InstrutorDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import util.ComponentController;

/**
 *
 * @author gabi0
 * 
 * Classe que exibe a tela de Editar de Aluno. Auxilia na editagem do mesmo e
 * gerenciamento dos dados.
 */
public class EditarAluno extends javax.swing.JFrame {

    //Variável que guarda o instrutor logado atualmente para recuperar apenas os alunos
    //deste instrutor
    private final Instrutor instrutorLogado;

    //Variável de gerenciamento dos exercícios entre a aplicação e o banco
    private final ExercicioDao exercicioDao = new ExercicioDao();

    //Lista que contém todos os exercícios cadastrados e que o aluno selecionado ainda não possui
    private List<Exercicio> listaDeExercicios;

    //Variável de gerenciamento dos alunos entre a aplicação e o banco
    private final AlunoDao alunoDao = new AlunoDao();

    //Lista com todos os alunos associados ao instrutor logado
    private List<Aluno> listaDeAlunos;

    //Armazena o aluno selecionado atualmente
    private Aluno alunoSelecionado;

    //Lista com os exercícios que o aluno atualmente selecionado possui
    private final List<Exercicio> exerciciosAlunoSelecionado;

    //Variável de gerenciamento da relação entre um aluno e seus exercícios entre a aplicação e o banco
    private final AlunoExercicioDao alunoExDao = new AlunoExercicioDao();

    /**
     * Construtor que inicializa a tela Editar Aluno.
     */
    public EditarAluno() {
        //iniciliza a lista de exercicios do aluno
        this.exerciciosAlunoSelecionado = new ArrayList();
        InstrutorDao instrutoDao = new InstrutorDao();
        //Recupera o instrutor atualmente logado
        instrutorLogado = instrutoDao.recuperarInstrutorLogado();
        //título da tela Editar Aluno
        this.setTitle("Editar Aluno");
        //Inicializa os componentes da tela
        initComponents();
        //Inicializa o combo box contendo os alunos cadastrados pelo instrutor logado
        initComboBox();
        //inicia tela no centro
        this.setLocationRelativeTo(null);
    }

    /**
     * Recupera todos os alunos cadastrados no banco de dados pelo instrutor
     * logado e adiciona no combo box para que possam ser editados.
     */
    private void initComboBox() {
        jComboBox1.removeAllItems();
        listaDeAlunos = alunoDao.recuperarAlunos(instrutorLogado.getId());
        listaDeAlunos.forEach((aluno) -> {
            jComboBox1.addItem(aluno.getNome());
        });
    }

    /**
     * Monta as tabelas dos exercícios do aluno selecionado e dos exercícios no
     * banco que o aluno ainda não possui
     */
    private void montarListaDeExercicios() {
        //Limpa a lista de exercícios do aluno, quando selecionar novo aluno
        exerciciosAlunoSelecionado.clear();

        //Recupera todos os exercícios cadastrados novamente
        listaDeExercicios = exercicioDao.recuperarExercicios();

        //Lista com a relação dos id's dos exercícios que o aluno selecionado possui 
        List<AlunoExercicio> listaDeExerciciosAluno = alunoExDao.recuperar(alunoSelecionado.getId());

        //Para cada item na variável listaDeExerciciosAluno pega o id de cada exercício 
        //e recupera o exercício correspondente na variável listaDeExercicios
        //Adiciona o exercício encontrado a lista de exercícios do aluno selecionado
        //e remove esse exercício da lista de exercícios, já que ele pertence ao aluno
        listaDeExerciciosAluno.forEach((item) -> {
            for (int i = 0; i < listaDeExercicios.size(); i++) {
                //Se o id do exercício for igual ao id de algum exercício do banco
                //adiciona esse exercício para o aluno e o retira da lista de exercícios 
                if (item.getExercicioId() == listaDeExercicios.get(i).getId()) {
                    exerciciosAlunoSelecionado.add(listaDeExercicios.get(i));
                    listaDeExercicios.remove(listaDeExercicios.get(i));
                }
            }
        });

        //Variável para armazenar o nome dos exercícios que o aluno possui
        //e adicionar na tabela correspondente
        Vector<String> exerciciosAtuais = new Vector();
        exerciciosAlunoSelecionado.forEach((ex) -> {
            exerciciosAtuais.add(ex.getNome());
        });
        jList2.setListData(exerciciosAtuais);

        //Variável para armazenar o nome dos exercícios que o aluno não possui
        //e adicionar na tabela correspondente
        Vector<String> exerciciosNovos = new Vector();
        listaDeExercicios.forEach((ex) -> {
            exerciciosNovos.add(ex.getNome());
        });
        jList1.setListData(exerciciosNovos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Aluno:");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Sexo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Objetivo:");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Masculino" }));
        jComboBox2.setEnabled(false);
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setEnabled(false);

        jTextField3.setEnabled(false);

        jTextField4.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Peso:");

        jTextField5.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Idade:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Altura:");

        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jList1.setEnabled(false);
        jScrollPane1.setViewportView(jList1);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Exercícios: ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Adicionar Exercícios: ");

        jList2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jList2.setEnabled(false);
        jScrollPane2.setViewportView(jList2);

        jButton1.setText(">>");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("<<");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("SALVAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("EXCLUIR ALUNO");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(60, 60, 60)
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel5))
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(44, 44, 44))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(122, 122, 122)
                                        .addComponent(jLabel14)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton3)
                                .addGap(136, 136, 136)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                                .addComponent(jButton4)))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        /*quando um italunoem for selecionado, recupera a posição do item selecionado
        através do combo box e consequentemente o exercicio selecionado 
        preenchendo os campos de acordo com as informações no aluno.
         */
        int itemSelecionado = jComboBox1.getSelectedIndex();

        if (itemSelecionado >= 0) {
            alunoSelecionado = listaDeAlunos.get(itemSelecionado);

            //Habilita os campos, tabelas e combo box e insera as informações correspondentes
            ComponentController.alterarJText(true, alunoSelecionado.getNome(), jTextField2);
            ComponentController.alterarJText(true, alunoSelecionado.getIdade(), jTextField3);
            ComponentController.alterarJText(true, alunoSelecionado.getAltura(), jTextField4);
            ComponentController.alterarJText(true, alunoSelecionado.getObjetivo(), jTextField1);
            ComponentController.alterarJText(true, alunoSelecionado.getPeso(), jTextField5);
            jComboBox2.setSelectedIndex(alunoSelecionado.getSexo());
            ComponentController.alterarComponente(true, jComboBox2);
            ComponentController.alterarComponente(true, jList1);
            ComponentController.alterarComponente(true, jList2);
            ComponentController.alterarComponente(true, jButton1);
            ComponentController.alterarComponente(true, jButton2);

            //monta as tabelas de exercícios de acordo com o aluno selecionado
            montarListaDeExercicios();
        } else {
            //Esvazia-se e desabilita os campos
            ComponentController.alterarJText(false, "", jTextField1);
            ComponentController.alterarJText(false, "", jTextField2);
            ComponentController.alterarJText(false, "", jTextField3);
            ComponentController.alterarComponente(false, jComboBox2);
            ComponentController.alterarComponente(false, jList1);
            ComponentController.alterarComponente(false, jList2);
            ComponentController.alterarComponente(false, jButton1);
            ComponentController.alterarComponente(false, jButton2);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //variáveis para pegar conteúdo dos campos de texto
        String objetivo;
        String novoNome;
        String novaIdade;
        String novaAltura;
        String novoPeso;

        //pegando conteúdo dos campos de texto
        objetivo = jTextField1.getText();
        novoNome = jTextField2.getText();
        novaIdade = jTextField3.getText();
        novaAltura = jTextField4.getText();
        novoPeso = jTextField5.getText();

        //verificando se textos não estão vazios. Se estiverem, mostra mensagem de erro
        if (!objetivo.equals("") && !novoNome.equals("") && !novaIdade.equals("")
                && !novaAltura.equals("") && !novoPeso.equals("")) {
            //Atualiza-se as informações do aluno selecionado de acordo com os campos
            alunoSelecionado.setNome(novoNome);
            alunoSelecionado.setIdade(novaIdade);
            alunoSelecionado.setAltura(novaAltura);
            alunoSelecionado.setObjetivo(objetivo);
            alunoSelecionado.setPeso(novoPeso);
            alunoSelecionado.setSexo(jComboBox2.getSelectedIndex());

            //Se o aluno for atualizado com sucesso, mostra-se mensagem de sucesso
            //e atualiza-se a lista de alunos na tela, senão, mostra mensagem de erro
            if (alunoDao.atualizarAluno(alunoSelecionado)) {
                JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso!");
                //Atualiza-se as informações no combo box de exercícios
                initComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao atualizar aluno");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Algum dos campos se encontra vazio");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Cria uma instância da tela Principal e a torna visível
        //removendo a tela de Editar Aluno
        Principal princi = new Principal();
        princi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (alunoSelecionado != null) {
            //Remove o aluno selecionado assim como quaisquer relações existentes
            //entre esse aluno e um exercício. Se a remoção acontecer com sucesso, mostra-se
            //mensagem de sucesso, senão, mostra-se mensagem de erro
            if (alunoExDao.removerAluno(alunoSelecionado.getId())
                    && alunoDao.deletarAluno(alunoSelecionado)) {
                JOptionPane.showMessageDialog(null, "Aluno excluido com sucesso!");
                initComboBox();
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao excluir aluno");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um aluno!");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Vetor de inteiros contendo as posições dos exercícios selecionados
        //da lista de exercícios que o aluno possui        
        int[] exerciciosDoAlunoSelecionados = jList2.getSelectedIndices();

        //Para cada item selecionado da tabela, recupera-se o exercicio selecionado
        //e remove a relação entre o aluno e o exercício
        for (int i = 0; i < exerciciosDoAlunoSelecionados.length; i++) {
            Exercicio exercicioSelecionado = exerciciosAlunoSelecionado.get(exerciciosDoAlunoSelecionados[i]);
            alunoExDao.remover(alunoSelecionado.getId(), exercicioSelecionado.getId());
        }
        //Atualiza-se as tabelas
        montarListaDeExercicios();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Vetor de inteiros contendo as posições dos exercícios selecionados
        //da lista de exercícios que o aluno não possui       
        int[] novosExercicios = jList1.getSelectedIndices();

        //Para cada item selecionado da tabela de exercícios que o aluno não possui,
        //recupera-se o exercicio selecionado e cria-se uma nova relação entre o aluno e o exercício
        for (int i = 0; i < novosExercicios.length; i++) {
            Exercicio exercicioSelecionado = listaDeExercicios.get(novosExercicios[i]);
            alunoExDao.adicionar(alunoSelecionado.getId(), exercicioSelecionado.getId());
        }
        //Atualiza-se as tabelas
        montarListaDeExercicios();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Cria e torna a tela de Editar Aluno visível */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
