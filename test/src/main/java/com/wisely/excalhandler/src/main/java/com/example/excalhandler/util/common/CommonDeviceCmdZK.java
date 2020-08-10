package com.example.excalhandler.util.common;

/**
 * add at2017-04-25
 * 中控TFT系列机器命令码
 * @author maozy
 *
 */
public class CommonDeviceCmdZK {

	//设备连接
	public static String Connect_NET="Connect_NET";
	//设备断开
	public static String Disconnect="Disconnect";
	
	//读取考勤记录到缓存
	public static String ReadGeneralLogData = "ReadGeneralLogData";

	//从缓存逐条读取考勤记录
	public static String SSR_GetGeneralLogData = "SSR_GetGeneralLogData";
	
	//下发用户信息
	public static String SSR_SetUserInfo = "SSR_SetUserInfo";
	
	//刷新缓存
	public static String RefreshData = "RefreshData";
	
	//下发用户信息后刷新缓存
	public static String ClearGLog = "ClearGLog";
	
	//准备批量操作
	//高速上传使用BeginBatchUpdata创建临时缓冲区, 在该函数之后的所有上传操作都会将需要被上传的数据
	//存放在该缓冲区, 当使用函数 BatchUpdata 即可将缓冲区的数据一次性上传到机器, 该模式大大减少了 SDK 与
	//机器间的频繁通讯, 提高上传速度, 特别是对于大容量的数据, 效果相当明显
	public static String BeginBatchUpdate = "BeginBatchUpdate";
	
	//批量操作
	public static String BatchUpdate = "BatchUpdate";
}
