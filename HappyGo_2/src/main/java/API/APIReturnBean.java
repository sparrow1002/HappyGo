package API;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class APIReturnBean {
	private int overPoint;
	private boolean result;
	private int pointAdd;
	public int getPointAdd() {
		return pointAdd;
	}
	public void setPointAdd(int pointAdd) {
		this.pointAdd = pointAdd;
	}
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
				+ ", pointAdd=" + pointAdd + "]";
	}
	
	
}
