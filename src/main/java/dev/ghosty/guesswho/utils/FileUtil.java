package dev.ghosty.guesswho.utils;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

@UtilityClass
public final class FileUtil {
	
	public static void copy(File source, File destination) throws IOException {
		if(source.isDirectory()) {
			if(!destination.exists())
				destination.mkdir();
			String[] files = source.list();
			if(files == null)
				return;
			for(String file : files) {
				File newSource = new File(source, file);
				File newDest = new File(destination, file);
				copy(newSource, newDest);
			}
		} else {
			InputStream in = Files.newInputStream(source.toPath());
			OutputStream out = Files.newOutputStream(destination.toPath());
			byte[] buffer = new byte[1024];
			int length;
			while((length = in.read(buffer)) > 0)
				out.write(buffer, 0, length);
			in.close();
			out.close();
		}
	}
	
	public static void delete(File file) {
		if(!file.exists())
			return;
		if(file.isDirectory()) {
			String[] files = file.list();
			if(files == null)
				return;
			for(String f : files)
				delete(new File(file, f));
		} else
			file.delete();
	}
	
}