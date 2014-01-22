package de.htwg.se.PerangKolom.aview.GUI;

import java.awt.BorderLayout;import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
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
import javax.sound.midi.ControllerEventListener;
import javax.swing.JPanel;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import de.htwg.se.PerangKolom.controller.IPerangKolomController;
import de.htwg.se.PerangKolom.controller.impl.PerangKolomController;
import de.htwg.se.PerangKolom.controller.impl.PerangKolomControllerTest;
import de.htwg.se.PerangKolom.model.impl.Cell;
import de.htwg.se.PerangKolom.model.impl.CellArray;

import java.awt.SystemColor;

import javax.swing.JMenu;

public class GraphicalUI<E> extends JFrame {

	private final int BIG_SIZE = 7;
	private final int SMALL_SIZE = 3;
	private final int XCOORDINATES_BUTTON_OBJECT = 33;
	private final int YCOORDINATES_BUTTON_OBJECT = 35;
	private final int ADDITIONER_BUTTON_OBJECT = 60;
	
	IPerangKolomController perangKolomController;
	public CellArray cellArrayDummy = CellArray.getInstance();
	public Cell[][] cellArray = CellArray.getCellArray();
	
	private JFrame frame;
	private JPanel contentPane;
	private JPanel PanelMenu;
	private JPanel PanelBackground;
	private JLabel label;
	private JLabel schriftLabel;
	private ImageIcon backgroundplay;
	private ImageIcon letterBackground;
    private BufferedImage backgroundplaySmall;
    private JMenuBar menubar;
    private JMenu menuOptions;
    private JMenuItem menuItemRerun;
    private JMenu menuGridSize;
    private JMenuItem menuItemBigSize;
    private JMenuItem menuItemSmallSize;
    
    private JTextField tfPlayerName1;
    private JTextField tfPlayerName2;
    private JTextField tfPoints1;
    private JTextField tfPoints2;

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
		setVisible(true);
		
		/* Hash-Map */
		hashMapButton = new HashMap<Cell , ButtonObject>();
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(500, 600);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		PanelMenu = new JPanel();
		PanelMenu.setBounds(0, 0, 500, 110);
		contentPane.add(PanelMenu);
		
		PanelBackground = new JPanel();
//		PanelBackground.setForeground(Color.BLACK);
		PanelBackground.setBounds(0, 100, 500, 500);
		contentPane.add(PanelBackground);
		

		
		
//		PanelBackground.addMouseListener(new MouseListener() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			    int x=e.getX();
//			    int y=e.getY();
//			    System.out.println(x+","+y);//these co-ords are relative to the component
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
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
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		contentPane.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    int x=e.getX();
			    int y=e.getY();
			    System.out.println(x+","+y);//these co-ords are relative to the component
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		
		/********* JMenu ******/
		menubar = new JMenuBar();
		setJMenuBar(menubar);

		/**** Options Menu ****/
		menuOptions = new JMenu("Game Options");
		menubar.add(menuOptions);
		
		menuItemRerun = new JMenuItem("Rerun the game");
		menuOptions.add(menuItemRerun);
		
		/**** GridSize Menu ****/
		menuGridSize = new JMenu("Choose Grid Size");
		menubar.add(menuGridSize);
		
		menuItemBigSize = new JMenuItem("7 x 7 grid size");
		menuItemSmallSize = new JMenuItem("3 x 3 grid size");
		menuGridSize.add(menuItemBigSize);
		menuGridSize.add(menuItemSmallSize);
		
		
		/*** MENU Action Listener ***/
		menuItemSmallSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				perangKolomController.setGridSize(SMALL_SIZE, SMALL_SIZE);
				perangKolomController.createNewGrid(SMALL_SIZE, SMALL_SIZE);
				System.out.println("Spiel sollte hier mit KLEINEM Spielfeld neu gestartet werden");
			}
		});
		
		menuItemBigSize.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				perangKolomController.setGridSize(BIG_SIZE, BIG_SIZE);
				perangKolomController.createNewGrid(BIG_SIZE, BIG_SIZE);
				System.out.println("Spiel sollte hier mit GROSSEM Spielfeld neu gestartet werden");
			}
		});
		
		menuItemRerun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Spiel sollte hier neu gestartet werden");
			}
		});
		
		
		
		backgroundplay = new ImageIcon("src/utilities/PerangKolomGameField.jpg");
		PanelBackground.setOpaque(false);
		PanelMenu.setOpaque(false);
		
		label = new JLabel();
		label.setBounds(297, 16, 0, 0);
		label.setIcon(backgroundplay);
