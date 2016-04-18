package cardPoint.model;

public class APIReturnBean {
	private int overPoint;
	private boolean result;
	
	public int getOverPoint() {
		return overPoint;
	}
	public void setOverPoint(int overPoint) {
		this.overPoint = overPoint;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "APIReturnBean [overPoint=" + overPoint + ", result=" + result
				+ "]";
	}
	
}
