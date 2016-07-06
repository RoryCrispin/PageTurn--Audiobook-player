package com.rozzles.pageturner.ui;

import java.awt.Component;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.rozzles.pageturner.PageTurner;

public class actions {


	public static String browseFile(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    return selectedFile.getAbsolutePath();
		} else {
			return null;
		}
	}

	public static void openSingleFile() {
		String url = browseFile();
		if (url != null){
			System.out.println("url:" + url);
			PageTurner.mp.loadURL(url);
		}
		
	}
	
	public static void playPause(){
		PageTurner.mp.playPause();
	}
	
	public static void seek30(boolean rewind){
		if (rewind){
			PageTurner.mp.seek(-30000);
		} else {
			PageTurner.mp.seek(30000);
		}
	}

}
