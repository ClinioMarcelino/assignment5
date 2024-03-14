package a5;

/**
 * @author Clinio Marcelino
 * 
 * @precondition x and y are in the inclusive range [-100,100]
 * 
 * @date March 12 2024
 * @version 1.0
 * 
 * 
 */
public class Node {

	private int x = 0;
	private int y = 0;

	final int xAndYmax = 100;
	final int xAndYmin = -100;
	
	/**
	 * Default constructor, lead to x and y  =0
	 * @throws Exception
	 */
	public Node() throws Exception {
		this(0, 0);

	}
	
	/**
	 * Copy constructor: receives an object of the class and copy the values.
	 * @param obj -> should be an instance of the class Node
	 * @throws Exception> in case Object is not an intanceof Node.
	 */
	public Node(Object obj) throws Exception {
		if (!(obj instanceof Node))
			throw new Exception("The Object is not an Node Object");

		Node nd = (Node) obj;

		this.setX(nd.getX());
		this.setY(nd.getY());
	}

	/**
	 * Classic constructor, sets X and Y if in range
	 * @param x
	 * @param y
	 * @throws Exception> in case x or y are out of the range.
	 */
	public Node(int x, int y) throws Exception {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	/**
	 * Setting the <b>x</b> value
	 * @precondion <b>x</b> is in the valid range
	 * @param x
	 * @throws Exception
	 */
	public void setX(int x) throws Exception {
		if (isValidXandY(x))
			this.x = x;
		else
			throw new Exception("The value of X must be in the range [-100,100]");
	}
	
	/**
	 * Setting the <b>y</b> value
	 * @precondion <b>y</b> is in the valid range
	 * @param y
	 * @throws Exception
	 */
	public void setY(int y) throws Exception {
		if (isValidXandY(y))
			this.y = y;
		else
			throw new Exception("The value of Y must be in the range [-100,100]");
	}

	/**
	 * Private method that validate the <b>x</b> and <b>y</b>
	 * @preconditon in the inclusive range <b>[-100,100]</b>
	 * @param num
	 * @return true if valid<br>false if invalid
	 */
	private boolean isValidXandY(int num) {
		if (num >= xAndYmin && num <= xAndYmax)
			return true;
		return false;
	}

	/**
	 * Method for adding the <b>x</b> and <b>y</b> values of two classes
	 * @param nd -> instance of Node
	 * @throws Exception> in case of stepping out of the range
	 */
	public void add(Node nd) throws Exception {
		int sumX = nd.getX() + this.x;
		int sumY = nd.getY() + this.y;
		
		if (!isValidXandY(sumX))
			throw new Exception("Adding the two X's lead to " + sumX + " getting out of the range [-100,100]");
		else if (!isValidXandY(sumY))
			throw new Exception("Adding the two Y's lead to " + sumY + " getting out of the range [-100,100]");
		setX(nd.getX() + this.x);
		setY(nd.getY() + this.y);
	}

	
	/**
	 * Method for verifying if the two instances of the object Node have the same values for <b>x</b> and <b>y</b>
	 * @param nd -> instance of Node
	 * @return true if equals<br>false if different
	 */
	public boolean equals(Node nd) {
		if (this.x == nd.getX() && this.y == nd.getY())
			return true;
		return false;
	}

	/**
	 * @Overrides toString() in Object class
	 */
	public String toString() {
		return "Node: x= " + x + ", y= " + y;
	}

	public static void main(String[] args) throws Exception {
		Node n1 = new Node();
		System.out.println(n1);

		Node n2 = new Node(33, 45);
		System.out.println(n2);

		Node n3 = new Node(-90, 3);
		System.out.println(n3);
		
		Node n4 = new Node(n1);
		System.out.println(n4);
		
		Node n5 = new Node(n2);
		System.out.println(n5.equals(n1));
	}
}
