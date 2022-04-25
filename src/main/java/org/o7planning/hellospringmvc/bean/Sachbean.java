package org.o7planning.hellospringmvc.bean;

import java.sql.Timestamp;

public class Sachbean {
	private String masach;
	private String tensach;
	private String tacgia;
	private Long gia;
	private Long soluong;
	private Timestamp ngaynhap;
	private String anh;
	private String maloai;
	public Sachbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sachbean(String masach, String tensach, String tacgia, Long gia, Long soluong,Timestamp ngaynhap, String anh, String maloai) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.tacgia = tacgia;
		this.gia = gia;
		this.soluong = soluong;
		this.ngaynhap=ngaynhap;
		this.anh = anh;
		this.maloai = maloai;
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
	public Long getSoluong() {
		return soluong;
	}
	public void setSoluong(Long soluong) {
		this.soluong = soluong;
	}
	public Timestamp getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Timestamp ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
}