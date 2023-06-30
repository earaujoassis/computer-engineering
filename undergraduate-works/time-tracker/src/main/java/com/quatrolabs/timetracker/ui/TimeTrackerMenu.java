package com.quatrolabs.timetracker.ui;

import com.quatrolabs.timetracker.ui.actions.AboutAction;
import com.quatrolabs.timetracker.ui.actions.AddEntryAction;
import com.quatrolabs.timetracker.ui.actions.ExitApplicationAction;
import com.quatrolabs.timetracker.ui.actions.RemoveEntriesAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class TimeTrackerMenu extends JMenuBar {

    private JFrame frame;

    public TimeTrackerMenu(JFrame frame) {
        super();

        this.frame = frame;

        JMenu menu;
        JMenuItem menuItem;

        menu = new JMenu("Opções");
        menu.setMnemonic(KeyEvent.VK_O);
        menu.getAccessibleContext().setAccessibleDescription("Opções disponíveis para a aplicação");
        add(menu);

        menuItem = new JMenuItem("Adicionar entrada");
        menuItem.getAccessibleContext().setAccessibleDescription("Adicionar entrada no time tracker");
        menuItem.addActionListener(new AddEntryAction(frame));
        menu.add(menuItem);

        menuItem = new JMenuItem("Remover todas entradas");
        menuItem.getAccessibleContext().setAccessibleDescription("Remover todas as entradas do time tracker");
        menuItem.addActionListener(new RemoveEntriesAction(frame));
        menu.add(menuItem);

        menu.addSeparator();

        menuItem = new JMenuItem("Sair");
        menuItem.getAccessibleContext().setAccessibleDescription("Sair da aplicação");
        menuItem.addActionListener(new ExitApplicationAction(frame));
        menu.add(menuItem);

        menu = new JMenu("Ajuda");
        menu.setMnemonic(KeyEvent.VK_S);
        menu.getAccessibleContext().setAccessibleDescription("Opções de ajuda da aplicação");
        add(menu);

        menuItem = new JMenuItem("Sobre");
        menuItem.getAccessibleContext().setAccessibleDescription("Informações sobre o projeto");
        menuItem.addActionListener(new AboutAction(frame));
        menu.add(menuItem);
    }

}
