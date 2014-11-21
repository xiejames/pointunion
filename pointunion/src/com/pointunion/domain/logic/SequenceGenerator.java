package com.pointunion.domain.logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class SequenceGenerator {
	public static void main(String args[]) {
		System.out.println(SequenceGenerator.getInstnce().nextPassword());
		System.out.println(SequenceGenerator.getInstnce().nextPassword());
		System.out.println(SequenceGenerator.getInstnce().nextPassword());
		System.out.println(SequenceGenerator.getInstnce().nextPassword());
	}

	private static SequenceGenerator instance = new SequenceGenerator();

	public static SequenceGenerator getInstnce() {
		return instance;
	}

	private Generator customerNoGenerator = new SeqGenerator("");

	private Generator acctountNoGenerator = new SeqGenerator("");

	private Generator changeSeqGenerator = new SeqGenerator("");

	private Generator pwdGenerator = new PasswordGenerator(8);

	private SequenceGenerator() {
	}

	public String nextCustomerNo() {
		return customerNoGenerator.nextSeq();
	}

	public String nextAccountNo() {
		return acctountNoGenerator.nextSeq();
	}

	public String nextChangeSeq() {
		return changeSeqGenerator.nextSeq();
	}

	public String nextPassword() {
		return pwdGenerator.nextSeq();
	}
}

interface Generator {
	String nextSeq();
}

class PasswordGenerator implements Generator {
	char[] charArr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	int pwdLength = 8;

	PasswordGenerator(int pwdLength) {
		this.pwdLength = pwdLength;
	}

	public String nextSeq() {
		Random r = new Random();
		char arr[] = new char[pwdLength];
		int count = 0;
		while (count < pwdLength) {
			int t = r.nextInt(36);
			arr[count] = charArr[t];
			count++;
		}
		return new String(arr);
	}
}

class SeqGenerator implements Generator {
	private String curMinutes = null;

	private int count = 0;

	private int maxCount = 10000;

	private String head;

	SeqGenerator(String head) {
		this.head = head;
	}

	SimpleDateFormat sf = new SimpleDateFormat("yyyyDDD");

	// yyyyDDDmmmmSSSSC 4位年 + 3位天 + 4位分钟 + 4位流水号 + 1位checksum
	public synchronized String nextSeq() {
		if (!getCurMinutes().equals(curMinutes) || count >= maxCount) {
			curMinutes = getCurMinutes();
			count = 0;
		}
		StringBuffer buf = new StringBuffer(16);
		buf.append(curMinutes).append("0000").append(count++);
		buf.delete(11, buf.length() - 4).append(checkSum(buf.toString()));
		buf.insert(0, head);
		return buf.toString();

	}

	private int checkSum(String str) {
		char[] arr = str.toCharArray();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			sum += c;
		}
		return sum % 10;
	}

	// yyyyDDDmmmm
	private String getCurMinutes() {
		StringBuffer buf = new StringBuffer(16);
		Date now = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		buf.append(sf.format(now)).append("0000").append(c.get(Calendar.HOUR_OF_DAY) * 60 + c.get(Calendar.MINUTE));
		buf.delete(7, buf.length() - 4);
		return buf.toString();
	}
}
