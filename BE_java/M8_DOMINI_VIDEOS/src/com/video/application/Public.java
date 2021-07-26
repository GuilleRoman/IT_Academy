package com.video.application;

import com.video.domain.Video;

public class Public implements Estats {

	private estatActual estat;
	
	public Public(Video video) {
		estat = Estats.estatActual.PUBLIC;
		System.out.println(video.toString());
		System.out.println(estat);
		
	}
	
	@Override
	public estatActual getEstat() {
		return estat;		
	}		
	
	@Override
	public void setVideo() {
		
	}
}
