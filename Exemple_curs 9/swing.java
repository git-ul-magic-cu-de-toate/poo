import javax . swing .*;
import java . awt .*;
import java . awt. event .*;
class ExempluSwing extends JFrame implements ActionListener {
	public ExempluSwing ( String titlu ) {
		super ( titlu );
		// Metoda setLayout nu se aplica direct ferestrei
		getContentPane (). setLayout (new FlowLayout ());
		// Componentele au denumiri ce incep cu litera J
		getContentPane ().add( new JLabel ("Swing"));
		JButton b = new JButton ("Close");
		b. addActionListener ( this );
		// Metoda add nu se aplica direct ferestrei
		getContentPane ().add(b);
		pack ();
		show ();
	}
	public void actionPerformed ( ActionEvent e) {
		// Tratarea evenimentelor se face ca in AWT
	System . exit (0);
	}
	public static void main ( String args []) {
		new ExempluSwing (" Hello ");
	}
}