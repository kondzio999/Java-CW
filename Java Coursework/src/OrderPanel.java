import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OrderPanel extends PanelModel {
	private JSlider width;
	private JSlider height;
	private JSlider length;
	private JComboBox<Integer> gradeList;
	private JComboBox<String> colourList;
	private Integer[] grades = new Integer[] { 1, 2, 3, 4, 5 };
	private String[] colours = new String[] { "no colour", "1 colour", "2 colours" };
	private JRadioButton bottomR;
	private JRadioButton cornerR;
	private JRadioButton sealed;
	private JTextField quantity;
	private ArrayList<BoxModel> boxes;
	private BottomPanel bPanel;
	private LogPanel lPanel;
	private JLabel lwidth, lheight, llength, lgrade, lcolor, lbottom, lsealed, lcorner, lquantity;

	public OrderPanel(String border, int width, int height) {
		super(border, width, height);
		setBackground(Color.LIGHT_GRAY);
		init();
	}

	public void init() {
		// Font font = new Font("Arial", 16, Font.BOLD);
		boxes = new ArrayList<BoxModel>();
		createSliders();
		createLabels();
		createLists();
		createRadioButtons();
		createTextBoxes();

		addCompontents();

	}

	public void linkPanels(BottomPanel bPanel, InvoicePanel iPanel, LogPanel lPanel) {
		this.bPanel = bPanel;
		this.lPanel = lPanel;
	}

	public void createLists() {
		gradeList = new JComboBox<Integer>(grades);
		gradeList.setToolTipText("Choose your grade from the list, higher grade means higher price of the box");
		colourList = new JComboBox<String>(colours);
		colourList.setToolTipText("Select from the list, if you would like the box to be coloured");
	}

	public void createRadioButtons() {
		bottomR = new JRadioButton();
		bottomR.setToolTipText("Would you like your box to have stronger bottom?");
		cornerR = new JRadioButton();
		cornerR.setToolTipText("Would you like your box to have stronger bottom?");
		sealed = new JRadioButton();
		sealed.setToolTipText("Would you like your box to have stronger bottom?");
	}

	public void createLabels() {

		lwidth = new JLabel("specify your width in cm : " + getChosenWidth());
		lwidth.setToolTipText("Specify width of your box in cm");
		lheight = new JLabel("specify your height in cm : " + getChosenHeight());
		lheight.setToolTipText("Specify width of your box in cm");
		llength = new JLabel("specify your length in cm : " + getChosenLength());
		llength.setToolTipText("Specify width of your box in cm");
		lgrade = new JLabel("specify grade of your card : ");
		lgrade.setToolTipText("Choose your grade from the list, higher grade means higher price of the box");
		lcolor = new JLabel("specify colour printing of your box : ");
		lcolor.setToolTipText("Select from the list, if you would like the box to be coloured");
		lbottom = new JLabel("Would you like bottom reinforcement?: ");
		lbottom.setToolTipText("Would you like your box to have stronger bottom?");
		lcorner = new JLabel("Would you like corner reinforcement?: ");
		lcorner.setToolTipText("Would you like your box to have stronger corners?");
		lsealed = new JLabel("Would you like your box to be sealed?");
		lsealed.setToolTipText("Would you like your box to be sealed?");
		lquantity = new JLabel("How many of these boxes would you like?");
		lquantity.setToolTipText("Choose how many boxes would you like to order (max in total 25)");

	}

	public void createSliders() {
		width = new JSlider();
		width.setToolTipText("Change your width of the box by using a slider");
		width.setMajorTickSpacing(20);
		width.setMinorTickSpacing(5);
		width.setPaintTicks(true);
		width.setPaintLabels(true);
		width.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {

				lwidth.setText("specify your width in cm : " + getChosenWidth());
				if (width.getValue() == 0 || height.getValue() == 0 || length.getValue() == 0) {
					lPanel.print("Your width,height or length cannot be 0", true);
					bPanel.disableEverything();
				} else {
					lPanel.clear();
					bPanel.enableEverything();
				}
			}

		});
		length = new JSlider();
		length.setToolTipText("Change your length of the box by using a slider");
		length.setMajorTickSpacing(20);
		length.setMinorTickSpacing(5);
		length.setPaintTicks(true);
		length.setPaintLabels(true);
		length.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {

				llength.setText("specify your length in cm : " + getChosenLength());
				if (width.getValue() == 0 || height.getValue() == 0 || length.getValue() == 0) {
					lPanel.print("Your width,height or length cannot be 0", true);
					bPanel.disableEverything();
				} else {
					lPanel.clear();
					bPanel.enableEverything();
				}

			}

		});
		height = new JSlider();
		height.setToolTipText("Change your height of the box by using a slider");
		height.setMajorTickSpacing(20);
		height.setMinorTickSpacing(5);
		height.setPaintTicks(true);
		height.setPaintLabels(true);
		height.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {

				lheight.setText("specify your height in cm : " + getChosenHeight());
				if (width.getValue() == 0 || height.getValue() == 0 || length.getValue() == 0) {
					lPanel.print("Your width,height or length cannot be 0", true);
					bPanel.disableEverything();
				} else {
					lPanel.clear();
					bPanel.enableEverything();
				}

			}

		});
	}

	public void createTextBoxes() {
		quantity = new JTextField();
		quantity.setToolTipText("Choose how many boxes would you like to order (max in total 25)");
		quantity.setColumns(10);
	}

	public void addCompontents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 0;
		gc.gridy = 0;

		add(lwidth, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		add(width, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		add(llength, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		add(length, gc);

		gc.gridx = 0;
		gc.gridy = 2;
		add(lheight, gc);

		gc.gridx = 1;
		gc.gridy = 2;
		add(height, gc);

		gc.gridx = 0;
		gc.gridy = 3;
		add(lgrade, gc);

		gc.gridx = 1;
		gc.gridy = 3;
		add(gradeList, gc);

		gc.gridx = 0;
		gc.gridy = 4;
		add(lcolor, gc);

		gc.gridx = 1;
		gc.gridy = 4;
		add(colourList, gc);

		gc.gridx = 0;
		gc.gridy = 5;
		add(lbottom, gc);

		gc.gridx = 1;
		gc.gridy = 5;
		add(bottomR, gc);

		gc.gridx = 0;
		gc.gridy = 6;
		add(lcorner, gc);

		gc.gridx = 1;
		gc.gridy = 6;
		add(cornerR, gc);

		gc.gridx = 0;
		gc.gridy = 7;
		add(lsealed, gc);

		gc.gridx = 1;
		gc.gridy = 7;
		add(sealed, gc);

		gc.gridx = 0;
		gc.gridy = 8;
		add(lquantity, gc);

		gc.gridx = 1;
		gc.gridy = 8;
		add(quantity, gc);
	}

	public int getgradeList() {
		return grades[gradeList.getSelectedIndex()];
	}

	public int getColourList() {
		return colourList.getSelectedIndex();
	}

	public boolean isSealed() {
		return sealed.isSelected();
	}

	public boolean bottom() {
		return bottomR.isSelected();
	}

	public boolean corner() {
		return cornerR.isSelected();
	}

	public int getChosenWidth() {
		return width.getValue();
	}

	public int getChosenLength() {
		return length.getValue();
	}

	public int getChosenHeight() {
		return height.getValue();
	}

	public JLabel getqLabel() {
		return lquantity;
	}

	public int getQuantity() {
		int q = 0;
		try {

			if (Integer.parseInt(quantity.getText()) <= 25) {
				q = Integer.parseInt(quantity.getText());
			}
		} catch (NumberFormatException e) {

		}

		return q;
	}

	public int basketSize() {
		return boxes.size();
	}

	public ArrayList<BoxModel> getBasket() {
		return boxes;
	}

	public void reset() {
		width.setValue(50);
		height.setValue(50);
		length.setValue(50);
		gradeList.setSelectedIndex(0);
		colourList.setSelectedIndex(0);
		bottomR.setSelected(false);
		cornerR.setSelected(false);
		sealed.setSelected(false);
		quantity.setText("");
	}

	public void clearBasket() {
		for (int i = 0; i < boxes.size(); i++) {
			boxes.remove(i);
		}
	}
}
