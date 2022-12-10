package fr.daart.y2015.ex04;

import fr.daart.y2015.AoC2015;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AoC201504 extends AoC2015 {

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    @Override
    public int getDay() {
        return 4;
    }

    @Override
    public void part1() {

        var input = readInputAsString("input.txt");

        int counter = 0;
        String hash = "";
        while(!hash.startsWith("00000")) {
            counter++;
            hash = getMd5Hash(input+counter);
        }

        var result = counter;
        System.out.println("Part 1: "+result);
    }

@Override
    public void part2() {
    var input = readInputAsString("input.txt");

    int counter = 0;
    String hash = "";
    while(!hash.startsWith("000000")) {
        counter++;
        hash = getMd5Hash(input+counter);
    }

    var result = counter;
    System.out.println("Part 2: "+result);
    }


    public String getMd5Hash(String input) {
        try {
            byte[] bytesOfMessage = input.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theMD5digest = md.digest(bytesOfMessage);

            return bytesToHex(theMD5digest);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
