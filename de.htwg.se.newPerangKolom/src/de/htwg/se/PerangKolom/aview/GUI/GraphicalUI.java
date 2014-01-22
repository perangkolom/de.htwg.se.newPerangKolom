package de.htwg.se.PerangKolom.aview.GUI;

import java.awt.BorderLayout;import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import de.htwg.se.PerangKolom.controller.IPerangKolomController;
import de.htwg.se.PerangKolom.controller.impl.PerangKolomController;
import de.htwg.se.PerangKolom.model.impl.Cell;

import java.awt.SystemColor;

import javax.swing.JMenu;

public class GraphicalUI<E> extends JFrame {

	private static final double RANDOM_MAX = 4;
	private static final double RANDOM_MIN = 1;

	IPerangKolomController perangKolomController;
	
	private JPanel contentPane;
	private JPanel PanelMenu;
	private JPanel PanelBackground;
	private JLabel label;
	private JLabel schriftLabel;
	private ImageIcon backgroundplay;
	private ImageIcon letterBackground;
    private BufferedImage backgroundplaySmall;
    HashMap<Cell, ButtonObject> hashMapButton;
    
    
//    private final int = 
//    private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicalUI frame = new GraphicalUI();
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
	public GraphicalUI() {
		
		schriftLabel = new JLabel();

		
		
		perangKolomController = new PerangKolomController();
		
		setResizable(false);
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 628);
		
		/* Hash-Map */
		hashMapButton = new HashMap<Cell , ButtonObject>();
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(500, 600);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelMenu = new JPanel();
		PanelMenu.setBounds(0, 5, 500, 100);
		contentPane.add(PanelMenu);
		
		PanelBackground = new JPanel();
//		PanelBackground.setForeground(Color.BLACK);
		PanelBackground.setBounds(0, 100, 500, 500);
		contentPane.add(PanelBackground);
		
//		PanelBackground.addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			    int x=e.getX();
//			    int y=e.getY();
//			    System.out.println(x+","+y);//these co-ords are relative to the component
//			}
//		});
//		
		/*******************************/


		
//		btnNewButton = new JButton("");
//		
//
//		btnNewButton.setContentAreaFilled(false);
//		btnNewButton.setBorderPainted(false);
//		btnNewButton.setBackground(Color.WHITE);
////		btnNewButton.setBorderPainted(false);
//		btnNewButton.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("Hallo, ich wurde gedrückt");
//				PanelBackground.setOpaque(true);
//				btnNewButton.setContentAreaFilled(true);
//				btnNewButton.setEnabled(false);
//				
//			}
//		});
		
		backgroundplay = new ImageIcon("src/utilities/PerangKolomGameField.jpg");
		PanelBackground.setOpaque(false);
		PanelMenu.setOpaque(true);
		
		label = new JLabel();
		label.setBounds(297, 16, 0, 0);
		label.setIcon(backgroundplay);
//		label.add(btnNewButton).setBounds(46, 35, 45, 10);;
		
		letterBackground = new ImageIcon("src/utilities/spielname.jpg");
		schriftLabel.setBounds(0, 0, 0, 0);
		schriftLabel = new JLabel();
		schriftLabel.setIcon(letterBackground);

		
		/******* BUILD Cells ********/
		int counterX = 33;
		int counterY = 35;
		
		
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 7; j++){
				int randomNumber = perangKolomController.getRandNumber(i, j);
				ButtonObject btnObject = new ButtonObject(counterX, counterY, i, j, Integer.toString(randomNumber));
				JPanel btnPanel = btnObject.getPanel();
				label.add(btnPanel);
				hashMapButton.put(perangKolomController.getCell(i, j), btnObject);
				counterX += 60;
			}
			counterX = 33;
			counterY += 60; 
		}
        PanelMenu.add(schriftLabel);
		PanelBackground.add(label);
		setVisible(true); 
		this.validate();
	}
	
	public int makeRandomNumber() {
		
		double random = Math.random();
		double tmp = (random * RANDOM_MAX);
		if (tmp < RANDOM_MIN) 
			tmp = RANDOM_MIN;
		int result = (int) Math.ceil(tmp);
		
		result = result * 25;
		return result;		
	}
}
