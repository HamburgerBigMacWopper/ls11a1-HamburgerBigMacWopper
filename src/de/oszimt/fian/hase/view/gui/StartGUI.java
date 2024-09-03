package de.oszimt.fian.hase.view.gui;

import de.oszimt.fian.hase.model.HaseGmbHManagement;
import de.oszimt.fian.hase.view.IntView;

import javax.swing.*;

public class StartGUI implements IntView {

    @Override
    public void show(HaseGmbHManagement model) {
        showError("Nicht implementiert");
    }

    @Override
    public void showError(String mess) {
        JOptionPane.showMessageDialog(null, mess, "Fehler aufgetreten", JOptionPane.ERROR_MESSAGE);
    }
}
