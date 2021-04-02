package com.techm.todomanagement.model;

public class ToDoBean {

	private int _id;
	private String title;
	private String description;
	private String name;
	private boolean status;
	public int get_id() {
		return _id;
	}
	public void set_id(int _id) {
		this._id = _id;
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ToDoBean [_id=" + _id + ", title=" + title + ", description=" + description + ", name=" + name
				+ ", status=" + status + ", get_id()=" + get_id() + ", getTitle()=" + getTitle() + ", getDescription()="
				+ getDescription() + ", getName()=" + getName() + ", isStatus()=" + isStatus() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
