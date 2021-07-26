package com.video.application;

import com.video.domain.Video;

public class Reproduint_se implements Status{

	private Video video;
	private estatReproductor estat;
	
	public Reproduint_se(Video video) {
		this.video = video;
		this.estat = estatReproductor.REPRODUINT_SE;	
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
