class Rank {
	private int rank;
	public final int MIN = 0;
	public final int MAX = 9;
	
	public Rank(int rank){ //Constructor
		this.rank = rank;
	}
	
	@Override
	public String toString(){
		return String.valueOf(rank);
	}
}
