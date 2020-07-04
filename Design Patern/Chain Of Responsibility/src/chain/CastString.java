package chain;

public class CastString extends CastChain {

	public CastString(CastChain next) {
		super(next);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object cast(Package value) {
		return value.getValue();
	}

}
