package com.example.testt.datamodels;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ListLogbookkResponse{

	@SerializedName("count")
	private int count;

	@SerializedName("logbooks")
	private List<LogbooksItem> logbooks;

	@SerializedName("status")
	private String status;

	public int getCount(){
		return count;
	}

	public List<LogbooksItem> getLogbooks(){
		return logbooks;
	}

	public String getStatus(){
		return status;
	}
}