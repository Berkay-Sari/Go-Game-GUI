import java.io.Serializable;
import java.util.Arrays;

public class Board implements java.io.Serializable
{
	boolean dolu_mu = false;
	Item [][]taslar;
	private String tahta = "";
	public Board()
	{
		taslar = new Item[9][9];
		for(int i = 0; i<taslar.length; i++)
			
			for(int j = 0; j<taslar[i].length; j++)
				
				taslar[i][j] = new Item(" -");
	}
	public void putItem(Player p, String input) //4a
	{
		if(input.equals("baslangýc")) {
			
		}
		else {
			int satir = input.charAt(1) - 97;
			int sutun = input.charAt(0) - 49;
		
			if(taslar[satir][sutun].getRenk().equals(" -"))
			{
				if(p.getRenk().equals("Siyah"))
					taslar[satir][sutun] = new Item(" x");	
				else if(p.getRenk().equals("Beyaz"))
					taslar[satir][sutun] = new Item(" o");
			}
			else
			{
				System.out.println("Item koymaya calistiginiz yer dolu.");
				dolu_mu = true;
			}
		}
	}
	public int tahtadakiBeyazTasPuani()
	{
		int tasSayisi = 0;
		
			for(int i = 0; i<taslar.length; i++)
			
				for(int j = 0; j<taslar[i].length; j++)
				
					if(taslar[i][j].getRenk().equals(" o"))
						
						tasSayisi++;
		
		return tasSayisi;
	}
	public int tahtadakiSiyahTasPuani()
	{
		int tasSayisi = 0;
		
		for(int i = 0; i<taslar.length; i++)
		
			for(int j = 0; j<taslar[i].length; j++)
			
				if(taslar[i][j].getRenk().equals(" x"))
					
					tasSayisi++;
	
		return tasSayisi;
	}
	public boolean kusatilmisMi(int satir, int sutun , Item tas)
	{
		
		tas.setBaktimMi(true);
		
		if(satir != 9 && sutun + 1 != 9 && taslar[satir][sutun + 1].getRenk().equals(" -")) return false;
		else if(sutun + 1 != 9 && satir != 9 && taslar[satir][sutun + 1].getRenk().equals(tas.getRenk())
			   && !taslar[satir][sutun+1].getBaktimMi())
			if(!(kusatilmisMi(satir , sutun + 1, taslar[satir][sutun + 1]))) return false;
		
		if(sutun != 9 && satir + 1 != 9 && taslar[satir + 1][sutun].getRenk().equals(" -")) return false;
		else if(sutun != 9 && satir + 1 != 9 && taslar[satir + 1][sutun].getRenk().equals(tas.getRenk()) 
				&& !taslar[satir+1][sutun].getBaktimMi())
			if(! (kusatilmisMi(satir + 1 , sutun, taslar[satir + 1][sutun]))) return false;
		
		if(satir != 9 && sutun - 1 != -1 && taslar[satir][sutun - 1].getRenk().equals(" -")) return false;
		else if(sutun - 1 != -1 && satir != 9 && taslar[satir][sutun - 1].getRenk().equals(tas.getRenk())
				&& !taslar[satir][sutun-1].getBaktimMi())
			if(! (kusatilmisMi(satir , sutun - 1, taslar[satir][sutun - 1]))) return false;
		
		if(sutun != 9 && satir - 1 != -1 && taslar[satir - 1][sutun].getRenk().equals(" -")) return false;
		else if(sutun != 9 && satir - 1 != -1 && taslar[satir - 1][sutun].getRenk().equals(tas.getRenk()) 
				&& !taslar[satir-1][sutun].getBaktimMi())
			if(! (kusatilmisMi(satir - 1 , sutun, taslar[satir - 1][sutun]))) return false;
		
		if(tas.kusatilmis) return false;
		
		return true;
		
	}
	public String getTahta()
	{
		tahta = "  1 2 3 4 5 6 7 8 9\n";
		for(int i = 0; i<taslar.length; i++)
		{	
			tahta += (char)(97 + i);
			for(int j = 0; j<taslar[i].length; j++)
			{	
				tahta += taslar[i][j];
			}
			tahta += "\n";
		}
		return tahta + " ";
	}
}
