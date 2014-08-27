package raine;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

public class JodaTimeTest<T> {

	private static DateTime TicksToDateTime(long ticks) {
        return new DateTime(ticks);
    }
	
//	public User	Call<T,User>(T arg) {
//		return (User)(object)TicksToDateTime((long)(object)arg);
//    }
	
	public static void main(String[] args) {
//		List<Integer> iList = new ArrayList<Integer>();
//		List<Number> nList = iList; // not allowed
//		nList.add(0.5);
		
		
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(new Integer(3));
		List<? extends Number> nList = iList;
		Number n = nList.get(0);
		for (Number number : nList) {
			System.out.println(number);
		}
		//		nList.add(0.5); // Not allowed
	}
}
