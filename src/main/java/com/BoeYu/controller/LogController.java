package com.BoeYu.controller;

import com.BoeYu.pojo.UserSearch;
import com.BoeYu.service.LogService;
import com.BoeYu.util.DateUtil;
import com.BoeYu.util.MyUtil;
import com.BoeYu.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.generic.GenericAudioHeader;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.audio.ogg.util.OggInfoReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
@RequestMapping("log/")
public class LogController {

	@Autowired
	private LogService logServiceImpl;
	
	@RequestMapping("logList")
	@RequiresPermissions("log:log:list")
	public String logList(){
		return "page/log/logList";
	}
	
	@RequestMapping("getLogList")
	@RequiresPermissions("log:log:list")
	@ResponseBody
	public ResultUtil getLogList(Integer page, Integer limit, UserSearch search){
		return logServiceImpl.selLogList(page,limit,search);
	}
	public static void main(String[] args) throws IOException, CannotReadException {
		File file = new File("D:\\upload\\f6bb52e07f76436f8af7e12ca61e33da2382.mp3");

		try {
			MP3File f = (MP3File) AudioFileIO.read(file);
			MP3AudioHeader audioHeader = (MP3AudioHeader)f.getAudioHeader();
			int xx=audioHeader.getTrackLength();
			System.out.println(audioHeader.getTrackLength());
		} catch(Exception e) {
			e.printStackTrace();
		}


	}


	/*public static Date stampToDate(String s){

		long lt = new Long(s);
		Date date = new Date(lt);

		return date;
	}*/


}
