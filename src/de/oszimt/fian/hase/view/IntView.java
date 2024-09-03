package de.oszimt.fian.hase.view;

import de.oszimt.fian.hase.model.HaseGmbHManagement;

public interface IntView {

    /**
     * Display this view
     * @param model, datamodel
     */
    void show(HaseGmbHManagement model);

    /**
     * Display an error message
     * @param mess, Message to display
     */
    void showError(String mess);

}
