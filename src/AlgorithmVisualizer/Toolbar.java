package AlgorithmVisualizer;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import AlgorithmVisualizer.Gameplay;
import AlgorithmVisualizer.Settings;

public class Toolbar extends JPanel{
	private Gameplay gameplay;
	private Settings settings;
	
	public Toolbar(Gameplay gameplay, Settings settings) {
		this.gameplay = gameplay;
		this.settings = settings;
		this.setLayout(new BorderLayout());

		setFocusable(true);
//		setFocusTraversalKeysEnabled(true);

		this.add(gameplay, BorderLayout.CENTER);
		this.add(settings, BorderLayout.WEST);
	}
	
	public Gameplay getGameplay() {
		return this.gameplay;
	}
}
