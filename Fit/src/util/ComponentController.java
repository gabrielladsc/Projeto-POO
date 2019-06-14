/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author guilhermeyabu
 */
public class ComponentController {
    
    public static void alterarJText(boolean habilitar, String texto,
            JTextField jTextField) {
        jTextField.setEnabled(habilitar);
        jTextField.setText(texto);
    }
    
    public static void alterarComponente(boolean habilitar, 
            JComponent componente) {
        componente.setEnabled(habilitar);
    }
}
