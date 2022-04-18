package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private static BigInteger hashint;

	public static BigInteger hashOf(String entity) {

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest

		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// compute the hash of the input 'entity'

		byte[] result = md.digest(entity.getBytes());

		// convert the hash into hex format

		String hex = toHex(result);

		// convert the hex into BigInteger

		hashint = new BigInteger(hex, 16);

		// return the BigInteger

		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// get the digest length

		// compute the number of bits = digest length * 8

		int bits = bitSize();

		// compute the address size = 2 ^ number of bits

		BigInteger size = new BigInteger(new byte[] { 1 });

		size = size.shiftLeft(bits);

		// return the address size

		return size;
	}

	public static int bitSize() {

		int digestlen = 16;

		// find the digest length

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
