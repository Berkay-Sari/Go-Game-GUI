public class Player 
	{
		private String renk;
		private String hamle = "";
		private boolean hamleSırası = false;
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
		public boolean getHamleSırası() 
		{
			return hamleSırası;
		}
		public void setHamleSırası(boolean hamleSırası) 
		{
			this.hamleSırası = hamleSırası;
		}
	}