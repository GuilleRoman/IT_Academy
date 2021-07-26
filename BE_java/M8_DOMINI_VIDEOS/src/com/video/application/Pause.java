package com.video.application;

import com.video.domain.Video;

public class Pause implements Status {

	
	private Video video;
	private estatReproductor estat;
	
	public Pause (Video video) {
		this.video = video;
		this.estat = estatReproductor.PAUSAT;	
		System.out.println(estat.toString());
	}
	
	
	@Override
	public void setEstat() {		
		
	}

	@Override
	public estatReproductor getEstat() {
		return estat;
	}
	

}
