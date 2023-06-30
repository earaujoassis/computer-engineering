package com.quatrolabs.timetracker.ui.dialogs;

import javax.swing.*;

public class AboutDialog {

    public static void displayDialog(JFrame frame) {
        JOptionPane.showMessageDialog(frame,
                "Projeto desenvolvido como parte da disciplina de\n" +
                        "Programação de Soluções Computacionais\n" +
                        "2023/1\n" +
                        "Desenvolvido por Ewerton Carlos Assis");
    }

}
