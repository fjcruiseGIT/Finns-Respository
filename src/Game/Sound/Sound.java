package Game.Sound;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class Sound {
	private Clip bgmusic1;
	private Clip bgmusic2;
	private Clip bgmusic3;
	private Clip jubeln;

	public Sound() {

	}

	public void stopAll() {
		if (bgmusic1 != null)
			bgmusic1.stop();
		if (bgmusic2 != null)
			bgmusic2.stop();
		if (bgmusic3 != null)
			bgmusic3.stop();
	}

	public void playj() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(System.class.getResource("/jubeln.wav"));
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format, ((int) ais.getFrameLength() * format.getFrameSize()));
			jubeln = (Clip) AudioSystem.getLine(info);
			jubeln.open(ais);

			FloatControl gainControl = (FloatControl) jubeln.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(1.0F);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jubeln.start();

	}

	public void play1() {
		stopAll();
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(System.class.getResource("/urban.wav"));
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format, ((int) ais.getFrameLength() * format.getFrameSize()));
			bgmusic1 = (Clip) AudioSystem.getLine(info);
			bgmusic1.open(ais);

			FloatControl gainControl = (FloatControl) bgmusic1.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(1.0F);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bgmusic1.start();
		bgmusic1.loop(999);
	}

	public void play2() {
		stopAll();
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(System.class.getResource("/piano.wav"));
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format, ((int) ais.getFrameLength() * format.getFrameSize()));
			bgmusic2 = (Clip) AudioSystem.getLine(info);
			bgmusic2.open(ais);

			FloatControl gainControl = (FloatControl) bgmusic2.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(1.0F);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bgmusic2.start();
		bgmusic2.loop(999);
	}

	public void play3() {
		stopAll();
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(System.class.getResource("/rock.wav"));
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format, ((int) ais.getFrameLength() * format.getFrameSize()));
			bgmusic3 = (Clip) AudioSystem.getLine(info);
			bgmusic3.open(ais);

			FloatControl gainControl = (FloatControl) bgmusic3.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(1.0F);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bgmusic3.start();
		bgmusic3.loop(999);
	}
}
