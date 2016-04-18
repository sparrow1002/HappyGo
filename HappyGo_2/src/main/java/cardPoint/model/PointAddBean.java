package cardPoint.model;

public class PointAddBean {
	private int projId;
	private int pointAdd;
	
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
	}
	public int getPointAdd() {
		return pointAdd;
	}
	public void setPointAdd(int pointAdd) {
		this.pointAdd = pointAdd;
	}
	@Override
	public String toString() {
		return "pointAddBean [projId=" + projId + ", pointAdd=" + pointAdd
				+ "]";
	}
	
}
