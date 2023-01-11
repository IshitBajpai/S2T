package SpeechRec;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;


import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class TranscriberDemo {       

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("src\\main\\resources\\1874.dic");
		configuration.setLanguageModelPath("src\\main\\resources\\1874.lm");
//        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
//        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

		
//		  try
//		    {
//		        Clip clip = AudioSystem.getClip();
//		        clip.open(AudioSystem.getAudioInputStream(new File("C:\\Users\\admin\\eclipse-workspace\\SpeechRec\\lib\\src\\main\\java\\SpeechRec\\StarWars3.wav")));
//		        clip.setFramePosition(0);
//		        clip.start();
//		    }
//		    catch (Exception exc)
//		    {
//		        exc.printStackTrace(System.out);
//		    }
	
	
	
	try {
	LiveSpeechRecognizer speech = new LiveSpeechRecognizer(configuration);
	speech.startRecognition(true);
	
	SpeechResult speechResult = null;
	
	while ((speechResult = speech.getResult()) != null) {
		String voiceCommand = speechResult.getHypothesis();
		System.out.println("Voice Command is " + voiceCommand);
		if(voiceCommand.equalsIgnoreCase("View")) {
			speech.stopRecognition();
			MyFrame f1 = new MyFrame();
			break;
		}
		
		
	}
	
} catch (IOException e) {
	e.printStackTrace();
}

}
	
    }


//public class TranscriberDemo {
//
//	public static void main(String[] st) {
//		
//		Configuration config = new Configuration();
//		
//		config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
//		config.setDictionaryPath("src\\main\\resources\\1874.dic");
//		config.setLanguageModelPath("src\\main\\resources\\1874.lm");
//		
//		try {
//			LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
//			speech.startRecognition(true);
//			
//			SpeechResult speechResult = null;
//			
//			while ((speechResult = speech.getResult()) != null) {
//				String voiceCommand = speechResult.getHypothesis();
//				System.out.println("Voice Command is " + voiceCommand);
//				
//				
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}
//}
