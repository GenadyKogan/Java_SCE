package chain;

public class Test {

	public static void main(String[] args) {
		//correct chain
		CastChain chain = new CastInt(new CastDouble(new CastString(null)));
		
		//wrong chains - some examples
//		CastChain chain = new CastDouble(new CastInt(new CastString(null)));
//		CastChain chain = new CastDouble(new CastInt(null));
		
		//wrong chain - from the exam (gimel)!
		//order of the two last nodes is not important!
//		CastChain chain = new CastString(new CastInt(new CastDouble(null)));
		
		System.out.print("1. "); System.out.println(chain.cast(new Package("143")) instanceof Integer);
		System.out.print("2. ");System.out.println(chain.cast(new Package("143")) instanceof Double);
		System.out.print("3. ");System.out.println(chain.cast(new Package("143")) instanceof String);
		System.out.print("4. ");System.out.println(chain.cast(new Package("143.8")) instanceof Double);
		System.out.print("5. ");System.out.println(chain.cast(new Package("143.8")) instanceof Integer);
		System.out.print("6. ");System.out.println(chain.cast(new Package("ab8")) instanceof String);
	}

}
