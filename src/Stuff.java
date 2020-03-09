import java.util.Random;

public class Stuff {
	
	private int roomNo;
	private int ghost;
	private boolean rich;
	private int rng;
	private int userCoins;
	private int npc;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getGhost() {
		return ghost;
	}

	public void setGhost(int ghost) {
		this.ghost = ghost;
	}

	public boolean isRich() {
		return rich;
	}

	public void setRich(boolean rich) {
		this.rich = rich;
	}

	public int getRng() {
		return rng;
	}

	public void setRng(int rng) {
		this.rng = rng;
	}

	public int getUserCoins() {
		return userCoins;
	}

	public void setUserCoins(int userCoins) {
		this.userCoins = userCoins;
	}

	public int getNpc() {
		return npc;
	}

	public void setNpc(int npc) {
		this.npc = npc;
	}

	

	public Stuff(int roomNo, int ghost, boolean rich, int rng, int userCoins, int npc) {
		super();
		this.roomNo = roomNo;
		this.ghost = ghost;
		this.rich = rich;
		this.rng = rng;
		this.userCoins = userCoins;
		this.npc = npc;
	}
	public Stuff() {
		// TODO Auto-generated constructor stub
	}

}
