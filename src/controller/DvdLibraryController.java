package controller;


import dao.DvdLibraryDao;
import dao.DvdLibraryDaoException;
import dao.DvdLibraryDaoFileImpl;
import dto.DVD;
import ui.DvdLibraryView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

public class DvdLibraryController {
	
	private DvdLibraryView view;
	private DvdLibraryDao dao;
	
	private UserIO io = new UserIOConsoleImpl();
	
	public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao) {
		this.view = view;
		this.dao = dao;
	}
	
	//This is where the controller begins executing
	public void run() {
		boolean keepGoing = true;
		int userSelection = 0;
		
		try {
		while(keepGoing) {
			
			//Get the selection from user
			userSelection = getMenuSelection();
			
			switch(userSelection) {
				
			case 1:
				createDVD();
				break;
			case 2:
				removeDVD();
				break;
			case 3:
				editDVD();
				break;
			case 4:
				displayDVDs();
				break;
			case 5:
				displayDVDByTitle();
				break;
			case 6:
				keepGoing = false;
				break;
			default:
				unknownCommand();
			}
		}
		exitMessage();
		}
		catch(DvdLibraryDaoException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}
	
	//Receive menu selection from user
	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}
	
	//Create a new DVD
	private void createDVD() throws DvdLibraryDaoException{
		view.displayCreateDVDBanner();
		DVD newDVD = view.getNewDVDInfo();
		dao.addDVD(newDVD.getTitle(), newDVD);
		view.displayCreateDVDSuccessBanner();
	}
	
	//Display all DVDs in the collection
	private void displayDVDs() throws DvdLibraryDaoException{
		view.displayDisplayAllBanner();
		view.displayDVDList(dao.getAllDVDs());
		view.displayDisplayAllSuccessBanner();
	}
	
	//Display DVD by title
	private void displayDVDByTitle() throws DvdLibraryDaoException{
		view.displayDisplayDVDBanner();
		String DVDtitle = view.DVDTitleRequest();
		DVD tempDVD = view.displayDVD(dao.getDVD(DVDtitle));
		view.displayDisplayDVDSuccessBanner(tempDVD);
	}
	
	//Remove a particular DVD
	private void removeDVD() throws DvdLibraryDaoException{
		String title = view.DVDTitleRequest();
		DVD dvd = dao.removeDVD(title);
		view.removeDVDSuccessBanner(dvd);
	}
	
	//Edit a particular DVD
	private void editDVD() throws DvdLibraryDaoException{
		
		String title = view.DVDTitleRequest();
		String dvdAttributeName = view.getDvdAttributeName();
		String change = view.getChange();
		DVD dvd = dao.editDVDInformation(title, dvdAttributeName, change);
		view.displayMakeChangeSuccessBanner(dvd);
	}
	
	//Tell the user that the message is unknown
	private void unknownCommand() {
		view.displayUnknownCommandMessage();
	}
	
	//Tell the user that the program has ended
	private void exitMessage() {
		view.displayExitMessage();
	}
	
}