//		label.add(btnNewButton).setBounds(46, 35, 45, 10);;
		
		/* ÜberschriftLabel 'PerangKolom' */
		letterBackground = new ImageIcon("src/utilities/GameFieldWName.png");
		schriftLabel.setBounds(0, 0, 0, 0);
		schriftLabel = new JLabel();
		schriftLabel.setIcon(letterBackground);

		/* JTextField Player and Points */
		tfPlayerName1 = new JTextField(15);
		tfPlayerName1.setBounds(122, 60, 80, 10);
		tfPlayerName2 = new JTextField(15);
		tfPoints1 = new JTextField(15);
		tfPoints2 = new JTextField(15);
		
		/* Labels for Player and Points*/
		JLabel lblPlayer1 = new JLabel();
		lblPlayer1.setBounds(124, 50, 140, 25);
		lblPlayer1.setFont (lblPlayer1.getFont ().deriveFont (25.0f));
		lblPlayer1.setText("Olaf Bibirossssooososo");
		lblPlayer1.setForeground(Color.gray);
		schriftLabel.add(lblPlayer1);
		
		JLabel lblPoints1 = new JLabel();
		lblPoints1.setBounds(100, 80, 140, 25);
		lblPoints1.setFont (lblPoints1.getFont ().deriveFont (25.0f));
		lblPoints1.setText("100000");
		lblPoints1.setForeground(Color.gray);
		schriftLabel.add(lblPoints1);
		
		JLabel lblPlayer2 = new JLabel();
		lblPlayer2.setBounds(384, 50, 120, 25);
		lblPlayer2.setFont (lblPlayer2.getFont ().deriveFont (25.0f));
		lblPlayer2.setText("Boris Becker");
		lblPlayer2.setForeground(Color.gray);
		schriftLabel.add(lblPlayer2);
		
		JLabel lblPoints2 = new JLabel();
		lblPoints2.setBounds(360, 80, 120, 25);
		lblPoints2.setFont (lblPoints2.getFont ().deriveFont (25.0f));
		lblPoints2.setText("200");
		lblPoints2.setForeground(Color.gray);
		schriftLabel.add(lblPoints2);
		
		/******* BUILD Cells ********/

		createCellObjects();
		
        PanelMenu.add(schriftLabel);
		PanelBackground.add(label);
		setVisible(true); 
		this.validate();
	}
	
	public void createCellObjects(){
		int counterX = XCOORDINATES_BUTTON_OBJECT;
		int counterY = YCOORDINATES_BUTTON_OBJECT;
		
		for(int i = 0; i < cellArrayDummy.getNumberOfColums(); i++){
			for(int j = 0; j < cellArrayDummy.getNumberOfRows(); j++){
				int randomNumber = perangKolomController.getRandNumber(i, j);
				ButtonObject btnObject = new ButtonObject(counterX, counterY, i, j, Integer.toString(randomNumber));
				JPanel btnPanel = btnObject.getPanel();
				label.add(btnPanel);
				hashMapButton.put(perangKolomController.getCell(i, j), btnObject);
				counterX += ADDITIONER_BUTTON_OBJECT;
			}
			counterX = XCOORDINATES_BUTTON_OBJECT;
			counterY += ADDITIONER_BUTTON_OBJECT; 
		}
	}
	

}
