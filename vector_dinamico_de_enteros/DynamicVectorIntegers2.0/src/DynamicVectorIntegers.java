/**
 * Class that allows representing dynamic vectors of integers (int).
 * 
 * It includes operations like insert, remove, set, get, ... In this version the
 * vector grows with a scaling factor INCREMENT, and the space is freed when the
 * occupancy level is below capacity()/C1
 * 
 * restriction: the default and minimum capacity is MINIMUM elements
 */
public class DynamicVectorIntegers {
	// data representation
	private int[] data;

	private int length; // different to a data.length

	private static final int MINIMUM = 4; // minimum capacity

	private static final int INCREMENT = 2;

	private static final int C1 = 4; // 1/C1 is the limit to downsize

	// getters for length and capacity
	/**
	 * Returns the capacity of the vector, that is, the total number of slots, used
	 * or free.
	 * 
	 * @return the number of slots of the vector
	 */
	public int capacity() {
		return (data == null) ? 0 : data.length;
	}

	/**
	 * Returns the number of values stored in the vector.
	 * 
	 * @return the number of values in the vector
	 */
	public int length() {
		return length;
	}

	// Constructors
	/**
	 * Constructs a new dynamic vector with the minimum capacity and empty
	 */
	public DynamicVectorIntegers() {
		data = new int[MINIMUM];
		length = 0;
	}

	/**
	 * Construct a dynamic vector from other (copy constructor)
	 * 
	 * @param vOI dynamic vector to copy from
	 */
	public DynamicVectorIntegers(DynamicVectorIntegers vOI) {
		data = new int[vOI.capacity()];
		for (int i = 0; i < vOI.length(); i++)
			data[i] = vOI.get(i);
		length = vOI.length();
	}

	/**
	 * Construct a dynamic vector with a given capacity but empty
	 * 
	 * / * @param size capacity of the vector
	 */
	public DynamicVectorIntegers(int size) {
		data = new int[Math.max(size, MINIMUM)];
		length = 0;
	}

	/**
	 * Construct a dynamic vector from a static vector
	 * 
	 * @param v static vector to copy from
	 */
	public DynamicVectorIntegers(int[] v) {
		if (v == null) {
			data = new int[MINIMUM]; // The minimum capacity is MINIMUM
			length = 0;
		} else {
			length = v.length; // length = capacity
			data = new int[Math.max(v.length * INCREMENT, MINIMUM)]; // capacity = v.length
			for (int i = 0; i < length(); i++)
				data[i] = v[i];
		}
	}

	/**
	 * Indicates if the vector is empty or not
	 */
	public boolean isEmpty() {
		return length() == 0;
	}

	/**
	 * Returns the value stored in the vector in a given position
	 * 
	 * @param p position to retrieve
	 * @return the value stored in the requested position
	 */
	public int get(int p) {
		if (p < length && p >= 0)
			return data[p];
		else {
			// gives an error
			System.err.println("Invalid position");
			return -1;
		}
	}

	/**
	 * Prints the information of the vector in the console
	 */
	public void show() {
		System.out.println("\nDynamicVectorIntegers");
		System.out.printf("Length: %d", length());
		System.out.printf(" Capacity: %d", capacity());
		System.out.print("\nData: ");
		for (int i = 0; i < length(); i++)
			System.out.printf(" %d", data[i]);
		System.out.println();
	}

	/**
	 * Returns the position if a value in the vector. If the value is duplicated,
	 * the position of the first appearance is returned. If the value is not
	 * present, -1 is returned.
	 * 
	 * @param x the value to look for
	 * @return the position of the first time x appears, -1 if not present
	 */
	public int position(int x) {
		int i = 0;
		while (i < length()) {
			if (get(i) == x)
				return i;
			i++;
		}
		return -1;
	}

	/**
	 * Indicates if a value in present in the vector.
	 * 
	 * @param x the value to look for
	 * @return whether the value is in the vector or not
	 */
	public boolean member(int x) {
		return position(x) != -1;
	}

	// setters
	/**
	 * Set a value in the indicated position.
	 * 
	 * @param p position where the new value will be set
	 * @param x the new value
	 */
	public void set(int p, int x) {
		if (p < length() && p >= 0)
			data[p] = x;
		else
			System.err.println("Invalid position");
	}

	/**
	 * Adds a new value at the end of the vector
	 * 
	 * @param x the new value
	 */
	public void add(int x) { // adds at the end
		insert(length(), x);
	}

	/**
	 * Insert a value at the indicated position. Any value to the right of {@code p}
	 * are displaced one position to the right to make space for the new element.
	 * 
	 * @param p the position for the new element
	 * @param x the new value to store
	 */
	public void insert(int p, int x) {
		if (length() == capacity()) { // if the vector is full
			// resize to double
			int[] temp = new int[capacity() * INCREMENT];

			for (int i = 0; i < p; i++) // copy the previous values to the position i
				temp[i] = data[i];

			temp[p] = x; // set the new inserted value

			for (int i = p + 1; i <= length; i++) // move only the positions with real values
				temp[i] = data[i - 1];

			data = temp;
		} else {
			for (int i = length; i > p; i--) // move only the positions with real values (from the last)
				data[i] = data[i - 1];

			data[p] = x;

		}
		// length
		length++;
	}

	/**
	 * Adds a new value at the beginning of the vector
	 * 
	 * @param x the new value
	 */
	public void push(int x) {
		insert(0, x);
	}

	/**
	 * Deletes all the values in the vector and reduces its capacity to the minimum
	 */
	public void erase() {
		data = new int[MINIMUM]; // the minimum capacity is MINIMUM
		length = 0;
	}

	/**
	 * Removes the value at a given position. Any value to the right of {@code p}
	 * are displaced one position to the left.
	 * 
	 * @param p the position of the valued to be removed
	 */
	public void remove(int p) {
		// removes the value at position p and move the next ones to the left
		// if the length is lower than 1/C1, then resize to length * INCREMENT
		if (capacity() == MINIMUM || length() > capacity() / C1) {
			for (int i = p; i < length(); i++)
				data[i] = data[i + 1];
		} else {
			// resizing
			int[] temp = new int[Math.max(MINIMUM, length() * INCREMENT)];
			for (int i = 0; i < p; i++)
				temp[i] = data[i];
			for (int i = p; i < length() - 1; i++)
				temp[i] = data[i + 1];
			data = temp;
		}
		length = length - 1;
	}

	/**
	 * Removes the first element in the vector and returns this value.
	 * 
	 * @return the value of the first element in the vector
	 */
	public int pop() {
		if (isEmpty()) {
			System.err.println("\nEmpty vector!!");
			return -1;
		} else {
			int x = data[0];
			remove(0);
			return x;
		}
	}

}