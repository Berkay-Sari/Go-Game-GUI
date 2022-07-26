public class Player 
	{
		private String renk;
		private String hamle = "";
		private boolean hamleSýrasý = false;
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
		public boolean getHamleSýrasý() 
		{
			return hamleSýrasý;
		}
		public void setHamleSýrasý(boolean hamleSýrasý) 
		{
			this.hamleSýrasý = hamleSýrasý;
		}
	}