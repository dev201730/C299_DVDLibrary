package dao;

import java.util.List;
import dto.DVD;


public interface DvdLibraryDao {

	DVD addDVD(String title, DVD dvd) throws DvdLibraryDaoException;
	
	DVD removeDVD(String title) throws DvdLibraryDaoException;
	
	List<DVD> getAllDVDs() throws DvdLibraryDaoException;
	
	DVD getDVD(String title) throws DvdLibraryDaoException;
	
	DVD editDVDInformation(String title, String dvdAttributeName, String change) throws DvdLibraryDaoException;
	
	
}