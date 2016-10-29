package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTree;

public class TestSwing extends JFrame {

	
	public ArrayList<String> arrBP = new ArrayList<String>();
	public ArrayList<String> arrSP = new ArrayList<String>();
	public ArrayList<String> arrAC = new ArrayList<String>();
	
	private JPanel contentPane;
	DefaultMutableTreeNode BusinessProcess = null;
	DefaultMutableTreeNode Step = null;
	DefaultMutableTreeNode Action = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSwing frame = new TestSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 715);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(0, 27, 714, 300);
		textArea.setFont(new Font("Calibri", Font.ITALIC, 20));
		textArea.setSelectedTextColor(Color.red);
		contentPane.add(textArea);

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(textArea, popupMenu);

		JMenuItem mntmHighlightVerb = new JMenuItem("Highlight Verb");
		JMenuItem mntmHighlightNoun = new JMenuItem("Highlight Noun");
		JMenuItem mntmAddBuisnessProcess = new JMenuItem("Add Business Process");
		JMenuItem mntmAddStep = new JMenuItem("Add Step");
		JMenuItem mntmAddAction = new JMenuItem("Add Action");

		mntmHighlightVerb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					HighlightSelectedWord();
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void HighlightSelectedWord() throws BadLocationException {

				textArea.getHighlighter().addHighlight(textArea.getSelectionStart(), textArea.getSelectionEnd(),
						new DefaultHighlighter.DefaultHighlightPainter(Color.yellow));

			}

		});

		mntmHighlightNoun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				try {
					HighlightSelectedWord();
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void HighlightSelectedWord() throws BadLocationException {

				textArea.getHighlighter().addHighlight(textArea.getSelectionStart(), textArea.getSelectionEnd(),
						new DefaultHighlighter.DefaultHighlightPainter(Color.green));

			}

		});

		mntmAddBuisnessProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg2) {
				try {
					AddVerbNounPairAsBusinessProcess();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void AddVerbNounPairAsBusinessProcess() {

				arrBP.add(textArea.getSelectedText());
			}
		});

		mntmAddStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg3) {
				try {
					AddVerbNounPairAsStep();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void AddVerbNounPairAsStep() {
				arrSP.add(textArea.getSelectedText());
			}
		});

		mntmAddAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg4) {
				try {
					AddVerbNounPairAsAction();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			public void AddVerbNounPairAsAction() {
				arrAC.add(textArea.getSelectedText());
			}
		});

		popupMenu.add(mntmHighlightVerb);
		popupMenu.add(mntmHighlightNoun);
		popupMenu.add(mntmAddBuisnessProcess);
		popupMenu.add(mntmAddStep);
		popupMenu.add(mntmAddAction);

		JLabel lblInputDescription = new JLabel("Input Description");
		lblInputDescription.setBounds(0, 4, 144, 20);
		contentPane.add(lblInputDescription);

		JButton btnNewButton = new JButton("Display Profile Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(
						"Course:SDP_CSE5322 \n Project:Requirement Extraction Tool");
			}
		});
		btnNewButton.setActionCommand("btnDisplayProfile");
		btnNewButton.setBounds(729, 23, 204, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Import File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser();
				String FileName = null;
				int returnval = jfc.showOpenDialog(null);
				if (JFileChooser.APPROVE_OPTION == returnval) {
					File file = jfc.getSelectedFile();
					FileName = file.getAbsolutePath();
				}
				String strInputFile = new String();
				ImportFile objImpFile = new ImportFile();
				strInputFile = objImpFile.FetchInputData(FileName);
				if (strInputFile != null) {
					textArea.setText(strInputFile);
				} else {
					textArea.setText("");
				}
			}
		});

		btnNewButton_1.setBounds(729, 68, 204, 29);
		contentPane.add(btnNewButton_1);

		JButton btnGenerateRequirements = new JButton("Generate Requirements");
		btnGenerateRequirements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTree tree = null;
				DefaultMutableTreeNode top = new DefaultMutableTreeNode("Requirements");
				createNodes(top);
				tree = new JTree(top);
				contentPane.add(tree);
				tree.setBounds(10, 343, 704, 300);

			}

			private void createNodes(DefaultMutableTreeNode top) {

				for (int i = 0; i < arrBP.size(); i++) {
					BusinessProcess = new DefaultMutableTreeNode(arrBP.get(i));
					top.add(BusinessProcess);
					
					BusinessProcess.setUserObject(arrBP);
					for (int j = 0; j < arrSP.size(); j++) {
						Step = new DefaultMutableTreeNode(arrSP.get(j));
						BusinessProcess.add(Step);

						for (int k = 0; k < arrAC.size(); k++) {
							Action = new DefaultMutableTreeNode(arrAC.get(k));
							Step.add(Action);
						}

					}

				}

			}
		});
		btnGenerateRequirements.setBounds(729, 113, 204, 29);
		contentPane.add(btnGenerateRequirements);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
