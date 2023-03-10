package com.ssafy.h_fileio.io.node;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class UseFileStream {
	public static void main(String[] args) throws IOException {
		UseFileStream st = new UseFileStream();
		st.testFile();

		// System.out.printf("buffer size: %d, time: %d%n", 100, st.fileMove(100));
		// System.out.printf("buffer size: %d, time: %d%n", 1000, st.fileMove(1000));
		// System.out.printf("buffer size: %d, time: %d%n", 10000, st.fileMove(10000));
		// System.out.printf("buffer size: %d, time: %d%n", 100000,
		// st.fileMove(100000));
		// System.out.printf("buffer size: %d, time: %d%n", 1000000,
		// st.fileMove(1000000));
	}

	private void testFile() throws IOException {
		// 절대 경로
		File temp = new File("c:\\Temp");
		System.out.printf("존재? %b, 디렉토리? %b%n", temp.exists(), temp.isDirectory());

		// 상대경로
		File current = new File(".");
		System.out.printf("여기는 어디? %s%n", current.getCanonicalPath());

		// 상대경로의 기준은 java program을 실행하는 위치(소스와 무관)
		// d:\>java -cp .;c:\SSAFY\workspace\java\live\bin
		// com.ssafy.live5.io.node.UseFileStream
		// c:\SSAFY\workspace\java\live\bin>java com.ssafy.live5.io.node.UseFileStream

		// TODO: readme.txt에 해당하는 File 객체를 만들어 보자.
//        File readMe = new File("C:\\SSAFY\\workspace\\02-Java\\01-SsafyLive\\bin\\com\\ssafy\\h_fileio\\io\\node");
//        System.out.println(readMe.canRead());
//        URL url = UseFileStream.class.getResource("com/ssafy/h_fileio/io/node/readme.txt");
		URL url = UseFileStream.class.getResource("./readme.txt");
		File readMe = new File(url.getFile());
		System.out.println(readMe.canRead());
		// END:
	}

	public long fileMove(int bufferSize) {
		long start = System.currentTimeMillis();
		// TODO: 본인의 컴퓨터에서 크기가 큰 파일을 선택하세요.
		File sr = new File("다운로드/JavaTest_city_ban_name.zip");
		File target = new File("JavaTest_city_ban_name.zip");
		// END:
		return System.currentTimeMillis() - start;
	}
}
