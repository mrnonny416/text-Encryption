import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;

public class MainGUI {
	
	private JFrame frmEncyptionprogram;
	private JTextField txtBrowseFile;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtOutFile;
	private JLabel lblOutFile;
	private JLabel lblKey;
	private JPasswordField txtKey;
	private String fileBrowseName;
	public Encrypt encrypt;
	public File file;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					window.frmEncyptionprogram.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LineBorder lineBorder = new LineBorder(Color.black, 5, true);
		frmEncyptionprogram = new JFrame();
		frmEncyptionprogram.setResizable(false);
		frmEncyptionprogram.setAlwaysOnTop(false);
		frmEncyptionprogram.setBackground(new Color(0, 0, 0));
		frmEncyptionprogram.getContentPane().setBackground(new Color(255, 69, 0));
		frmEncyptionprogram.getContentPane().setForeground(new Color(255, 255, 255));
		frmEncyptionprogram.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Private File\\1\\0.jpg"));
		frmEncyptionprogram.setTitle("EncyptionProgram");
		frmEncyptionprogram.setForeground(new Color(255, 255, 255));
		frmEncyptionprogram.setBounds(100, 100, 711, 311);
		frmEncyptionprogram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));

		lblNewLabel = new JLabel(
				"\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21\u0E40\u0E02\u0E49\u0E32\u0E23\u0E2B\u0E31\u0E2A\u0E44\u0E1F\u0E25\u0E4C\u0E02\u0E49\u0E2D\u0E04\u0E27\u0E32\u0E21");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("TH Sarabun New", Font.BOLD, 30));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frmEncyptionprogram.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(panel, GroupLayout.PREFERRED_SIZE, 676,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel))))
						.addContainerGap(177, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(5).addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE).addContainerGap()));
		JLabel lblFile = new JLabel("FILE : ");
		lblFile.setForeground(new Color(0, 0, 0));
		lblFile.setFont(new Font("TH SarabunPSK", Font.BOLD, 30));

		txtBrowseFile = new JTextField();
		txtBrowseFile.setBackground(new Color(211, 211, 211));
		txtBrowseFile.setEditable(false);
		txtBrowseFile.setToolTipText("Browse File");
		txtBrowseFile.setFont(new Font("TH Sarabun New", Font.PLAIN, 23));
		txtBrowseFile.setColumns(10);
		txtBrowseFile.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));

		JButton btnBrowse = new JButton("BROWSE");
		btnBrowse.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnBrowse.setBackground(new Color(50, 205, 50));
		btnBrowse.setForeground(new Color(255, 255, 255));
		btnBrowse.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		btnBrowse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser browseFile = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text/txt file", "txt", "*.txt");
				browseFile.addChoosableFileFilter(filter);

				int ret = browseFile.showDialog(null, "Choose File");
				if (ret == JFileChooser.APPROVE_OPTION) {
					fileBrowseName = browseFile.getSelectedFile().toString();
					file =  new File(browseFile.getSelectedFile(), fileBrowseName);
					txtBrowseFile.setText(fileBrowseName);
					try {
						encrypt = new Encrypt(browseFile.getSelectedFile(), fileBrowseName);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txtOutFile.setText(encrypt.changName());
				}
			}

		});

		txtOutFile = new JTextField();
		txtOutFile.setToolTipText("Browse File");
		txtOutFile.setFont(new Font("TH Sarabun New", Font.PLAIN, 23));
		txtOutFile.setEditable(false);
		txtOutFile.setColumns(10);
		txtOutFile.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));
		txtOutFile.setBackground(new Color(211, 211, 211));
		lblOutFile = new JLabel("Out FILE : ");
		lblOutFile.setForeground(Color.BLACK);
		lblOutFile.setFont(new Font("TH SarabunPSK", Font.BOLD, 30));

		lblKey = new JLabel("KEY : ");
		lblKey.setForeground(Color.BLACK);
		lblKey.setFont(new Font("TH SarabunPSK", Font.BOLD, 30));

		txtKey = new JPasswordField();
		txtKey.setBackground(new Color(255, 255, 255));
		txtKey.setFont(new Font("TH Sarabun New", Font.PLAIN, 27));
		txtKey.setEchoChar('*');
		txtKey.setBorder(new LineBorder(new Color(192, 192, 192), 2, true));

		JProgressBar barStatsu = new JProgressBar();
		barStatsu.setStringPainted(true);
		barStatsu.setForeground(new Color(30, 144, 255));

		JButton btnEncrypt = new JButton("ENCRYPT");
		btnEncrypt.setForeground(new Color(0, 0, 0));
		btnEncrypt.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		btnEncrypt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEncrypt.setBackground(new Color(100, 149, 237));

		JLabel lblStatus = new JLabel("status : ");
		lblStatus.setForeground(Color.BLACK);
		lblStatus.setFont(new Font("TH SarabunPSK", Font.BOLD, 30));

		JButton btnDecrypt = new JButton("DeCRYPT");
		btnDecrypt.setForeground(Color.BLACK);
		btnDecrypt.setFont(new Font("TH Sarabun New", Font.BOLD, 30));
		btnDecrypt.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnDecrypt.setBackground(new Color(143, 188, 143));

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblFile)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtBrowseFile, GroupLayout.PREFERRED_SIZE, 451,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnBrowse, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblOutFile)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtOutFile))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblKey)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(txtKey,
														GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup().addComponent(lblStatus)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(barStatsu,
														GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)))
										.addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnEncrypt, GroupLayout.PREFERRED_SIZE, 118,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnDecrypt, GroupLayout.PREFERRED_SIZE, 118,
														GroupLayout.PREFERRED_SIZE)))))
				.addGap(185)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblFile)
								.addComponent(txtBrowseFile, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnBrowse, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOutFile, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOutFile, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKey, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtKey, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEncrypt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStatus, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(barStatsu, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
								.addComponent(btnDecrypt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		panel.setLayout(gl_panel);
		frmEncyptionprogram.getContentPane().setLayout(groupLayout);
	}
	

}

