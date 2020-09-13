package dto;

public class MemberDTO {

	String mid; 
	String mpassword; 
	String mname; 
	String mbirth; 
	String memail; 
	String maddress;
	String mphone; 
	String mphoto;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMaddress() {
		return maddress;
	}
	public void setMaddress(String maddress) {
		this.maddress = maddress;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMphoto() {
		return mphoto;
	}
	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mbirth=" + mbirth
				+ ", memail=" + memail + ", maddress=" + maddress + ", mphone=" + mphone + ", mphoto=" + mphoto + "]";
	}
	public MemberDTO(String mid, String mpassword, String mname, String mbirth, String memail, String maddress,
			String mphone, String mphoto) {
		super();
		this.mid = mid;
		this.mpassword = mpassword;
		this.mname = mname;
		this.mbirth = mbirth;
		this.memail = memail;
		this.maddress = maddress;
		this.mphone = mphone;
		this.mphoto = mphoto;
	}
	public MemberDTO() {
		super();
	}
	
}
