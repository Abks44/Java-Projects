import javax.swing.JFrame;

public class Main {
public static void main(String[] args) {
	JFrame frame = new JFrame("Marking Attendance");
	AttendHere attendHere = new AttendHere();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800, 800);
	frame.setLocationRelativeTo(null);
	frame.add(attendHere);
	
	frame.setVisible(true);
}
}
