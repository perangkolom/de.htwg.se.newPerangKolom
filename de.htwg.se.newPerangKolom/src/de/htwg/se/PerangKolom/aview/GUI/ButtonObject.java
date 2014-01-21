package de.htwg.se.PerangKolom.aview.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;
import java.util.prefs.BackingStoreException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

import org.apache.log4j.helpers.AbsoluteTimeDateFormat;

import de.htwg.se.PerangKolom.controller.IPerangKolomController;
import de.htwg.se.PerangKolom.controller.impl.PerangKolomController;

public class ButtonObject extends JFrame{

	private JPanel buttonPanel;
	private JPanel centrePanel;
	private JLabel valueOfCellLabel;
	private JButton buttonTop;
	private JButton buttonRight;
	private JButton buttonBottom;
	private JButton buttonLeft;
	
	private IPerangKolomController controller;
	
	private final int BUTTONWIDE = 45;
	private final int BUTTONHEIGHT = 10;
	private Map<Integer, JButton> treeMap;
	
	public ButtonObject(int x, int y, String cellValue){
		
		this.buttonPanel = new JPanel();
		this.centrePanel = new JPanel();
		this.valueOfCellLabel = new JLabel(cellValue);
		this.buttonTop = new JButton("");
		this.buttonRight = new JButton("");
		this.buttonBottom = new JButton("");
		this.buttonLeft = new JButton("");
		this.treeMap = new TreeMap<Integer, JButton>();
		this.controller = new PerangKolomController();
		
		treeMap.put(1, buttonTop);
		treeMap.put(2, buttonRight);
		treeMap.put(3, buttonBottom);
		treeMap.put(4, buttonLeft);
		valueOfCellLabel.setBackground(null);
		buttonPanel.setLayout(null);

		buttonTop.setContentAreaFilled(false);
		buttonTop.setBorderPainted(false);
		buttonTop.setOpaque(false);
		buttonTop.setRolloverEnabled(false);
//		buttonTop.setBackground(new Color(0,0,0,0));
		
		buttonRight.setContentAreaFilled(false);
		buttonRight.setBorderPainted(false);
		buttonRight.setOpaque(false);
		buttonRight.setRolloverEnabled(false);
		
		buttonBottom.setContentAreaFilled(false);
		buttonBottom.setBorderPainted(false);
		buttonBottom.setOpaque(false);
		buttonBottom.setRolloverEnabled(false);
		
		buttonLeft.setContentAreaFilled(false);
		buttonLeft.setBorderPainted(false);
		buttonLeft.setOpaque(false);
		buttonLeft.setRolloverEnabled(false);
		
		centrePanel.setOpaque(false);
		
		buttonTop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonTop.setContentAreaFilled(true);
				buttonTop.setBackground(Color.gray);
				buttonTop.setEnabled(false);
				
//				controller.;
				
			}
		});
		
		buttonRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonRight.setContentAreaFilled(true);
				buttonRight.setBackground(Color.gray);
				buttonRight.setEnabled(false);
				
			}
		});
		
		buttonBottom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonBottom.setContentAreaFilled(true);
				buttonBottom.setBackground(Color.gray);
				buttonBottom.setEnabled(false);
				
			}
		});
		
		buttonLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonLeft.setContentAreaFilled(true);
				buttonLeft.setBackground(Color.gray);
				buttonLeft.setEnabled(false);
				
			}
		});

		
		buttonPanel.setBounds(x, y, 75, 75);
		buttonPanel.setOpaque(false);
		centrePanel.setBounds(10, 10, 50, 50);
		centrePanel.setBackground(Color.BLUE);
//		centrePanel.setOpaque(false); //sets the cell invisible
		
		
		/* add Buttons to panel */
		buttonPanel.add(buttonTop).setBounds(13, 0, BUTTONWIDE, BUTTONHEIGHT);
		buttonPanel.add(buttonRight).setBounds(60, 13, BUTTONHEIGHT, BUTTONWIDE);
		buttonPanel.add(buttonBottom).setBounds(13, 60, BUTTONWIDE, BUTTONHEIGHT);
		buttonPanel.add(buttonLeft).setBounds(0, 13, BUTTONHEIGHT, BUTTONWIDE);
		buttonPanel.add(centrePanel);
		centrePanel.add(valueOfCellLabel).setBounds(40, 45, 20, 20);
		valueOfCellLabel.setBackground(Color.DARK_GRAY);
		valueOfCellLabel.setForeground(Color.WHITE);
		valueOfCellLabel.setVisible(true);
//		valueOfCellLabel.setSize(20, 20);
		valueOfCellLabel.setOpaque(true);


		
	}
	 
	public JPanel getPanel(){
		return buttonPanel;
	}
	
	public Map<Integer, JButton> getMap(){
		return this.treeMap;
	}
	
}
