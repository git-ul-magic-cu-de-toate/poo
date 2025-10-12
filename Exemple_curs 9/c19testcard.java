import java . awt .*;
import java . awt. event .*;
class TestCardLayout extends Frame implements ActionListener {
	Panel tab;
	public TestCardLayout () {
		super (" Test CardLayout ");
		Button card1 = new Button (" Card 1");
		Button card2 = new Button (" Card 2");
		Panel butoane = new Panel ();
		butoane . add( card1 );
		butoane . add( card2 );
		tab = new Panel ();
		tab . setLayout ( new CardLayout ());
		TextField tf = new TextField (" Text Field ");
		Button btn = new Button (" Button ");
		tab .add (" Card 1", tf);
		tab .add (" Card 2", btn);
		add ( butoane , BorderLayout . NORTH );
		add (tab , BorderLayout . CENTER );
		pack ();
		show ();
		card1 . addActionListener ( this );
		card2 . addActionListener ( this );
}
public void actionPerformed ( ActionEvent e) {
	CardLayout gestionar = ( CardLayout ) tab. getLayout ();
	gestionar . show (tab , e. getActionCommand ());
}
public static void main ( String args []) {
	TestCardLayout f = new TestCardLayout ();
	f. show ();
}
}