package raine;

import java.lang.reflect.Array;

public class ArrayExample<T> {

	 private Class<T> clazz;

    public ArrayExample(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T[] getArray(int size) {
        return (T[])Array.newInstance(clazz, size);
    }
    
    public static void main(String[] args) {
//    	System.out.println(new ArrayExample<TestSlf4J>(TestSlf4J.class).getArray(1));
//    	new ArrayExample<TestSlf4J>(TestSlf4J.class).getArray(0)[0].test();
	}
}
