package org.o7planning.hellospringmvc.bean;

import java.sql.Timestamp;

public class Hoadonbean {
	private long mahoadon;
	private String hoten;
	private Timestamp ngaymua;
	private long totalsl;
	private long totalgia;
	private long thanhtien;
	public Hoadonbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hoadonbean(long mahoadon, String hoten, Timestamp ngaymua, long totalsl, long totalgia, long thanhtien) {
		super();
		this.mahoadon = mahoadon;
		this.hoten = hoten;
		this.ngaymua = ngaymua;
		this.totalsl = totalsl;
		this.totalgia = totalgia;
		this.thanhtien = thanhtien;
	}
	public long getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(long mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Timestamp getNgaymua() {
		return ngaymua;
	}
	public void setNgaymua(Timestamp ngaymua) {
		this.ngaymua = ngaymua;
	}
	public long getTotalsl() {
		return totalsl;
	}
	public void setTotalsl(long totalsl) {
		this.totalsl = totalsl;
	}
	public long getTotalgia() {
		return totalgia;
	}
	public void setTotalgia(long totalgia) {
		this.totalgia = totalgia;
	}
	public long getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
	}
	
}
