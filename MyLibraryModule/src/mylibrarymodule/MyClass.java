package mylibrarymodule;

public class MyClass {
	private int x,y;
	
	public MyClass(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	   * ...
	   * @deprecated  This method does not properly convert bytes into
	   * characters.  As of JDK 1.1, the preferred way to do this is via the
	   * {@code String} constructors that take a {@link
	   * java.nio.charset.Charset}, charset name, or that use the platform's
	   * default charset.
	   * @return int return int value
	   * ...
	   */
	@Deprecated(since="9",forRemoval=true)
	public int add() {
		return x+y;
	}
	public int sub() {
		return x-y;
	}

}
