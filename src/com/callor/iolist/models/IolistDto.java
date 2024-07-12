package com.callor.iolist.models;

import java.util.Date;

public class IolistDto {
	// * 거래일자,거래시각,거래구분,상품명,수량,가격*/
	public String io_date;
	public String io_time;
	public String io_type;
	public String io_name;
	public String io_quantity;
	public String io_price;

	public int phurchase() {
		int phurchase = Integer.parseInt(io_quantity) * Integer.parseInt(io_price) ;

		return phurchase;
	}
	
	public int sell() {
		int sell = Integer.parseInt(io_quantity) * Integer.parseInt(io_price) ;

		return sell;
	}
	public int totalphurchase() {
		int totalPhurchase =+ Integer.parseInt(io_quantity) * Integer.parseInt(io_price) ;

		return totalPhurchase;
	}
	public int totalSell() {
		int totalSell =+ Integer.parseInt(io_quantity) * Integer.parseInt(io_price) ;

		return totalSell;
	}

	@Override
	public String toString() {
		return "IolistDto [io_date=" + io_date + ", io_time=" + io_time + ", io_type=" + io_type + ", io_name="
				+ io_name + ", io_quantity=" + io_quantity + ", io_price=" + io_price + "]";
	}

//매입금액
//매출금액	

}
