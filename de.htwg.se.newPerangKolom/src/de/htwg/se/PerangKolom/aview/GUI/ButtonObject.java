package de.htwg.se.PerangKolom.aview.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.htwg.se.PerangKolom.controller.IPKController;
import de.htwg.se.PerangKolom.controller.IPerangKolomController;
import de.htwg.se.PerangKolom.controller.impl.PKController;
import de.htwg.se.PerangKolom.controller.impl.PerangKolomController;

public class ButtonObject extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
	private JPanel centrePanel;

	private Color centrePanelColor;
	private JLabel valueOfCellLabel;
	private JButton buttonTop;
	private JButton buttonRight;
	private JButton buttonBottom;
	private JButton buttonLeft;
	
	private IPKController controller;
	
	private final int BUTTONWIDE = 45;
	private final int BUTTONHEIGHT = 10;
	private final int BUTTON_TOP = 1;
	private final int BUTTON_RIGHT = 2;
	private final int BUTTON_BOTTOM = 3;
	private final int BUTTON_LEFT = 4;
	private final int x;
	private final int y;
	private Map<Integer, JButton> treeMap;
	
	public ButtonObject(int coordinateX, int coordinateY, final int x, final int y, String cellValue){
		
		this.buttonPanel = new JPanel();
		this.centrePanel = new JPanel();
		this.centrePanelColor = Color.DARK_GRAY;
		this.valueOfCellLabel = new JLabel(cellValue);
		this.buttonTop = new JButton("");
		this.buttonRight = new JButton("");
		this.buttonBottom = new JButton("");
		this.buttonLeft = new JButton("");
		this.treeMap = new TreeMap<Integer, JButton>();
		this.controller = new PKController();
		this.x = x;
		this.y = y;
		
		treeMap.put(1, buttonTop);
		treeMap.put(2, buttonRight);
		treeMap.put(3, buttonBottom);
		treeMap.put(4, buttonLeft);
		valueOfCellLabel.setBackground(null);
		buttonPanel.setLayout(null);
		
		setModelValues(buttonTop, BUTTON_TOP);
		setModelValues(buttonRight, BUTTON_RIGHT);
		setModelValues(buttonBottom, BUTTON_BOTTOM);
		setModelValues(buttonLeft, BUTTON_LEFT);
		

		
//		entrePanel.setOpaque(false);
		
		buttonTop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				buttonMethod(buttonTop, BUTTON_TOP);
			}
		});
		
		buttonRight.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				buttonMethod(buttonRight, BUTTON_RIGHT);
			}
		});
		
		buttonBottom.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonMethod(buttonBottom, BUTTON_BOTTOM);
			}
		});
		
		buttonLeft.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonMethod(buttonLeft, BUTTON_LEFT);
			}
		});

		
		buttonPanel.setBounds(coordinateX, coordinateY, 75, 75);
		buttonPanel.setOpaque(false);
		centrePanel.setBounds(10, 10, 50, 50);
		centrePanel.setBackground(centrePanelColor);
//		centrePanel.setOpaque(false); //sets the cell invisible
		
		
		/* add Buttons to panel */
		buttonPanel.add(buttonTop).setBounds(13, 0, BUTTONWIDE, BUTTONHEIGHT);
		buttonPanel.add(buttonRight).setBounds(60, 13, BUTTONHEIGHT, BUTTONWIDE);
		buttonPanel.add(buttonBottom).setBounds(13, 60, BUTTONWIDE, BUTTONHEIGHT);
		buttonPanel.add(buttonLeft).setBounds(0, 13, BUTTONHEIGHT, BUTTONWIDE);
		buttonPanel.add(centrePanel);
		centrePanel.add(valueOfCellLabel).setBounds(40, 45, 20, 20);
		valueOfCellLabel.setFont (valueOfCellLabel.getFont ().deriveFont (25.0f));
		valueOfCellLabel.setBackground(Color.DARK_GRAY);
		valueOfCellLabel.setForeground(Color.WHITE);
		valueOfCellLabel.setVisible(true);
//		valueOfCellLabel.setSize(20, 20);
		valueOfCellLabel.setOpaque(true);


		
	}
	
	public void setModelValues(JButton button, int buttonNumber){
//		System.out.printf("Cell %d %d, is Border %d filled??? %s%n", x, y, buttonNumber, (controller.getCell(x, y).getBorder(buttonNumber)));
		if(controller.getCell(x, y).getBorder(buttonNumber)){
			button.setContentAreaFilled(true);
			button.setOpaque(true);
			button.setBackground(Color.gray);
			button.setEnabled(false);

		}else{
			button.setContentAreaFilled(false);
			button.setOpaque(false);
		}
		button.setBorderPainted(false);
		button.setRolloverEnabled(false);
//		this.revalidate();
		centrePanel.validate();
		controller.notifyObservers();
	}
	 
	public JPanel getPanel(){
		return buttonPanel;
	}
	
	public Map<Integer, JButton> getMap(){
		return this.treeMap;
	}
	
	public void fillCellTest(){
		
//		System.out.printf("FOUR BORDERS FILLED??? :  %s\n", controller.fourBordersFilled(x, y));
		
		if(controller.isCellFilled(x, y)){
			centrePanel.setOpaque(true);
			centrePanel.setBackground(Color.blue);
			valueOfCellLabel.setBackground(Color.blue);
			valueOfCellLabel.setForeground(Color.BLACK);
		}
	}
	
	/*******button management method ****/
	public void buttonMethod(JButton button, int buttonNumber){

//		button.setContentAreaFilled(true);
//		button.setBackground(Color.gray);
//		button.setEnabled(false);
		centrePanel.setOpaque(true);
		centrePanel.validate();
		
		controller.setBorder(buttonNumber, true, x, y);
		fillCellTest();
//		System.out.printf("is Border %d filled??? %s%n", buttonNumber, (controller.getCell(x, y).getBorder(buttonNumber)));
		setModelValues(button, buttonNumber);
	}
	
}
