/*
@Author M.G, K.P
*/
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
import javax.swing.Timer;
import java.util.concurrent.ThreadLocalRandom;

public class Component extends JPanel implements ActionListener, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    
   private JProgressBar progressbar;
   private JPanel panel;
   private Color bgColor;
   private int value, min, max;
   private JButton button1;
   private String btnText;
   private JTextField tmin, tmax;
   private int bounds;
   private boolean painted;
   
   public Component() {
      progressbar = new JProgressBar();
      panel = new JPanel(new FlowLayout());
      panel.add(progressbar);
      button1 = new JButton();
      add(panel);
      tmin = new JTextField();
      tmax = new JTextField();
      panel.add(tmin);
      panel.add(tmax);
      tmin.setColumns(5);
      tmax.setColumns(5);
      progressbar.setStringPainted(true);
            panel.add(button1);
      button1.setText("Ustaw Wartosci min-max");
      button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            int min = Integer.parseInt(tmin.getText());
                            int max = Integer.parseInt(tmax.getText());
                                        Timer timer = new Timer(500, this);
      timer.start();
                            int oldvalue = progressbar.getValue();
       int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
       progressbar.setValue(randomNum);
			}
		});
   }

   public boolean isSet(){
       return painted;
   }
   public void setPaint(boolean painted){
       this.painted = painted;
       progressbar.setStringPainted(painted);
   }
   
   public int getValue(){
       return value;
   }
   public void setValue(int value){
       this.value = value;
       progressbar.setValue(value);
   }
   public JTextField getValueofmin(){
    return tmin;
}
   public void setValueofmin( JTextField tmin)
   {
       this.tmin = tmin;
       tmin.setText("");
   }
      public JTextField getValueofmax(){
    return tmin;
}
   public void setValueofmax( JTextField tmax)
   {
       this.tmin = tmin;
       tmin.setText("");
   }
   public Color getBackgroundColor() {
       return bgColor;
   }
   public void setBackgroundColor(Color bgColor){
       this.bgColor = bgColor;
       panel.setBackground(bgColor);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}