//*****************************************************************************
// Name: Main
// Author: Werner Vanderstraeten
// Description: A seperate Main class with the main() method.
//*****************************************************************************

package be.WernerVanderstraeten;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.pack();
        calculator.setLocationRelativeTo(null);
        calculator.setVisible(true);
    }
}
