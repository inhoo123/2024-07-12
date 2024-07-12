package com.callor.iolist.exec;

import java.io.FileNotFoundException;
import java.nio.file.attribute.AclEntry;

import com.callor.iolist.service.IolistService;
import com.callor.iolist.service.impl.IolistServiceImplV1;

public class IolistExecA {
	public static void main(String[] args) {
		IolistService iolistService = null;
		String ioListFile = "src/com/callor/iolist/iolist.txt";
		try {
			iolistService = new IolistServiceImplV1(ioListFile);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		iolistService.loadIolistData();
		iolistService.printIolistList();
	}

}
