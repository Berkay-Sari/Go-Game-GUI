public class Player 
	{
		private String renk;
		private String hamle = "";
		private boolean hamleS�ras� = false;
		public Player(String renk)
		{
			this.renk = renk;
		}
		public String getRenk()
		{
			return renk;
		}
		public String getHamle()
		{
			return hamle;
		}
		public void setHamle(String input)
		{
			hamle = input;
		}
		public boolean getHamleS�ras�() 
		{
			return hamleS�ras�;
		}
		public void setHamleS�ras�(boolean hamleS�ras�) 
		{
			this.hamleS�ras� = hamleS�ras�;
		}
	}