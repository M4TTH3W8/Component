/*
 * @Komponent "wyświetlacz słupkowy"
 * @Autorzy: Mateusz Głowacki, Krzysztof Prochoń
 * @Politechnika Koszalińska 2020
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class compo extends JPanel {
    //licznik wskaznikow
   private int count;
   //domyslne wartosci
   private int min=0;
   private int max=100;
   private int wartmin;
   private int wartmax;
   private Color kolor;
   //wyswietla w srodku aktualna wartosc
   private boolean cyfra;
   //tablice z wartosciami
   private int[] wartosci;
   private String[] nazwy;
//swing'owe
   private JPanel minmaxPanel;
   private JLabel minNumb;
   private JLabel maxNumb;
   private JLabel minimumLabel;
   private JLabel maximumLabel;
   private JPanel[] wskPanel;
   private JProgressBar[] wskazniki;
   private JLabel[] nzw;
   //glowny
   private final JPanel jPanel = new JPanel();
   
   //konstruktor
   public compo(){
       setLayout(new BorderLayout());
       
       minmaxPanel = new JPanel(new FlowLayout());
       minimumLabel = new JLabel("Wartość minimalna: " + min);
       maximumLabel = new JLabel("Wartość maksymalna: " + max);
       minNumb = new JLabel();
       maxNumb = new JLabel();
       
       jPanel.setLayout(new FlowLayout());
       add(minmaxPanel, BorderLayout.NORTH);
       add(jPanel, BorderLayout.CENTER);
       //domyslna wartosc ilosci wskaznikow
       setcount(3);
   }
    public int getcount() {
        return count;
    }
    public void setcount(int numer) {
        
        if(this.count==numer){
            return;
        }
        else{
            wskPanel = new JPanel[numer];
            wskazniki = new JProgressBar[numer];
            nzw = new JLabel[numer];
            nazwy = new String[numer];
            wartosci = new int[numer];
        }
        
        jPanel.removeAll();
        minmaxPanel.add(minimumLabel);
        minmaxPanel.add(maximumLabel);
       //ilosc wskaznikow=ilosc paneli
        for(int i=0; i<wskPanel.length; i++)
         {
            wskPanel[i] = new JPanel();
            wskPanel[i].setLayout(new BorderLayout());
            wskazniki[i] = new JProgressBar(0,100);
            wskazniki[i].setOrientation(SwingConstants.VERTICAL);
            wskPanel[i].add(wskazniki[i], BorderLayout.CENTER);
            nazwy[i] = "Wskaźnik " + (i+1);
            nzw[i] = new JLabel(nazwy[i], SwingConstants.CENTER);
            wskPanel[i].add(nzw[i], BorderLayout.SOUTH);
            //do glownego dodanie paneli z wsk
            jPanel.add(wskPanel[i]);  
         }
    }
    //gettery i settery
    public int getwartmin() {
        return wartmin;
    }
    public void setwartmin(int wartmin) {
        this.wartmin = wartmin;
        minNumb.setText(String.valueOf(wartmin));
        min = Integer.parseInt(minNumb.getText());
        minimumLabel.setText("Wartość minimalna: " + minNumb.getText());
        
       for (JProgressBar progressBar : wskazniki) {
           progressBar.setMinimum(min);
       }
    }
    public int getwartmax() {
        return wartmax;
    }
    public void setwartmax(int wartmax) {
        this.wartmax = wartmax;
        maxNumb.setText(String.valueOf(wartmax));
        max = Integer.parseInt(maxNumb.getText());
        maximumLabel.setText("Wartość maksymalna: " + maxNumb.getText());
        
       for (JProgressBar progressBar : wskazniki) {
           progressBar.setMaximum(max);
       }
    }
    public Color getkolor() {
        return kolor;
    }
    public void setkolor(Color kolor) {
        this.kolor = kolor;
       for (JProgressBar progressBar : wskazniki) {
           progressBar.setForeground(kolor);
       }
    }
    public boolean iscyfra() {
        return cyfra;
    }
    public void setcyfra(boolean cyfra) {
        this.cyfra = cyfra;
        //jezeli true to pokazuje jezeli false to nie widac
        if(cyfra)
        {
            for (JProgressBar progressBar : wskazniki) {
                progressBar.setStringPainted(true);
                progressBar.setString(String.valueOf(progressBar.getValue()));
            }
        }
        else if(!cyfra)
        {
            for (JProgressBar progressBar : wskazniki) {
                progressBar.setStringPainted(false);
            }
        }
    }
    public int[] getwartosci() {
        return wartosci;
    }
    public void setwartosci(int[] nwartosci) {
        for(int i=0; i<nwartosci.length; i++){
            wartosci[i] = nwartosci[i];
            wskazniki[i].setValue(wartosci[i]);
        }
    }
    public String[] getnazwy() {
        return nazwy;
    }
    public void setnazwy(String[] nnazwy) {
        for(int i=0; i<nnazwy.length; i++){
            nazwy[i] = nnazwy[i];
            nzw[i].setText(nazwy[i]);
        }
    }
}
