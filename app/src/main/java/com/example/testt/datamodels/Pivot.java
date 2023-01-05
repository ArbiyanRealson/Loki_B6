package com.example.testt.datamodels;

import com.google.gson.annotations.SerializedName;

public class Pivot{

	@SerializedName("student_id")
	private int studentId;

	@SerializedName("id")
	private int id;

	@SerializedName("thesis_seminar_id")
	private int thesisSeminarId;

	public int getStudentId(){
		return studentId;
	}

	public int getId(){
		return id;
	}

	public int getThesisSeminarId(){
		return thesisSeminarId;
	}
}