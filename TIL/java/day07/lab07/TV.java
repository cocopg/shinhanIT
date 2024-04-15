package com.shinhan.day07.lab07;

public class TV implements Volume {
	int volLevel;

	@Override
	public void volumeUp(int vol) {
		volLevel += vol;
		System.out.println(getClass().getSimpleName() + "볼륨 올립니다." + volLevel);
	}

	@Override
	public void volumeDown(int vol) {
		volLevel -= vol;
		if (volLevel < 0)
			volLevel = 0;
		System.out.println(getClass().getSimpleName() + "볼륨 내립니다." + volLevel);
	}

}
