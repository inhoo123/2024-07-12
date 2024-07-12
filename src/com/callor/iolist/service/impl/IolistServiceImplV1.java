package com.callor.iolist.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.callor.iolist.models.IolistDto;
import com.callor.iolist.service.IolistService;
import com.callor.iolist.utils.Contract;
import com.callor.iolist.utils.Line;

public class IolistServiceImplV1 implements IolistService {
	// 제목

	protected final String iolistDataFile;

	protected String[] iolistTitle;
	protected final List<IolistDto> iolistList;
	protected final Scanner fileReader;

	public IolistServiceImplV1(String iolistDataFile) throws FileNotFoundException {

		this.iolistDataFile = iolistDataFile;
		this.iolistList = new ArrayList<>();
		InputStream in = new FileInputStream(this.iolistDataFile);
		this.fileReader = new Scanner(in);
	}

	@Override
	public void loadIolistData() {
		iolistTitle = fileReader.nextLine().split(",");

		while (fileReader.hasNext()) {
			String line = fileReader.nextLine();
			String[] lines = line.split(",");
			IolistDto dto = new IolistDto();
			dto.io_date = lines[0];
			dto.io_time = lines[1];
			dto.io_type = lines[2];
			dto.io_name = lines[3];
			dto.io_quantity = lines[4];
			dto.io_price = lines[5];
			iolistList.add(dto);
		}
	}

	@Override
	public void printIolistList() {

		int[] phurchaseTotal = new int[iolistList.size()];
		
		System.out.println(Line.dLine(100));
		System.out.print("거래일자   거래구분    상품이름    매입금액     매출금액");
		System.out.println();
		System.out.println(Line.sLine(100));

		for (IolistDto dto : iolistList) {
			System.out.print(dto.io_date + " ");
			if (Integer.parseInt(dto.io_type) == 1) {
				System.out.print("매입  ");
				System.out.printf(dto.io_name);
				System.out.printf(":");
				System.out.println("  " + dto.phurchase() + "매입금");

			} else {
				System.out.print("매출  ");
				System.out.printf(dto.io_name);
				System.out.printf(":");
				System.out.println("  " + dto.sell() + "매출금");
			}
			
		}
		System.out.println(Line.sLine(100));
		System.out.print("거래건수");
		System.out.println(iolistList.size() + "건");
		// System.out.println("총매입금"+dto);
	}

}
