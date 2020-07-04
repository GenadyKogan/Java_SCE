package chain;

public class CastDouble extends CastChain {

	public CastDouble(CastChain next) {
		super(next);
	}

	@Override
	public Object cast(Package value) {
		try {
			return Double.parseDouble(value.getValue());
		}
		catch(NumberFormatException e) {
			if (next!=null) return next.cast(value);
			return null;
		}
	}

}
