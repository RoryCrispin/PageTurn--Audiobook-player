package com.rozzles.pageturner.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainUi {

	private JFrame frmPageTurner;
	private JTable table;
	private JLayeredPane ControlPanel;
	private JMenuBar menuBar;


	/**
	 * Create the application.
	 */
	public MainUi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmPageTurner(new JFrame());
		getFrmPageTurner().setTitle("Page Turner");
		getFrmPageTurner().setBounds(100, 100, 683, 268);
		getFrmPageTurner().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		getFrmPageTurner().setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open single file");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				actions.browseFile();
				actions.openSingleFile();
				
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmOpenSequence = new JMenuItem("Open sequence");
		mnFile.add(mntmOpenSequence);
		
		JMenuItem mntmOptions = new JMenuItem("Options");
		mnFile.add(mntmOptions);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		ControlPanel = new JLayeredPane();
		getFrmPageTurner().getContentPane().add(ControlPanel, BorderLayout.SOUTH);
		ControlPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel trackNameLabel = new JLabel("No media playing");
		trackNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ControlPanel.add(trackNameLabel, BorderLayout.NORTH);
		
		JPanel mediaControlsPanel = new JPanel();
		ControlPanel.add(mediaControlsPanel, BorderLayout.CENTER);
		
		JButton button = new JButton("<<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actions.seek30(true);
			}
		});
		mediaControlsPanel.add(button);
		
		JButton btnPlaypause = new JButton("Play/Pause");
		btnPlaypause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actions.playPause();
			}
		});
		mediaControlsPanel.add(btnPlaypause);
		
		JButton button_1 = new JButton(">>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actions.seek30(false);
			}
		});
		mediaControlsPanel.add(button_1);
		
		JPanel panel_2 = new JPanel();
		ControlPanel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.setValue(0);
		panel_2.add(slider);
		
		JLabel label = new JLabel("0:00/1:00");
		panel_2.add(label, BorderLayout.EAST);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getFrmPageTurner().getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Media Options", null, panel, null);
		
		JLabel lblPlaybackSpeed = new JLabel("Playback Speed");
		panel.add(lblPlaybackSpeed);
		
		JSlider slider_1 = new JSlider();
		slider_1.setValue(0);
		slider_1.setPaintTicks(true);
		slider_1.setMinorTickSpacing(50);
		slider_1.setMajorTickSpacing(100);
		slider_1.setMaximum(300);
		slider_1.setMinimum(-300);
		panel.add(slider_1);
		
		JButton btnReset = new JButton("Reset");
		panel.add(btnReset);
		
		JSplitPane splitPane = new JSplitPane();
		tabbedPane.addTab("Library", null, splitPane, null);
		splitPane.setContinuousLayout(true);
		
		JPanel contentDetail = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentDetail.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		splitPane.setLeftComponent(contentDetail);
		
		JPanel libraryView = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) libraryView.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		splitPane.setRightComponent(libraryView);
		
		table = new JTable();
		libraryView.add(table);
	}

	public JLayeredPane getControlPanel() {
		return ControlPanel;
	}

	public JFrame getFrmPageTurner() {
		return frmPageTurner;
	}

	public void setFrmPageTurner(JFrame frmPageTurner) {
		this.frmPageTurner = frmPageTurner;
	}
	public JMenuBar getMenuBar() {
		return menuBar;
	}
}
