package main;

import controller.DvdLibraryController;
import dao.DvdLibraryDao;
import dao.DvdLibraryDaoFileImpl;
import ui.DvdLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class Main {

	public static void main(String[] args) {
		
		UserIO myIo = new UserIOConsoleImpl();
		DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
		DvdLibraryView myView = new DvdLibraryView(myIo);
		DvdLibraryController myController = new DvdLibraryController(myView, myDao);
		myController.run();
		
	}

}