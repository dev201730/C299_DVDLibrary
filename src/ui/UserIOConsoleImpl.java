package ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

	public void print(String msg) {
		System.out.println(msg);
	}
	public int readInteger() {
		
		Scanner myScannerObj = new Scanner(System.in);
		int integer = myScannerObj.nextInt();
		return integer;
	}
	public String readString() {
		
		Scanner myScannerObj = new Scanner(System.in);
		String string = myScannerObj.nextLine();
		return string;
	}
}