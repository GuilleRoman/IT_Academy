package com.video.application;

public interface Estats {
	public enum estatActual {UPLOADING,VERIFYING,PUBLIC};
	
	void setVideo();
	estatActual getEstat();
}
