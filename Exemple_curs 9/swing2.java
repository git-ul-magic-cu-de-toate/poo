import javax . swing .*;
import java . awt .*;
import java . awt. event .*;
class ExempluSwing extends JFrame implements ActionListener {
	public ExempluSwing ( String titlu ) {
		super ( titlu );
		setLayout (new FlowLayout ());
		add( new JLabel ("Swing"));
		JButton b = new JButton ("Close");
		b. addActionListener ( this );
		add(b);
		setVisible (true);
		show ();
	}
	public void actionPerformed ( ActionEvent e) {
		System . exit (0);
	}
	public static void main ( String args []) {
		new ExempluSwing (" Hello ");
	}
}