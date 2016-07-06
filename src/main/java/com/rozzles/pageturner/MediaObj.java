package com.rozzles.pageturner;

import java.awt.image.BufferedImage;

import uk.co.caprica.vlcj.component.AudioMediaPlayerComponent;

public class MediaObj {
	private final AudioMediaPlayerComponent mediaPlayerComponent;

	public MediaObj(){
		
	    mediaPlayerComponent = new AudioMediaPlayerComponent(); 
//        BufferedImage img = mediaPlayerComponent.getMediaPlayer().getMediaMeta().getArtwork();


//        mediaPlayerComponent.getMediaPlayer().playMedia();
//        mediaPlayerComponent.getMediaPlayer().setRate(2);
	}
	
	public boolean loadURL(String url){
		 mediaPlayerComponent.getMediaPlayer().prepareMedia(url);
	     mediaPlayerComponent.getMediaPlayer().parseMedia();
	        mediaPlayerComponent.getMediaPlayer().play();

		return true; //TODO error checking
	}
	
	public void playPause(){
        mediaPlayerComponent.getMediaPlayer().pause();
	}
	public void seek(int seek){
        mediaPlayerComponent.getMediaPlayer().skip(seek);

	}
	}
