package com.xiaohang;

import java.io.File;

public class Main {
	
	public static void main(String[] args) throws Exception {
		int len = args.length;
		
		//目前文件必须是包含路径的全名
		File file = new File(args[args.length - 1]);
		if (!file.isFile()) {
			System.out.println("The last parameter must be a valid pathname");
			System.exit(0);
		}
		for (int i = 0; i < len - 1; i++) {
			switch (args[i]) {
			
			//统计单词
			case "-w":
				int wordCount = Utils.wordCount(file);
				System.out.println("total words: " + wordCount);
				break;
				
			//统计字符
			case "-c":
				int charCount = Utils.charCount(file);
				System.out.println("total characters: " + charCount);
				break;
				
			//统计行数
			case "-l":
				int lineCount = Utils.lineCount(file);
				System.out.println("total lines: " + lineCount);
				break;
			default:
				System.out.println("you enter a invalid parameter!");
				break;
			}
		}
	}

}
