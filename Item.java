import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

class Item implements java.io.Serializable 
	{	
	    boolean kusatilmis = false;
		public Item()
		{
			
		}
		String renk;
		private boolean baktimMi = false;
		public Item(String renk)
		{
			this.renk = renk;
		}
		public String getRenk()
		{
			return renk;
		}
		public String toString()
		{
			return renk;
		}
		public boolean getBaktimMi() {
			return baktimMi;
		}
		public void setBaktimMi(boolean baktimMi) {
			this.baktimMi = baktimMi;
		}
		public void setRenk(String renk) {
			this.renk = renk;
		}
	}

		
	    
	  
	   