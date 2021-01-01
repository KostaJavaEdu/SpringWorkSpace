package kosta.test.audio;

import org.springframework.stereotype.Service;

import kosta.test.service.Player;

@Service("audio")
public class AudioImpl implements Player {

	public AudioImpl() {}
	
	@Override
	public void start(int start) {
		System.out.println("AudioImpl 호출");
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String pause() {
		System.out.println("AudioImpl pause() 호출");
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void stop() {
		System.out.println("AudioImpl stop() 호출");
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
