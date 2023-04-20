package com.reeltalks.securecode;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class SecureCode {
	// 약속된 암호소수키
	final String secretKey = "104739469659726466616292665499885731397";

	public String[] encode(String code) {
		String numStr = "";
		
		// code 를 2자리수 10진법으로 변환
		for (int i = 0; i < code.length(); i++) {
			numStr = numStr + alphabetToNum(code.charAt(i));
		}
		System.out.println(numStr);
		
		BigDecimal dividend = new BigDecimal(numStr);
		BigDecimal divisor = new BigDecimal(secretKey);

		// 몫과 나머지를 모두 계산
		BigDecimal[] result = dividend.divideAndRemainder(divisor);

		String quotient = result[0].toString(); // 몫을 문자열로 변환
		String remainder = result[1].toString(); // 나머지를 문자열로 변환
		
		String[] encryptedData = {quotient, remainder};
		
		return encryptedData;
	}
	
	public String decode(String[] encryptedData) {
		BigDecimal quotient = new BigDecimal(encryptedData[0]);
		BigDecimal remainder = new BigDecimal(encryptedData[1]);
		BigDecimal scretNum = new BigDecimal(secretKey);
		
		BigDecimal BD_result = quotient.multiply(scretNum).add(remainder);
		String result = BD_result.toString();
		// result는 1912590712905701275095901250... 80자리 로 나옴
		
		return result;
	}
	
	public String alphabetToNum(char alphabet) {
		
		String result = null;
		
		switch (alphabet) {
		case '0': result = "00"; break;
		case '1': result = "01"; break;
		case '2': result = "02"; break;
		case '3': result = "03"; break;
		case '4': result = "04"; break;
		case '5': result = "05"; break;
		case '6': result = "06"; break;
		case '7': result = "07"; break;
		case '8': result = "08"; break;
		case '9': result = "09"; break;
		case 'a': result = "11"; break;
		case 'b': result = "12"; break;
		case 'c': result = "13"; break;
		case 'd': result = "14"; break;
		case 'e': result = "15"; break;
		case 'f': result = "16"; break;
		case 'g': result = "17"; break;
		case 'h': result = "18"; break;
		case 'i': result = "19"; break;
		case 'j': result = "20"; break;
		case 'k': result = "21"; break;
		case 'l': result = "22"; break;
		case 'm': result = "23"; break;
		case 'n': result = "24"; break;
		case 'o': result = "25"; break;
		case 'p': result = "26"; break;
		case 'q': result = "27"; break;
		case 'r': result = "28"; break;
		case 's': result = "29"; break;
		case 't': result = "30"; break;
		case 'u': result = "31"; break;
		case 'v': result = "32"; break;
		case 'w': result = "33"; break;
		case 'x': result = "34"; break;
		case 'y': result = "35"; break;
		case 'z': result = "36"; break;
		default:
			break;
		}
		
		return result;
	}
}
