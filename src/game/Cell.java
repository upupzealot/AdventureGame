package game;

public class Cell {
	private String tile_name;
	
	public Cell(String tile_name) {
		this.tile_name = tile_name;
	}
	
	public String getTileName() {
		return tile_name;
	}
	
	public void setTileName(String tile_name) {
		this.tile_name = tile_name;
	}
}
