package pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class IniciPipe {

	public static void main(String[] args) throws IOException {
		
		//pipe 1
		PipedReader in1 = new PipedReader();
		PipedWriter out1 = new PipedWriter();
		
		//pipe 2
		PipedReader in2 = new PipedReader();
		PipedWriter out2 = new PipedWriter();
		
		ThreadAillat t1 = new ThreadAillat(in1, out2, "A");
		ThreadAillat t2 = new ThreadAillat(in2, out1, "B");
		
		t1.start();
		t2.start();
		
		try {
			
			t1.join();
			t2.join();
			
		}catch(InterruptedException ie) {
			System.out.println(ie.toString());
		}
	}

}
