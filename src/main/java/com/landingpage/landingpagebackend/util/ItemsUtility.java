package com.landingpage.landingpagebackend.util;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.fasterxml.jackson.core.util.ByteArrayBuilder;

public class ItemsUtility {
	 public static byte[] compressImage(byte[] data) {

	        Deflater deflater = new Deflater();
	        deflater.setLevel(Deflater.BEST_COMPRESSION);
	        deflater.setInput(data);
	        deflater.finish();

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	        byte[] tmp = new byte[4*1024];
	        while (!deflater.finished()) {
	            int size = deflater.deflate(tmp);
	            outputStream.write(tmp, 0, size);
	        }
	        try {
	            outputStream.close();
	        } catch (Exception e) {
	        }
	        return outputStream.toByteArray();
	    }

	    public static byte[] decompressImage(byte[] data) {
	        Inflater inflater = new Inflater();
	        inflater.setInput(data);
	        ByteArrayBuilder outputStream = new ByteArrayBuilder(data.length);
	        byte[] tmp = new byte[4*1024];
	        try {
	            while (!inflater.finished()) {
	                int count = inflater.inflate(tmp);
	                outputStream.write(tmp, 0, count);
	            }
	            outputStream.close();
	        } catch (Exception exception) {
	        }
	        return outputStream.toByteArray();
	    }
}
