package os2_project;

import java.util.Random;
import java.util.concurrent.Semaphore;

import javax.swing.JTextField;

public class Student implements Runnable{
	private final Semaphore ta;
	private final Semaphore chairs;
	private JTextField TA_working,TA_sleeping,Student_Waiting,Students_Later;
	public Student(Semaphore ta,Semaphore chairs,JTextField TA_W,JTextField TA_S,JTextField S_W,JTextField S_L) {
		this.chairs=chairs;
		this.ta = ta;
		this.TA_working = TA_W;
		this.TA_sleeping = TA_S;
		this.Student_Waiting = S_W;
		this.Students_Later = S_L;
				
	}
	private void updateCount(JTextField field,int value) {
		synchronized (field) {
			int val = Integer.parseInt(field.getText())+value;
			field.setText(Integer.toString(val));
		}
	}
	private void waitForRandomTime() throws InterruptedException{
		Random random = new Random();
		int delay = random.nextInt(3500)+1000;
		Thread.sleep(delay);
	}
	@Override
	public void run() {
			try {
				if(ta.tryAcquire()) {
					updateCount(TA_working,1);
					updateCount(TA_sleeping, -1);
					updateCount(Students_Later,-1);
					waitForRandomTime();
					updateCount(TA_working,-1);
					updateCount(TA_sleeping, 1);
					ta.release();
				}else {
					if(chairs.tryAcquire()) {
						updateCount(Student_Waiting,1);
						updateCount(Students_Later,-1);
						ta.acquire();
						chairs.release();
						updateCount(Student_Waiting,-1);
						updateCount(TA_working,1);
						updateCount(TA_sleeping,-1);
						waitForRandomTime();
						updateCount(TA_sleeping,1);
						updateCount(TA_working,-1);
						ta.release();
					}
					else {
						chairs.acquire();
						updateCount(Student_Waiting,1);
						updateCount(Students_Later,-1);
						ta.acquire();
						updateCount(TA_working,1);
						updateCount(TA_sleeping,-1);
						updateCount(Student_Waiting,-1);
						chairs.release();
						waitForRandomTime();
						updateCount(TA_working,-1);
						updateCount(TA_sleeping,1);
						ta.release();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
}
