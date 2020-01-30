package com.oreilly.servlet.multipart;

import java.io.*;
import java.util.*;
import java.text.*;

//MultipartRequest에 기본으로 있는 DefaultFileRenamePolicy.java 파일을 수정한것
//업로드되는 파일의 파일명을 아이디_현재날짜시간으로 표시, 만약 중복된다면 파일명 끝에 숫자를 +1씩 하면서 붙임

public class FileUploadRename implements FileRenamePolicy {

	private String userId;

	public FileUploadRename() {
	}

	public FileUploadRename(String userId) {
		this.userId = userId;
	}

	public File rename(File f) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date nowdate = new Date();
		String dateString = formatter.format(nowdate);

		String name = f.getName();
		String ext = null;

		int dot = name.lastIndexOf(".");
		if (dot != -1) {
			ext = name.substring(dot); // includes "."
		} else {
			ext = "";
		}

		int count = 0;
		do {
			count++;
			String newName = userId + "_" + dateString + count + ext;
			f = new File(f.getParent(), newName);
		} while (!createNewFile(f) && count < 9999);

		return f;
	}

	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		} catch (IOException ignored) {
			return false;
		}
	}
}
