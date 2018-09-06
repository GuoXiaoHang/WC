package com.xiaohang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

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
				//用来统计纯文本是准确的，统计代码时会出现意外的结果
				BufferedReader word_br = new BufferedReader(new FileReader(file));
				StringBuilder sb = new StringBuilder();
				String word_line;
				while ((word_line=word_br.readLine()) != null) {
					sb.append(word_line);
					sb.append("\r");
				}
				String text = new String(sb);
				String[] target = {"\r", ".", " ", "!", "?", "\t", "\n", "\r\n"};
				String newText = null;
				for (int j = 0; j < target.length; j++) {
					newText = text.replace(target[j], ",");
					text = newText;
				}
				String[] words = text.split(",");
				int wordCount = 0;
				for (int j = 0; j < words.length; j++) {
					if (!words[j].equals("")) {
						wordCount++;
					}
				}
				System.out.println("total words: " + wordCount);
				break;
				
			//统计字符
			case "-c":
				BufferedReader char_br = new BufferedReader(new FileReader(file));
				int charCount = 0;
				int c;
				while ((c=char_br.read()) != -1) {
					charCount++;
				}
				System.out.println("total characters: " + charCount);
				break;
				
			//统计行数
			case "-l":
				BufferedReader line_br = new BufferedReader(new FileReader(file));
				int lineCount = 0;
				String line;
				while ((line=line_br.readLine()) != null) {
					lineCount++;
				}
				System.out.println("total lines: " + lineCount);
				break;
			default:
				System.out.println("you enter a invalid parameter!");
				break;
			}
		}
	}

}
