package org.o7planning.hellospringmvc.bean;


public class Giohangbean {
	private String masach;
	private String tensach;
	private String tacgia;
	private Long gia;
	private Long slmua;
	public Giohangbean(String masach, String tensach, String tacgia, Long gia, Long slmua) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.slmua = slmua;
	}
	
	public Giohangbean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public String getTacgia() {
		return tacgia;
	}
	public void setTacgia(String tacgia) {
		this.tacgia = tacgia;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public Long getSlmua() {
		return slmua;
	}
	public void setSlmua(Long slmua) {
		this.slmua = slmua;
	}
	public Long getThanhtien() {
		return slmua*gia;
	}
	
}
