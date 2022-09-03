import java.util.Scanner;

public class Clock {
	public Clock(int h, int m, int s){
		this.h = h;
		this.m = m;
		this.s = s;
	}
	private int h;
	private int m;
	private int s;

	@Override
	public String toString() {
		return h + ":" + m + ":" + s;
	}

	private String twoDigit(int time){
		return "0";
	}

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		System.out.println("Hour?");
        int hour = scanner.nextInt();
        System.out.println("Minute?");
        int minute = scanner.nextInt();
        System.out.println("Second?");
        int second = scanner.nextInt();
		Clock c = new Clock (hour, minute, second);
		System.out.println(c);
	}
}
