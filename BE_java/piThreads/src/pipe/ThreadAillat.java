package pipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.PrintWriter;

public class ThreadAillat extends Thread {
	private BufferedReader bufReader;
	private PrintWriter printWriter;
	private String msgRx;
	private String msgTx;
	
	/**
	 * Constructor 
	 * 
	 * @param in		PipedReader
	 * @param out		PipedWriter
	 * @param name		String
	 */
	public ThreadAillat(PipedReader in, PipedWriter out, String name) {
		super(name);
		this.bufReader = new BufferedReader(in);
		this.printWriter = new PrintWriter(out);		
	}
	
	public void run() {
		int trama = 0;
		msgRx = "";
		
		while(msgRx.endsWith("Final")) {
			
			msgTx="Trama";
			if(trama < 4) {
				msgTx += "Trama";
			}else {
				msgTx += "Final";
			}
			
			printWriter.println(msgTx);
			System.out.println(getName()+" >> "+msgTx);
			
			try {
				msgRx = bufReader.readLine();
				System.out.println(getName()+" << "+msgRx);
			}catch(IOException ioe) {
				System.out.println("Error en le Thread "+ioe.toString());
			}
			trama++;
		}
		
	}
	

}
