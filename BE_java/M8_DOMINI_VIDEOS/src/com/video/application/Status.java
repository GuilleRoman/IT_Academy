package com.video.application;

public interface Status {
	public enum estatReproductor{REPRODUINT_SE, ATURAT, PAUSAT};
	
	void setEstat();
	estatReproductor getEstat();
}
