package heavy_exercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class app {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app window = new app();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter N");
		lblNewLabel.setBounds(27, 34, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane textN = new JTextPane();
		textN.setBounds(106, 34, 260, 21);
		frame.getContentPane().add(textN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 144, 776, 181);
		frame.getContentPane().add(scrollPane);
		
		JTextArea txt_display = new JTextArea();
		txt_display.setText("result");
		scrollPane.setViewportView(txt_display);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 357, 776, 181);
		frame.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][]", "[][][][][][]"));
		
		JRadioButton btn_showPrime = new JRadioButton("Show elements are Prime numer");
		panel.add(btn_showPrime, "cell 0 0");
		
		JRadioButton btn_dropRow = new JRadioButton("Drop a row");
		panel.add(btn_dropRow, "cell 8 0");
		
		JRadioButton btn_totalEven = new JRadioButton("Total of even elements");
		panel.add(btn_totalEven, "cell 0 1");
		
		JRadioButton btn_totalMainDiagonal = new JRadioButton("Total of elements are main diagonal");
		panel.add(btn_totalMainDiagonal, "cell 8 1");
		
		JRadioButton btn_countNegPos = new JRadioButton("Count negative & positive elements ");
		panel.add(btn_countNegPos, "cell 0 2,aligny bottom");
		
		JRadioButton btn_permutate = new JRadioButton("Permutate max row & min row");
		panel.add(btn_permutate, "cell 8 2");
		
		JRadioButton btn_findMin = new JRadioButton("Find min element");
		panel.add(btn_findMin, "cell 0 3");
		
		JRadioButton btn_perfect = new JRadioButton("Find max Perfect number");
		panel.add(btn_perfect, "cell 8 3");
		
		JRadioButton btn_findMaxRow = new JRadioButton("Find max total of row");
		panel.add(btn_findMaxRow, "cell 0 4");
		
		JRadioButton btn_avgMinCol = new JRadioButton("Average min elements on columns");
		panel.add(btn_avgMinCol, "cell 8 4");
		
		JRadioButton btn_showRowNeg = new JRadioButton("Show rows have negative number");
		panel.add(btn_showRowNeg, "cell 0 5");
		
		JRadioButton btn_sort = new JRadioButton("Sort matrix Increasing");
		panel.add(btn_sort, "cell 8 5");
		
		JButton btn_Generate = new JButton("Generate Random Matrix");
		btn_Generate.setBounds(404, 29, 205, 25);
		frame.getContentPane().add(btn_Generate);
		
		JButton btn_handing = new JButton("Handing");
		btn_handing.setBounds(632, 29, 114, 25);
		frame.getContentPane().add(btn_handing);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(0, 139, 788, 4);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btn_showOrigin = new JButton("Original matrix");
		btn_showOrigin.setBounds(12, 116, 141, 25);
		frame.getContentPane().add(btn_showOrigin);
		
		JButton btnNewButton_4 = new JButton("Result");
		btnNewButton_4.setBounds(155, 116, 114, 25);
		frame.getContentPane().add(btnNewButton_4);
	}
}
