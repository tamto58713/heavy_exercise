package heavy_exercise;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class app {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	protected int number;
	protected int[][] a;
	protected String txtOrigin, txtResult, txt;
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
	private boolean isNaN(String numberString) {
		
		if (numberString.length() == 0)
			return true;
		int i = 0;
		while (i < numberString.length()) {
			if ((numberString.charAt(i) < 48) ||(numberString.charAt(i) > 57))
				return true;
			i++;
		}
		return false;
	}
	private boolean checkPrime (int number) {
		if (number < 2)
			return false;
		int root = (int) Math.sqrt(number), i = 2;
		while (i <= root) {
			if (number % i == 0)
				return false;
			i++;
		}
		return true;
	}
	private boolean checkPerfect(int number) {
		if (number < 6) 
			return false;
		int root = (int) Math.sqrt(number), i = 2, divisor = 1;
		while (i <= root) {
			if (number % i == 0) {
				divisor += i + number/i;
			}
			i++;
		}
		return (divisor == number) ? true:false;
	}
	private void initialize() {
		frame =new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter N");
		lblNewLabel.setBounds(27, 34, 66, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane txtN = new JTextPane();
		txtN.setBounds(106, 34, 260, 21);
		frame.getContentPane().add(txtN);
		
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
		btn_showPrime.setActionCommand("1");
		btn_showPrime.setSelected(true);
		panel.add(btn_showPrime, "cell 0 0");
		
		JRadioButton btn_dropRow = new JRadioButton("Drop a row");
		btn_dropRow.setActionCommand("2");
		panel.add(btn_dropRow, "cell 8 0");
		
		JRadioButton btn_totalEven = new JRadioButton("Total of even elements");
		btn_totalEven.setActionCommand("3");
		panel.add(btn_totalEven, "cell 0 1");
		
		JRadioButton btn_totalMainDiagonal = new JRadioButton("Total of elements are main diagonal");
		btn_totalMainDiagonal.setActionCommand("4");
		panel.add(btn_totalMainDiagonal, "cell 8 1");
		
		JRadioButton btn_countNegPos = new JRadioButton("Count negative & positive elements ");
		btn_countNegPos.setActionCommand("5");
		panel.add(btn_countNegPos, "cell 0 2,aligny bottom");
		
		JRadioButton btn_permutate = new JRadioButton("Permutate max row & min row");
		btn_permutate.setActionCommand("6");
		panel.add(btn_permutate, "cell 8 2");
		
		JRadioButton btn_findMin = new JRadioButton("Find min element");
		btn_findMin.setActionCommand("7");
		panel.add(btn_findMin, "cell 0 3");
		
		JRadioButton btn_perfect = new JRadioButton("Find max Perfect number");
		btn_perfect.setActionCommand("8");
		panel.add(btn_perfect, "cell 8 3");
		
		JRadioButton btn_findMaxRow = new JRadioButton("Find max total of row");
		btn_findMaxRow.setActionCommand("9");
		panel.add(btn_findMaxRow, "cell 0 4");
		
		JRadioButton btn_avgMinCol = new JRadioButton("Average min elements on columns");
		btn_avgMinCol.setActionCommand("10");
		panel.add(btn_avgMinCol, "cell 8 4");
		
		JRadioButton btn_showRowNeg = new JRadioButton("Show rows have negative number");
		btn_showRowNeg.setActionCommand("11");
		panel.add(btn_showRowNeg, "cell 0 5");
		
		JRadioButton btn_sort = new JRadioButton("Sort matrix Increasing");
		btn_sort.setActionCommand("12");
		panel.add(btn_sort, "cell 8 5");
		
		
		ButtonGroup btn_group = new ButtonGroup();
			btn_group.add(btn_showPrime);
			btn_group.add(btn_dropRow);
			btn_group.add(btn_totalEven);
			btn_group.add(btn_totalMainDiagonal);
			btn_group.add(btn_countNegPos);
			btn_group.add(btn_permutate);
			btn_group.add(btn_findMin);
			btn_group.add(btn_perfect);
			btn_group.add(btn_findMaxRow);
			btn_group.add(btn_avgMinCol);
			btn_group.add(btn_showRowNeg);
			btn_group.add(btn_sort);
		
		
		JButton btn_Generate = new JButton("Generate Random Matrix");
		btn_Generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt = txtN.getText();
				if (isNaN(txt)) {
					JOptionPane.showMessageDialog(frame, "Error! You have to enter a postive number!");
					txtN.setText("");
				}
				else {
					number = Integer.parseInt(txt);
					a = new int[20][20];
					txtOrigin = "";
					txtResult = "";
					for (int i = 0; i < number; i++) {
						for (int j = 0; j < number; j++) {
							a[i][j] = (int) (Math.random() * 101) - 50;
							txtOrigin += Integer.toString(a[i][j]) + "\t";
						}
						txtOrigin += "\n\n";
					}
					
					txt_display.setText(txtOrigin);
					
				}	
				
				}
				
		});
		btn_Generate.setBounds(404, 29, 205, 25);
		frame.getContentPane().add(btn_Generate);
		
		JButton btn_handing = new JButton("Handing");
		btn_handing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String action = btn_group.getSelection().getActionCommand();
				txtN.setText(txt);
				if (action == "1") {
					txtResult = "";
				for (int i = 0; i < number; i++)
					for (int j = 0; j < number; j++)
						if (checkPrime(a[i][j]))
							txtResult += Integer.toString(a[i][j]) + "\t";
				}
				else if (action == "2") {
					txtResult = "";
					boolean flag = false;
					String txt = "";
					do {
						txt = JOptionPane.showInputDialog("Enter row that you want to Drop!");
						if (txt == null)
							flag = false;
						else
							flag = !isNaN(txt);
						
						if (!flag)
							JOptionPane.showMessageDialog(frame, "Error! You have to enter a positive number!");
					} 
					while (!flag);
					
					int col = Integer.parseInt(txt);
					int b[][] = a;
					txtResult = "";
					for (int i = 0; i < number; i++) {
						for (int j = 0; j < number; j++) {
							if (i < col)
								b[i][j] = a[i][j];
							else 
								b[i][j] = a[i+1][j];
							if (i < number - 1)
								txtResult += Integer.toString(b[i][j]) + "\t";
						}
						txtResult += "\n\n";
					}
					
					
				}
				else if (action == "3") {
					txtResult = "";
					long sum = 0;
					for (int i = 0; i < number; i++)
						for (int j = 0; j < number; j++)
							if (a[i][j] % 2 == 0)
								sum += a[i][j];
					txtResult += Long.toString(sum);	
				}
				else if (action == "4") {
					txtResult = "";
					long sum = 0;
					for (int i = 0; i < number; i++)
						sum += a[i][i];
					txtResult += Long.toString(sum);
				}
				else if (action == "5") {
					txtResult = "";
					int negative = 0, positive = 0;
					for (int i = 0; i < number; i++)
						for (int j = 0; j < number; j++)
							if (a[i][j] < 0)
								negative++;
							else
								positive ++;
					txtResult += " Negative: " + Integer.toString(negative) + "\n\n" + " Positive: " + Integer.toString(positive);
					
				}
				else if (action == "6") {
					txtResult = "";
					long min = 1000000000, max = -1000000000, sum = 0;
					int posMin = -1, posMax = -1;
					for (int i = 0; i < number; i++) {
						sum = 0;
						for (int j = 0; j < number; j++)
							sum += a[i][j];
						
						if (sum > max) {
							max = sum;
							posMax = i;
						}
						if (sum < min) {
							min = sum;
							posMin = i;
						}
					}
					int [][]b = new int[20][20];
 					for (int i = 0; i < number; i++) {
						for (int j = 0; j < number; j++) {
							if (i == posMin) {
								b[i][j] = a[posMax][j];
							}	
							else if (i == posMax) {
								b[i][j] = a[posMin][j];
							}	
							else {
								b[i][j] = a[i][j];
							}
						}	
					}
 					for (int i = 0; i < number; i++) {
						for (int j = 0; j < number; j++) {
							txtResult += Integer.toString(b[i][j]) + "\t";
						}
						txtResult += "\n\n"; 	
					}
 					
 					
				}
				else if (action == "7") {
					txtResult = "";
					int min = 100000000;
					for (int i = 0; i < number; i++)
						for (int j = 0; j < number; j++) 
							if (a[i][j] < min) 
								min = a[i][j];
					txtResult = Integer.toString(min);
					
				}
				else if (action == "8") {
					txtResult = "";
					int max = -1;
					for (int i = 0; i < number; i++)
						for (int j = 0; j < number; j++) 
							if (checkPerfect(a[i][j]) && (a[i][j] > max))
								max = a[i][j];
					if (max > 0)
						txtResult += Integer.toString(max);
					else
						txtResult += "Nothing!";
					
				}
				else if (action == "9") {
					txtResult = "";
					long max = -100000000;
					int pos = -1;
					for (int i = 0; i < number; i++) {
						long sum = 0;
						for (int j = 0; j < number; j++) 
							sum += a[i][j];
						if (sum > max) {
							max = sum;
							pos = i;
						}
					}
					txtResult = "Max row: " + pos + ". Total: " + Long.toString(max) + "\n\n";
					for (int i = 0; i < number; i++ )
						txtResult += Integer.toString(a[pos][i]) + "\t";
				}
				else if (action == "10") {
					txtResult = "";
					int avg = 0;
					for (int i = 0; i < number; i++) {
						int min = 100000000;
						for (int j = 0; j < number; j++)
							if (a[j][i] < min)
								min = a[j][i];
						avg += min;
					}
					txtResult += Double.toString((double) avg/number);
					
				}
				else if (action == "11") {
					txtResult = "";
					for (int i = 0; i < number; i++) {
						boolean flag = false;
						for (int j = 0; j < number; j++)
							if (a[i][j] < 0) {
								flag = true;
								continue;
							}
						
						if (flag) {
							for (int j = 0; j < number; j++) {
								txtResult += Integer.toString(a[i][j]) + "\t";
							}
							txtResult += "\n\n";
						}	
					}	
				}
				else {
					txtResult = "";
					int k = 0;
					int[] b = new int [400];
					for (int i = 0; i < number; i++)
						for (int j = 0; j < number; j++) {
							b[k++] = a[i][j];
						}
					int len = k;
					
					for (int i = 0; i < len; i++) 
						for (int j = len - 1; j > i; j--) {
							if (b[j] < b[j-1]) {
								int temp = b[j];
								b[j] = b[j-1];
								b[j-1] = temp;
							}
						}
					for (int i = 0; i < len; i++) {
						txtResult += Integer.toString(b[i]) + "\t";
						if ((i + 1) % number == 0) {
							txtResult += "\n\n";
						}
					}
					
				}
				
				
				txt_display.setText(txtResult);
				
			}
				
		});
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
		
		JButton btn_showResult = new JButton("Result");
		btn_showResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txt_display.setText(txtResult);
			}
		});
		btn_showResult.setBounds(161, 116, 114, 25);
		frame.getContentPane().add(btn_showResult);
		
		JButton btn_showOrigin = new JButton("Original matrix");
		btn_showOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_display.setText(txtOrigin);
				
			}
		});
		btn_showOrigin.setBounds(27, 116, 141, 25);
		frame.getContentPane().add(btn_showOrigin);
		
	}
}
