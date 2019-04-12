package com.swj.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class Test {

	public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		FileSystem fs = FileSystem.get(new URI("hdfs://red111:9000"), configuration,"swj");
		// 2 获取输出流
		FSDataOutputStream fos = fs.create(new Path("/LICENSE.txt.txt"));
		// 3 写数据
		fos.write("hello".getBytes());
		// 4 一致性刷新
		fos.hflush();
		// 5 关闭资源
		fos.close();
		fs.close();

	}

}
