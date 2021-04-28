package com.window_programming_api.file.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.window_programming_api.dto.MyFileDTO;
import com.window_programming_api.file.service.IFileService;
import com.window_programming_api.utils.MyFileUtil;

@Service
public class FileService extends BaseFileService implements IFileService {

	@Override
	public String upFileGetLink(MyFileDTO fileDto) {
		byte[] data = Base64.getDecoder().decode(fileDto.getBase64String().getBytes());

		// Check if dir is not exist
		StringBuilder fileName = new StringBuilder("");
		StringBuilder rootPath = new StringBuilder("");

		Boolean check = false;
		for (int i = fileDto.getFileName().length() - 1; i >= 0; i--) {
			if (fileDto.getFileName().charAt(i) != '/' && !check)
				fileName.append(fileDto.getFileName().charAt(i));
			else
				check = true;
			if (check)
				rootPath.append(fileDto.getFileName().charAt(i));
		}
		fileName = fileName.reverse();
		rootPath = rootPath.reverse();
		rootPath = new StringBuilder(MyFileUtil.removeDoubleSlash("src/main/resources/sources/" + rootPath.toString()));
		File uploadRootDir = new File(rootPath.toString());
		if (!uploadRootDir.exists())
			uploadRootDir.mkdirs();

		// try to write file to drive
		try (OutputStream stream = new FileOutputStream(
				uploadRootDir.getAbsolutePath() + "/" + fileName + "." + fileDto.getFileType())) {
			stream.write(data);
			stream.close();

			// Get fileLink return
			StringBuilder linkRoot = new StringBuilder(rootPath.toString().replace("src/main/resources/sources/", ""));
			String fileLink = "/api/file/" + linkRoot + fileName + "." + fileDto.getFileType();
			fileLink = MyFileUtil.removeDoubleSlash(fileLink);

			return fileLink;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public byte[] getFileAsByte(HttpServletRequest request, String moduleURL) {
		// get root path
		File rootPath = new File("src/main/resources/");

		// get file name
		String requestURL = request.getRequestURL().toString();
		String fileName = requestURL.split(moduleURL)[1];

		// return FileUtil.getInstance().getByteBySource("/sources/student/" +
		// fileName);
		return MyFileUtil.getByteBySource(rootPath.getAbsolutePath() + "/sources/student/" + fileName);
	}

	@Override
	public void deleteFolder(String folderPath) {
		try {
			FileUtils.deleteDirectory(new File(MyFileUtil.removeDoubleSlash("src/main/resources/sources/" + folderPath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
