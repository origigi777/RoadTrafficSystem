package Ori.Project;

/**
 * This Class holds the ruining time of the whole program 
 */
public class Timer extends Thread {
	private int timerSec = 0;
	private int timerMinutes = 0;
	private boolean ifTimeRun = true;
	DrivingGame drivingGame;


	public Timer(DrivingGame drivingGame) {
		this.drivingGame = drivingGame;
	}


	public void run() {
		//keeps timer alive as the program still running
		while (this.ifTimeRun) {
			timerSec++;
			System.out.println(this.toString());
			try {



				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	/**
	 * holds The flag responsible for stopping the Timer 
	 */
	public void setIfTimeRun(boolean ifTimeRun) {

		this.ifTimeRun = ifTimeRun;
	}

	/**
	 * holds The time unites switch 
	 */
	public int getTimerSec() {
		if (timerSec == 59) {
			timerMinutes++;
		}
		if(timerSec==60) {
			timerSec = 0;
		}

		return timerSec;

	}

	public int getTimerMinutes() {
		return timerMinutes;
	}

	private String secString() {
		int i=getTimerSec();
		if (i < 10) {
			return "0" +i;
		}
		else {
			return Integer.toString(i);
		}
	}

	private String MinString() {

		if (this.timerMinutes < 10) {
			return "0" + this.timerMinutes;
		}

		return Integer.toString(timerMinutes);

	}
	/**
	 * return the running time of the program as string 
	 */

	@Override
	public String toString() {
		return "Time: " + this.MinString() + ":" + this.secString();
	}

}
