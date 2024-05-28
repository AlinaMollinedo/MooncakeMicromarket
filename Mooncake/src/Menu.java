import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 414);
		setResizable(false);
		setTitle("Menu Principal");
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredBg = new JLayeredPane();
		layeredBg.setBounds(0, 0, 722, 377);
		contentPane.add(layeredBg, JLayeredPane.DEFAULT_LAYER);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setBounds(0, 0, 736, 378);
		Image img = new ImageIcon(this.getClass().getResource("/bg.jpeg")).getImage();
		background.setIcon(new ImageIcon(img));
		layeredBg.add(background);
		
		
		setVisible(true);
	}
}
