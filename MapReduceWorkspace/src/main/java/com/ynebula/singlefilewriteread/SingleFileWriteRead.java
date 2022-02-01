package com.ynebula.singlefilewriteread;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/*
org.apache.hadoop.fs 패키지로 로컬이나 HDFS 파일을 제어할수 있습니다.

HDFS를 제어하기 위해서 Configuration 객체를 생성하고, FileSystem의 get 메서드에 Configuration 객체를 전달해 FileSystem을 획득합니다.
org.apache.hadoop.conf.Configuration은 하둡 환경설정 파일에 접근하기 위한 클래스입니다.
이 클래스를 이용해 core-default.xml과 core-site.xml 등에 정의된 값을 조회하거나 변경할 수 있습니다.

FileSystem은 파일 시스템을 추상화한 클래스이며, 이 클래스를 이용해 로컬 파일 시스템이나 HDFS를 제어할 수 있습니다.
FileSystem 클래스의 get 메서드를 호출하면 파라미터로 설정한 Configuration 객체가 사용하는 HDFS를 반환합니다.

FSDataOutputStream은 DataOutputStream을 래핑한 유틸리티 클래스로서, 버퍼에 데이터를 출력하고, 데이터 검증을 위한 체크섬 파일도 생성합니다.

파일읽기는 FSDataInputStream은 DataInputStream을 래핑한 유틸리티 클래스로서, open 메서드를 호출해 파일을 조외하고, readUTF 메서드를 호출해 파일의 내용을 문자열 변수에 저장합니다.

FSDataOutputStream, FSDataInputStream 클래스는 반드시 close 메서드를 호출해 스트림을 닫아야 합니다.
 */

public class SingleFileWriteRead {
    // 사용자에게서 파일이 저장될 경로와 파일에 생성할 문자열을 입력 받습니다
    // arg[0]: 사용자가 지정한 경로
    // arg[1]: 내용
    public static void main(String[] args) {
        // 입력 파라미터 확인
        if (args.length != 2) {
            System.out.println("Usage: SingleFileWriteRead <filename> <contens>");
            System.exit(2);
        }

        try {
            // 파일 시스템 제어 객체 생성
            Configuration conf = new Configuration();
            FileSystem hdfs = FileSystem.get(conf);

            // 경로 체크
            // 해당 경로가 HDFS에 이미 존재할 경우 삭제
            // 경로 확인이나 삭제는 FileSystem의 API를 호출해서 수행
            Path path = new Path(args[0]);
            if (hdfs.exists(path)) {
                hdfs.delete(path, true);
            }

            // 파일 저장
            FSDataOutputStream outStream = hdfs.create(path);
            outStream.writeUTF(args[1]);
            outStream.close();

            // 파일 출력
            FSDataInputStream inputStream = hdfs.open(path);
            String inputString = inputStream.readUTF();
            inputStream.close();

            System.out.println("## inputString:" + inputString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
