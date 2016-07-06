package com.rozzles.pageturner;

/**
 * --PageTurner--
 * Created by Roory Crispin
 * rorycr96(&)gmail.com
 * License info located in the LICENCE file.
 * Happy hacking
 */
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.AudioMediaPlayerComponent;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.direct.BufferFormat;
import com.rozzles.pageturner.ui.MainUi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class PageTurner {
	public static MediaObj mp;
	

        public static void main (final String[] args){
        	
            try {
                // Set cross-platform Java L&F (also called "Metal")
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e){
            System.out.println(e);	
            }

       boolean found = new NativeDiscovery().discover();
        System.out.println(found);
        System.out.println(LibVlc.INSTANCE.libvlc_get_version());

        
    		EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					PageTurner pt = new PageTurner();
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
        
    }

    public PageTurner() {
    
    	mp = new MediaObj();
    	MainUi window = new MainUi();
		window.getFrmPageTurner().setVisible(true);
    	
     

    }

}

