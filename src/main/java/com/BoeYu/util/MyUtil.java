package com.BoeYu.util;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.TagException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class MyUtil {
	/**
	 * 返回当前日期的字符串表示
	 * YYYY-MM-DD
	 * @return 当前日期的字符串表示
	 */
	public static String getNowDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	public static Date getDateByString(String dateStr){
		Date date=null;
		try {
			date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 获取当前日期的Date格式化类型(yyyy-MM-dd)
	 * @return
	 */
	public static Date createDate(){
		String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		Date date=null;
		try {
			date=new SimpleDateFormat("yyyy-MM-dd").parse(nowDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 得到yyyyMMddHHmmss
	 */
	public static String getNowDateStr(){
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	/**
	 * 得到yyyyMMddHHmmss
	 */
	public static String getNowDateStr2(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 得到一个字符串形式的格式化UUID
	 * @return
	 */
	public static String getStrUUID(){
		Random random = new Random();
		int end = random.nextInt(999);
		//如果不足三位前面补0
		String endStr =String.format("%03d", end);
		return UUID.randomUUID().toString().replace("-", "")+endStr;
	}

	public static boolean deleteFile(String filePath, String fileName){
		boolean delete_flag = false;
		File file = new File(filePath + fileName);
		if (file.exists() && file.isFile() && file.delete())
			delete_flag = true;
		else
			delete_flag = false;
		return delete_flag;
	}

	public static int mp3time(File file) throws TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
		MP3File f = (MP3File) AudioFileIO.read(file);
		MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
		return audioHeader.getTrackLength();
	}
//D盘上传jpg 文件
	public static String shangchuan(MultipartFile file){
		Random d = new Random();
		String img = UUID.randomUUID().toString().replace("-", "") + d.nextInt(10000) + ".jpg";
		try {
			// uploadFile.transferTo(new
			// File(req.getServletContext().getRealPath("WEB-INF/upload"),img));
			File f=new File(GlobalUtil.getValue("upfile.path"));
			if(!f.exists()){
				f.mkdirs();
			}
			file.transferTo(new File(f, img));
		} catch (IllegalStateException e) {
			img="";
			e.printStackTrace();
		} catch (IOException e) {
			img="";
			e.printStackTrace();
		}
		return img;
	}

	public static boolean deletewj(String fileName){
		//String fileName="C:/Users/Admin/Desktop/f766.png";
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (file.delete()) {
				//System.out.println("删除单个文件" + fileName + "成功！");
                     return true;
			} else {
				return false;
				//System.out.println("删除单个文件" + fileName + "失败！");
			}
		} else {
			//System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}

	public static String getOrderIdByUUId() {
		Random d = new Random();
		int machineId = d.nextInt(8)+1;
		System.out.println(machineId);
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {//有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%015d", hashCodeV);

	}

	public static String OrderIdByUUId() {
		Random d = new Random();
		int machineId = d.nextInt(8)+1;
		System.out.println(machineId);
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {//有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0
		// 4 代表长度为4
		// d 代表参数为正数型
		return machineId + String.format("%09d", hashCodeV);

	}


}
