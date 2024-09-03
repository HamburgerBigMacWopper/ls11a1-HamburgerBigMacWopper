package de.oszimt.fian.hase;

import de.oszimt.fian.hase.view.IntView;
import de.oszimt.fian.hase.view.console.StartConsole;
import de.oszimt.fian.hase.model.HaseGmbHManagement;
import de.oszimt.fian.hase.view.gui.StartGUI;

public class HaseGmbHClientStart {
	enum View {GUI, CONSOLE}

	public static void main(String[] args) {
		new HaseGmbHClientStart();
	}


	public HaseGmbHClientStart() {
		IntView view = getView(View.CONSOLE); //getView(View.GUI); //

		// connect and start
		HaseGmbHManagement model = new HaseGmbHManagement(view);
		model.getEmployee().loadData();
		model.getCustomer().loadData();
		model.getContract().loadData();
		view.show(model);
	}

	/**
	 * Get the requested view
	 * @param type, type of the view
	 * @return the requested view
	 */
	private IntView getView(View type){
		switch (type) {
			case CONSOLE:
				return new StartConsole();
			case GUI:
				return new StartGUI();
        };
		return null;
	}

}
