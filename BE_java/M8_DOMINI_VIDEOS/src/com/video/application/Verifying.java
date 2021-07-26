package com.video.application;

import java.util.Timer;
import java.util.TimerTask;

import com.video.domain.Video;

public class Verifying implements Estats {
	private Video video;
	private estatActual estat;
	
	public Verifying(Video video) {
		estat = Estats.estatActual.VERIFYING;
		System.out.println(video.toString());
		System.out.println(estat);
		this.video =video;
		setVideo();
	}

	

	@Override
	public void setVideo() {				
		new Timer().schedule(new TimerTask() {
		    @Override
		    public void run() {
		        Verifying.this.video.setEstat(new Public(video));
		    }
		}, 10000);
	}



	@Override
	public estatActual getEstat() {
		return estat;
		
	}		
	

}
