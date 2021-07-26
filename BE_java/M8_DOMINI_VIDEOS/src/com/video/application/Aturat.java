package com.video.application;

import com.video.domain.Video;

public class Aturat implements Status{
	
	private Video video;
	private estatReproductor estat;
	
	public Aturat(Video video) {
		this.video = video;
		this.estat = estatReproductor.ATURAT;	
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
