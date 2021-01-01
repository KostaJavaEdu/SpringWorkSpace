package kosta.test.vedio;

import kosta.test.service.Player;

public class VedioImpl implements Player {

	@Override
	public void start(int start) {
		System.out.println("VedioImpl start(int start) 호출");

	}

	@Override
	public String pause() {
		System.out.println("VedioImpl pause() 호출");
		return null;
	}

	@Override
	public void stop() {
		System.out.println("VedioImpl stop() 호출");

	}

}
