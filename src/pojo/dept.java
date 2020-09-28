package pojo;

public class dept {
	int d_id;
	String d_name;
	int d_louceng;
	public dept(int d_id, String d_name, int d_louceng) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_louceng = d_louceng;
	}
	public dept() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "dept [d_id=" + d_id + ", d_name=" + d_name + ", d_louceng=" + d_louceng + "]";
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public int getD_louceng() {
		return d_louceng;
	}
	public void setD_louceng(int d_louceng) {
		this.d_louceng = d_louceng;
	}
	

}
