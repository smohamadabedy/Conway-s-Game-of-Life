import com.cwgl.society;


public class test {
    public static  void  main(String[] args){
		try{
			society sc = new society(5,5,3);
			System.out.println(sc.random_pop(0,6,10));
			sc.printSociety();
		}catch(Throwable ex){
			System.out.println("Error");
		}
		
		System.out.println("Done ...");

    }
}
