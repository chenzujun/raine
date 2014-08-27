package raine;

public class GetObj<T> {

	 private T myObj ;

	public T getMyObj() {
		return myObj;
	}

	public void setMyObj(T myObj) {
		this.myObj = myObj;
	}

	public static void main(String[] args) {
		GetObj<String> strObj = new GetObj<String>();

        strObj.setMyObj("Hello Nissay");

        System.out.println(strObj.getMyObj());

 

        GetObj<Double> douObj = new GetObj<Double>();

         douObj.setMyObj(new Double("116023"));

         System.out.println(douObj.getMyObj());
	}
}
