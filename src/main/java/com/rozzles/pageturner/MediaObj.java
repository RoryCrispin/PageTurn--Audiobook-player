package com.rozzles.pageturner;

import java.awt.image.BufferedImage;

import uk.co.caprica.vlcj.component.AudioMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;

public class MediaObj {
	private final AudioMediaPlayerComponent mediaPlayerComponent;

	public MediaObj(){
		
	    mediaPlayerComponent = new AudioMediaPlayerComponent() {
	        @Override
	        public void playing(MediaPlayer mediaPlayer) {
	        	System.out.println("Playing");
	        }

	        @Override
	        public void finished(MediaPlayer mediaPlayer) {
	        }

	        @Override
	        public void error(MediaPlayer mediaPlayer) {
	        }
	    };
	    
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
	
	public void setPlaybackSpeed(float speed){
		mediaPlayerComponent.getMediaPlayer().setRate(speed);
	}
}
