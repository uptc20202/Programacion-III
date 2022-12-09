/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.CustomFont;
import model.QuestionsModel;

/**
 *
 * @author luism
 */
public class Question extends javax.swing.JFrame {

	private int positionQuestions;
    private QuestionsModel[] questionsModel;
    private int levelNumber;
    private Font font;
	/**
     * Creates new form Question
     */
	
	
    public Question(ActionListener listener) {
    	super("Questions");
    	CustomFont customFont = new CustomFont("font\\\\Frygia-Bold.ttf");
		font = customFont.customFontStream();
        initComponents2(listener);
        this.positionQuestions = 0;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents2(ActionListener listener) {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/labelTittle.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/einstein2.gif"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/btnComprobar.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Felix Titling", 0, 18)); // NOI18N
        jLabel3.setText("¡Bien hecho!");

        jLabel3.setFont(font.deriveFont(Font.BOLD, 23));
        jLabel3.setText("");
        
        jLabel4.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 627, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(152, 152, 152))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextPane1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer placerat augue ut tellus sollicitudin, id pulvinar lectus molestie. ");
        jTextPane1.setToolTipText("");
        jTextPane1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextPane1.setFocusable(false);
        jTextPane1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextPane1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jButton2.setText("jButton2");

        jButton3.setText("jButton2");

        jButton5.setText("jButton2");

        jButton6.setText("jButton2");

        jButton7.setText("jButton2");

        jButton8.setText("jButton2");

        jButton4.setText("jButton2");

        jButton9.setText("jButton2");
        
        jButton1.setActionCommand("checkAnswer");
        jButton1.addActionListener(listener);
        
        jButton3.setActionCommand("answer1");
        jButton3.addActionListener(listener);
        
        jButton2.setActionCommand("answer2");
        jButton2.addActionListener(listener);
        
        jButton5.setActionCommand("answer3");
        jButton5.addActionListener(listener);
        
        jButton6.setActionCommand("answer4");
        jButton6.addActionListener(listener);
        
        jButton9.setActionCommand("answer5");
        jButton9.addActionListener(listener);
        
        jButton4.setActionCommand("answer6");
        jButton4.addActionListener(listener);
        
        jButton8.setActionCommand("answer7");
        jButton8.addActionListener(listener);
        
        jButton7.setActionCommand("answer8");
        jButton7.addActionListener(listener);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)))
                            .addComponent(jLabel2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(199, 199, 199))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, "card2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1218, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, "card3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1218, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, "card4");

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Question.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Question().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
	public void setJTextPane1(String string) {
		// TODO Auto-generated method stub
		jTextPane1.setText(string);
		
	}

	public void fill(QuestionsModel[] questions) {
		// TODO Auto-generated method stub
		
	}

	
	public void setQuestionsModel(QuestionsModel[] questionsModel) {
		this.questionsModel = questionsModel;
	}

	public void setQuestionsFill() {
		// TODO Auto-generated method stub
		this.setJTextPane1(questionsModel[positionQuestions].getName());
		fillButtons();
	}
	
	public void fillButtons() {
		String[] answers = new String[8];
		for(int i = 0; i < questionsModel[positionQuestions].getAnswersFalse().length;i++ ) {
			answers[i]= questionsModel[positionQuestions].getAnswersFalse()[i];
		}
		int count = 0;
		for(int i = questionsModel[positionQuestions].getAnswersFalse().length; i < 8;i++ ) {
			answers[i]= 
					questionsModel[positionQuestions].getAnswersTrue()[count];
			count++;
		}
		
                int numero = (int)(Math.random()*8+0); 
                ArrayList numeros = new ArrayList();
                
                jButton2.setBackground(Color.white);        
	    jButton2.setText(answers[numero]);
                numeros.add(numero);
                
                numero = (int)(Math.random()*8+0);
                while(numeros.contains(numero)){
                	numero = (int)(Math.random()*8+0);
                }
                
                jButton3.setBackground(Color.white);
	    jButton3.setText(answers[numero]);
                numeros.add(numero);
                
                numero = (int)(Math.random()*8+0);
                while(numeros.contains(numero)){
                	numero = (int)(Math.random()*8+0);
                }
                
                jButton4.setBackground(Color.white);
	    jButton4.setText(answers[numero]);
                numeros.add(numero);
                
                numero = (int)(Math.random()*8+0);
                while(numeros.contains(numero)){
                	numero = (int)(Math.random()*8+0);
                }
                
                jButton5.setBackground(Color.white);
	    jButton5.setText(answers[numero]);
                numeros.add(numero);
                
                numero = (int)(Math.random()*8+0);
                while(numeros.contains(numero)){
                	numero = (int)(Math.random()*8+0);
                }
                
                jButton6.setBackground(Color.white);
	    jButton6.setText(answers[numero]);
                numeros.add(numero);
                
                numero = (int)(Math.random()*8+0);
                while(numeros.contains(numero)){
                	numero = (int)(Math.random()*8+0);
                }
                
                jButton7.setBackground(Color.white);
	    jButton7.setText(answers[numero]);
                numeros.add(numero);
                
                numero = (int)(Math.random()*8+0);
                while(numeros.contains(numero)){
                	numero = (int)(Math.random()*8+0);
                }
                
                jButton8.setBackground(Color.white);
	    jButton8.setText(answers[numero]);
                numeros.add(numero);
                
                numero = (int)(Math.random()*8+0);
                while(numeros.contains(numero)){
                	numero = (int)(Math.random()*8+0);
                }
                
                jButton9.setBackground(Color.white);
	    jButton9.setText(answers[numero]);
                
	}
	
	public String getjButton2Txt() {
		// TODO Auto-generated method stub
		return jButton2.getText();
	}
	
	public String getjButton3Txt() {
		// TODO Auto-generated method stub
		return jButton3.getText();
	}
	
	public String getjButton4Txt() {
		// TODO Auto-generated method stub
		return jButton4.getText();
	}
	
	public String getjButton5Txt() {
		// TODO Auto-generated method stub
		return jButton5.getText();
	}
	
	public String getjButton6Txt() {
		// TODO Auto-generated method stub
		return jButton6.getText();
	}
	
	public String getjButton7Txt() {
		// TODO Auto-generated method stub
		return jButton7.getText();
	}
	
	public String getjButton8Txt() {
		// TODO Auto-generated method stub
		return jButton8.getText();
	}
	
	public String getjButton9Txt() {
		// TODO Auto-generated method stub
		return jButton9.getText();
	}

	public void setJTextArea2(ArrayList<String> temporalAnswer) {
		// TODO Auto-generated method stub
		String answerBuilt = "";
		for(String answerBuilt1: temporalAnswer) {
			answerBuilt = answerBuilt+" "+answerBuilt1;
		}
		jTextArea2.setText(answerBuilt);
	}

	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public int getPositionQuestions() {
		return positionQuestions;
	}

	public void getjButton2Paint(Color color) {
		// TODO Auto-generated method stub
		jButton2.setBackground(color);
	}
	
	public void getjButton3Paint(Color color) {
		// TODO Auto-generated method stub
		jButton3.setBackground(color);
	}
	
	public void getjButton4Paint(Color color) {
		// TODO Auto-generated method stub
		jButton4.setBackground(color);
	}
	
	public void getjButton5Paint(Color color) {
		// TODO Auto-generated method stub
		jButton5.setBackground(color);
	}
	
	public void getjButton6Paint(Color color) {
		// TODO Auto-generated method stub
		jButton6.setBackground(color);
	}
	
	public void getjButton7Paint(Color color) {
		// TODO Auto-generated method stub
		jButton7.setBackground(color);
	}
	
	
	
	public void getjButton8Paint(Color color) {
		// TODO Auto-generated method stub
		jButton8.setBackground(color);
	}
	
	public void getjButton9Paint(Color color) {
		// TODO Auto-generated method stub
		jButton9.setBackground(color);
	}

	public void PaintJPanel1(Color color) {
		// TODO Auto-generated method stub
		jPanel1.setBackground(color);
	}

	public javax.swing.JLabel getjLabel3() {
		return jLabel3;
	}

	public void setjLabel3Txt(String txt) {
		jLabel3.setText(txt);
	}

	public void setjButton1(String command1,String url) {
		this.jButton1.setActionCommand(command1);
		jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource(url))); // NOI18N

	}

	public void setjLabel4(String txt) {
		jLabel4.setText(txt);
	}

	public void increasePositionQuestions() {
		// TODO Auto-generated method stub
		if(positionQuestions<questionsModel.length-1) {
			positionQuestions++;
		}else {
			this.dispose ();
		}
	}

	public void clearJPanel1() {
		// TODO Auto-generated method stub
		setjButton1("checkAnswer","/resource/img/btnComprobar.png");
		setjLabel3Txt("");
		setjLabel4("");
		PaintJPanel1(new Color(255,255,255));
		jTextArea2.setText("");
	}
	
	
	
}
