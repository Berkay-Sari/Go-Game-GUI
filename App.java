import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class App extends JFrame{
	
	Board b = new Board();
	int pas = 0;
	Player beyaz = new Player("Beyaz");
	Player siyah = new Player("Siyah");
	
	int satir = 0;
	int sutun = 0;
	private String input = "baslangýc";
	class Onaylama extends JFrame implements ActionListener {
		JLabel yazi = new JLabel("Cýkmak istediginden emin misiniz?");
		JButton evet = new JButton("Evet");
		JButton hayir = new JButton("Hayir");
		JPanel tuslar = new JPanel(new FlowLayout());
		JPanel düzgün_yazi = new JPanel(new FlowLayout());
		
		public Onaylama() {
			setSize(350,100);
			setTitle("Exit");
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setLayout(new GridLayout(2,1));
			tuslar.add(evet);
			tuslar.add(hayir);
			add(düzgün_yazi);
			add(tuslar);
			düzgün_yazi.add(yazi);
			evet.addActionListener(this);
			hayir.addActionListener(this);
			setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e) {
			String karar = e.getActionCommand();
			if(karar.equals("Evet"))	System.exit(0);
			else	dispose();
			
		}
	}
	
	class Pencere implements WindowListener {

		public void windowOpened(WindowEvent e) {}
		
		public void windowClosing(WindowEvent e) {
			new Onaylama();
		}

		public void windowClosed(WindowEvent e) {}		
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
	}
	class Pas extends JButton implements ActionListener {
		public Pas() {
			setLayout(new FlowLayout());
			addActionListener(this);
			add(new JLabel("Pas"));
		}
		public void actionPerformed(ActionEvent e) {
			pas++;
				siyah.setHamleSýrasý(!siyah.getHamleSýrasý());
				beyaz.setHamleSýrasý(!beyaz.getHamleSýrasý());
				if(siyah.getHamleSýrasý())
					setTitle("Beyaz");
				else setTitle("Siyah");
				
			if(pas == 2) {
				String winner = "";
				if(b.tahtadakiBeyazTasPuani() > b.tahtadakiSiyahTasPuani())
					winner = " BEYAZ OYUNCU!";
				else if(b.tahtadakiSiyahTasPuani() > b.tahtadakiBeyazTasPuani())
					winner = " SIYAH OYUNCU!";
				else
					winner = "BERABERE";
				JFrame sonuc = new JFrame();
				sonuc.setSize(250,110);
				JPanel yazilar = new JPanel();
				yazilar.setLayout(new FlowLayout());
				JLabel beyaz = new JLabel("Beyaz: "+ b.tahtadakiBeyazTasPuani());
				JLabel siyah = new JLabel("Siyah: "+ b.tahtadakiSiyahTasPuani());
				JLabel kazanan = new JLabel("Kazanan: "+ winner);
				beyaz.setLayout(new FlowLayout());
				yazilar.add(beyaz);
				yazilar.add(siyah);
				yazilar.add(kazanan);
				sonuc.add(yazilar);
				sonuc.setDefaultCloseOperation(EXIT_ON_CLOSE);
				sonuc.setVisible(true);
			}
		}
	}
	class Bolge extends JPanel implements MouseListener { 
		
		public Bolge()
		{
			
	        setBackground(new java.awt.Color(255,209, 105));
	        addMouseListener(this);
		}
		protected void paintComponent(Graphics g) {
			if(b.dolu_mu) {
				JFrame uyari = new JFrame();
				uyari.setLayout(new FlowLayout());
				uyari.setSize(330,100);
				JLabel uyari_yazisi = new JLabel("Hatali hamle!");
				uyari.add(uyari_yazisi);
				uyari.setVisible(true);
				uyari.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			super.paintComponent(g);
			g.setColor(Color.black);
			g.drawLine(25, 25, 480, 25);
			g.drawLine(25, 26, 480, 26);
			g.drawLine(25, 27, 480, 27);
			
        	g.drawLine(25, 25, 25, 480);
        	g.drawLine(26, 25, 26, 480);
        	g.drawLine(27, 25, 27, 480);
			
        	
        	g.drawLine(25, 480, 480, 480);
        	g.drawLine(25, 479, 480, 479);
        	g.drawLine(25, 478, 480, 478);
        	
        	g.drawLine(480, 25, 480, 480);
        	g.drawLine(482, 25, 482, 480);
        	g.drawLine(481, 25, 481, 480);
        	
        	for(int i = 1; i<8; i++) {
				g.drawLine(25, 28+56*(i), 480, 28+56*(i));
				g.drawLine(28+56*i, 25, 28+56*i, 480);
			}
        	g.fillOval(136, 136, 8, 8);	g.fillOval(248, 136, 8, 8);	g.fillOval(360, 136, 8, 8);
        	g.fillOval(136, 248, 8, 8);	g.fillOval(248, 248, 8, 8);	g.fillOval(360, 248, 8, 8);
        	g.fillOval(136, 360, 8, 8);	g.fillOval(248, 360, 8, 8);	g.fillOval(360, 360, 8, 8);
        	for(int i = 0; i<9; i++) {
        		for(int j = 0; j<9; j++) {
        			if(b.taslar[i][j].getRenk().equals(" o"))
        				g.setColor(Color.white);
        			else if(b.taslar[i][j].getRenk().equals(" x"))	
        				g.setColor(Color.black);
        			else continue;
        			g.fillOval((j)*56+5,(i)*56+5, 45, 45);
        		}
        	}
	    }
	        
		
		public void mouseClicked(MouseEvent e) {
			pas = 0;
			char row = '0';
			char column = 'x';
			
			int x = e.getX();
			int y = e.getY();
			if(x <= 56*1) column = '1';
			else if(x <= 56*2) column = '2';
			else if(x <= 56*3) column = '3';
			else if(x <= 56*4) column = '4';
			else if(x <= 56*5) column = '5';
			else if(x <= 56*6) column = '6';
			else if(x <= 56*7) column = '7';
			else if(x <= 56*8) column = '8';
			else if(x <= 56*9) column = '9';
			
			if(y <= 56*1) row = 'a';
			else if(y <= 56*2) row = 'b';
			else if(y <= 56*3) row = 'c';
			else if(y <= 56*4) row = 'd';
			else if(y <= 56*5) row = 'e';
			else if(y <= 56*6) row = 'f';
			else if(y <= 53*7) row = 'g';
			else if(y <= 56*8) row = 'h';
			else if(y <= 56*9) row = 'i';
			
			
			
			
			input = ("" + column + row);
			
			
			siyah.setHamleSýrasý(!siyah.getHamleSýrasý());
			
			if(siyah.getHamleSýrasý())
			{
				setTitle("Beyaz");
				
				
				siyah.setHamle(input);
				
					b.putItem(siyah, siyah.getHamle());	
			}
			else if(beyaz.getHamleSýrasý())
			{
				setTitle("Siyah");
				
				
				beyaz.setHamle(input);
				
				
					b.putItem(beyaz, beyaz.getHamle());
				
			}
			
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					if(b.kusatilmisMi(i, j, b.taslar[i][j]))
					{	
						if(b.taslar[i][j].getRenk().equals(" o") ) {
							if(i > 0 && j  >0)
							if (b.taslar[i-1][j].getRenk().equals(" o") || b.taslar[i][j-1].getRenk().equals(" o")) continue;
							b.taslar[i][j].setRenk(" x");b.taslar[i][j].kusatilmis = true;
						}
							
						else if(b.taslar[i][j].getRenk().equals(" x")) {
							if(i > 0 && j  >0)
							if(b.taslar[i-1][j].getRenk().equals(" x") || b.taslar[i][j-1].getRenk().equals(" x")) continue;
							b.taslar[i][j].setRenk(" o");b.taslar[i][j].kusatilmis = true;
						}
						
					}
					
				}
			}
			for(int i = 0; i < 9; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					b.taslar[i][j].setBaktimMi(false);
				}
			}
			
			beyaz.setHamleSýrasý(!beyaz.getHamleSýrasý());	
			
			
			
			setVisible(true);
			repaint();
			if(b.tahtadakiBeyazTasPuani() + b.tahtadakiSiyahTasPuani() == 81) {
				String winner = "";
				if(b.tahtadakiBeyazTasPuani() > b.tahtadakiSiyahTasPuani())
					winner = " BEYAZ OYUNCU!";
				else if(b.tahtadakiSiyahTasPuani() > b.tahtadakiBeyazTasPuani())
					winner = " SIYAH OYUNCU!";
				else
					winner = "BERABERE";
				JFrame sonuc = new JFrame();
				sonuc.setSize(250,110);
				JPanel yazilar = new JPanel();
				yazilar.setLayout(new FlowLayout());
				JLabel beyaz = new JLabel("Beyaz: "+ b.tahtadakiBeyazTasPuani());
				JLabel siyah = new JLabel("Siyah: "+ b.tahtadakiSiyahTasPuani());
				JLabel kazanan = new JLabel("Kazanan: "+ winner);
				beyaz.setLayout(new FlowLayout());
				yazilar.add(beyaz);
				yazilar.add(siyah);
				yazilar.add(kazanan);
				sonuc.add(yazilar);
				sonuc.setDefaultCloseOperation(EXIT_ON_CLOSE);
				sonuc.setVisible(true);
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public App() {
		
		setSize(523, 580);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(new BorderLayout());	
			Bolge a = new Bolge();  
			add(a, BorderLayout.CENTER);

				
		add(new Pas(), BorderLayout.SOUTH);
		
		addWindowListener(new Pencere());
		setVisible(true);
	}	
	public String getInput() {
		return input;
	}
	public static void main(String [] args) {
		
		App gui = new App();
		gui.setTitle("Siyah");
					
	}
}
