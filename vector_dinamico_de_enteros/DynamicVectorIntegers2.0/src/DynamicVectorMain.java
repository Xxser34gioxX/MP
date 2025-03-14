
public class DynamicVectorMain {

	public static void main(String[] args) {
		int[] vI = { 1, 2, 3, 4, 5 };
		DynamicVectorIntegers dVI = new DynamicVectorIntegers(vI);
		dVI.show();

		for (int i = 6; i < 14; i++) {
			dVI.add(i);
			dVI.show();
		}

		for (int i = 0; i < 9; i++) {
			dVI.pop();
			dVI.show();
		}

		for (int i = 10; i < 15; i++) {
			dVI.add(i);
			dVI.show();
		}

		dVI.remove(2);
		dVI.show();

		dVI.insert(3, 20);
		dVI.show();

		int[] v1 = { 1, 2, 3, 4, 5 };
		DynamicVectorIntegers dVI1 = new DynamicVectorIntegers(v1);
		int[] v2 = { 11, 12, 13, 14, 15 };
		DynamicVectorIntegers dVI2 = new DynamicVectorIntegers(v2);

		// Now, some interesting algorithms (Implemented in the class
		// DynamicVectorIntegers)

		// 1.- Get from a dVI another that contain only the even numbers

		// DynamicVectorIntegers dVI1 = dVI.onlyEven();
		// dVI1.show();

		// 2.- Check if all elements in the vector provided as parameter are contained
		// in this vector

		// boolean h = dVI.contains(dVI1);

		// System.out.println(h);

		// 3.- Remove all elements that are negative

		// int[] v1 = {-1,-2,1,-2,2,-3,-4,-5,3,-6,4};
		// DynamicVectorIntegers dVI3 = new DynamicVectorIntegers(v1);
		// dVI3.removeNegatives();
		// dVI3.show();

		// 4.- Of course: sort a dVI (ascending)

		// dVI.sort();

		// 5.- Check if a vector is sorted

		// boolean h1 = dVI.isSorted();

		// 6.- The same as in 2., but assuming that the two dVIs are sorted

		// boolean h2 = dVI.containsSorted(dVI1);

		// 7.- Remove duplicated values in a sorted dVI

		// dVI.removeDuplicatesSorted();

		// 8.- Remove all instances of x in a vector (not necessarily sorted)

		// dVI.removeAllInstances(25);

		// 9.- Insert a new element in a sorted dVI maintaining it sorted

		// dVI.insertSorted(23);

		// 10.- Given another dVI, both sorted, get another dVI that contains all
		// elements from both sorted as well.

		// DynamicVectorIntegers dVI2 = dVI.mixSorted(dVI1);
		// dVI2.show();

		// 11.- Return a new vector as the concatenation of this one and other given as
		// parameter.

		// DynamicVectorIntegers dVI4 = dVI.concat(dVI1);
		// dVI4.show();

		// 12.- Given another dVI, identify if the values from the vector given as
		// parameter appear in this one in the same order and consecutively
		// from any position. If this is true, return the position of the first time it
		// appears

		// int pos1 = dVI1.isSubVector(dVI2);

	}

}
