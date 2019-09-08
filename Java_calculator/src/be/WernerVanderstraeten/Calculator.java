//*****************************************************************************
// Name: Java Calculator
// Author: Werner Vanderstraeten
// Description: A simple GUI calculator written in Java. The program
// demonstrates the use of GUI components, action listeners, and inner classes.
//*****************************************************************************

package be.WernerVanderstraeten;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

   private ButtonPane buttonPane = new ButtonPane();
   private TextPane textPane = new TextPane();
   private double operator1, operator2;
   private void parseOperators() {
      operator1 = Double.parseDouble(textPane.txtNum1.getText());
      operator2 = Double.parseDouble(textPane.txtNum2.getText());
   }
   private void add() {
      setAnswer(operator1 + operator2);
   }
   private void subtract() {
      setAnswer(operator1 - operator2);
   }
   private void multiply() {
      setAnswer(operator1 * operator2);
   }
   private void divide() {
      setAnswer(operator1 / operator2);
   }
   private void setAnswer(double value) {
      textPane.txtResult.setText(value + "");
   }

   public Calculator() {
      add(textPane, BorderLayout.NORTH);
      add(buttonPane, BorderLayout.SOUTH);
   }

   private class ButtonPane extends JPanel {

      private JButton btnAdd = new JButton("Add");
      private JButton btnSubtract = new JButton("Subtract");
      private JButton btnMultiply = new JButton("Multiply");
      private JButton btnDivide = new JButton("Divide");
      private ButtonListener listener = new ButtonListener();

      private ButtonPane() {
         btnAdd.addActionListener(listener);
         btnSubtract.addActionListener(listener);
         btnMultiply.addActionListener(listener);
         btnDivide.addActionListener(listener);

         add(btnAdd);
         add(btnSubtract);
         add(btnMultiply);
         add(btnDivide);
      }

      private class ButtonListener implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent e) {
            parseOperators();

            if (e.getSource() == btnAdd) {
               Calculator.this.add();
            } else if (e.getSource() == btnSubtract) {
               subtract();
            } else if (e.getSource() == btnMultiply) {
               multiply();
            } else if (e.getSource() == btnDivide) {
               divide();
            }
         }
      }
   }

   private class TextPane extends JPanel {

      private JLabel labelNum1 = new JLabel("Number 1:");
      private JLabel labelNum2 = new JLabel("Number 2:");
      private JLabel labelResult = new JLabel("Result:");
      private JTextField txtNum1 = new JTextField(5);
      private JTextField txtNum2 = new JTextField(5);
      private JTextField txtResult = new JTextField(15);

      private TextPane() {
         add(labelNum1);
         add(txtNum1);
         add(labelNum2);
         add(txtNum2);
         add(labelResult);
         add(txtResult);

         txtResult.setEnabled(false);
         txtResult.setDisabledTextColor(Color.BLACK);
      }
   }
}
