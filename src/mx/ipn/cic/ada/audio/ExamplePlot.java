/**
 * 
 */
package mx.ipn.cic.ada.audio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * @author wanderer
 * 
 */
public class ExamplePlot {
	
	public static final String FILE = "C:\\Users\\SIA Miguel\\Music\\a2002011001-e02-128k.mp3";
	
	//public static final String FILE = "/home/wanderer/samples/09_sonne_hagal-who_has_seen_the_wind.mp3";
	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public static void main(String[] args) throws FileNotFoundException,
			Exception {

		/*
		 * WavDecoder decoder = new WavDecoder( new FileInputStream(
		 * "/home/wanderer/Dropbox/code/java/SoundIt-Basic/teste-wav2.wav"));
		 */

		MP3Decoder decoder = new MP3Decoder(
				new FileInputStream(FILE));

		/*
		 * ArrayList<Float> allSamples = new ArrayList<Float>(); float[] samples
		 * = new float[1024];
		 * 
		 * while (decoder.readSamples(samples) > 0) { for (int i = 0; i <
		 * samples.length; i++) allSamples.add(samples[i]); }
		 */

		SamplesReader samplesReader = new SamplesReader(decoder, 1024);

		ArrayList<Float> allSamples = samplesReader.getAllSamples();

		// converto de array list para array, para poder usar no plot
		/*
		 * float[] totalSamples = new float[allSamples.size()]; for (int i = 0;
		 * i < totalSamples.length; i++) totalSamples[i] = allSamples.get(i);
		 */

		System.out.println("Samples: " + allSamples.size());
                
                for (Float allSample : allSamples) {
                    System.out.println(allSample);
                }

		

	}
}
