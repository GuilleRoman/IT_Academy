package com.video.application;

import java.util.Timer;
import java.util.TimerTask;

import com.video.domain.Video;

public class Uploading implements Estats{
	private Video video;
	private estatActual estat;
	
	public Uploading(Video video) {
		this.video =video;
		this.estat = Estats.estatActual.UPLOADING;		
		System.out.println("- url : "+video.getUrl()+" titol : "+video.getTitol()+" Estat : "+estat);
		System.out.println(estat);		
		setVideo();
	}


	@Override
	public void setVideo() {
		new Timer().schedule(new TimerTask() {
		    @Override
		    public void run() {
		        Uploading.this.video.setEstat(new Verifying(video)); 
		    }
		}, 10000);
	}
	
	@Override
	public estatActual getEstat() {
		return estat;
		
	}		
}
