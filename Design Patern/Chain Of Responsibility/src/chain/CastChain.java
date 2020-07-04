package chain;

public abstract class CastChain {
	
	CastChain next;
	
	public CastChain(CastChain next) {
		this.next = next;
	}

	public abstract Object cast(Package value);
}
