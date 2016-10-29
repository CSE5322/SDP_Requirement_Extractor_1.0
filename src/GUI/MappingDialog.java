package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

import BusinessObjects.Repository;

public class MappingDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Repository repository;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MappingDialog dialog = new MappingDialog(true, true, false, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MappingDialog(boolean showVerbNounPair, boolean showSequenceNumber, boolean showParentBusinessProcess, boolean showParentStep) {		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Map");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		{
			JPanel optionsPanel = new JPanel();
			optionsPanel.setLayout(new GridLayout(0,2,5,10));
			getContentPane().add(optionsPanel, BorderLayout.WEST);	
			
			{
				if(showVerbNounPair)
				{
					JLabel lblVerbNounPair = new JLabel("Verb Noun Pair : ");
					JLabel lblVerbNounValue = new JLabel("Verb Noun Value");
					optionsPanel.add(lblVerbNounPair);
					optionsPanel.add(lblVerbNounValue);
				}
				
				if(showSequenceNumber)
				{
					JLabel lblSequenceNumber = new JLabel("Sequence Number : ");
					JComboBox<String> cbSequenceNumber = new JComboBox<>(new String[] {"Seq no", "Head First Java"});
					optionsPanel.add(lblSequenceNumber);
					optionsPanel.add(cbSequenceNumber);
				}
				
				if(showParentBusinessProcess)
				{
					JLabel lblParentBusinessProcess = new JLabel("Parent Business Process : ");
					JComboBox<String> cbParentBusinessProcess = new JComboBox<>(new String[] {"Business", "Head First Java"});
					optionsPanel.add(lblParentBusinessProcess);
					optionsPanel.add(cbParentBusinessProcess);
				}
				
				if(showParentStep)
				{
					JLabel lblParentStep = new JLabel("Parent Step : ");
					JComboBox<String> cbParentStep = new JComboBox<>(new String[] {"Step", "Head First Java"});				
					optionsPanel.add(lblParentStep);
					optionsPanel.add(cbParentStep);
				}
				
			}			

		}
		
		this.pack();

	}
	
	public static void setRepository(Repository repository) {
		MappingDialog.repository = repository;
	}

}
